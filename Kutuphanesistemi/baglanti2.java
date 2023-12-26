package Kutuphanesistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti2 {
    static Connection myConn;
    static Statement myStat;

    static ResultSet yap() {
        ResultSet myRs = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kutupotomasyonmysql", "root", "Mk05468651318");
            myStat = myConn.createStatement();
            myRs = myStat.executeQuery("SELECT * FROM user");
            return myRs;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return myRs;
    }
   
      

    static void ekle(String sql_sorgu) {
        try {
            myStat.executeUpdate(sql_sorgu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void update(String sql_sorgu) {
        try {
            myStat.executeUpdate(sql_sorgu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void sil(String sql_sorgu) {
        try {
            myStat.executeUpdate(sql_sorgu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static ResultSet sorgula(String sql_sorgu) {
        ResultSet myRs = null;
        try {
            myRs = myStat.executeQuery(sql_sorgu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myRs;
    }
   
   
    }


