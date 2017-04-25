package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogTab extends Tab {
    private final ListView<String> list;
    private final ObservableList<String> dataList;



    public LogTab() {
        this.list = new ListView<>();
        this.dataList = FXCollections.observableArrayList();
        this.list.setItems(dataList);
        this.setContent(this.list);



        this.setText("Log");
        this.setClosable(false);
    }

    public synchronized void addData(String status, Student student) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        dataList.add(simpleDateFormat.format(date) + "        " + status + "          " + student.getFirstName() + "        " + student.getLastName());

    }

}
