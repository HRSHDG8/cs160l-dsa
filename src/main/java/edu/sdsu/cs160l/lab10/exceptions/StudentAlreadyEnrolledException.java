package edu.sdsu.cs160l.lab10.exceptions;

public class StudentAlreadyEnrolledException extends Exception {
  public StudentAlreadyEnrolledException(String message) {
    super(message);
  }
}
