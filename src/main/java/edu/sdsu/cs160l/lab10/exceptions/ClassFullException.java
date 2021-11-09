package edu.sdsu.cs160l.lab10.exceptions;

/**
 * General blueprint to how custom exceptions are created
 */
public class ClassFullException extends Exception{
  public ClassFullException(String message) {
    super(message);
  }
}
