/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.Pesan.Pemesanan;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Yosua Astutakari
 */
public class coba {
    
    public static void main(String[] args) throws ParseException, SQLException {

//        DateFormat as = new SimpleDateFormat("dd-MMM-yyyy");
//        Date s = (Date) as.parseObject("01-June-2014");
//        System.out.println(s);
        Pemesanan s = new Pemesanan();
        s.setId_pemesanan("123456789012345");
        s.setNama("Yosua asd");
        s.setTelp("123567433");
        s.setTpe_kursi("VVIP");
        s.setJum_kursi("5");
        s.setTgl_pertandingan("02-MAR-2014");
         System.out.println(s.getTgl_pertandingan());
        s.simpan(s);
        System.out.println(s.getTgl_pertandingan());
    }
}
