package semester1.uebungsblatt10;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Aufgabe3 {

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(2001, Calendar.SEPTEMBER, 5);
        Date now = new Date();
        long lifeDurationMillis = now.getTime() - birthday.getTimeInMillis();
        long numbersOfMillisInAMinute = 1000 * 60;
        System.out.println("You are " + lifeDurationMillis / numbersOfMillisInAMinute + " minutes old!");
    }
}
