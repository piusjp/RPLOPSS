/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjadwalan;

import com.tools.Connections;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yosua Astutakari
 */
public class Jadwal {

    private String lawan;
    private Date tgl;
    private String jam;
    private String url, status_main;
    private final Connection conn = Connections.getKoneksi();

    public Jadwal() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLawan() {
        return lawan;
    }

    public void setLawan(String lawan) {
        this.lawan = lawan;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public List<Jadwal> tampilJadwal(String bulan, String thn) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        statement = conn.prepareStatement("select * from jadwal where tgl_pertandingan between '01-" + bulan + "-" + thn + "' and '31-" + bulan + "-" + thn + "'");
        result = statement.executeQuery();
        List<Jadwal> kategoris = new ArrayList<Jadwal>();
        try {
            while (result.next()) {
                Jadwal s = new Jadwal();
                s.setTgl(result.getDate("TGL_PERTANDINGAN"));
                s.setLawan(result.getString("lawan"));
                s.setJam(result.getString("JAM"));
                kategoris.add(s);
            }

            conn.commit();
            return kategoris;
        } catch (SQLException exception) {
            try {
                throw exception;
            } catch (SQLException ex) {
                Logger.getLogger(Jadwal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public String getStatus_main() {
        return status_main;
    }

    public void setStatus_main(String status_main) {
        this.status_main = status_main;
    }

    public void UpdateBelum() throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "update jadwal set status_main='belum' where TO_DATE(SYSDATE, 'dd-mm-yyyy')<=TO_DATE(tgl_pertandingan, 'dd-mm-yyyy')";
            stmt.executeQuery(query);
            conn.commit();
            System.out.println("Tambah Data Jadwal Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        }
    }

    public void UpdateSudah() throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "update jadwal set status_main='sudah' where TO_DATE(SYSDATE, 'dd-mm-yyyy')>TO_DATE(tgl_pertandingan, 'dd-mm-yyyy')";
            stmt.executeQuery(query);
            conn.commit();
            System.out.println("Tambah Data Jadwal Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        }
    }

    public void buatJadwal(Jadwal dataJadwal) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into jadwal(tgl_pertandingan,lawan,jam"
                    + ",urllogo,status_main)"
                    + "values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, dataJadwal.getTgl());
            pstmt.setString(2, dataJadwal.getLawan());
            pstmt.setString(3, dataJadwal.getJam());
            pstmt.setString(4, dataJadwal.getUrl());
            pstmt.setString(5, dataJadwal.getStatus_main());
            pstmt.executeUpdate();
            UpdateBelum();
            UpdateSudah();
            conn.commit();
            System.out.println("Tambah Data Jadwal Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException exception) {
                throw exception;
            }
        }
    }
    public void updateJadwal(Jadwal dataJadwal,String tgl) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            String sql = "update jadwal set tgl_pertandingan=?, lawan=?, jam=? where tgl_pertandingan = to_date('"+tgl+"','dd-mm-yyyy')";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, dataJadwal.getTgl());
            pstmt.setString(2, dataJadwal.getLawan());
            pstmt.setString(3, dataJadwal.getJam());
            pstmt.executeUpdate();
            UpdateBelum();
            UpdateSudah();
            conn.commit();
            System.out.println("Tambah Data Jadwal Berhasil");
        } catch (SQLException exception) {
            conn.rollback();
            System.out.println("Tambah Data Jadwal Pertandingan gagal = " + exception.getMessage());
            throw exception;
        } finally {
            try {
                conn.setAutoCommit(true);
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException exception) {
                throw exception;
            }
        }
    }

    public Jadwal lihatNamaLogo() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;

        statement = conn.prepareStatement("select * from jadwal where status_main like 'belum'");
        result = statement.executeQuery();
        Jadwal a = new Jadwal();
        while (result.next()) {
            a.setLawan(result.getString("Lawan"));
            a.setUrl(result.getString("urllogo"));
            a.setTgl(result.getDate("TGL_PERTANDINGAN"));
            a.setJam(result.getString("jam"));
            return a;

        }
        return a;
    }

    public List<Jadwal> tampilJadwal() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conn.setAutoCommit(false);
            statement = conn.prepareStatement("select * from jadwal");
            result = statement.executeQuery();
            List<Jadwal> kategoris = new ArrayList<Jadwal>();

            while (result.next()) {
                Jadwal s = new Jadwal();
                s.setTgl(result.getDate("TGL_PERTANDINGAN"));
                s.setLawan(result.getString("lawan"));
                s.setJam(result.getString("JAM"));
                kategoris.add(s);
            }

            conn.commit();
            return kategoris;
        } catch (SQLException exception) {
            throw exception;
        }

    }
}
