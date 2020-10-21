package com.capgemini.indiancensusanalyzer.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column = "State", required = true)
	private String stateName;

	@CsvBindByName(column = "Population", required = true)
	private int population;

	@CsvBindByName(column = "AreaInSqKm", required = true)
	private String areaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm", required = true)
	private String densityPerKm;

	@Override
	public String toString() {
		return "StateCensus {" + "state = " + stateName + '\s' + "population = " + population + '\s' + "area = "
				+ areaInSqKm + '\s' + "density = " + densityPerKm + '\s' + '}';

	}
}
