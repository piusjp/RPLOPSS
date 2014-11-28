/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjadwalan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.sql.DATE;

/**
 *
 * @author HP
 */
public class controlBuatJadwal extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Jadwal j=new Jadwal();
        String tglPertandingan = request.getParameter("tanggal");
        String lawan = request.getParameter("away");
        String jam = request.getParameter("jam");
        j.setJam(jam);
        j.setLawan(lawan);
        j.setStatus_main("belum");
        j.setUrl("url");
        try {
            j.setTgl(tglPertandingan);
            j.buatJadwal(j);
        } catch (SQLException ex) {
            Logger.getLogger(controlBuatJadwal.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/formBuatJadwal.jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
