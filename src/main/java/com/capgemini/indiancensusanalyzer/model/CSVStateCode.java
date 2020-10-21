package com.capgemini.indiancensusanalyzer.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {
	public class StateCode {
		@CsvBindByName(column = "SrNo", required = true)
		private String srNo;
		
		@CsvBindByName(column = "State", required = true)
		private int stateName;
		
		@CsvBindByName(column = "TIN", required = true)
		private String tIN;
		
		@CsvBindByName(column = "StateCode", required = true)
		private String stateCode;
		
		@Override
		public String toString() {
			return "StateCensus {" + 
					"SrNo = " + srNo + '\s' + 
					"state = " + stateName + '\s' + 
					"TIN = " + tIN + '\s' + 
					"statecode = " + stateCode + '\s' + 
					'}';
		}
	}
}
