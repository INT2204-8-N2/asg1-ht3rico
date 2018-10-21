
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
    public Database() {
        IdMax();
    }
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
     * Gán thuộc tính id = id Max
     */
    public  void  IdMax(){
        String sql="SELECT MAX(id) FROM Dictionary";
        int idmax=0;
        ResultSet rs=null;
        try (Connection conn = this.connect()){    
             Statement stmt=conn.createStatement();
            rs  = stmt.executeQuery(sql);
            idmax=rs.getInt("MAX(id)");
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        id=idmax+1;
    }
     /**
      * Thêm từ
      * @param eng
      * @param viet 
      */
    public void insert(String en, String vi){
        String sql = "INSERT INTO Dictionary(id,word,info) VALUES("+(id++) +",'"+en+"','"+vi+"')";

        try (Connection conn = this.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"Tính năng");
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi nè");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(Word w) {
        String sql = "INSERT INTO Dictionary(id,word,info) VALUES("+(id++) +",'"+w.getSpelling()+"','"+w.getExplain()+"')";

        try (Connection conn = this.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"Tính năng");
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi nè");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     /**
      * Sửa từ
      * @param id
      * @param word
      * @param info 
      */
    public void update(int id, String word, String info) {
        String sql = "UPDATE Dictionary SET word = ? , "
                + "info = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setString(2, info);
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
    public void delete(String w) {
        String sql = "DELETE FROM Dictionary WHERE word = ?";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, w);
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"Lỗi del");
        }
    }
    /**
     * Trả vè Word với tham số spelling
     * @param word
     * @return 
     */
    public Word getword(String s) {
        String sql = "SELECT id,word,info "+ "FROM Dictionary WHERE word = \""+s+"\"";
        Word w = new Word();

        w.setExplain("Không tìm thấy từ này");
        try (Connection conn = this.connect()){
            Statement stmt=conn.createStatement();
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                 w.setId(rs.getInt(1));
                 w.setSpelling(rs.getString(2));
                 w.setExplain(rs.getString(3));
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
//    public Word getData(int i){
//       String sql = "SELECT * "+ "FROM Dictionary WHERE id = '"+ i+ "'";
//        ResultSet rs=null;
//        Word w=new Word();
//        try (Connection conn = this.connect(); Statement stmt=conn.createStatement(); ResultSet result = stmt.executeQuery(sql)) {       
//                 w.setSpelling(result.getString("word"));
//                 w.setExplain(result.getString("info"));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return w;
//    }

}
