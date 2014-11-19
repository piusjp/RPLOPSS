/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tools;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author admin
 */
public class Connections {
     private String us;
    private String pass;
    private String urla;

    public static Connection getKoneksi() {
        //static Connection getKoneksi(){
        Connection conn = null;
//        String url = "jdbc:oracle:thin:@172.23.9.185:1521:orcl";
//        String userid = "mhs125314065";
//        String password = "mhs125314065";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String userid = "hr";
        String password = "hr";
        OracleDataSource ds;
        try {
            ds = new OracleDataSource();
            ds.setURL(url);
            conn =  ds.getConnection(userid, password);
           
        } catch (SQLException ex) {
            System.out.println("Eror : " + ex.getMessage());;
        }
        return conn;
    }
    
}
