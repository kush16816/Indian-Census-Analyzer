package com.capgemini.indiancensusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.capgemini.indiancensusanalyzer.exception.StateCensusException;
import com.capgemini.indiancensusanalyzer.exception.StateCensusException.Type;
import com.capgemini.indiancensusanalyzer.model.CSVStateCensus;
import com.capgemini.indiancensusanalyzer.model.CSVStateCode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer 
{
	static final Path indianCensusData = Paths.get("src/main/resources/IndiaStateCensusData.csv");
	static final Path indianCensusDataFalseType = Paths.get("src/main/resources/IndiaStateCensusData.exe");
	static final Path indianCensusDataFalseHeader = Paths.get("src/main/resources/IndiaStateCensusDataFalseHeader.csv");
	static final Path indianCensusDataFalseCount = Paths.get("src/main/resources/IndiaStateCensusDataFalseCount.csv");
	
	static final Path indianStateCode = Paths.get("src/main/resources/IndiaStateCode.csv");
	static final Path indianStateCodeFalseType = Paths.get("src/main/resources/IndiaStateCode.exe");
	static final Path indianStateCodeFalseHeader = Paths.get("src/main/resources/IndiaStateCodeFalseHeader.csv");
	static final Path indianStateCodeFalseCount = Paths.get("src/main/resources/IndiaStateCodeFalseCount.csv");
	
	public static Iterator<CSVStateCensus> loadCSVFile(Path censusData) throws IOException, StateCensusException {
		Reader reader = Files.newBufferedReader(censusData);
		try{
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).withType(CSVStateCensus.class)
				.withIgnoreLeadingWhiteSpace(true).build();
		Iterator<CSVStateCensus> stateCensusItr = csvToBean.iterator();
		return stateCensusItr;
		}
		catch (Exception e) {
			throw new StateCensusException(Type.IncorrectHeaderOrDelimiter);
		}
	}
	
	public static int getCount(Iterator<CSVStateCensus> itr) {
		Iterable<CSVStateCensus> censusIterable = () -> itr;
		int count = (int) StreamSupport.stream(censusIterable.spliterator(), false).count();
		return count;
	}
	
	public static Iterator<CSVStateCode> loadCSVStateCodeFile(Path censusData) throws IOException, StateCensusException {
		Reader reader = Files.newBufferedReader(censusData);
		try{
			CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader).withType(CSVStateCode.class)
				.withIgnoreLeadingWhiteSpace(true).build();
		Iterator<CSVStateCode> stateCodeItr = csvToBean.iterator();
		return stateCodeItr;
		}
		catch (Exception e) {
			throw new StateCensusException(Type.IncorrectHeaderOrDelimiter);
		}
	}
	
	public static int getCountStateCode(Iterator<CSVStateCode> itr) {
		Iterable<CSVStateCode> stateCodeIterable = () -> itr;
		int count = (int) StreamSupport.stream(stateCodeIterable.spliterator(), false).count();
		return count;
	}
}
