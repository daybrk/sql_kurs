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
import org.example.sql.QueryClass;

public class PerInfController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField secondName;

    @FXML
    private TextField firstName;

    @FXML
    private TextField middleName;

    @FXML
    private TextField address;

    @FXML
    private TextField numberPhone;

    @FXML
    private TextField jobTitle;

    @FXML
    private TextField wages;

    @FXML
    private TextField workExperience;

    @FXML
    private TextField upgPost;

    @FXML
    private TextField department;

    @FXML
    private Button addButton;

    @FXML
    void initialize() {

        //TODO: Добавить определение пробелов
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                String fN = firstName.getText().replaceAll(" ", "");
                String sN = secondName.getText().replaceAll(" ", "");
                String mN = middleName.getText().replaceAll(" ", "");
                String ad = address.getText().replaceAll(" ", "");
                String nP = numberPhone.getText().replaceAll(" ", "");
                String jT = jobTitle.getText().replaceAll(" ", "");
                String wag = wages.getText().replaceAll(" ", "");
                String wE = workExperience.getText().replaceAll(" ", "");
                String uP = upgPost.getText().replaceAll(" ", "");
                String dep = department.getText().replaceAll(" ", "");

                try {
                    int i = Integer.parseInt(wag);
                    int d = Integer.parseInt(dep);

                    if (fN.equals("") || sN.equals("") || mN.equals("") || ad.equals("") || nP.equals("") || jT.equals("")
                            || wag.equals("") || wE.equals("") || uP.equals("") || dep.equals("")){

                        System.out.println("firstName.getText()");

                    } else {

                        if(InsertClass.addNewPerFile(ConnectDB.maxId, firstName.getText(), secondName.getText(),
                                middleName.getText(), numberPhone.getText(), address.getText())) {

                            if (InsertClass.addNewPos(ConnectDB.maxId, jobTitle.getText(), wages.getText(),
                                    workExperience.getText(), upgPost.getText())) {

                                InsertClass.addNewEmp(ConnectDB.maxId, ConnectDB.maxId, Integer.parseInt(department.getText()));

                            } else {
                                System.out.println("insert add NewPos error");
                            }
                        } else {
                            System.out.println("insert add newPerFile error");
                        }
                    }

                } catch (Exception e) {
                    AlertClass.alertM(e);
                }


            }
        });

    }
}