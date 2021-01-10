package org.example.sql;

import org.example.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeleteClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromPerFile(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Личные_данные WHERE [Id_Сотрудника] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromPos(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Должность WHERE [Id_Сотрудника] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromEmp(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Сотрудник WHERE [Id_Сотрудника] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    public static void deleteFromDep(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Отдел WHERE [Id_Отдела] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }

    static int depId;
    static String pro;

    public static void deleteFromProj(int id) {


        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM Действующие_проекты");

            while (executeQuery.next()) {
                if (id == Integer.parseInt(executeQuery.getString("Id_Проекта"))) {
                    depId = Integer.parseInt(executeQuery.getString("Отдел_исполнитель"));
                }
            }

            executeQuery.close();

            executeQuery = stmt.executeQuery("SELECT * FROM Отдел");

            while (executeQuery.next()) {
                if (depId == Integer.parseInt(executeQuery.getString("Id_Отдела"))) {
                    pro = executeQuery.getString("Проекты");
                }
            }

            executeQuery.close();

            char[] arrayList = pro.toCharArray();
            int i;

            for (i = 0; i < arrayList.length; i++) {
                if (id == Integer.parseInt(String.valueOf(arrayList[i]))) {
                    break;
                }
            }

            pro = pro.substring(0, i) + pro.substring(i + 2);

            stmt.executeUpdate("UPDATE Отдел SET Проекты = " + "'" + pro + "'" + " WHERE Id_Отдела = " + depId);
            stmt.execute("DELETE FROM Действующие_проекты WHERE [Id_Проекта] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }
}
