package org.example;

import javafx.scene.control.Alert;

public class AlertClass {

    public static void alertM(Exception e) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText(e.getMessage());
        alert.showAndWait();
    }

    public static void alert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText(s);
        alert.showAndWait();
    }
}
