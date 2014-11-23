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
        Jadwal j=new Jadwal();
<<<<<<< HEAD
        j.setLawan("PERSEBAYA SURABAYA");
        j.setJam("16.40");
        j.setStatus_main("belum");
        j.setTgl(java.sql.Date.valueOf("2014-12-13"));
        j.setUrl("img/persebaya.png");
=======
        j.setLawan("PSBL");
        j.setJam("03.00");
        j.setStatus_main("sudah");
        j.setTgl(java.sql.Date.valueOf("2013-09-04"));
        j.setUrl("img/a");
>>>>>>> origin/master
        j.buatJadwal(j);
    }
 
}
