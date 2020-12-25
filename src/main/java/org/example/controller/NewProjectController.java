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

public class NewProjectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField projName;

    @FXML
    private TextField excDep;

    @FXML
    private TextField projFin;

    @FXML
    private Button addProj;

    @FXML
    private TextField deadline;

    @FXML
    void initialize() {

        addProj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (projName.getText().equals("") || excDep.getText().equals("")
                        || projFin.getText().equals("") || deadline.getText().equals("")) {
                    System.out.println("Ge-Ge");
                } else {
                    InsertClass.addNewProj(ConnectDB.maxProjId, projName.getText(),
                            Integer.parseInt(excDep.getText()), projFin.getText(), deadline.getText());
                    System.out.println();
                }
            }
        });

    }
}
