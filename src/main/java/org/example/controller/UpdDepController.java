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

public class UpdDepController {

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
    private Button updDepInf;

    @FXML
    void initialize() {

        ArrayList<String> arrayList = new ArrayList<>();

        int id = Integer.parseInt(String.valueOf(MainFxmlController.getIdDep()));

        arrayList = QueryClass.getFullDepartment("Отдел", id);

        depName.setText(arrayList.get(0));
        depChief.setText(arrayList.get(1));
        depProj.setText(arrayList.get(2));

        updDepInf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                UpdateClass.updateDepInf(id, depName.getText(), depChief.getText(), Integer.parseInt(depProj.getText()));
            }
        });

        arrayList.clear();
    }
}