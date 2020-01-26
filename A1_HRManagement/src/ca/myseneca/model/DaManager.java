package ca.myseneca.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class DaManager {

    public static int verifyEmployee(String user, String password) {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;
        int id = 0;
        
        try {
            connection = new DbUtilities().getConnection();

            statement = connection.prepareCall("{? = call P_SECURITY.f_security(?,?)}");
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, user);
            statement.setString(3, password);
            
            statement.execute();
            
            id = statement.getInt(1);
            

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
        return id;
    }

    public static void addEmployee(Employee employee) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = new DbUtilities().getConnection();

            String query = "insert into Employees values (?,?,?,?,?,?,?,?,?,?,?)";
            
            statement = connection.prepareStatement(query);
            
            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getEmail());
            statement.setString(5,employee.getPhoneNumber());
            statement.setDate(6, employee.getHireDate());
            statement.setString(7, employee.getJobId());
            statement.setFloat(8, employee.getSalary());
            statement.setFloat(9, employee.getCommissionPercent());
            statement.setInt(10, employee.getManagerId());
            statement.setInt(11, employee.getDepartmentId());
            
            statement.executeUpdate();
            

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

    
    public static int getEmployeeID(String user, String password) {
    
    		int id = verifyEmployee(user, password);
            
            if(id == 0) {
            	System.out.println("User does not exist");
            	System.exit(-1);
            }
            
            return id;
    }
    
    
    public static ArrayList<Employee> getAllEmployees() {
    
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Employee> list = null;
        try{
            connection = new DbUtilities().getConnection();

            statement = connection.createStatement();
            
            String query = "select * from Employees";
            
            resultSet = statement.executeQuery(query);
            
            list = new ArrayList<>();
            
            while(resultSet.next()) {
            	Employee e = new Employee();
            	
            	e.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
            	e.setFirstName(resultSet.getString("FIRST_NAME"));
            	e.setLastName(resultSet.getString("LAST_NAME"));
            	e.setEmail(resultSet.getString("EMAIL"));
            	e.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
            	e.setHireDate(resultSet.getDate("HIRE_DATE"));
            	e.setJobId(resultSet.getString("JOB_ID"));
            	e.setSalary(resultSet.getFloat("SALARY"));
            	e.setCommissionPercent(resultSet.getFloat("COMMISSION_PCT"));
            	e.setManagerId(resultSet.getInt("MANAGER_ID"));
            	e.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
            	
            	list.add(e);
            }      

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
        return list;
    }
    
    public static ArrayList<Employee> getEmployeesByDepartmentID (int depid) {
    	
    	
    	return null;
    }
    
    
    public static Employee getEmployeeById(int employeeId){
        Connection connection = null;
        OracleCallableStatement statement = null;
        ResultSet resultSet = null;
        Employee e = new Employee();
        try{
            connection = new DbUtilities().getConnection();

            statement = (OracleCallableStatement) connection.prepareCall("{call P_SECURITY.P_EMP_INFO(?,?)}");
            statement.setInt(1, employeeId);
            statement.registerOutParameter(2, OracleTypes.CURSOR);
            
            statement.execute();
            
            OracleResultSet orset = (OracleResultSet) statement.getCursor(2);
           
            if(orset.next()) {
            
            	e.setEmployeeId(orset.getInt(1));
            	e.setFirstName(orset.getString(2));
            	e.setLastName(orset.getString(3));
            	e.setEmail(orset.getString(4));
            	e.setPhoneNumber(orset.getString(5));
            	e.setHireDate(orset.getDate(6));
            	e.setJobId(orset.getString(7));
            	e.setSalary(orset.getFloat(8));
            	e.setCommissionPercent(orset.getFloat(9));
            	e.setManagerId(orset.getInt(10));
            	e.setDepartmentId(orset.getInt(11));
            }
            
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
        return e;
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
