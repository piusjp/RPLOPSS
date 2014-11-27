/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pesan;

import com.tools.Connections;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author admin
 */
public class Pemesanan {

    private String id_pemesanan;
    private String telp;
    private String nama;
    private String tgl_pertandingan;
    private String tpe_kursi;
    private String jum_kursi;
    private String kode_booking;
    private String block;
    private String harga;
    private final Connection conn = Connections.getKoneksi();

    public Pemesanan() {
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
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
    public String getId_pemesanan() {
        return id_pemesanan;
    }

    /**
     * @param id_pemesanan the id_pemesanan to set
     */
    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    /**
     * @return the telp
     */
    public String getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(String telp) {
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
    public String getTgl_pertandingan() {
        return tgl_pertandingan;
    }

    /**
     * @param tgl_pertandingan the tgl_pertandingan to set
     */
    public void setTgl_pertandingan(String tgl_pertandingan) {
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
    public String getJum_kursi() {
        return jum_kursi;
    }

    /**
     * @param jum_kursi the jum_kursi to set
     */
    public void setJum_kursi(String jum_kursi) {
        this.jum_kursi = jum_kursi;
    }

    private String getKode_booking() throws SQLException {

        Statement stmt = conn.createStatement();
        String sql = "select current_date from dual";
        String jumlahRow = "";
        ResultSet rset = stmt.executeQuery(sql);
        while (rset.next()) {
            jumlahRow = rset.getString("current_date");
            //    jumlahRow = rset.getString("no_faktur");
        }
        kode_booking = jumlahRow.replace("-", "");
        kode_booking = kode_booking.substring(0, 8);
        conn.commit();

        return kode_booking;
    }

    private String getHarga(String asd) throws SQLException {
        Statement s = conn.createStatement();
        String h = "";
        ResultSet r = s.executeQuery("select harga from kursi where tipe_kursi like '" + asd + "'");
        while (r.next()) {
            h = r.getString("harga");
        }
        conn.commit();
        return h;
    }

    public void simpan(Pemesanan p) throws SQLException {
        String kb = p.getKode_booking() + p.getTpe_kursi().substring(0, 4) + p.getId_pemesanan();
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
        String k=p.getHarga(p.getTpe_kursi());
        java.util.Date sd = new java.util.Date(Long.valueOf(p.getTgl_pertandingan().replace("-", "")));
        String sql = "insert into pemesanan(id_pemesan,telp,nama,tgl_pertandingan,"
                + "tipe_kursi,jum_kursi,status_bayar,kode_booking,id_block,harga) "
                + "values(" + p.getId_pemesanan() + "," + p.getTelp() + ",'" + p.getNama() + "','" + s.format(sd)
                + "','" + p.getTpe_kursi() + "'," + p.getJum_kursi() + "," + 0 + ",'"
                + kb.substring(0, 16) + "','" + p.getBlock() + "'," + k + ")";
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
