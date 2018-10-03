/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdtb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HT3rico
 */
public class TestDTB {

    /**
     * @param args the command line arguments
     */
    Connection conn = null;
    private Connection connect() {
      try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:dictionaries.db";
                conn = DriverManager.getConnection(url);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return conn;
    }
    protected Statement getStatement() throws Exception {  //ham thuc thi cau lenh Query
      // Neu staement =null hoac da dong thi can khoi tao lai
      Statement statement = null;
        if (statement == null ? true : statement.isClosed()) {
            statement = this.connect().createStatement();
        }
        return statement;
    }
     public ResultSet excuteQuery(String query) throws Exception {
         ResultSet result;
        try {
            //thực thi câu lệnh
            result = this.getStatement().executeQuery(query);
        } catch (Exception e) {
            throw new Exception("Lỗi:" + e.getMessage());
        }
        return result; 
    }
    //Lay gia tri tra ve cua cac cau lenh: insert, update, delete, cerate
    public int excuteUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = this.getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception("Lỗi:" + e.getMessage());
        } 
        return res;
    }
}
