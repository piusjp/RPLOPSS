/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Test;

import com.Pesan.Pemesanan;
import com.penjadwalan.Jadwal;
import java.sql.SQLException;

/**
 *
 * @author Yosua Astutakari
 */
public class Test4 {
    public static void main(String[] args) throws SQLException {
        Pemesanan p=new Pemesanan();
        p.setBlock("A");
        p.setId_pemesanan("098376273284");
        p.setNama("Marni");
        p.setJum_kursi("5");
        p.setTelp("002873");
        p.setTgl_pertandingan("13-12-2014");
        p.setTpe_kursi("VVIP");
        Pemesanan s=new Pemesanan();
        s.simpan(p);
    }
}
