package com.example.displaytime;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.*;

public class TimeBean implements Serializable {
    private Locale[] allLocale = Locale.getAvailableLocales();
    private String[] allTimeZone = TimeZone.getAvailableIDs();
    private int localeIndex;
    private int timeZoneIndex;

    public TimeBean() {
        Arrays.sort(allTimeZone);
    }

    public Locale[] getAllLocale() { return allLocale; }

    public String[] getAllTimeZone() { return allTimeZone; }

    public int getLocaleIndex() { return localeIndex; }

    public int getTimeZoneIndex() { return timeZoneIndex; }

    public void setLocaleIndex(int index) { localeIndex = index; }

    public void setTimeZoneIndex(int index) { timeZoneIndex = index; }

    public String currentTimeString(
            int localeIndex, int timeZoneIndex) {
        Calendar calendar = new GregorianCalendar(allLocale[localeIndex]);
        TimeZone timeZone = TimeZone.getTimeZone(allTimeZone[timeZoneIndex]);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.FULL, DateFormat.FULL, allLocale[localeIndex]);
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(calendar.getTime());
    }
}