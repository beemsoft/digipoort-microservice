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
package org.techytax.util;

public class VersionHelper {
	
	public static String getVersion() {
		StringBuilder sb = new StringBuilder();
		if (isSaasVersion()) {
			sb.append("SaaS-");
		}
		sb.append(VersionHelper.class.getPackage().getImplementationVersion());
		return sb.toString();
	}

    public static String getXbrlVersion() {
        return getVersion().replace("-SNAPSHOT", "");
    }
	
	public static boolean isSaasVersion() {
		return "true".equals(System.getProperty("saas.version"));
	}
	
}
