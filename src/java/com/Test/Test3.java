/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.penjadwalan.Jadwal;
import java.sql.SQLException;

/**
 *
 * @author Yosua Astutakari
 */
public class Test3 {

    public static void main(String[] args) throws SQLException {
        Jadwal j = new Jadwal();
        for (int i = 0; i < 2; i++) {
            System.out.println(j.tampilJadwal().get(i).getJam());
            System.out.println(j.tampilJadwal().get(i).getLawan());
            System.out.println(j.tampilJadwal().get(i).getTgl());            
        }
        
    }
}
