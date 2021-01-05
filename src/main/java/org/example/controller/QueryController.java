package org.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.example.sql.QueryClass;

public class QueryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea queryText;

    @FXML
    private Button q1;

    @FXML
    private Button q2;

    @FXML
    private Button q3;

    @FXML
    private Button q4;

    @FXML
    private Button q5;

    @FXML
    private Button q6;

    @FXML
    private Button q7;

    @FXML
    private Button q8;

    @FXML
    private Button q9;


    @FXML
    void initialize() {

        q1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query1());
            }
        });

        q2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query2());
            }
        });

        q3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query3());
            }
        });

        q4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query4());
            }
        });

        q5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query5());
            }
        });

        q6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query6());
            }
        });

        q7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query7());
            }
        });

        q8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query8());
            }
        });

        q9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                queryText.setText(QueryClass.query9());
            }
        });

    }
}