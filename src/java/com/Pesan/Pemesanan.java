/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pesan;

import com.tools.Connections;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class Pemesanan extends HttpServlet {

    private long id_pemesanan;
    private long telp;
    private String nama;
    private Date tgl_pertandingan;
    private String tpe_kursi;
    private int jum_kursi;
    private String kode_booking;
    private String block;
    private final Connection conn = Connections.getKoneksi();

    public Pemesanan() {
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * @return the id_pemesanan
     */
    public long getId_pemesanan() {
        return id_pemesanan;
    }

    /**
     * @param id_pemesanan the id_pemesanan to set
     */
    public void setId_pemesanan(long id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    /**
     * @return the telp
     */
    public long getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(long telp) {
        this.telp = telp;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the tgl_pertandingan
     */
    public Date getTgl_pertandingan() {
        return tgl_pertandingan;
    }

    /**
     * @param tgl_pertandingan the tgl_pertandingan to set
     */
    public void setTgl_pertandingan(Date tgl_pertandingan) {
        this.tgl_pertandingan = tgl_pertandingan;
    }

    /**
     * @return the tpe_kursi
     */
    public String getTpe_kursi() {
        return tpe_kursi;
    }

    /**
     * @param tpe_kursi the tpe_kursi to set
     */
    public void setTpe_kursi(String tpe_kursi) {
        this.tpe_kursi = tpe_kursi;
    }

    /**
     * @return the jum_kursi
     */
    public int getJum_kursi() {
        return jum_kursi;
    }

    /**
     * @param jum_kursi the jum_kursi to set
     */
    public void setJum_kursi(int jum_kursi) {
        this.jum_kursi = jum_kursi;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            Pemesanan p=new Pemesanan();
            
            p.setId_pemesanan(Long.valueOf(request.getParameter("id_ktp")));
            p.setNama(request.getParameter("nama"));
            p.setTelp(Long.valueOf(request.getParameter("No_Telp")));
            p.setTgl_pertandingan(Date.valueOf(request.getParameter("tgl_pertandingan")));
            p.setTpe_kursi(request.getParameter("tipe_kursi"));
            p.setBlock(request.getParameter("block"));
            p.setJum_kursi(Integer.parseInt(request.getParameter("jumlah")));
            p.simpan(p);
            System.out.println("asdasdasdasdasd");
            request.getRequestDispatcher("/formPemesananTiket.jsp").forward(request, response);
        } catch (SQLException ex) {
            
            Logger.getLogger(Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private String getKode_booking() throws SQLException {

        Statement stmt = conn.createStatement();
        String sql = "select current_date from dual";
        String jumlahRow = "";
        ResultSet rset = stmt.executeQuery(sql);
        while (rset.next()) {
            jumlahRow = rset.getString("current_date") + "AS";
            //    jumlahRow = rset.getString("no_faktur");
        }
        kode_booking = jumlahRow.replace("-", "");
        kode_booking = kode_booking.substring(0, 8);
        conn.commit();

        return kode_booking;
    }

    private void simpan(Pemesanan p) throws SQLException {
        String sql = "insert into pemesanan(id_pemesan,telp,nama,tgl_pertandingan,"
                + "tipe_kursi,jum_kursi,status_bayar,kode_booking) "
                + "values(" + p.getId_pemesanan() + "," + p.getTelp() + ",'" + p.getNama() + "','" + p.getTgl_pertandingan()
                + "','" + p.getTpe_kursi() + "'," + p.getJum_kursi() + "," + 0 + ",'" + p.getKode_booking() + "')";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        conn.close();

    }

    /**
     * @param kode_booking the kode_booking to set
     */
    public void setKode_booking(String kode_booking) {
        this.kode_booking = kode_booking;
    }
}
