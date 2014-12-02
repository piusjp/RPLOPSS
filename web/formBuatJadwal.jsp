<%-- 
    Document   : formJadwalPertandingan
    Created on : Nov 19, 2014, 5:39:31 PM
    Author     : Yosua Astutakari
--%>


<%@page import="java.util.List"%>
<%@page import="com.penjadwalan.Jadwal"%>
<a href="formJadwalPertandingan.jsp"></a>
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
        .leftSlide5 {
            position: absolute;
            top: 200px;
            left:  215px;
            width: 900px;
            height: 400px;
            background-color: #ffffff;
        }
        .leftSlide1 {
            position: absolute;
            top: 20px;
            left:  170px;
            width: 900px;
            height: 150px;

        }
        .top{
            position: absolute;
            top: 100px;
            left:  100px;
            width: 1100px;
            height: 100px;
            background-color: #ffffff;
        }
        .dalam{
            position: absolute;
            top: 0px;
            left:  150px;
            width: 950px;
            height: 100px;
            background-color:  #0f71ba;
            font-family: sans-serif;
        }
        .frame{
            position: absolute;
            top: 250px;
            left:  200px;
            width: 800px;
            height: 600px;
            background-color: #ffffff;
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
        <title>PSS-Jadwal Pertandingan</title>

    </head>

    <body bgcolor="#555555">

        <div id='cssmenu'>
            <ul>
                <li ><a href='formOp.jsp'><span>Home</span></a></li>
                <li class='active'><a href='formBuatJadwal.jsp'><span>Buat Jadwal Pertandingan</span></a></li>
                <li><a href='formEditJadwal.jsp'><span>Update Jadwal Pertandingan</span></a></li>
                <li ><a href='#'><span>Laporan Satu Musim</span></a></li>
                <li class='last'><a href="home.jsp"<% 
                session.removeAttribute("username");
                %> ><span>Logout</span></a> </li>
            </ul>
        </div>
        <div class="top">
            <img src="img/Logo_PSS.png" width="150px"height="150px">
            <div class="dalam"> <h1 align="center" style="color: #ffffff;">Jadwal Pertandingan PSS Sleman</h1></div>
        </div>
        <div class="frame">
            <div>
                <p></p>
            </div>
            <div>
                <table align="center" border="1" title="Tabel Jadwal Pertandingan selama satu musim">
                    <tr bgcolor="#2CF936" align="conter">
                        <td>Tanggal</td>
                        <td>Jam</td>
                        <td>Home</td>
                        <td>Vs</td>
                        <td>Away</td>
                    </tr>
                    <%if (request.getAttributeNames().equals("lihat")) {
                            Jadwal j = new Jadwal();
                            List<Jadwal> k = j.tampilJadwal(request.getParameter("bulan"), request.getParameter("tahun"));
                            for (int i = 0; i < k.size(); i++) {
                    %>
                    <tr bgcolor="#FFEBCD">
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(String.valueOf(k.get(i).getTgl()).substring(0, 10)); %>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(k.get(i).getJam()); %>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbspPSS SLEMAN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbspVS&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(k.get(i).getLawan());%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                    </tr>


                    <% }
                    } else {
                        Jadwal j = new Jadwal();
                        List<Jadwal> jad = j.tampilJadwal();
                        for (int i = 0; i < jad.size(); i++) {%>
                    <tr bgcolor="#FFEBCD">
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(String.valueOf(jad.get(i).getTgl()).substring(0, 10)); %>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(jad.get(i).getJam()); %>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbspPSS SLEMAN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbspVS&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                        <td>&nbsp&nbsp&nbsp&nbsp&nbsp<% out.print(jad.get(i).getLawan());%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                    </tr>
                    <%}
                        }%>
                </table>
                <br/>
                <br/>
                <h1>Masukan Jadwal</h1>
                <form action="controlBuatJadwal" method="post">
                    <table align="center" border="1" title="Tabel Jadwal Pertandingan selama satu musim">
                        <tr bgcolor="#2CF936" align="conter">
                            <td>Tanggal</td>
                            <td>Jam</td>
                            <td>Home</td>
                            <td>Vs</td>
                            <td>Away</td>
                        </tr>
                        <tr>
                            <td><input type="text" name="tanggal"/></td>
                            <td><input type="text" name="jam"/></td>
                            <td>PSS Sleman</td>
                            <td>VS</td>
                            <td><input type="text" name="away"/></td>
                        </tr>
                        <td><input type="submit" value="Tambah"/></td>
                    </table>
                </form>
            </div>
        </div>
    </body>

</html>