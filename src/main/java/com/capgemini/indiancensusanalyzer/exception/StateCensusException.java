package com.capgemini.indiancensusanalyzer.exception;

public class StateCensusException extends Exception{
	
	public enum Type {FileNotFound};
	public Type type;
	public String message;
	
	public StateCensusException(Type type, String message) {
		this.type = type;
		this.message = message;
	}

}
