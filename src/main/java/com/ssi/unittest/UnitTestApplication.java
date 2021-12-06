package com.ssi.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class UnitTestApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(UnitTestApplication.class, args);
//		String date = "2020-12-01";
//		String dateWithTimeString = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDate.parse(date).atTime(23,59,59));
//		System.out.println(dateWithTimeString);
//		date = "2019-07-15T00:00:00";
//		System.out.println(setDateWithTimeEndOfDay(date));

		System.out.println("".equals(null));
	}

	private static String setDateWithTimeEndOfDay(String date)  throws Exception{
		Date formattedDate = getDateFromStr(date, "yyyy-MM-dd'T'HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(formattedDate);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return dateFormat.format(cal.getTime());
	}

	public static Date getDateFromStr(String str, String format) throws Exception {
		if (str == null) {
			throw new Exception("Can't parse String to Date. Input String is null");
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new Exception("The value " + str + " can't be parsed to a Date", e);
		}
	}

}
