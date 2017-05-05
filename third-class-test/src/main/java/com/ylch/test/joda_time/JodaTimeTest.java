package com.ylch.test.joda_time;

import org.joda.time.*;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * Created by yanglaichang1 on 2017/3/8.
 */
public class JodaTimeTest {


    /**
     *  The use of an Object constructor is a little unusual,
     *  but it is used because the list of types that can be converted is extensible.
     *  The main advantage is that converting from a JDK Date or Calendar to a Joda-Time class is easy
     *  - simply pass the JDK class into the constructor.
     *  For example, this code converts a java.util.Date to a DateTime:
     *
     */
    @Test
    public void test(){
        java.util.Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        System.out.println(dt.getYear());
    }

    /**
     *  Each date-time class provides simple easy methods to access the date-time fields.
     *  For example, to access the month and year you can use:
     */
    @Test
    public void test1(){
        DateTime dt = new DateTime();
        int month = dt.getMonthOfYear();
        int year = dt.getYear();
        System.out.println(month + " --- " + year) ;
    }

    /**
     *  All the main date-time classes are immutable, like String,
     *  and cannot be changed after creation.
     *  However, simple methods have been provided to alter field values in a newly created object.
     *  For example, to set the year, or add 2 hours you can use:
     */
    @Test
    public void test2(){
        DateTime dt = new DateTime();
        DateTime year2000 = dt.withYear(2000);
        DateTime twoHoursLater = dt.plusHours(2);
        System.out.println(year2000 + " ---- " + twoHoursLater) ;
    }

    /**
     *  In addition to the basic get methods, each date-time class provides property methods for each field.
     *  These provide access to the full wealth of Joda-Time functionality.
     *  For example, to access details about a month or year:
     */
    @Test
    public void test03(){
        DateTime dt = new DateTime();
        String monthName = dt.monthOfYear().getAsText();
        String frenchShortName = dt.monthOfYear().getAsShortText(Locale.CHINA);
        boolean isLeapYear = dt.year().isLeap();
        DateTime rounded = dt.dayOfMonth().roundFloorCopy();

        System.out.println(monthName + " ---- " + frenchShortName + " --- " + isLeapYear + " ----- " + rounded) ;
    }

    /**
     *  Calendar systems and time-zones
     *  Joda-Time provides support for multiple calendar systems and the full range of time-zones.
     *  The Chronology and DateTimeZone classes provide this support.

     Joda-Time defaults to using the ISO calendar system, which is the de facto civil calendar used by the world. The default time-zone is the same as the default of the JDK.
     These default values can be overridden whenever necessary. Please note that the ISO calendar system is historically inaccurate before 1583.

     Joda-Time uses a pluggable mechanism for calendars. By contrast, the JDK uses subclasses such as GregorianCalendar. This code obtains a Joda-Time chronology by calling one of the factory methods on the Chronology implementation:
     *
     */
    @Test
    public void test04(){
        Chronology coptic = CopticChronology.getInstance();

        //Time zones are implemented as part of the chronology. The code obtains a Joda-Time chronology in the Tokyo time-zone:

        DateTimeZone zone = DateTimeZone.forID("Asia/Tokyo");
        Chronology gregorianJuian = GJChronology.getInstance(zone);

        System.out.println(coptic.hourOfDay() + " ----- " + gregorianJuian.hourOfDay());

    }

    @Test
    public void test05(){
        DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
        DateTime plusPeriod = dt.plus(Period.days(1));
        DateTime plusDuration = dt.plus(new Duration(24L * 60L * 60L * 1000L));
        System.out.println(plusPeriod + " ---- " + plusDuration);

    }







}
