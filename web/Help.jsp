<%-- 
    Document   : Help
    Created on : Nov 27, 2014, 9:29:33 PM
    Author     : Yosua Astutakari
--%>

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

        <body>

            <div id='cssmenu'>
                <ul>
                    <li ><a href='home.jsp'title="Logo PSS"><span title="Halaman Home">Home</span></a></li>
                    <li><a href='formJadwalPertandingan.jsp'><span title="Halaman Jadwal Pertandingan">Jadwal Pertandingan</span></a></li>
                    <li><a href='formPesanTiket.jsp'><span title="halaman Pesan Tiket">Pesan Tiket</span></a></li>
                    <li class="active"><a href='Help.jsp'><span title="Help">Help</span></a></li>
                </ul>
            </div>
            <div>
                <h2>1. Pesan tiket</h2>
                <p>a. tekan menu Pesan Tiket </p>
                <p><img src="help/1.PNG">
                </p>
                <p>b. kemudian isikan field yang ada. Id Ktp : 16 digit angka, nama :carakter string, Nomor telp : berisi maximal 12 digit angka, tipe kursi : VVIP, VIP, STANDARD dan jumlah : angka </p>
                <p><img src="help/2.PNG"> </p>
                <p>c. kemudian tekan tombol pesan</p>
                <h2>2. Login Operator</h2>
                <p>a. tekan menu Home </p>
                <p><img src="help/3.PNG">
                </p>
                <p>b. Tekan menu Login Operator</p>
                <p>c. Login berdasarkan Username dan Password</p>
                <p><img src="help/4.PNG"></p>
                <p>d. Kemudian tekan tombol submit</p>
                <p>e. maka akan muncul tampilan seperti dibawah ini </p>
                <p><img src="help/5.PNG"></p>
                <h2>3. Pembuatan Jadwal Baru </h2>
                <p>a. tekan menu buat pesan</p>
                <p><img src="help/6.PNG"></p>
                <p>b. Kemudian isikan semua field yang berhubungan dengan pertandingan tgl : memiliki format "dd-MON-yyyy" jam : berformat string, Away : Lawan yang akan dihadapi</p>
                <p><img src="help/7.PNG"></p>
                <p>c. Kemudian tekan tombol tambah untuk menambahnya </p>
            </div>

        </body>
    </html>
