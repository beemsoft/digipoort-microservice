package org.techytax.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Cost {

	static final String FOR_PERIOD = "Cost.FOR_PERIOD";
	static final String FOR_PERIOD_AND_TYPES = "Cost.FOR_PERIOD_AND_TYPES";
	static final String FOR_PERIOD_AND_VAT_DECLARABLE = "Cost.FOR_PERIOD_AND_VAT_DECLARABLE";
	static final String FOR_PERIOD_AND_ACCOUNT = "Cost.FOR_PERIOD_AND_ACCOUNT";

	protected Long id = 0L;

	@NotNull
	private String user;

	private BigDecimal amount;

	private BigDecimal vat = BigDecimal.ZERO;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private LocalDate date;

	private String description;

	public void roundValues() {
		if (amount != null) {
			amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		if (vat != null) {
			vat = vat.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}
}
