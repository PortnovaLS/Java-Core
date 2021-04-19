package Lesson9;

public class Main {

    public static void main(String[] args) {
        Functional functional = new Functional();

        System.out.println("Список уникальных курсов, на которые подписаны студенты");
        System.out.println(functional.uniqueCourses);

        System.out.println("Список из трех самых любознательных");
        System.out.println(functional.curiousStudents);

        System.out.println("Список студентов, которые посещают этот курс.");
        System.out.println(functional.attendCourse);
    }
}
