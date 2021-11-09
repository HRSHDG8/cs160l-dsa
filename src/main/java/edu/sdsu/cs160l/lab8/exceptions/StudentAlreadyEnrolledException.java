package edu.sdsu.cs160l.lab8.exceptions;

public class StudentAlreadyEnrolledException extends Exception {
  public StudentAlreadyEnrolledException(String message) {
    super(message);
  }
}
