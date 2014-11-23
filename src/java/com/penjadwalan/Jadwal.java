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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yosua Astutakari
 */
public class Jadwal {

    private String lawan;
    private Date tgl;
    private String jam;
    private String url;
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

    public Jadwal lihatNamaLogo() throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;

        statement = conn.prepareStatement("select * from jadwal where status_main=1");
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
