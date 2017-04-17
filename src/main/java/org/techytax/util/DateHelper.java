package org.techytax.util;

import org.techytax.domain.FiscalPeriod;
import org.techytax.domain.VatPeriodType;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateHelper {

	private static String datePattern = "yyyy-MM-dd";
	private static String timePattern = "yyyy-MM-dd HH:mm:ss";
	private static String timePattern2 = "yyyyMMddHHmm";
	private static String datePatternForTravelChipCard = "dd-MM-yyyy";
	private static String datePatternForInvoice = "dd-MM-yyyy";
	private static String datePatternForIng = "dd-MM-yyyy";

	public static LocalDate stringToDate(String date_str) throws Exception {
        return LocalDate.parse(date_str);
	}

	public static Date stringToDateForIng(String date_str) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(datePatternForIng);
		try {
			return format.parse(date_str);
		} catch (ParseException e) {
			throw new Exception("errors.date.invalid");
		}
	}

	public static Date stringToDateForTravelChipCard(String date_str) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(datePatternForTravelChipCard);
		try {
			return format.parse(date_str);
		} catch (ParseException e) {
			throw new Exception("errors.date.invalid");
		}
	}

	public static String getDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		return format.format(date);
	}

   public static String getTimeStamp(Date date) {
	   SimpleDateFormat format = new SimpleDateFormat(timePattern2);
	   return format.format(date);
	}

	public static XMLGregorianCalendar getDate(String date_str) throws Exception {
		XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		LocalDate date = stringToDate(date_str);
		calendar.setDay(getDay(date));
		calendar.setMonth(date.getMonth().getValue());
		calendar.setYear(date.getYear());
		return calendar;
	}

	public static XMLGregorianCalendar getDateForXml(LocalDate date) {
		XMLGregorianCalendar calendar = null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		calendar.setDay(date.getDayOfMonth());
		calendar.setMonth(date.getMonth().getValue());
		calendar.setYear(date.getYear());
		calendar.setHour(0);
		calendar.setMinute(0);
		calendar.setSecond(0);
		return calendar;
	}

	public static int getDay(LocalDate date) {
		return date.getDayOfMonth();
	}

	public static int getMonth(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	public static FiscalPeriod getPeriodPreviousYear() {
		return new FiscalPeriod(LocalDate.now().minusYears(1).withDayOfYear(1), LocalDate.now().withDayOfYear(1).minusDays(1));
	}

	public static FiscalPeriod getLastVatPeriodPreviousYear() {
		return new FiscalPeriod(LocalDate.now().minusYears(1).withMonth(10).withDayOfMonth(1), LocalDate.now().withDayOfYear(1).minusDays(1));
	}

	public static FiscalPeriod getLatestVatPeriod(VatPeriodType vatPeriodType) {
		FiscalPeriod period = null;
		switch (vatPeriodType) {
		case PER_QUARTER:
			period = getLatestQuarterPeriod();
			break;
		case PER_YEAR:
			period = getPeriodPreviousYear();
			break;
		}

		return period;
	}

	private static FiscalPeriod getLatestQuarterPeriod() {
		return new FiscalPeriod(LocalDate.now().minusMonths(3).withDayOfMonth(1), LocalDate.now().withDayOfMonth(1).minusDays(1));
	}

	public static Date getLastDayOfFirstMonthOfNextQuarter(Date date) {
		int month = getMonth(date);
		int year = getYear(date);
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, year);
		Date lastDay = null;
		switch (month) {
		case 0:
		case 1:
		case 2:
		case 3:
			cal.set(Calendar.MONTH, Calendar.APRIL);
			cal.set(Calendar.DAY_OF_MONTH, 30);
			lastDay = cal.getTime();
			break;
		case 4:
		case 5:
		case 6:
			cal.set(Calendar.MONTH, Calendar.JULY);
			cal.set(Calendar.DAY_OF_MONTH, 31);
			lastDay = cal.getTime();
			break;
		case 7:
		case 8:
		case 9:
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			cal.set(Calendar.DAY_OF_MONTH, 31);
			lastDay = cal.getTime();
			break;
		case 10:
		case 11:
			cal.add(Calendar.YEAR, 1);
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			cal.set(Calendar.DAY_OF_MONTH, 31);
			lastDay = cal.getTime();
			break;
		default:
			break;
		}
		return lastDay;
	}
	
	public static Date getDateAfterDays(int nofDays) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, nofDays);
		return cal.getTime();
	}

	public static FiscalPeriod getLatestVatPeriodTillToday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int month = cal.get(Calendar.MONTH);
		if (month == 0) {
			cal.add(Calendar.YEAR, -1);
		}
		int quarter = getQuarter(month);
		int firstMonth = quarter * 3 - 3;
		cal.set(Calendar.MONTH, firstMonth);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date beginDatum = cal.getTime();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date eindDatum = cal.getTime();
