<%-- 
    Document   : home
    Created on : Nov 19, 2014, 4:25:47 AM
    Author     : Yosua Astutakari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
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
                <li class='active'><a href='home.jsp'><span>Home</span></a></li>
                <li><a href='formJadwalPertandingan.jsp'><span>Jadwal Pertandingan</span></a></li>
                <li><a href='formPesanTiket.jsp'><span>Pesan Tiket</span></a></li>
                <li class='last'><a href='#'><span>Jalur Terpendek</span></a></li>
            </ul>
        </div>
        <div class="leftSlide" align="justify">
            <div class="left">
                <img src="img/Logo_PSS.png" width="150px" height="150px">    
            </div>
            <div class="leftSlide1">
                <span style="color: #ffffff;">
                    Perserikatan Sepak bola Sleman (biasa disingkat: PSS) merupakan sebuah tim sepak bola yang berbasis di Kabupaten Sleman, Daerah Istimewa Yogyakarta, Indonesia. Tim yang didirikan pada 20 Mei 1976 ini merupakan salah satu tim sepak bola yang disegani di Indonesia dan memiliki julukan sebagai tim Super Elang Jawa atau Super Elja. Tim ini juga sering disebut dengan julukan Laskar Sembada. Mereka bermain di Divisi Utama dalam sebuah kompetisi sepak bola Indonesia, Liga Indonesia. Prestasi tertingginya dalam kompetisi kasta tertinggi Liga Indonesia adalah dua tahun berturut-turut menempati empat besar pada Divisi Utama Liga Indonesia 2003 dan Divisi Utama Liga Indonesia 2004. Stadion utama mereka adalah Stadion Maguwoharjo, dan menggunakan Stadion Tridadi sebagai stadion kedua. PSS juga memiliki supporter fanatik yakni Slemania dan Brigata Curva Sud (BCS X PSS 1976)
                </span>

            </div>
        </div>
        <div>
            <!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
            <div id="wowslider-container1">
                <div class="ws_images"><ul>
                        <li><a href="E:\DATA KULIAH\SEMESTER 5\RPL T\ProjectKita\p1.jpeg"><img src="data1/images/p1.jpg" alt="p1" title="p1" id="wows1_0"/></a></li>
                        <li><a href="E:\DATA KULIAH\SEMESTER 5\RPL T\ProjectKita\p2.jpeg"><img src="data1/images/p2.jpg" alt="p2" title="p2" id="wows1_1"/></a></li>
                        <li><a href="E:\DATA KULIAH\SEMESTER 5\RPL T\ProjectKita\p3.jpeg"><img src="data1/images/p3.jpg" alt="p3" title="p3" id="wows1_2"/></a></li>
                        <li><a href="E:\DATA KULIAH\SEMESTER 5\RPL T\ProjectKita\jpeg"><img src="data1/images/p4.jpg" alt="p4" title="p4" id="wows1_3"/></a></li>
                    </ul></div>
                <div class="ws_bullets"><div>
                        <a href="#" title="p1"><img src="data1/tooltips/p1.jpg" alt="p1"/>1</a>
                        <a href="#" title="p2"><img src="data1/tooltips/p2.jpg" alt="p2"/>2</a>
                        <a href="#" title="p3"><img src="data1/tooltips/p3.jpg" alt="p3"/>3</a>
                        <a href="#" title="p4"><img src="data1/tooltips/p4.jpg" alt="p4"/>4</a>
                    </div></div><span class="wsl"><a href="http://wowslider.com/vu">image carousel</a> by WOWSlider.com v7.2</span>
                <div class="ws_shadow"></div>
            </div>	
            <script type="text/javascript" src="engine1/wowslider.js"></script>
            <script type="text/javascript" src="engine1/script.js"></script>
            <!-- End WOWSlider.com BODY section -->

        </div>
    </body>
    </html>
