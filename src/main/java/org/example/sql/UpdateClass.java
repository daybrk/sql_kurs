package org.example.sql;

import org.example.ConnectDB;

import java.sql.*;

public class UpdateClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void updateEmpInf(int id, String firstName, String secondName,
                                    String middleName, String numPhone, String address) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Личные_данные SET Имя = " + "'" + firstName + "'" + ", Фамилия = " +
                            "'" + secondName + "'" + ", Отчество = " + "'" + middleName + "'" + ", Номер_телефона = "
                            +  "'" + numPhone + "'" + ",  Адрес = " + "'" + address + "'" + " WHERE Id_Сотрудника = " + id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePosInf(int id, String jobTit, int wages,
                                    String workExp, String uPost) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Должность SET Название_должности = " + "'" + jobTit + "'" + ", Заработная_плата = " +
                            "'" + wages + "'" + ", Стаж_работы = " + "'" + workExp + "'" + ", Повышение_должности = "
                            +  "'" + uPost + "'" + " WHERE Id_Сотрудника = " + id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDepInf(int id, String depName, String depChief, int proj) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Отдел SET Название_отдела = " + "'" + depName + "'" + ", Начальник_отдела = " +
                            "'" + depChief + "'" + ", Проекты = " + "'" + proj + "'" + " WHERE Id_Отдела = " + id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDepProj(int id, int proj) {

        String pro = String.valueOf(proj - 1);
        try {
            Statement stmt = connection.createStatement();

            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM Отдел");

            while (executeQuery.next()) {
                System.out.println(id);
                if (id == Integer.parseInt(executeQuery.getString("Id_Отдела"))) {
                    pro = pro + " " + executeQuery.getString("Проекты");
                }
            }

            stmt.executeUpdate
                    ("UPDATE Отдел SET Проекты = " + "'" + pro + "'" + " WHERE Id_Отдела = " + id);

            executeQuery.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProj(int id, String projName, int excDep, String projFin, String deadline) {

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate
                    ("UPDATE Действующие_проекты SET Название_проекта = " + "'" + projName + "'" +
                            ", Отдел_исполнитель = " + "'" + excDep + "'" + ", Финансирование_проекта = " + "'"
                            + projFin + "'" + ", Срок_сдачи = " + "'" + deadline + "'" + " WHERE Id_Проекта = " + id);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
