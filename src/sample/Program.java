package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Program
{

	public static void main( String[] args ) throws IOException 
	{
//		List<Student> students = StudentsParser.parse( new URL( "http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt" ) );
		List<Student> students = StudentsParser.parse( new File( "students.txt" ) );
			
		for( Student el : students )
			System.out.println( el.getMark() + " " + el.getFirstName() + " " + el.getLastName() + " " + el.getAge() );
	}
}
