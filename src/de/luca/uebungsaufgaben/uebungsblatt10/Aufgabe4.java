package de.luca.uebungsaufgaben.uebungsblatt10;

import java.util.*;

public class Aufgabe4 {

    public static void main(String[] args) {

        TreeSet<Date> saturdaysAndSundays = new TreeSet<>();
        Calendar cal = Calendar.getInstance();
        final int maxDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);

        for (int day = 1; day <= maxDay; day++) {
            cal.set(Calendar.DAY_OF_YEAR, day);
            final int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) saturdaysAndSundays.add(cal.getTime());
        }

        System.out.println(saturdaysAndSundays);

        SortedSet<Date> saturdaysAndSundaysInRange = saturdaysAndSundays.subSet(
                new GregorianCalendar(cal.get(Calendar.YEAR), Calendar.JANUARY, 5).getTime(), // inclusive
                new GregorianCalendar(cal.get(Calendar.YEAR), Calendar.FEBRUARY, 5).getTime() // exclusive
        );

        System.out.println(saturdaysAndSundaysInRange);
    }
}
