package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {


    public static void main(String[] args) throws IOException, CrawlerException, InterruptedException {

            launch(args);




    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Crawler crawler = new Crawler();
        crawler.run();
        primaryStage.setTitle("Crawler");
        Scene scene = new Scene(new VBox(),800,500);

        MenuBar menuBar = new MenuBar();
        Menu programMenu = new Menu("Program");
        MenuItem exitItem = new MenuItem("Close");
        Menu aboutMenu = new Menu("About");
        MenuItem aboutItem = new MenuItem("About");

        exitItem.setAccelerator(KeyCharacterCombination.keyCombination("Ctrl+C"));
        exitItem.setOnAction(event -> System.exit(0));
        aboutItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Designer information");
            alert.setContentText("~Adam Dobroch");

            alert.showAndWait();
        });
        aboutMenu.getItems().addAll(aboutItem);
        programMenu.getItems().addAll(exitItem);

        menuBar.getMenus().addAll(programMenu, aboutMenu);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);


        CustomTabPane customTabPane = new CustomTabPane();
       customTabPane.getLogTab();
        ((VBox) scene.getRoot()).setVgrow(customTabPane, Priority.ALWAYS);



       ((VBox) scene.getRoot()).getChildren().addAll( customTabPane);



        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
