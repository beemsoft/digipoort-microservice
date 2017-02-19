package org.techytax.domain;

public enum VatPeriodType {
	PER_QUARTER, PER_YEAR;

	public static VatPeriodType getInstance(int type) {
		VatPeriodType vatPeriodType;
		switch (type) {
		case 0:
			vatPeriodType = PER_QUARTER;
			break;
		case 1:
			vatPeriodType = PER_YEAR;
			break;
		default:
			vatPeriodType = null;
			break;
		}
		return vatPeriodType;
	}
}
