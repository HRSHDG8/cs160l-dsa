package edu.sdsu.cs160l.methodrefrence;

import edu.sdsu.cs160l.institute.student.Student;
import edu.sdsu.cs160l.institute.student.TestStudents;
import edu.sdsu.cs160l.institute.Registrar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SingleLevelSorting {
    private final Registrar registrar;

    public SingleLevelSorting() {
        this.registrar = new Registrar();
        TestStudents.enrollDummyStudents(registrar);
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

    private static class StudentGpaOrder implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getGpa().compareTo(o2.getGpa());
        }
    }
}
