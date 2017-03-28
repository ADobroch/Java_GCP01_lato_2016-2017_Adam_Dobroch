package sample;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import static sample.Crawler.ExtremumMode.MAX;
import static sample.Crawler.ExtremumMode.MIN;
import static sample.SorterOfStudents.*;


public class Crawler  {

    private final Logger[] loggers =new Logger[]
            {
                    new ConsoleLogger(),
                    new MailLogger()
            };

    List<Student>currentStudents;
    List<Student>newStudents;

    private int iteration=0;
    private URL url;
    private String directoryFile;

    public String getDirectoryFile() {
        return directoryFile;
    }

    public void setDirectoryFile(String directoryFile) {
        this.directoryFile = directoryFile;
    }

    public enum OrderMode
 {
     MARK,
     FIRSTNAME,
     LASTNAME,
     AGE;
 }
 public enum ExtremumMode
 {
     MAX,
     MIN;
 }
    public Crawler() throws MalformedURLException {

        directoryFile ="C:\\Users\\Adam\\IdeaProjects\\Crawler\\students.txt";
        url = new URL( "http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt");

    }

    List<Student> extractStudents(List<Student> students, OrderMode mode )
    {
        List<Student> sortedStudents = new ArrayList<>();
        switch(mode){
            case MARK:
                sortedStudents = sortByMark(students);
                break;
            case FIRSTNAME:
                sortedStudents = sortByName(students);
                break;
            case LASTNAME:
                sortedStudents = sortByLastName(students);
                break;
            case AGE:
                sortedStudents = sortByAge(students);
                break;
            default:
                break;
        }
        return sortedStudents;
    }
    public double extractMark(ExtremumMode mode,List<Student> students)
    {
        Student student;
        double currentMark =0;
        switch (mode) {

            case MAX:
                student = Collections.max(students,(a,b)->Double.compare(a.getMark(),b.getMark()));
                currentMark = student.getMark();
                return currentMark;

            case MIN:
                student = Collections.min(students,(a,b)->Double.compare(a.getMark(),b.getMark()));
                currentMark = student.getMark();

            default:
                return -1;

        }

    }
    public int extractAge(ExtremumMode mode,List<Student> students)
    {
        Student student;
        int currentAge =0;
        switch (mode) {

            case MAX:
                student = Collections.max(students,(a,b)->Integer.compare(a.getAge(),b.getAge()));
                currentAge = student.getAge();
                return currentAge;

            case MIN:
                student = Collections.min(students,(a,b)->Integer.compare(a.getAge(),b.getAge()));
                currentAge = student.getAge();
                return currentAge;

            default:
                return -1;

        }

    }
    public void run() throws CrawlerException, IOException, InterruptedException {
        while(true)
        {
            String adressDirectory =this.getDirectoryFile();
            if(adressDirectory == null) throw new CrawlerException();
            File file = new File(directoryFile + toString().valueOf(iteration));
            FileUtils.copyURLToFile(url, file);

            newStudents =new ArrayList<>();
            newStudents = StudentsParser.parse(file);

            if(currentStudents ==null) {
                Student student;

                    for (Logger el : loggers) {
                        for (Student stud : newStudents) {
                            el.log("ADDED: ", stud);
                        }
                    }

            }
            else if(currentStudents.size() > newStudents.size()) {
                if (newStudents == null) {
                    for (Logger el : loggers) {
                        for (Student stud : newStudents) {
                            el.log("REMOVED: ", stud);
                        }
                    }


                }
                else {
                    Student student;
                    List<Student>upToDate = new ArrayList<>(newStudents);
                    upToDate.removeAll(currentStudents);
                    ListIterator<Student> studentIterator = upToDate.listIterator();
                    do {
                        student = studentIterator.next();
                        for(Logger el : loggers) {
                            el.log("REMOVED: ", student);
                        }

                    }while(studentIterator.hasNext());

                }
            }
            else if(currentStudents.size() < newStudents.size()){
                Student student;

                    List<Student>upToDate = new ArrayList<>(newStudents);
                    upToDate.removeAll(currentStudents);
                    ListIterator<Student> studentIterator = upToDate.listIterator();
                    do {
                        student = studentIterator.next();
                        for(Logger el : loggers) {
                            el.log("ADDED: ", student);
                        }

                    }while(studentIterator.hasNext());

                for(Logger el : loggers) {
                    el.log("ITERATION: ", iteration);
                }
                System.out.println("\nAge:<"+extractAge(MIN,newStudents)+","+extractAge(MAX,newStudents)+">\n");
                System.out.println("\nMark:<"+extractMark(MIN,newStudents)+","+extractMark(MAX,newStudents)+">\n");
                extractStudents(newStudents,OrderMode.MARK);


            }
            else{
                for(Logger el : loggers){
                    el.log(" NO_CHANGE ");
                }


            }

            currentStudents = newStudents;


            Thread.sleep(10000);
            iteration++;
        }

    }




}