//		return new FiscalPeriod(beginDatum, eindDatum);
		return null;
	}

	private static int getQuarter(int month) {
		int quarter = 1;
		switch (month) {
		case 1:
		case 2:
		case 3:
			quarter = 1;
			break;
		case 4:
		case 5:
		case 6:
			quarter = 2;
			break;
		case 7:
		case 8:
		case 9:
			quarter = 3;
			break;
		case 10:
		case 11:
		case 0:
			quarter = 4;
			break;
		default:
			break;
		}
		return quarter;
	}

	public static int getCurrentYear() {
		return getYear(new Date());
	}

	public static int getYear(Date date) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getFiscalYear() {
		return getYear(new Date()) - 1;
	}
	
	public static Date getLastDayOfFiscalYear() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, -1);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return cal.getTime();
	}

	public static boolean hasOneDayDifference(Date date1, String date2) throws Exception {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String date = getDate(cal.getTime());
		if (date.equals(date2)) {
			return true;
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);
		date = getDate(cal.getTime());
		if (date.equals(date2)) {
			return true;
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);
		date = getDate(cal.getTime());
		return date.equals(date2);
	}

	public static FiscalPeriod getPeriodTillDate(Date balanceDate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(balanceDate);
		Date eindDatum = cal.getTime();
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date beginDatum = cal.getTime();
//		return new FiscalPeriod(beginDatum, eindDatum);
		return null;
	}

	public static String getInvoiceDateString(Date date) {
		SimpleDateFormat df;
		String returnValue = "";
		if (date != null) {
			df = new SimpleDateFormat(datePatternForInvoice);
			returnValue = df.format(date);
		}
		return returnValue;
	}

	public static String getMaand(Date date) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(date);
		int maand = cal.get(Calendar.MONTH);
		String maandString = null;
		switch (maand) {
		case 0:
			maandString = "januari";
			break;
		case 1:
			maandString = "februari";
			break;
		case 2:
			maandString = "maart";
			break;
		case 3:
			maandString = "april";
			break;
		case 4:
			maandString = "mei";
			break;
		case 5:
			maandString = "juni";
			break;
		case 6:
			maandString = "juli";
			break;
		case 7:
			maandString = "augustus";
			break;
		case 8:
			maandString = "september";
			break;
		case 9:
			maandString = "oktober";
			break;
		case 10:
			maandString = "november";
			break;
		case 11:
			maandString = "december";
			break;
		}
		return maandString;
	}

	public static List<Integer> getLatestSevenYears() {
		List<Integer> yearList = new ArrayList<>();
		int yearInt = getCurrentYear();
		Integer year = yearInt;
		for (int i = 0; i < 7; i++) {
			yearList.add(year);
			yearInt--;
			year = yearInt;
		}
		return yearList;
	}
	
	public static boolean isTimeForUsingLatestYearPeriod() {
		Date currentDate = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(currentDate);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date beginDate = cal.getTime();
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date endDate = cal.getTime();
		return currentDate.after(beginDate) && currentDate.before(endDate);
	}
	
	public static boolean isBefore2015(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.YEAR, 2015);
		Date fromDate = cal.getTime();
		return fromDate.after(date);
	}
}
