package edu.sdsu.cs160l.lab10.methodrefrence;

import edu.sdsu.cs160l.lab10.institute.Registrar;
import edu.sdsu.cs160l.lab10.institute.student.Student;
import edu.sdsu.cs160l.lab10.institute.student.StudentLevel;
import edu.sdsu.cs160l.lab10.institute.student.StudentMajor;
import edu.sdsu.cs160l.lab10.exceptions.ClassFullException;
import edu.sdsu.cs160l.lab10.exceptions.StudentAlreadyEnrolledException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SingleLevelSorting {
  private final Registrar registrar;

  public SingleLevelSorting() {
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

  private static class StudentGpaOrder implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
      return o1.getGpa().compareTo(o2.getGpa());
    }
  }

  public List<Student> sortByGpa() {
    return registrar
       .getStudentsEnrolled()
       .stream()
       .sorted(new StudentGpaOrder())
       .collect(Collectors.toList());
  }

  public List<Student> sortByGpaWithLambda() {
    return registrar
       .getStudentsEnrolled()
       .stream()
       .sorted((o1, o2) -> o1.getGpa().compareTo(o2.getGpa()))
       .collect(Collectors.toList());
  }

  public List<Student> sortByGpaWithComparatorComparing() {
    return registrar
       .getStudentsEnrolled()
       .stream()
       .sorted(Comparator.comparing(student -> student.getGpa()))
       .collect(Collectors.toList());
  }

  public List<Student> sortByGpaWithComparatorComparingAndMethodReference() {
    return registrar
       .getStudentsEnrolled()
       .stream()
       .sorted(Comparator.comparing(Student::getGpa))
       .collect(Collectors.toList());
  }
}
