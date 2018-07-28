package com.johncrisanto.courseregsystem.utils;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void parseDate() throws ParseException {
        // dd/MM/yyyy
        String date = "2018-10-01";
        LocalDate convertedDate = DateUtils.parseDate(date);
        System.out.println(convertedDate);
        String str = DateUtils.convertDateToString(convertedDate);
        System.out.println(str);
    }

    @Test
    public void convertDateToString() {
    }
}