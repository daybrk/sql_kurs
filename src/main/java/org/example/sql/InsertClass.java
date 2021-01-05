package org.example.sql;

import org.example.ConnectDB;
import org.example.QueryStrings;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertClass {

    private static final Connection connection = ConnectDB.getConnection();

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Boolean addNewPerFile(int id, String firstName, String secondName,
                                     String middleName, String numPhone, String address) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewPersonalFile +
                    " VALUES (" + id + ",'" + firstName + "','" + secondName + "','" + middleName + "','"
                    + numPhone + "','" + address + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewPerf");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Boolean addNewPos(int id, String jobTit, String wages,
                                 String workExp, String uPost) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewPosition +
                    " VALUES (" + id + ",'" + jobTit + "','" + wages + "','" + workExp + "','" + uPost + "')");

            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewPos");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Boolean addNewEmp(int id, int pos, int dep) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewEmployee +
                    " VALUES (" + id + "," + pos + "," + dep + ")");

            ConnectDB.maxId++;
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: addNewEmp");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void addNewDep(int id, String depName, int depChief, String proj) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewDepartment +
                    "VALUES (" + id + ",'" + depName + "','" + depChief + "','" + proj + "')");

            ConnectDB.maxDepId++;
            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewDep");
            e.printStackTrace();
        }
    }

    public static void addNewProj(int id, String projName, int exeDep, String projFin, String deadline) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(QueryStrings.addNewProject +
                    "VALUES (" + id + ",'" + projName + "','" + exeDep + "','" + projFin + "','" + deadline + "')");

            ConnectDB.maxProjId++;
            stmt.close();
        } catch (SQLException  e) {
            System.out.println("Error: addNewProj");
            e.printStackTrace();
        }
    }

}
