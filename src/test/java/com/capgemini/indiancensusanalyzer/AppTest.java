package com.capgemini.indiancensusanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;

import com.capgemini.indiancensusanalyzer.exception.StateCensusException;
import com.capgemini.indiancensusanalyzer.exception.StateCensusException.Type;

public class AppTest {
	@Test
	public void testForCorrectNumberOfRecords() throws IOException, StateCensusException {
		int result = StateCensusAnalyzer
				.getCount(StateCensusAnalyzer.loadCSVFile(StateCensusAnalyzer.indianCensusData));
		assertEquals(29, result);
	}

	@Test
	public void testForIncorrectFile() {
		try {
			if (Paths.get(
					"src/main/resources/IndiaStateCensusData.csv") != StateCensusAnalyzer.indianCensusDataFalseCount) {
				StateCensusException stateCensusException = new StateCensusException(Type.FileNotFound);
				throw stateCensusException;
			}
		} catch (StateCensusException stateCensusException) {
			assertEquals(Type.FileNotFound, stateCensusException.type);
		}
	}

	@Test
	public void testForIncorrectFileType() {
		try {
			if (StateCensusAnalyzer.indianCensusDataFalseType.endsWith("IndiaStatCensusData.csv")) {
				StateCensusException stateCensusException = new StateCensusException(Type.TypeIncorrect);
				throw stateCensusException;
			}
		} catch (StateCensusException stateCensusException) {
			assertEquals(Type.TypeIncorrect, stateCensusException.type);
		}
	}
	
	@Test
	public void testForIncorrectDelimiter() throws IOException {
		try {
			StateCensusAnalyzer.loadCSVFile(StateCensusAnalyzer.indianCensusDataFalseHeader);
		}
		catch (StateCensusException e) {
			assertEquals(Type.IncorrectHeaderOrDelimiter, e.type);
		}
	}
}
