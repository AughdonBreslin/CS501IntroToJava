package AbstractClassesAndInterfaces_12;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author: Aughdon
 * @class: CS501 Intro to Java
 * @description:
 * @date: 3/1/2025, Saturday
 **/

public class MyCalendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.printf("Current time is %s\n", new Date());
        // Ctrl click to hop into Calendar to find these
        System.out.printf("Year: %s\n", calendar.get(Calendar.YEAR));
        System.out.printf("Month: %s\n", calendar.get(Calendar.MONTH));
        System.out.printf("Date: %s\n", calendar.get(Calendar.DATE));
        System.out.printf("Hour: %s\n", calendar.get(Calendar.HOUR));
        System.out.printf("Hour of Day: %s\n", calendar.get(Calendar.HOUR_OF_DAY));
        System.out.printf("Minute: %s\n", calendar.get(Calendar.MINUTE));
        System.out.printf("Second: %s\n", calendar.get(Calendar.SECOND));
        System.out.printf("Day of Week: %s\n", calendar.get(Calendar.DAY_OF_WEEK));
        System.out.printf("Day of Month: %s\n", calendar.get(Calendar.DAY_OF_MONTH));
        System.out.printf("Day of Year: %s\n", calendar.get(Calendar.DAY_OF_YEAR));
        System.out.printf("Week of Month: %s\n", calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("Week of Year: %s\n", calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.printf("AM or PM: %s\n", calendar.get(Calendar.AM_PM));

        // Note: 11 should be replaced with Calendar.DECEMBER
        Calendar calendar1 = new GregorianCalendar(2024,  11, 31);
        System.out.println(calendar1.getTime());
        calendar1.add(Calendar.DATE, 1);
        System.out.println(calendar1.getTime());
    }
}
