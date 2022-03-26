package com.projetfinetude.pfe.Entities;


import java.util.LinkedHashMap;
import java.util.Map;

public enum Status {
	NEW {
		@Override
		public String getValue() {
			return NEW_STR;
		}
	},
	SUBMITTED {
		@Override
		public String getValue() {
			return SUBMITTED_STR;
		}
	},
	VALIDATED {
		@Override
		public String getValue() {
			return VALIDATED_STR;
		}
	},
	ASSIGNED {
		@Override
		public String getValue() {
			return ASSIGNED_STR;
		}
	},
	CANCELED {
		@Override
		public String getValue() {
			return CANCELED_STR;
		}
	},
	REJECTED

	{
		@Override
		public String getValue() {
			return REJECTED_STR;
		}
	};

	private static final String NEW_STR = "NEW";
	private static final String SUBMITTED_STR = "SUBMITTED";
	private static final String VALIDATED_STR = "VALIDATED";
	private static final String ASSIGNED_STR = "ASSIGNED";
	private static final String CANCELED_STR = "VALIDATED";
	private static final String REJECTED_STR = "ASSIGNED";
	
	
	public abstract String getValue();

	public static Map<String, Status> getValues() {
		Map<String, Status> valuesMap = new LinkedHashMap<String, Status>();
		valuesMap.put(NEW_STR, NEW);
		valuesMap.put(SUBMITTED_STR, SUBMITTED);
		valuesMap.put(VALIDATED_STR, VALIDATED);
		valuesMap.put(ASSIGNED_STR, ASSIGNED);
		valuesMap.put(CANCELED_STR, VALIDATED);
		valuesMap.put(REJECTED_STR, ASSIGNED);
		return valuesMap;
	}
}
