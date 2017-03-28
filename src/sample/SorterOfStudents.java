package sample;

import java.util.*;

public class SorterOfStudents {

    public static List<Student> sortByMark(List<Student> students)
    {
        List<Student> sortedStudents = new ArrayList<>();
        sortedStudents =students;
        sortedStudents.sort(Comparator.comparingDouble(Student::getMark));
        return sortedStudents;

    }
    public static List<Student> sortByAge(List<Student> students)
    {
        List<Student> sortedStudents = new ArrayList<>();
        sortedStudents =students;
        sortedStudents.sort(Comparator.comparingInt(Student::getAge));
        return sortedStudents;

    }
    public static List<Student> sortByName(List<Student> students)
    {
        List<Student> sortedStudents = new ArrayList<>();
        sortedStudents =students;
        Collections.sort(sortedStudents,(a,b) -> a.getFirstName().compareTo(b.getFirstName()));
        return sortedStudents;

    }
    public static List<Student> sortByLastName(List<Student> students)
    {
        List<Student> sortedStudents = new ArrayList<>();
        sortedStudents =students;
        Collections.sort(sortedStudents,(a,b) -> a.getLastName().compareTo(b.getLastName()));
        return sortedStudents;

    }
}
