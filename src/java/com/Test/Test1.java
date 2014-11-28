/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.Pesan.Pemesanan;
import com.penjadwalan.Jadwal;
import com.tools.Connections;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
        Jadwal a=new Jadwal();
        System.out.println(a.lihatNamaLogo().getTgl());
    }
}
