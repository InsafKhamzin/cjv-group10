package ca.myseneca.model;

import java.sql.*;
import java.util.List;

public class DaManager {

    public static int verifyEmployee(String user, String password) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (SQLException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager addEmployee ex: " + ex);
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return 0;
    }

    public static void addEmployee(Employee employee) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (SQLException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager addEmployee ex: " + ex);
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
    }

    public static Employee getEmployeeById(int employeeId){
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (SQLException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager getEmployeeById ex: " + ex);
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return null;
    }

    public static int updateEmployee(Employee employee){
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (SQLException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager updateEmployee ex: " + ex);
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return 0;
    }

    public static int deleteEmployeeById(int employeeId){
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (SQLException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager deleteEmployeeById ex: " + ex);

        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return 0;
    }

    public static boolean batchUpdate(List<Employee> employees) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            //TODO

        } catch (BatchUpdateException ex) {
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager batchUpdate ex: " + ex);

        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed");
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return false;
    }

}
