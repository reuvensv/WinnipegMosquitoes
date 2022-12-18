package com.reuven.svechin.winnipegmosquitoes.utils;

import lombok.experimental.UtilityClass;

import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Date utils class
 */
@UtilityClass
public class DateUtils {

    static public long getFirstMilliOfMonth(int year, int month) {
        return getFirstMilliOfMonth(year, month, TimeZone.getDefault());
    }

    static public long getLastMilliOfMonth(int year, int month) {
        return getLastMilliOfMonth(year, month, TimeZone.getDefault());
    }


    private long getFirstMilliOfMonth(int year, int month, TimeZone tz) {
        GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);
        cal.setTimeZone(tz);
        return cal.getTime().getTime();
    }

    private long getLastMilliOfMonth(int year, int month, TimeZone tz) {
        GregorianCalendar cal = new GregorianCalendar(year, (month - 1), 1);
        cal.setTimeZone(tz);

        // set the maximum last day
        int lastday = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        cal.set(GregorianCalendar.DAY_OF_MONTH, lastday);


        cal.set(GregorianCalendar.HOUR_OF_DAY, 23);
        cal.set(GregorianCalendar.MINUTE, 59);
        cal.set(GregorianCalendar.SECOND, 59);
        cal.set(GregorianCalendar.MILLISECOND, 999);

        return cal.getTime().getTime();
    }
}

