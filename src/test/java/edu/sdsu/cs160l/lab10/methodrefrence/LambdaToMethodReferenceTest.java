package edu.sdsu.cs160l.lab10.methodrefrence;

import edu.sdsu.cs160l.lab10.institute.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LambdaToMethodReferenceTest {
  private LambdaToMethodReference lambdaToMethodReference;

  @BeforeEach
  void setUp() {
    lambdaToMethodReference = new LambdaToMethodReference();
  }

  @Test
  void printEachStudent() {
    lambdaToMethodReference.printEachStudent();
  }

  @Test
  void printEachStudentWithMethodReference() {
    lambdaToMethodReference.printEachStudentWithMethodReference();
  }

  @Test
  void whenCanYouNotUseMethodReference() {
    lambdaToMethodReference.whenCanYouNotUseMethodReference();
  }

  @Test
  void dynamicPrinter() {
    lambdaToMethodReference.dynamicPrinter(student -> student.getGpa());
    // OR you can use method reference -> lambdaToMethodReference.dynamicPrinter(Student::getGpa);
    lambdaToMethodReference.dynamicPrinter(Student::getMajor);
    lambdaToMethodReference.dynamicPrinter(Student::getLevel);
  }
}
