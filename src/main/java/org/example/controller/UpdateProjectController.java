package org.example.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.AlertClass;
import org.example.sql.QueryClass;
import org.example.sql.UpdateClass;

public class UpdateProjectController {

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
    private Button updProj;

    @FXML
    private TextField deadline;

    @FXML
    void initialize() {

        ArrayList<String> arrayList = new ArrayList<>();


        int id = Integer.parseInt(String.valueOf(MainFxmlController.getIdProj()));


        arrayList = QueryClass.getFullProject("Действующие_проекты", id);

        projName.setText(arrayList.get(1));
        excDep.setText(arrayList.get(3));
        projFin.setText(arrayList.get(5));
        deadline.setText(arrayList.get(7));


        updProj.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
                        UpdateClass.updateDepProj(id, projName.getText(), Integer.parseInt(excDep.getText()),
                                projFin.getText(), deadline.getText());
                    }

                } catch (Exception e) {
                    AlertClass.alertM(e);
                }
            }
        });

        arrayList.clear();

    }
}