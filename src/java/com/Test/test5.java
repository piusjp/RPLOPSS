/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.penjadwalan.Jadwal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Yosua Astutakari
 */
public class test5 {

    public static void main(String[] args) throws SQLException {
        Jadwal j = new Jadwal();
        List<Jadwal> k = j.tampilJadwal("DEC", "14");
        for (int i = 0; i < k.size(); i++) {
            System.out.println(k.get(i).getLawan());
        }
    }
}
