/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class DBConnect {
     public Connection getConnection()
    {
        String url="jdbc:mysql://localhost:3306/ql_nhahang";
        String user="root";
        String password="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        }
        catch(Exception e)
        {}
        return null;
    }
}
