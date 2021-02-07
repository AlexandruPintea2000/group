package com.napier.sem;

import java.sql.*;
import com.mysql.*;
import com.mysql.cj.MysqlConnection;
import com.mysql.cj.jdbc.MysqlXAConnection;

public class Main {

    public static void main(String[] args){
        // Test SQL Connection
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Name from world.country");
            while(rs.next())
                System.out.println(rs.getString(1));
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
