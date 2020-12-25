package org.example.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.sql.DeleteClass;
import org.example.sql.QueryClass;

public class MainFxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public ListView<String> list_of_employees;

    @FXML
    public Button add_new_employee;

    @FXML
    private TextArea inf_about_emp;

    @FXML
    private Button update_inf_emp;

    @FXML
    private Button delete_emp;

    @FXML
    private ListView<String> list_of_departments;

    @FXML
    private TextArea inf_about_dep;

    @FXML
    private Button add_new_departments;

    @FXML
    private Button update;

    @FXML
    private Button deleteDep;

    @FXML
    private Button updateDepInf;

    @FXML
    private ListView<String> projList;

    @FXML
    private TextArea projInfo;

    @FXML
    private Button addProj;

    @FXML
    private Button deleteProj;

    @FXML
    private Button updProj;

    @FXML
    private Button queryBut;


    public ObservableList<String> empList = FXCollections.observableArrayList();
    public ObservableList<String> depList = FXCollections.observableArrayList();
    public ObservableList<String> pjList = FXCollections.observableArrayList();

    private static char idEmp, idDep, idProj;
    private static boolean clickedEmp, clickedDep, clickedProj = false;

    public static char getIdEmp() {
        return idEmp;
    }

    public static char getIdDep() {
        return idDep;
    }

    public static char getIdProj() {
        return idProj;
    }

    @FXML
    void initialize() {

        add_new_employee.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.addScene("per_inf.fxml", 350, 600);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        add_new_departments.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.addScene("new_dep.fxml", 235, 390);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        addProj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.addScene("new_proj.fxml", 280, 430);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        update.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEmpList();
                setDepList();
                setProjList();
            }
        });

        delete_emp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedEmp) {

                    DeleteClass.deleteFromEmp(Integer.parseInt(String.valueOf(idEmp)));
                    DeleteClass.deleteFromPerFile(Integer.parseInt(String.valueOf(idEmp)));
                    DeleteClass.deleteFromPos(Integer.parseInt(String.valueOf(idEmp)));
                    clickedEmp = false;
                }
            }
        });

        deleteProj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedProj) {

                    DeleteClass.deleteFromProj(Integer.parseInt(String.valueOf(idProj)));
                    clickedProj = false;
                }
            }
        });

        deleteDep.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedDep) {

                    DeleteClass.deleteFromDep(Integer.parseInt(String.valueOf(idDep)));
                    clickedDep = false;
                }
            }
        });

        updateDepInf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedDep) {
                    try {
                        App.addScene("upd_dep.fxml", 235, 390);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    clickedDep = false;
                }
            }
        });

        updProj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedProj) {
                    try {
                        App.addScene("upd_proj.fxml", 280, 430);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                clickedProj = false;
            }
        });


        update_inf_emp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (clickedEmp) {
                    try {
                        App.addScene("upd_inf.fxml", 350, 600);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    clickedEmp = false;
                }
            }
        });

        queryBut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.addScene("query.fxml", 400, 600);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        updateEmpList();
    }

    public void setEmpList() {

        empList.removeAll(empList);
        empList.addAll(QueryClass.getNamesOfEmp("Личные_данные"));

        list_of_employees.setItems(empList);

    }

    public void setDepList() {

        depList.removeAll(depList);
        depList.addAll(QueryClass.getDepartment("Отдел"));

        list_of_departments.setItems(depList);

    }

    public void setProjList() {

        pjList.removeAll(pjList);
        pjList.addAll(QueryClass.getProject("Действующие_проекты"));

        projList.setItems(pjList);

    }

    private void updateEmpList() {

        list_of_employees.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    try {
                        idEmp = new_val.charAt(0);
                        inf_about_emp.setText(String.valueOf(QueryClass.getFullNamesOfEmp("Личные_данные",
                                Integer.parseInt(String.valueOf(idEmp)), "Должность"))
                                .replaceAll("^\\[|]$", ""));
                    } catch (NullPointerException e) {

                    }
                    clickedEmp = true;
                });

        list_of_departments.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    try {
                        idDep = new_val.charAt(0);
                        inf_about_dep.setText(String.valueOf(QueryClass.getFullDepartment("Отдел",
                                Integer.parseInt(String.valueOf(idDep))))
                                .replaceAll("^\\[|]$", ""));
                    } catch (NullPointerException e) {

                    }
                    clickedDep = true;
                });

        projList.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    try {
                        idProj = new_val.charAt(0);
                        projInfo.setText(String.valueOf(QueryClass.getFullProject("Действующие_проекты",
                                Integer.parseInt(String.valueOf(idProj))))
                                .replaceAll("^\\[|]$", ""));
                    } catch (NullPointerException e) {

                    }
                    clickedProj = true;
                });

    }

}
