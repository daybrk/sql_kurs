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
                if (firstName.getText().equals("") || secondName.getText().equals("")
                        || middleName.getText().equals("") || address.getText().equals("")
                        || numberPhone.getText().equals("") || jobTitle.getText().equals("")
                        || wages.getText().equals("") || workExperience.getText().equals("")
                        || upgPost.getText().equals("") || department.getText().equals("")){
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
            }
        });

    }
}