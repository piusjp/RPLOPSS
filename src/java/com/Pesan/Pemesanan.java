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

    private String getKode_bookin() throws SQLException {

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

    public String getKode_booking() {
        return kode_booking;
    }

    public void simpan(Pemesanan p) throws SQLException {
        String b = amblBlock(p.getTpe_kursi());
        p.setKode_booking(p.getKode_bookin() + p.getId_pemesanan().substring(5, 12));
        gantiKapasitas(b, p.getTpe_kursi(), p.getJum_kursi());
        String k = getHarga(p.getTpe_kursi());
        long a = Long.parseLong(k) * Long.parseLong(p.getJum_kursi());
        String sql = "insert into pemesanan(id_pemesan,telp,nama,tgl_pertandingan,"
                + "tipe_kursi,jum_kursi,status_bayar,kode_booking,id_block,harga) "
                + "values(" + p.getId_pemesanan() + "," + p.getTelp() + ",'" + p.getNama() + "','" + p.getTgl_pertandingan()
                + "','" + p.getTpe_kursi() + "'," + p.getJum_kursi() + "," + 0 + ",'"
                + p.getKode_booking() + "','" + b + "'," + a + ")";
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
//        conn.close();
    }

    public String amblBlock(String tipe) throws SQLException {
        if (!hitungKapasitas("A", tipe).equals("0")) {
            return "A";
        } else if (!hitungKapasitas("B", tipe).equals("0")) {
            return "B";
        } else if (!hitungKapasitas("C", tipe).equals("0")) {
            return "C";
        } else if (!hitungKapasitas("D", tipe).equals("0")) {
            return "D";
        } else {
            return "";
        }

    }

    public Pemesanan lihatPesan(String kode) throws SQLException {
        String sql = "select * from pemesanan where kode_booking like '" + kode + "'";
        Pemesanan h = new Pemesanan();
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery(sql);
        while (r.next()) {
            h.setBlock(r.getString("id_block"));
            h.setNama(r.getString("nama"));
            h.setId_pemesanan(r.getString("id_pemesan"));
            h.setHarga(r.getString("harga"));
            h.setJum_kursi(r.getString("jum_kursi"));
            h.setKode_booking(r.getString("kode_booking"));
            h.setTpe_kursi(r.getString("tipe_kursi"));
            h.setTelp(r.getString("telp"));
            h.setTgl_pertandingan(r.getString("tgl_pertandingan"));
        }
        conn.commit();
        return h;

    }

    public void gantiKapasitas(String id, String tipe, String ganti) throws SQLException {
        String s = hitungKapasitas(id, tipe);
        int a = Integer.valueOf(s);
        int b = Integer.valueOf(ganti);
        int c = a - b;
        String sql = "update block set jumlah=" + c + " where id_block like '" + id + "' and tipe_kursi like '" + tipe + "'";
        Statement t = conn.createStatement();
        t.executeUpdate(sql);

    }

    public String hitungKapasitas(String id, String tipe) throws SQLException {
        String sql = "SELECT JUMLAH FROM BLOCK WHERE ID_BLOCK LIKE '" + id + "' AND TIPE_KURSI LIKE '" + tipe + "'";
        String h = "";
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery(sql);
        while (r.next()) {
            h = r.getString("jumlah");
        }
        conn.commit();
        return h;
    }

    /**
     * @param kode_booking the kode_booking to set
     */
    public void setKode_booking(String kode_booking) {
        this.kode_booking = kode_booking;
    }
}
