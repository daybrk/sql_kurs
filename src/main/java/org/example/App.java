package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

 //TODO: Добавить составной запрос. Заняться оформлением отчёта. Переделать добавление проектов к отделам

public class App extends Application {

    public static AnchorPane root;

    @Override
    public void start(Stage stage) throws IOException {
        ConnectDB.ex();
        addScene("act_main.fxml", 730, 805);
    }


    public static void addScene(String name, int h, int w) throws IOException {
        root = FXMLLoader.load(App.class.getResource(name));
        Stage stage = new Stage();
        stage.setTitle("Нечаев Илья БИМ 18-01");
        stage.setScene(new Scene(root, w, h));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}