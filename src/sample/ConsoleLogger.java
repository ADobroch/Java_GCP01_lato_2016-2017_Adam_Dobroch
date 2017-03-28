package sample;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class  ConsoleLogger implements Logger {


    /* public ConsoleLogger() throws IOException {
         for( Student el: students )
             System.out.println( el.getMark() + " " + el.getFirstName() + " " + el.getLastName() + " " + el.getAge() );
     }
    */
    public void log(String status, Student student) {
        if (student == null) System.out.println(status);
        else System.out.println(status + " : " + student.getMark() + " " +student.getFirstName() + " " + student.getLastName() + " " + student.getAge());
    }

        public void log(String status){
            System.out.println("Status: "+status);

    }
    public void log(String status,int Iteration) {
        System.out.println(status + Iteration);
    }
}
