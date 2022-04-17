package edu.sdsu.cs160l.lab11.methodrefrence;

import edu.sdsu.cs160l.lab11.institute.Registrar;
import edu.sdsu.cs160l.lab11.institute.student.Student;

import java.util.function.Function;

import static edu.sdsu.cs160l.lab11.institute.student.TestStudents.enrollDummyStudents;

public class LambdaToMethodReference {
    private final Registrar registrar;

    public LambdaToMethodReference() {
        this.registrar = new Registrar();
        enrollDummyStudents(registrar);
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

    public void dynamicPrinter(Function<Student, ?> valueExtractor) {
        registrar
                .getStudentsEnrolled()
                .stream()
                .limit(1)
                .forEach(student -> System.out.println(valueExtractor.apply(student)));
    }

}
