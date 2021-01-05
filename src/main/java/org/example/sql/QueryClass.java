package org.example.sql;

import org.example.ConnectDB;

import java.sql.*;
import java.util.ArrayList;

public class QueryClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getNamesOfEmp(String table) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> name = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);


            while (executeQuery.next()) {
                stringBuilder.append(executeQuery.getInt("Id_Сотрудника"));
                stringBuilder.append(" ");
                stringBuilder.append(executeQuery.getString("Фамилия"));
                stringBuilder.append(" ");
                stringBuilder.append(executeQuery.getString("Имя"));
                stringBuilder.append(" ");
                stringBuilder.append(executeQuery.getString("Отчество"));
                name.add(String.valueOf(stringBuilder));
                stringBuilder = new StringBuilder();
            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static ArrayList<String> getFullNamesOfEmp(String table1, int id, String table2) {

        ArrayList<String> fullName = new ArrayList<>();


        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table1);

            while (executeQuery.next()) {

                if (executeQuery.getString("Id_Сотрудника").equals(String.valueOf(id))) {

                    fullName.add("Фамилия: ");
                    fullName.add((executeQuery.getString("Фамилия")));
                    fullName.add("\nИмя: ");
                    fullName.add((executeQuery.getString("Имя")));
                    fullName.add("\nОтчество: ");
                    fullName.add((executeQuery.getString("Отчество")));
                    fullName.add("\nНомер телефона: ");
                    fullName.add((executeQuery.getString("Номер_телефона")));
                    fullName.add("\nАдрес: ");
                    fullName.add((executeQuery.getString("Адрес")));
                }
            }

            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT * FROM " + table2);

            while (executeQuery.next()) {

                if (executeQuery.getString("Id_Сотрудника").equals(String.valueOf(id))) {

                    fullName.add("\nНазвание должности: ");
                    fullName.add((executeQuery.getString("Название_должности")));
                    fullName.add("\nЗаработная плата: ");
                    fullName.add((executeQuery.getString("Заработная_плата")));
                    fullName.add("\nСтаж работы: ");
                    fullName.add((executeQuery.getString("Стаж_работы")));
                    fullName.add("\nУровень должности: ");
                    fullName.add((executeQuery.getString("Повышение_должности")));
                }
            }

            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT * FROM " + "Сотрудник");

            while (executeQuery.next()) {

                if (executeQuery.getString("Id_Сотрудника").equals(String.valueOf(id))) {

                    fullName.add("\nОтдел: ");
                    fullName.add((executeQuery.getString("Отдел")));

                }
            }

            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fullName;
    }


    public static ArrayList<String> getDepartment(String table) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> department = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            while (executeQuery.next()) {
                stringBuilder.append(executeQuery.getInt("Id_Отдела"));
                stringBuilder.append(" ");
                stringBuilder.append(executeQuery.getString("Название_отдела"));
                department.add(String.valueOf(stringBuilder));
                stringBuilder = new StringBuilder();
            }

            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public static ArrayList<String> getFullDepartment(String table, int id) {

        ArrayList<String> depInf = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery
                    ("SELECT * FROM " + table);

            while (executeQuery.next()) {

                if (executeQuery.getString("Id_Отдела").equals(String.valueOf(id))) {

                    depInf.add("Название отдела: ");
                    depInf.add(executeQuery.getString("Название_отдела"));

                    if (Integer.parseInt(executeQuery.getString("Начальник_отдела")) == 0){
                        depInf.add("\nНачальник отдела: ");
                        depInf.add("Начальник отдела не назначен");
                    } else {
                        depInf.add("\nНачальник отдела: ");
                        depInf.add(executeQuery.getString("Начальник_отдела"));
                    }
                    depInf.add("\nПроекты: ");
                    depInf.add(executeQuery.getString("Проекты"));
                }

            }
            executeQuery.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depInf;
    }

    public static ArrayList<String> getProject(String table) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM " + table);

            while (executeQuery.next()) {
                stringBuilder.append(executeQuery.getInt("Id_Проекта"));
                stringBuilder.append(" ");
                stringBuilder.append(executeQuery.getString("Название_проекта"));
                proj.add(String.valueOf(stringBuilder));
                stringBuilder = new StringBuilder();
            }

            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static ArrayList<String> getFullProject(String table, int id) {


        ArrayList<String> proj = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery("SELECT * FROM " + table);

            while (executeQuery.next()) {

                if (executeQuery.getString("Id_Проекта").equals(String.valueOf(id))) {

                    proj.add("Название проекта: ");
                    proj.add(executeQuery.getString("Название_проекта"));
                    proj.add("\nОтдел исполнитель: ");
                    proj.add(executeQuery.getString("Отдел_исполнитель"));
                    proj.add("\nФинансирование проекта: ");
                    proj.add(executeQuery.getString("Финансирование_проекта"));
                    proj.add("\nСрок сдачи: ");
                    proj.add(executeQuery.getString("Срок_сдачи"));

                }
            }

            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proj;
    }

    public static String query1() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        " +
                                    "SUM(CASE WHEN Название_должности = 'Какая-то должность 1' THEN 1 ELSE 0 END) AS [Кл-во]\n" +
                                    "FROM            dbo.Должность");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Кл-во");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static String query2() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT    dbo.Должность.Название_должности AS Должность\n" +
                            "      FROM     dbo.Должность " +
                            "      INNER JOIN\n" +
                            "               dbo.Сотрудник ON dbo.Должность.Id_Сотрудника = dbo.Сотрудник.Должность\n" +
                            "      WHERE    (dbo.Сотрудник.Id_Сотрудника = 1)");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Должность");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query3() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        Начальник_отдела AS [Начальники отделов]\n" +
                                    "FROM            dbo.Отдел");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Начальники отделов");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query4() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        COUNT(*) AS [Кл-во проектов]\n" +
                                    "FROM            dbo.Отдел");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Кл-во проектов");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query5() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        dbo.Действующие_проекты.Название_проекта AS Проекты\n" +
                                    "FROM            dbo.Действующие_проекты INNER JOIN\n" +
                                    "                         dbo.Отдел ON " +
                                    "dbo.Действующие_проекты.Id_Проекта = dbo.Отдел.Проекты\n" +
                                    "WHERE        (dbo.Действующие_проекты.Отдел_исполнитель = 1)");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Проекты");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query6() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT       " +
                                    " dbo.Личные_данные.Имя + '' + dbo.Личные_данные.Фамилия + '' + dbo.Личные_данные.Отчество AS Сотрудник\n" +
                                    "FROM            dbo.Личные_данные " +
                                    "INNER JOIN dbo.Сотрудник ON dbo.Личные_данные.Id_Сотрудника = dbo.Сотрудник.Id_Сотрудника " +
                                    "INNER JOIN dbo.Отдел ON dbo.Сотрудник.Отдел = dbo.Отдел.Id_Отдела\n" +
                                    "WHERE  Название_отдела = 'Какой-то отдел 1'");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Сотрудник");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query7() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        dbo.Должность.Стаж_работы AS Стаж\n" +
                                    "FROM        dbo.Должность INNER JOIN\n" +
                                    " dbo.Сотрудник ON dbo.Должность.Id_Сотрудника = dbo.Сотрудник.Должность\n" +
                                    "WHERE        (dbo.Сотрудник.Id_Сотрудника = 1)");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Стаж");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query8() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        dbo.Должность.Заработная_плата AS [З/П]\n" +
                                    "FROM            dbo.Должность INNER JOIN\n" +
                                    "dbo.Сотрудник ON dbo.Должность.Id_Сотрудника = dbo.Сотрудник.Должность INNER JOIN\n" +
                                    "dbo.Личные_данные ON dbo.Сотрудник.Id_Сотрудника = dbo.Личные_данные.Id_Сотрудника\n" +
                                    "WHERE        (dbo.Сотрудник.Id_Сотрудника = 1)");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("З/П");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    public static String query9() {

        String query = "";

        try {
            Statement stmt = connection.createStatement();
            ResultSet executeQuery =
                    stmt.executeQuery
                            ("SELECT        dbo.Отдел.Название_отдела AS Отдел, dbo.Личные_данные.Имя + '' + dbo.Личные_данные.Фамилия + '' + dbo.Личные_данные.Отчество AS Сотрудники, \n" +
                                    "                         dbo.Должность.Название_должности + ' стаж работы ' + dbo.Должность.Стаж_работы AS Должность, dbo.Действующие_проекты.Название_проекта AS Проект\n" +
                                    "FROM            dbo.Сотрудник INNER JOIN\n" +
                                    "                         dbo.Отдел ON dbo.Сотрудник.Отдел = dbo.Отдел.Id_Отдела INNER JOIN\n" +
                                    "                         dbo.Личные_данные ON dbo.Сотрудник.Id_Сотрудника = dbo.Личные_данные.Id_Сотрудника INNER JOIN\n" +
                                    "                         dbo.Должность ON dbo.Сотрудник.Должность = dbo.Должность.Id_Сотрудника FULL OUTER JOIN\n" +
                                    "                         dbo.Действующие_проекты ON dbo.Отдел.Id_Отдела = dbo.Действующие_проекты.Отдел_исполнитель\n" +
                                    "WHERE        (dbo.Действующие_проекты.Финансирование_проекта > 100) AND (dbo.Отдел.Id_Отдела = 1) AND (dbo.Сотрудник.Отдел = 1)");
            while (executeQuery.next()) {
                query = query + " " + executeQuery.getString("Отдел") + query
                        + " " + executeQuery.getString("Сотрудники") + query
                        + " " + executeQuery.getString("Должность") + query
                        + " " + executeQuery.getString("Проект");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

}



