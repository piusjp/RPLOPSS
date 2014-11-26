/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import com.penjadwalan.Jadwal;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP
 */
public class testpius {

    public static void main(String[] args) throws SQLException, ParseException, Exception {
        Jadwal j = new Jadwal();

//        j.setLawan("PERSEBAYA SURABAYA");
//        j.setJam("16.50");
//        j.setTgl(java.sql.Date.valueOf("2014-12-10"));
//        j.updateJadwal(j, "10-DEC-2014");
//        System.out.println(j.lihatNamaLogo().getJam());
////        j.lihatNamaLogo();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//	String dateInString = "7-06-013";
//        System.out.println(formatter.parse(dateInString));\

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
        java.util.Date date = format1.parse("2014-12-10");
        System.out.println(format2.format(date));

    }
}
