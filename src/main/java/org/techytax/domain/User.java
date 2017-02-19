/**
 * Copyright 2014 Hans Beemsterboer
 * 
 * This file is part of the TechyTax program.
 *
 * TechyTax is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * TechyTax is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TechyTax; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.techytax.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -374265857173724138L;

	protected Long id;

	private String role;
	
	private boolean blocked;
	
	private String companyAddress;
	
	private String companyZipCode;
	
	private String companyCity;
	
	private String companyName;
	private String email;
	
	private String initials;
	private String prefix;
	private String surname;
	
	private Date latestOnlineTime;
    
	private String password;
	private String username;
	private String phoneNumber;
	private String fiscalNumber;
	
	private Long chamberOfCommerceNumber;
	
	private VatPeriodType vatPeriodType = VatPeriodType.PER_QUARTER;
	
	private String accountNumber;

	public boolean isBusinessAccount() {
		return true;
	}

	public boolean isAdmin() {
		return role.equals("admin");
	}

	public boolean passwordMatch(String pwd) {
		return password.equals(pwd);
	}

	public String getFullName() {
		StringBuffer sb = new StringBuffer();
		if (surname != null) {
			sb.append(initials);
			if (prefix != null) {
				sb.append(" ");			
				sb.append(prefix);
			}
			sb.append(" ");		
			sb.append(surname);
			return sb.toString();
		} else {
			return "user";
		}
	}

}
