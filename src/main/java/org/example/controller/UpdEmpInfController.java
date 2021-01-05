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

        secondName.setText(arrayList.get(1));
        firstName.setText(arrayList.get(3));
        middleName.setText(arrayList.get(5));
        numberPhone.setText(arrayList.get(7));
        address.setText(arrayList.get(9));

        jobTitle.setText(arrayList.get(11));
        wages.setText(arrayList.get(13));
        workExperience.setText(arrayList.get(15));
        upgPost.setText(arrayList.get(17));

        updateInf.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
                            || wag.equals("") || wE.equals("") || uP.equals("") || dep.equals("")) {

                        System.out.println("firstName.getText()");

                    } else {
                        UpdateClass.updateEmpInf(id, firstName.getText(), secondName.getText(), middleName.getText(),
                                numberPhone.getText(), address.getText());
                        UpdateClass.updatePosInf(id, jobTitle.getText(), Integer.parseInt(wages.getText()),
                                workExperience.getText(), upgPost.getText());
                    }
                } catch (Exception e) {
                    AlertClass.alertM(e);
                }
            }
        });

        arrayList.clear();

    }
}
