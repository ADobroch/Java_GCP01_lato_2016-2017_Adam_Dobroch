package sample;


import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomBarChart extends AnchorPane {
    private static List<Student> tempStudents;
    private static CategoryAxis xAxis = new CategoryAxis();
    private static NumberAxis yAxis = new NumberAxis();
    private static BarChart<String,Number> barChart = new BarChart<>(xAxis,yAxis);

    public static BarChart display() {
        barChart.setTitle("Distribution of marks");
        xAxis.setLabel("Mark");
        yAxis.setLabel("Count");
        int[] Marks=MarksCounter();


        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Marks");
        series1.getData().add(new XYChart.Data("2.0",Marks[0]));
        series1.getData().add(new XYChart.Data("2.5",Marks[1]));
        series1.getData().add(new XYChart.Data("3.0",Marks[2]));
        series1.getData().add(new XYChart.Data("3.5",Marks[3]));
        series1.getData().add(new XYChart.Data("4.0",Marks[4]));
        series1.getData().add(new XYChart.Data("4.5",Marks[5]));
        series1.getData().add(new XYChart.Data("5.0",Marks[6]));

        barChart.getData().add(series1);
        return barChart;

    }

    public static int[] MarksCounter()
    {
        int[] markCount = new int[7];

        String adress = "C:\\Users\\Adam\\IdeaProjects\\Crawler\\students.txt";
        File file = new File(adress);
        try {
            tempStudents = StudentsParser.parse(file);
        } catch (IOException ex) {}

        for(int i = 0; i < 7; i++){
            markCount[i] = 0;
        }
        for(Student s : tempStudents){
            if(s.getMark() == 2.0)
                markCount[0]++;
            else if(s.getMark() == 2.5)
                markCount[1]++;
            else if(s.getMark() == 3.0)
                markCount[2]++;
            else if(s.getMark() == 3.5)
                markCount[3]++;
            else if(s.getMark() == 4.0)
                markCount[4]++;
            else if(s.getMark() == 4.5)
                markCount[5]++;
            else if(s.getMark() == 5.0)
                markCount[6]++;
        }

        return markCount;

    }

}
