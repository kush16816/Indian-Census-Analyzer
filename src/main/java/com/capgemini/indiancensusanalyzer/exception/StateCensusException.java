package com.capgemini.indiancensusanalyzer.exception;

public class StateCensusException extends Exception{
	
	public enum Type {FileNotFound, TypeIncorrect, IncorrectHeaderOrDelimiter};
	public Type type;
	public String message;
	
	public StateCensusException(Type type) {
		this.type = type;
		switch (type) {
		case FileNotFound:
			this.message = "File does not exist";
			break;
		case TypeIncorrect:
			this.message = "File type incorrect";
			break;
		case IncorrectHeaderOrDelimiter:
			this.message = "Incorrect header or delimiter";
		default:
			break;
		}
	}
	
	public StateCensusException(Type type, String message) {
		this.type = type;
		this.message = message;
	}

}
