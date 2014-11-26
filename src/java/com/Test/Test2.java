/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.Pesan.Pemesanan;

/**
 *
 * @author Yosua Astutakari
 */
public class Test2 {

    public static void main(String[] args) {
        Pemesanan p = new Pemesanan();
        p.setId_pemesanan("1234567890");
        p.setJum_kursi("3");
        p.setNama("marjo");
        p.setTelp("789656576");
        p.setTgl_pertandingan("2014-05-12");
        p.setTpe_kursi("VIP");
    }
}
