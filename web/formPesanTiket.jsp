<%-- 
    Document   : formPesanTiket
    Created on : Nov 19, 2014, 10:18:11 AM
    Author     : Yosua Astutakari
--%>

<%@page import="com.Pesan.Pemesanan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.penjadwalan.Jadwal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="Logo_PSS.png" rel="shortcut icon">
    <style>
        #imag asd{
            display: block;
            padding: auto;
            width: 1300px;
            height:70px;
        }

        body {
            margin: 0;
            padding: 0;
        }

        .container {

            position: relative;
            width: 100%;
        }

        .left {
            position: absolute;
            left:  0px;
            top:20px;
            width: 150px;
            height: 150px;

        }
        .leftSlide4 {
            position: absolute;
            top: 200px;
            left:  215px;
            width: 900px;
            height: 400px;
            background-color: #ffffff;
        }
        .kiri{
            position: absolute;
            top: 0px;
            left: 0px;
            width: 400px;
            height: 400px;            
        }
        .kanan{
            position: absolute;
            top: 0px;
            left: 415px;
            width: 500px;
            height: 400px;            

        }
        .atas{
            position: absolute;
            top: 0px;
            left: 0px;
            width: 400px;
            height: 30px;
            background-color: #0f71ba;
        }
        .bawah{
            position: absolute;
            top: 90px;
            left: 0px;
            width: 400px;
            height: 300px;
            background-color: #ffffff;
        }
        .leftSlide1 {
            position: absolute;
            top: 20px;
            left:  170px;
            width: 900px;
            height: 150px;

        }
        .captionOrange, .captionBlack
        {
            color: #fff;
            font-size: 20px;
            line-height: 30px;
            text-align: center;
            border-radius: 4px;
        }
        .captionOrange
        {
            background: #EB5100;
            background-color: rgba(235, 81, 0, 0.6);
        }
        .captionBlack
        {
            font-size:16px;
            background: #000;
            background-color: rgba(0, 0, 0, 0.4);
        }
        a.captionOrange, A.captionOrange:active, A.captionOrange:visited
        {
            color: #ffffff;
            text-decoration: none;
        }
        a.captionOrange:hover
        {
            color: #eb5100;
            text-decoration: underline;
            background-color: #eeeeee;
            background-color: rgba(238, 238, 238, 0.7);
        }
        .bricon
        {
            background: url(img/browser-icons.png);
        }

    </style>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/jquery-latest.min.js" type="text/javascript"></script>
        <script src="js/script.js"></script>
        <title>PSS-Pesan Tiket</title>

    </head>

    <body bgcolor="#555555">

        <div id='cssmenu'>
            <ul>
                <li><a href='home.jsp'><span title="Halaman Home">Home</span></a></li>
                <li><a href='formJadwalPertandingan.jsp'><span title="Halaman Jadwal Pertandingan">Jadwal Pertandingan</span></a></li>
                <li class='active'><a href='formPesanTiket.jsp'><span title="Halaman Pesan Tiket">Pesan Tiket</span></a></li>
                <li class='last'><a href='Help.jsp'><span title="Halaman Help">Help</span></a></li>
            </ul>
        </div>
        <div class="leftSlide4">
            <div class="kiri" >
                <div class="atas" align="center">
                    PSS SLEMAN vs&nbsp&nbsp&nbsp&nbsp<%
                        Jadwal j = new Jadwal();
                        Jadwal k = new Jadwal();
                        k = j.lihatNamaLogo();
                        out.print(k.getLawan());
                    %>
                </div>
                <div class="bawah" align="center">
                    <table align="center">
                        <tr>              
                            <th><img src="img/Logo_PSS.png" width="150px" height="150px"></th>
                            <td>VS</td>
                            <td><img src="<%out.print(k.getUrl());%>" width="150px" height="150px"></td>
                        <br>
                        </tr>                    
                    </table>
                    Stadion Maguwoharjo Depok Sleman Yogyakarta
                    <p align="center">
                        <% String date = k.getTgl();
                            out.print(date.substring(0, 11) + " pada pukul " + k.getJam());

                        %>

                    </p>

                </div>
            </div>
            <form action='' method="post">
                <div class="kanan">
                    <h1 align="center">Form Pemesanan Titet</h1>
                    <table>
                        <tr>
                            <td>
                                ID KTP
                            </td>
                            <td>
                                <input type="text" name="id_ktp" size="16" title="Berisi nomor Identitas anda contoh ='0293458373823'">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Nama
                            </td>
                            <td>
                                <input type="text" name="nama" size="16" title="Isi nama dengan karakter contoh 'Marni Asih'">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Nomor Telp
                            </td>
                            <td>
                                <input type="text" name="No_Telp" size="16" title="Nomor telpon yang berisi angka, Contoh='0835876473198'">
                            </td>
                        </tr>
                        <!--                        <tr>
                                                    <td>
                                                        Tanggal Pertandingan
                                                    </td>
                                                    <td>
                                                        <input type="date" name="tgl_pertandingan" title="Tanggal Pertandingan">
                                                    </td>
                                                </tr>-->
                        <tr>
                            <td>
                                Tipe Kursi
                            </td>
                            <td>
                                <select name="tipe_kursi" title="Tipe Kursi">
                                    <option value="VVIP">VVIP</option>
                                    <option value="VIP">VIP</option>
                                    <option value="STANDARD">STANDARD</option>
                                </select> 
                            </td>
                        </tr>
                        <!--                        <tr>
                                                    <td>
                                                        Block
                                                    </td>
                                                    <td>
                                                        <select name="block" title="Block Kursi">
                                                            <option value="A">A</option>
                                                            <option value="B">B</option>
                                                            <option value="C">C</option>
                                                            <option value="D">D</option>
                                                        </select> 
                                                    </td>
                                                </tr>-->

                        <tr>
                            <td>Jumlah Kursi</td>
                            <td><input name="jumlah" type="number" title="Jumlah Kursi tidak boleh nerisikan nilai negatif"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Pesan" title="Tombol Pesan">
                            </td>
                        </tr>

                    </table><h3>
                        <%                            String a = request.getParameter("id_ktp");
                            String b = request.getParameter("nama");
                            String c = request.getParameter("No_Telp");
                            String d = request.getParameter("tgl_pertandingan");
                            String e = request.getParameter("tipe_kursi");
    //                        String f = request.getParameter("block");
                            String g = request.getParameter("jumlah");
                            if (a != null) {
                                Pemesanan p = new Pemesanan();
                                p.setId_pemesanan(a);
                                p.setNama(b);
                                p.setTelp(c);
                                p.setTgl_pertandingan(d);
                                p.setTpe_kursi(e);
    //                            p.setBlock(f);
                                p.setJum_kursi(g);
                                p.setTgl_pertandingan(k.getTgl().substring(0, 11));
                                p.simpan(p);
                                session.setAttribute("kode", p.getKode_booking());
                                response.sendRedirect("BuktiBooking.jsp");
                            }

                        %></h3>
                </div>

            </form>
        </div>

    </body>
</html>

