package org.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.sql.QueryClass;

public class QueryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea queryText;

    @FXML
    private MenuButton menuButton;


    @FXML
    private MenuItem item1;

    @FXML
    private MenuItem item2;

    @FXML
    private MenuItem item3;

    @FXML
    private MenuItem item4;

    @FXML
    private MenuItem item5;

    @FXML
    private MenuItem item6;

    @FXML
    private MenuItem item7;

    @FXML
    private TextField dataEntry;

    @FXML
    private Button execute;


    @FXML
    void initialize() {

        App.root.getChildren();

        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query1(dataEntry.getText()));
            }
        });

        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query4());
            }
        });

        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query5(Integer.parseInt(dataEntry.getText())));
            }
        });

        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query6(dataEntry.getText()));
            }
        });

        item5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query7(Integer.parseInt(dataEntry.getText())));
            }
        });

        item6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText(QueryClass.query8());
            }
        });

        item7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queryText.setText("1-Отдел  2-Сотрудники  3-Должность  4-Проект \n" +
                        String.valueOf(QueryClass.query9())
                        .replaceAll("^\\[|]$", "").replaceAll(",", ""));
            }
        });



    }


}