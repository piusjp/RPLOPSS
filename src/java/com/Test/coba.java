/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import oracle.sql.DATE;

/**
 *
 * @author Yosua Astutakari
 */
public class coba {
    
    public static void main(String[] args) throws ParseException {
        
        DateFormat as = new SimpleDateFormat("dd-MMM-yyyy");
        Date s = (Date) as.parseObject("01-June-2014");
        System.out.println(s);
    }
}
