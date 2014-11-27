/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.Pesan.Pemesanan;
import java.sql.SQLException;

/**
 *
 * @author Yosua Astutakari
 */
public class test {

    public static void main(String[] args) throws SQLException {
        Pemesanan p = new Pemesanan();
        System.out.println(p.hitungKapasitas("A", "VVIP"));
    }
}
