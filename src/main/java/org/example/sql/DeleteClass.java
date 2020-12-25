package org.example.sql;

import org.example.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void deleteFromProj(int id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Действующие_проекты WHERE [Id_Проекта] = '" + id + "'");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: deleteNewPerf");
            e.printStackTrace();
        }

    }
}
