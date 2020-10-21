package com.capgemini.indiancensusanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class AppTest 
{
	@Test
	public void testForCorrectNumberOfRecords() throws IOException {
		int result = StateCensusAnalyzer
				.getCount(StateCensusAnalyzer.loadCSVFile(StateCensusAnalyzer.indianCensusData));
		assertEquals(29, result);
	}
}
