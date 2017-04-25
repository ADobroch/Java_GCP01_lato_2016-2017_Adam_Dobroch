package sample;


import javafx.scene.chart.BarChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomTabPane extends TabPane {

    private static List<Student> tempStudents;
    private static BarChart barChart;
    private static StudentsTab studentsTab;
    private static LogTab logTab = new LogTab();
    private final CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();
    Tab histogramTab = new Tab();

    public CustomTabPane() {


        studentsTab = new StudentsTab();


        TableView table = new TableView();

        TableColumn markColumn = new TableColumn("Mark");
        TableColumn firstNameColumn = new TableColumn("First Name");
        TableColumn lastNameColumn = new TableColumn("Last Name");
        TableColumn ageColumn = new TableColumn("Age");

        table.getColumns().addAll(markColumn, firstNameColumn, lastNameColumn, ageColumn);

        histogramTab.setText("Histogram");
        barChart = CustomBarChart.display();
        histogramTab.setClosable(false);
        histogramTab.setContent(barChart);



        String adress = "C:\\Users\\Adam\\IdeaProjects\\Crawler\\students.txt";
        File file = new File(adress);
        try {
            tempStudents = StudentsParser.parse(file);
        } catch (IOException ex) {}
        for(Student s : tempStudents)
              {
                  students.add(s);
                  studentsTab.setData(students);
            
        }

        this.getTabs().addAll(studentsTab, logTab, histogramTab);
    }

    public LogTab getLogTab() {
        return logTab;
    }
    public void addStudent(Student student) {
        students.add(student);


        studentsTab.setData(students);
    }
    public void removeStudent(Student student) {
        students.remove(student);


    }
}
