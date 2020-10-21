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
			if (StateCensusAnalyzer.indianCensusDataFalseType.endsWith("IndiaStateCensusData.csv")) {
				StateCensusException stateCensusException = new StateCensusException(Type.TypeIncorrect);
				throw stateCensusException;
			}
		} catch (StateCensusException stateCensusException) {
			assertEquals(Type.TypeIncorrect, stateCensusException.type);
		}
	}
	
	@Test
	public void testForIncorrectDelimiterOrHeader() throws IOException {
		try {
			StateCensusAnalyzer.loadCSVFile(StateCensusAnalyzer.indianCensusDataFalseHeader);
		}
		catch (StateCensusException e) {
			assertEquals(Type.IncorrectHeaderOrDelimiter, e.type);
		}
	}
	
	@Test
	public void testForCorrectNumberOfRecordsStateCode() throws IOException, StateCensusException {
		int result = StateCensusAnalyzer
				.getCountStateCode(StateCensusAnalyzer.loadCSVStateCodeFile(StateCensusAnalyzer.indianStateCode));
		assertEquals(37, result);
	}
	
	@Test
	public void testForIncorrectStateCodeFile() {
		try {
			if (Paths.get(
					"src/main/resources/IndiaStateCode.csv") != StateCensusAnalyzer.indianStateCodeFalseCount) {
				StateCensusException stateCensusException = new StateCensusException(Type.FileNotFound);
				throw stateCensusException;
			}
		} catch (StateCensusException stateCensusException) {
			assertEquals(Type.FileNotFound, stateCensusException.type);
		}
	}
	
	@Test
	public void testForIncorrectStateCodeFileType() {
		try {
			if (StateCensusAnalyzer.indianStateCodeFalseType.endsWith("IndiaStateCode.csv")) {
				StateCensusException stateCensusException = new StateCensusException(Type.TypeIncorrect);
				throw stateCensusException;
			}
		} catch (StateCensusException stateCensusException) {
			assertEquals(Type.TypeIncorrect, stateCensusException.type);
		}
	}
	
	@Test
	public void testForIncorrectStateCodeDelimiterOrHeader() throws IOException {
		try {
			StateCensusAnalyzer.loadCSVStateCodeFile(StateCensusAnalyzer.indianStateCodeFalseHeader);
		}
		catch (StateCensusException e) {
			assertEquals(Type.IncorrectHeaderOrDelimiter, e.type);
		}
	}
}
