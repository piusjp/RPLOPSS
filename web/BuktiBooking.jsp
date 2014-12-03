<%-- 
    Document   : BuktiBooking
    Created on : Nov 27, 2014, 12:23:24 PM
    Author     : Yosua Astutakari
--%>

<%@page import="com.Pesan.Pemesanan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Logo_PSS.png" rel="shortcut icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bukti Booking</title>
        <style>
            #imag asd{
                display: block;
                padding: auto;
                width: 1300px;
                height:70px;
            }

            .top{
                position: absolute;
                top: 50px;
                left:  100px;
                width: 1100px;
                height: 100px;
                background-color: #ffffff;
            }
            .dalam1{
                position: absolute;
                top: 0px;
                left:  150px;
                width: 950px;
                height: 100px;
                background-color:   #0f71ba;
                font-family: sans-serif;
            }
            .fas{
                position: absolute;
                top: 150px;
                left:  300px;
                width: 800px;
                height: 400px;
                background-color: #ffffff;
            }

        </style>
    </head>
    <body bgcolor="#000000">
        <div class="top">
            <img src="img/Logo_PSS.png" width="150px"height="150px">
            <div class="dalam1"> <h1 align="center" style="color: #ffffff;">Bukti Booking Pertandingan PSS</h1></div>
        </div>
        <div class="fas">
            <% String s = String.valueOf(session.getAttribute("kode"));
                Pemesanan p = new Pemesanan();
                Pemesanan i = new Pemesanan();
                i = p.lihatPesan(s);
            %>
            <div align="center"> <table>
                    <tr>
                        <td>Informasi Pembeli</td><td></td><td></td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td>:</td>
                        <td><% out.print(i.getNama()); %></td>
                    </tr>
                    <tr>
                        <td>Id KTP Pembeli</td>
                        <td>:</td>
                        <td><% out.print(i.getId_pemesanan()); %></td>
                    </tr>
                    <tr>
                        <td>No Telpon</td>
                        <td>:</td>
                        <td><% out.print(i.getTelp()); %></td>
                    </tr>
                    <tr><td></td><td></td><td></td></tr>
                    <tr>
                        <td>Informasi Tiket</td><td></td><td></td>
                    </tr>
                    <tr>
                        <td>Kode Booking</td>
                        <td>:</td>
                        <td><% out.print(i.getKode_booking()); %></td>
                    </tr>
                    <tr>
                        <td>Jumlah Tiket</td>
                        <td>:</td>
                        <td><% out.print(i.getJum_kursi()); %></td>
                    </tr>
                    <tr>
                        <td>Harga Tiket</td>
                        <td>:</td>
                        <td>RP <% out.print(i.getHarga());%>,-</td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td><td></td><td><a href="formPesanTiket.jsp"><input type="submit" value="Back">
                                <% session.removeAttribute("kode");
                                %></a></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
