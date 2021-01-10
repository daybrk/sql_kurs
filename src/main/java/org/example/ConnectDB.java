package org.example;


import java.sql.*;

public class ConnectDB {

    private static String url = "jdbc:sqlserver://DESKTOP-O8NA0U3\\SQLEXPRESS01;database=KursovayaDB;";
    private static Connection connection;
    public static int maxId;
    public static int maxDepId;
    public static int maxProjId;

    public static String getUrl() {
        return url;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void ex() {

        String s = "   212";
        s = s.replaceAll("2", "");
        System.out.println(s);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(url, "User", "User");
            Statement stmt = connection.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT [Id_Сотрудника] FROM Личные_данные");

            maxId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Id_Сотрудника"));
                if (maxId < id) {
                    maxId = id;
                }
            }
            maxId++;
            executeQuery.close();


            executeQuery = stmt.executeQuery("SELECT [Id_Отдела] FROM Отдел");

            maxDepId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Id_Отдела"));
                if (maxDepId < id) {
                    maxDepId = id;
                }
            }
            maxDepId++;
            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT [Id_Проекта] FROM Действующие_проекты");

            maxProjId = 0;
            while (executeQuery.next()) {
                int id = Integer.parseInt(executeQuery.getString("Id_Проекта"));
                if (maxProjId < id) {
                    maxProjId = id;
                }
            }
            maxProjId++;
            executeQuery.close();


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

    }

}
