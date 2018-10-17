
package back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {
    Connection conn = null;
    int id;
    public Connection connect() {
      try {     
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:dictionaries.db";
                conn = DriverManager.getConnection(url);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return conn;
    }
    /**
     * Gán thuộc tính id = idx Max
     */
    public  void  IdMax(){
        String sql="SELECT MAX(idx) FROM tbl_edict";
        int idmax=0;
        ResultSet rs=null;
        try (Connection conn = this.connect()){    
             rs  = this.exeQ(sql);
             idmax=rs.getInt("MAX(idx)");
             conn.close();
             rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        this.id=idmax+1;
    }
     /**
      * Thêm từ
      * @param eng
      * @param viet 
      */
    public void insert(String eng, String viet){
        this.IdMax();
        String sql = "INSERT INTO tbl_edict(idx,word,detail) VALUES("+(id++) +",'"+eng+"','"+viet+"')";
       
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
      * Sửa từ
      * @param id
      * @param word
      * @param detail 
      */
    public void update(int id, String word, String detail) {
        String sql = "UPDATE tbl_edict SET word = ? , "
                + "detail = ? "
                + "WHERE idx = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setString(2, detail);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Xóa từ
     * @param word 
     */
    public void delete(String word) {
        String sql = "DELETE FROM tbl_edict WHERE word = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Trả vè Word với tham số spelling
     * @param word
     * @return 
     */
    public Word getword(String s) {
        String sql = "SELECT * "+ "FROM tbl_edict WHERE word = \""+s+"\"";
        ResultSet rs=null;
        Word w=new Word();
        try (Connection conn = this.connect()){
             rs  = this.exeQ(sql);
             while(rs.next()){
                 w.setId(rs.getInt("idx"));
                 w.setSpelling(rs.getString("word"));
                 w.setExplain(rs.getString("detail"));
             }     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return w;   
    }  
    /**
     * Trả về Word với tham số id
     * @param i
     * @return 
     */
    public Word getData(int i){
       String sql = "SELECT * "+ "FROM tbl_edict WHERE idx = '"+ i+ "'";
        ResultSet rs=null;
        Word w=new Word();
        try (Connection conn = this.connect()){
             rs  = this.exeQ(sql);
                 w.setSpelling(rs.getString("word"));
                 w.setExplain(rs.getString("detail"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return w;
    }

      /**
       * Trả về kết quả truy vấn
       * @param query
       * @return
       * @throws Exception 
       */
     public ResultSet exeQ(String s) throws Exception {
         ResultSet result;
        try {
            //thực thi câu lệnh
            result = connect().createStatement().executeQuery(s);
        } catch (Exception e) {
            throw new Exception("Lỗi:" + e.getMessage());
        }
        return result; 
    }
}
