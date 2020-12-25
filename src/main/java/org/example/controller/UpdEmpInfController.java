package org.example.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.sql.QueryClass;
import org.example.sql.UpdateClass;

public class UpdEmpInfController {

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
    private Button updateInf;

    ArrayList<String> arrayList = new ArrayList<>();

    @FXML
    void initialize() {

        int id = Integer.parseInt(String.valueOf(MainFxmlController.getIdEmp()));

        arrayList = QueryClass.getFullNamesOfEmp("Личные_данные",
                id, "Должность");

        secondName.setText(arrayList.get(0));
        firstName.setText(arrayList.get(1));
        middleName.setText(arrayList.get(2));
        numberPhone.setText(arrayList.get(3));
        address.setText(arrayList.get(4));

        jobTitle.setText(arrayList.get(5));
        wages.setText(arrayList.get(6));
        workExperience.setText(arrayList.get(7));
        upgPost.setText(arrayList.get(8));

        updateInf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                UpdateClass.updateEmpInf(id, firstName.getText(), firstName.getText(), middleName.getText(),
                        numberPhone.getText(), address.getText());
                UpdateClass.updatePosInf(id, jobTitle.getText(), Integer.parseInt(wages.getText()),
                        workExperience.getText(), upgPost.getText());
            }
        });

        arrayList.clear();

    }
}
