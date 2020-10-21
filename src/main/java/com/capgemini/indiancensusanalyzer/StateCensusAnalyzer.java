package com.capgemini.indiancensusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.capgemini.indiancensusanalyzer.model.CSVStateCensus;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer 
{
	static final Path indianCensusData = Paths.get("src/main/resources/IndiaStateCensusData.csv");
	static final Path indianCensusDataFalseHeader = Paths.get("src/main/resources/IndiaStateCensusDataFalseHeader.csv");
	static final Path indianCensusDataFalseCount = Paths.get("src/main/resources/IndiaStateCensusDataFalseCount.csv");
	
	public static Iterator<CSVStateCensus> loadCSVFile(Path censusData) throws IOException {
		Reader reader = Files.newBufferedReader(censusData);
		try {
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<CSVStateCensus> stateCensusItr = csvToBean.iterator();
			return stateCensusItr;
		} catch (Exception e) {
			e.getCause();
		}
		return null;
	}
	
	public static int getCount(Iterator<CSVStateCensus> itr) {
		Iterable<CSVStateCensus> censusIterable = () -> itr;
		int count = (int) StreamSupport.stream(censusIterable.spliterator(), false).count();
		return count;
	}
}