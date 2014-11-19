/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pesan;

import com.tools.Connections;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class Pemesanan {

    private long id_pemesanan;
    private long telp;
    private String nama;
    private Date tgl_pertandingan;
    private String tpe_kursi;
    private int jum_kursi;
    private String kode_booking;
    private final Connection conn=Connections.getKoneksi();

    public Pemesanan() {
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
    private String getKode_booking() throws SQLException{
       
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
    public void simpan(Pemesanan p) throws SQLException{
        String sql="insert into pemesanan(id_pemesan,telp,nama,tgl_pertandingan,"
                + "tipe_kursi,jum_kursi,status_bayar,kode_booking) "
                + "values("+p.getId_pemesanan()+","+p.getTelp()+",'"+p.getNama()+"','"+p.getTgl_pertandingan()
                +"','"+p.getTpe_kursi()+"',"+p.getJum_kursi()+","+0+",'"+p.getKode_booking()+"')";
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
