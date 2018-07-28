package com.johncrisanto.courseregsystem.utils;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Read a date string and convert it to a date
    public static LocalDate parseDate(String dateStr) throws ParseException {
        // Parse the date while applying the formatter and return it
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date;
    }

    // Read a date and convert it to a str
    public static String convertDateToString(LocalDate localDate) {
        String result = null;

        if(localDate != null) {
            result = formatter.format(localDate);
        }

        return result;
    }




}
