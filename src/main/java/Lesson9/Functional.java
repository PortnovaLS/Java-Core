package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public  class Functional {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ivan", Arrays.asList(new Course("Physics"),
                        new Course("Biology"), new Course("Geography"),
                        new Course("Art"), new Course("IT_Technologies"))),
                new Student("Alex", Arrays.asList(new Course("Biology"),
                        new Course("Testing"), new Course("Maths"))),
                new Student("Elena", Arrays.asList(new Course("Physics"),
                        new Course("Art"), new Course("Maths"), new Course("Art")))
        ));

        List<Course> uniqueCourses = students.stream()
                .map(s -> s.getCourseList())
                .flatMap(c -> c.stream())
                .distinct()
                .collect(Collectors.toList());

        List<Student> curiousStudents = students.stream()
                .sorted((s1, s2) -> s2.getCourseList().size() - s1.getCourseList().size())
                .limit(3)
                .collect(Collectors.toList());

        Course course = new Course("Biology");
        List<Student> attendCourse = students.stream()
                .filter(s -> s.getCourseList().contains(course))
                .collect(Collectors.toList());
}
