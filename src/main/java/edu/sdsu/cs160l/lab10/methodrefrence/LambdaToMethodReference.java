package edu.sdsu.cs160l.lab10.methodrefrence;

import edu.sdsu.cs160l.lab10.institute.Registrar;
import edu.sdsu.cs160l.lab10.institute.student.Student;
import edu.sdsu.cs160l.lab10.institute.student.StudentLevel;
import edu.sdsu.cs160l.lab10.institute.student.StudentMajor;
import edu.sdsu.cs160l.lab10.exceptions.ClassFullException;
import edu.sdsu.cs160l.lab10.exceptions.StudentAlreadyEnrolledException;

import java.util.function.Function;

public class LambdaToMethodReference {
  private final Registrar registrar;

  public LambdaToMethodReference() {
    this.registrar = new Registrar();
    int i = 1;
    for (StudentLevel level : StudentLevel.values()) {
      for (StudentMajor major : StudentMajor.values()) {
        Student student = new Student(825000003L + i, "Name" + i, (3.0 + ((i % 10) / 10.0)), level, major);
        i++;
        for (String courseName : registrar.availableCourseNames()) {
          try {
            registrar.enrollStudent(courseName, student);
          } catch (ClassFullException | StudentAlreadyEnrolledException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public void printEachStudent() {
    registrar
       .getStudentsEnrolled()
       .forEach(student -> System.out.println(student));
  }

  public void printEachStudentWithMethodReference() {
    registrar
       .getStudentsEnrolled()
       .forEach(System.out::println);
  }

  public void whenCanYouNotUseMethodReference() {
    registrar
       .getStudentsEnrolled()
       .forEach(student -> System.out.println(student.getName()));
  }

  /**
   * Think over this, and write your understanding in your reports
   */
  public void dynamicPrinter(Function<Student, ?> valueExtractor) {
    registrar
       .getStudentsEnrolled()
       .forEach(student -> System.out.println(valueExtractor.apply(student)));
  }

}
