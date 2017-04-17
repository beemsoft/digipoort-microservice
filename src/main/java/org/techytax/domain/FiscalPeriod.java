package org.techytax.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FiscalPeriod {

	private LocalDate beginDate;
	private LocalDate endDate;
	
}
