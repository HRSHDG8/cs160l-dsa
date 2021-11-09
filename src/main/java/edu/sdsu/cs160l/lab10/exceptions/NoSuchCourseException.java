package edu.sdsu.cs160l.lab10.exceptions;

import java.util.NoSuchElementException;

public class NoSuchCourseException extends NoSuchElementException {
  public NoSuchCourseException(String message) {
    super(message);
  }
}
