package edu.sdsu.cs160l.methodrefrence;

import edu.sdsu.cs160l.institute.student.Student;
import edu.sdsu.cs160l.institute.student.TestStudents;
import edu.sdsu.cs160l.institute.Registrar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiLevelSorting {
    private final Registrar registrar;

    public MultiLevelSorting() {
        this.registrar = new Registrar();
        TestStudents.enrollDummyStudents(registrar);
    }

    public List<Student> sortByGpaAndName() {
        return registrar
                .getStudentsEnrolled()
                .stream()
                .sorted(new StudentGpaNameOrder())
                .collect(Collectors.toList());
    }

    public List<Student> sortByGpaWithLambda() {
        return registrar
                .getStudentsEnrolled()
                .stream()
                .sorted((o1, o2) -> {
                    int compareTo = o1.getGpa().compareTo(o2.getGpa());
                    if (compareTo == 0) {
                        compareTo = o1.getName().compareTo(o2.getName());
                    }
                    return compareTo;
                })
                .collect(Collectors.toList());
    }

    public List<Student> sortByGpaAndNameWithComparatorComparing() {
        return registrar
                .getStudentsEnrolled()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa)
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());
    }

    private static class StudentGpaNameOrder implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            int compareTo = o1.getGpa().compareTo(o2.getGpa());
            if (compareTo == 0) {
                compareTo = o1.getName().compareTo(o2.getName());
            }
            return compareTo;
        }
    }

}
