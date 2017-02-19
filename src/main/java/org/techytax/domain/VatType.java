package org.techytax.domain;

public enum VatType {
	NONE("vat.none", 0), LOW("vat.low", 0.06d), HIGH("vat.high", 0.21d);

	private String key;
	private double value;

	VatType(String key, double value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}
	
	public double getValue() throws Exception {
		return value;
	}
	
	public int getValueAsInteger() throws Exception {
		return (int) (100 * getValue());
	}
	
	public static VatType getInstance(String type) {
		VatType balanceType;
		switch (Integer.parseInt(type)) {
		case 0:
			balanceType = NONE;
			break;
		case 1:
			balanceType = LOW;
			break;
		case 2:
			balanceType = HIGH;
			break;
		default:
			balanceType = NONE;
			break;
		}
		return balanceType;
	}
	
	@Override
	public String toString() {
		return name();
	}
}
