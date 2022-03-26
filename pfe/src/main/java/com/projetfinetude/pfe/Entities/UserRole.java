package com.projetfinetude.pfe.Entities;


import java.util.LinkedHashMap;
import java.util.Map;


public enum UserRole {

	/**
	 * "ADMIN"
	 */
	ADMIN {

		@Override
		public String getValue() {
			return ADMIN_ROLE;
		}

	},
	/**
	 * "USER"
	 *
	 */
	USER {

		@Override
		public String getValue() {
			return USER_ROLE;
		}
	},
	
	MEMBER{
			@Override
			public String getValue() {
				return MEMBER_ROLE;
			}
		};

	private static final String ADMIN_ROLE = "ADMIN";
	private static final String USER_ROLE = "USER";
	private static final String MEMBER_ROLE = "MEMBER";
	

	public abstract String getValue();

	public static Map<String, UserRole> getValues() {
		Map<String, UserRole> values = new LinkedHashMap<String, UserRole>();
		values.put(ADMIN_ROLE, ADMIN);
		values.put(USER_ROLE, USER);
		values.put(MEMBER_ROLE, MEMBER);

		return values;
	}
}
