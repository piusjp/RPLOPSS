<%-- 
    Document   : konfirmasiPembayaran
    Created on : Dec 8, 2014, 10:12:08 PM
    Author     : Yosua Astutakari
--%>

<%@page import="com.Pesan.Pemesanan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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
        .leftSlide {
            position: absolute;
            top: 64px;
            left:  0px;
            width: 1365px;
            height: 200px;
            background-color: #555555;
        }
        .leftSlide1 {
            position: absolute;
            top: 20px;
            left:  170px;
            width: 900px;
            height: 150px;

        }
        .leftSlide2 {
            position: absolute;
            top: 250px;
            left:  0px;
        }
        .slide{
            position: absolute;
            background-color: #ffffff;
            top: 200px;
            left:  230px;
            width: 800px;
            height:300px;
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
        <title>PSS-Home</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="Made with WOW Slider - Create beautiful, responsive image sliders in a few clicks. Awesome skins and animations. Image carousel" />

        <!-- Start WOWSlider.com HEAD section --> <!-- add to the <head> of your page -->
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <!-- End WOWSlider.com HEAD section -->

    </head>

    <body bgcolor="#555555">

        <div id='cssmenu'>
            <ul>
                <li><a href='home.jsp'title="Logo PSS"><span title="Halaman Home">Home</span></a></li>
                <li><a href='formJadwalPertandingan.jsp'><span title="Halaman Jadwal Pertandingan">Jadwal Pertandingan</span></a></li>
                <li><a href='formPesanTiket.jsp'><span title="Halaman Pesan Tiket">Pesan Tiket</span></a></li>
                <li><a href='Help.jsp'><span title="halaman Help">Help</span></a></li>
                <li><a href="LihatJalurTerpendek.jsp"><span title="halaman lihat jalur terpendek">Lihat Jalur Terpendek</span></a></li>
                <li  class='active'><a href="konfirmasiPembayaran.jsp"><span title="halaman konfirmasi Pembayaran">Konfirmasi</span></a></li>
                <li class='last'><a <%
                    if (session.getAttribute("username") != null) {
                        %>href='formOp.jsp'>
                        <%} else {
                        %>                        
                        href='formLoginOp.jsp'>
                        <% }%><span>Login Operator</span></a></li>
            </ul>
        </div>
        <div class="slide">
            <h2 align="center">Konfirmasi Pembayaran</h2>
            <form action=""method="post">
                <table align="center">
                    <tr>
                        <td>Kode Booking</td>
                        <td>&nbsp:&nbsp</td>
                        <td><input type="input" name="kode_booking" title="kode booking yang berisi 15 digit yang telah diberikan"></td>
                    </tr>
                    <tr>
                        <td>Kode Pembayaran</td>
                        <td>&nbsp:&nbsp</td>
                        <td><input type="input" name="kode_pembayaran" title="kode pembayaran yang berisi 13 digit yang telah diberikan oleh bank"></td>
                    </tr>
                    <tr>
                        <td>&nbsp</td>
                        <td>&nbsp</td>
                        <td><input type="submit" value="Konfirmasi" title="Tombol konfirmasi Pembayaran"></td>
                    </tr>
                </table>
                <h3 align="center">
                    <%
                        String kodebayar = request.getParameter("kode_pembayaran");
                        String kodebooking = request.getParameter("kode_booking");
                        Pemesanan p = new Pemesanan();
                        if (kodebayar == null) {
                    %>Isi kode booking dan kode bayar dengan benar<%
                    } else if (p.konfirmasiBayar(kodebayar, kodebooking) == false) {
                    %>Maaf kode booking atau kode bayar anda tidak tepat mohon masukkan dengan benar
                    <%
                    } else if (p.konfirmasiBayar(kodebayar, kodebooking) == true) {
                    %>Andah Telah berhasil melakukan konfirmasi pembayaran<%
                        }
                    %>
                </h3>
            </form>
        </div>
    </body>
</html>