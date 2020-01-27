package ca.myseneca.model;

import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

/**
 * DaManger is data access layer for the application
 */
public class DaManager {

    /**
     * Add employee
     * @param employee - employee object
     */
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
            
            System.out.println("Employee Added");

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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
    }

    /**
     * Employee verification method. Returns 0 if user and password wasn't found
     * @param user - employee login
     * @param password - employee password
     * @return
     */
    public static int getEmployeeID(String user, String password) {
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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return id;
    }

    /**
     * Get the list of all employees
     * @return
     */
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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return list;
    }

    /**
     * Get the list of employees by certain department
     * @param depid - department id
     * @return
     */
    public static ArrayList<Employee> getEmployeesByDepartmentID (int depid) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Employee> list = new ArrayList<>();
        
        try{
            connection = new DbUtilities().getConnection();

            statement = connection.createStatement();
            
            String query = "select * from Employees where DEPARTMENT_ID = " + depid;
            
            resultSet = statement.executeQuery(query);
            
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
            System.out.println("DaManager updateEmployee ex: " + ex);
        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
    	return list;
    }

    /**
     * Returns employee by employee id
     * @param employeeId employee id
     * @return
     */
    public static Employee getEmployeeById(int employeeId){
        Connection connection = null;
        OracleCallableStatement statement = null;
        ResultSet resultSet = null;
        Employee e = null;
        try{
            connection = new DbUtilities().getConnection();

            statement = (OracleCallableStatement) connection.prepareCall("{call P_SECURITY.P_EMP_INFO(?,?)}");
            statement.setInt(1, employeeId);
            statement.registerOutParameter(2, OracleTypes.CURSOR);
            
            statement.execute();
            
            OracleResultSet orset = (OracleResultSet) statement.getCursor(2);
           
            if(orset.next()) {
                e = new Employee();

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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return e;
    }

    /**
     * Updating employee
     * @param employee employee object
     * @return
     */
    public static int updateEmployee(Employee employee){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int result = 0;
        try{
        	connection = new DbUtilities().getConnection();

        	statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			String query = "select * from Employees where EMPLOYEE_ID = " + employee.getEmployeeId();

			resultSet = statement.executeQuery(query);

			resultSet.absolute(1);
			resultSet.updateString(2, employee.getFirstName());
			resultSet.updateString(3, employee.getLastName());
			resultSet.updateString(4, employee.getEmail());
			resultSet.updateString(5, employee.getPhoneNumber());
			resultSet.updateDate(6, employee.getHireDate());
			resultSet.updateString(7,employee.getJobId());
			resultSet.updateFloat(8, employee.getSalary());
			resultSet.updateFloat(9, employee.getCommissionPercent());
			resultSet.updateInt(10, employee.getManagerId());
			resultSet.updateInt(11, employee.getDepartmentId());
			resultSet.updateRow();
        	
            result = employee.getEmployeeId();
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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return result;
    }

    /**
     * Delete employee
     * @param employeeId - employee id
     * @return
     */
    public static int deleteEmployeeById(int employeeId){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int result = 0;

        try{
            connection = new DbUtilities().getConnection();

            statement = connection.createStatement();
            
            String query = "delete from Employees where EMPLOYEE_ID = " + employeeId;
            
            statement.executeUpdate(query);
            result = employeeId;
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
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return result;
    }

    /**
     * Batch update. Commit on success, rollback if exception occurred
     * @param SQLs
     * @return
     */
    public static boolean batchUpdate(String [] SQLs) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        boolean result = false;

        try{
            connection = new DbUtilities().getConnection();
            
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();

            for(String sql : SQLs) {
            	statement.addBatch(sql);
            }
            
            int count[] = statement.executeBatch();
            
            for(int i=1;i<=count.length;i++){
                System.out.println("SQL " + i + " has affected " + count[i] + " times");
            }
            
            connection.commit();
            result = true;
        } catch (BatchUpdateException ex) {
        	try {
        	connection.rollback();
        	} catch(SQLException e) {
        		System.err.println(e.getMessage());
        	}
            DbUtilities.printSQLException(ex);
        } catch (Exception ex){
        	try {
            	connection.rollback();
            	} catch(SQLException e) {
            		System.err.println(e.getMessage());
            	}
            System.err.println("DaManager batchUpdate ex: " + ex);

        }
        finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            }catch (SQLException ex){
                System.out.println("Failed to close connection");
            }
        }
        return result;
    }
}
