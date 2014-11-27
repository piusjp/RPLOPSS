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
 * @author HP
 */
public class testpius {

    public static void main(String[] args) throws SQLException {
        Jadwal j = new Jadwal();

//        j.setLawan("PERSEBAYA SURABAYA");
//        j.setJam("16.50");
//        j.setTgl(java.sql.Date.valueOf("2014-12-10"));
//        j.updateJadwal(j, "10-DEC-2014");
        
        System.out.println(j.lihatNamaLogo().getJam());
        j.lihatNamaLogo();
    }
}
