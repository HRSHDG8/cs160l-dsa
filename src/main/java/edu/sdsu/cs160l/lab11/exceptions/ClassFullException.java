package edu.sdsu.cs160l.lab11.exceptions;

/**
 * General blueprint to how custom exceptions are created
 */
public class ClassFullException extends Exception{
  public ClassFullException(String message) {
    super(message);
  }
}
