package org.example.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.AlertClass;
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

                String pN = projName.getText().replaceAll(" ", "");
                String eD = excDep.getText().replaceAll(" ", "");
                String pF = projFin.getText().replaceAll(" ", "");
                String dL = deadline.getText().replaceAll(" ", "");

                try {
                    int e = Integer.parseInt(eD);

                    if (pN.equals("") || eD.equals("") || pF.equals("") || dL.equals("")) {


                    } else {

                        InsertClass.addNewProj(ConnectDB.maxProjId, projName.getText(),
                                Integer.parseInt(excDep.getText()), projFin.getText(), deadline.getText());
                        System.out.println();
                    }
                } catch (Exception e) {
                    AlertClass.alertM(e);
                }
            }
        });

    }
}
