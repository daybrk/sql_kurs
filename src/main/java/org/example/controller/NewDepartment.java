package org.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.ConnectDB;
import org.example.sql.InsertClass;

public class NewDepartment {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField depName;

    @FXML
    private TextField depChief;

    @FXML
    private TextField depProj;

    @FXML
    private Button addDep;

    @FXML
    void initialize() {

        addDep.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (depName.getText().equals("") || depChief.getText().equals("")) {
                    System.out.println("Ge-Ge");
                } else {
                    InsertClass.addNewDep(ConnectDB.maxDepId, depName.getText(), depChief.getText(), depProj.getText());
                    System.out.println();
                }
            }
        });

    }
}