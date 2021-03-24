package de.luca.uebungsaufgaben.uebungsblatt10;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Aufgabe1 {

    public static void main(String[] args) throws ParseException {

        /*
         * mistake: mm/DD/yyyy instead of MM/dd/yyyy
         * m: minute in hour <-> M: month in year
         * D: Day in year <-> d: day in month
         */

        // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // wrong

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(formatter.parse("08/16/2011"));
    }
}
