package org.techytax.helper;

import org.apache.commons.lang3.StringUtils;
import org.techytax.domain.Cost;
import org.techytax.domain.VatType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class AmountHelper {

	public static void applyHighVat(Cost cost) throws Exception {
		applyVat(cost, VatType.HIGH);
	}

	public static void applyLowVat(Cost cost) throws Exception {
		applyVat(cost, VatType.LOW);
	}

	private static void applyVat(Cost cost, VatType vatType) throws Exception {
		BigDecimal amount = cost.getAmount();
		if (amount != null) {
			BigDecimal bd = new BigDecimal(amount.doubleValue()/(1 + vatType.getValue()));
			bd = round(bd);
			cost.setAmount(bd);
			cost.setVat(amount.subtract(bd));
		}
	}
	
	public static BigDecimal round(BigDecimal amount) {
		if (amount != null) {
			return amount.setScale(2,RoundingMode.HALF_UP);
		} else {
			return null;
		}
	}
	
	public static BigInteger roundToInteger(BigDecimal amount) {
		if (amount != null) {
			return amount.setScale(0,RoundingMode.HALF_UP).toBigInteger();
		} else {
			return null;
		}
	}
	
	public static BigInteger roundDownToInteger(BigDecimal amount) {
		if (amount != null) {
			return amount.setScale(0,RoundingMode.DOWN).toBigInteger();
		} else {
			return null;
		}
	}
	
	public static BigDecimal roundDown(BigDecimal amount) {
		if (amount != null) {
			return amount.setScale(0,RoundingMode.DOWN);
		} else {
			return null;
		}
	}	
	
	public static String formatDecimal(BigDecimal b) {
		if (b == null) {
			return null;
		}
		Locale loc = new Locale("nl", "NL", "EURO");
		NumberFormat n = NumberFormat.getCurrencyInstance(loc);
		double doublePayment = b.doubleValue();
		String s = n.format(doublePayment);
		return s;
	}	
	
	public static String formatDecimal(BigInteger b) {

		Locale loc = new Locale("nl", "NL", "EURO");
		NumberFormat n = NumberFormat.getCurrencyInstance(loc);
		double doublePayment = b.doubleValue();
		n.setMaximumFractionDigits(0);
		String s = n.format(doublePayment);
		return s;
	}
	
	public static String formatWithEuroSymbol(BigInteger amount) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("€ ###,###,###,##0", otherSymbols);
		return df.format(amount.doubleValue());
	}
	
	public static String formatWithEuroSymbol(BigDecimal amount) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("€ ###,###,###,##0.00", otherSymbols);
		return df.format(amount.doubleValue());
	}	
	
	public static String format(int amount) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,###,##0", otherSymbols);
		return df.format(amount);
	}
	
	public static String format(BigInteger amount) {
		if (amount == null) {
			return null;
		}
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,###,##0", otherSymbols);
		return df.format(amount);
	}
	
	public static BigInteger parse(String amount) throws ParseException {
		if (StringUtils.isEmpty(amount)) {
			return null;
		}
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.GERMAN);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###,###,##0", otherSymbols);
		return BigInteger.valueOf(df.parse(amount).intValue());
	}
}
