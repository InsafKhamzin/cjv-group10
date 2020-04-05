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

	static ConnectionPool pool = ConnectionPool.getInstance();
	static Connection connection = null;
    /**
     * Add employee
     * @param employee - employee object
     */
    public static boolean addEmployee(Employee employee) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        boolean result = false;

        try{
            connection = pool.getConnection();

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
            result = true;
        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
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
        return result;
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
            connection = pool.getConnection();

            statement = connection.prepareCall("{? = call P_SECURITY.f_security(?,?)}");
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, user);
            statement.setString(3, password);

            statement.execute();

            id = statement.getInt(1);


        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
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
            connection = pool.getConnection();

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
            ConnectionPool.printSQLException(ex);
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
    
    public static ArrayList<Employee> searchEmployees(String input) {
        
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Employee> list = null;
        try{
            connection = pool.getConnection();

            String query = "select * from Employees "
            		+ "inner join Departments on (Employees.DEPARTMENT_ID = Departments.DEPARTMENT_ID) "
            		+ "where LOWER(Employees.FIRST_NAME) like ? or LOWER(Employees.LAST_NAME) like ? or LOWER(Employees.EMAIL) like ? "
            		+ "or LOWER(Employees.PHONE_NUMBER) like ? or LOWER(Departments.DEPARTMENT_NAME) like ? ";
            
            statement = connection.prepareStatement(query);
            input = "%" + input + "%";

            statement.setString(1, input);
            statement.setString(2, input);
            statement.setString(3, input);
            statement.setString(4, input);
            statement.setString(5, input);

            resultSet = statement.executeQuery();
            
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
            	e.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
            	
            	list.add(e);
            }      

        } catch (Exception ex){
            System.out.println("DaManager searchEmployees ex: " + ex);
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
            connection = pool.getConnection();

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
            ConnectionPool.printSQLException(ex);
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
        
        OracleCallableStatement statement = null;
        ResultSet resultSet = null;
        Employee e = null;
        try{
        	connection = pool.getConnection();

            statement = ConnectionPool.getOracleCallableStatement(connection.prepareCall("{call P_SECURITY.P_EMP_INFO(?,?)}"));
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
            ConnectionPool.printSQLException(ex);
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
    public static boolean updateEmployee(Employee employee){
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        boolean result = false;
        try{
        	connection = pool.getConnection();

        	statement = connection.prepareStatement( "select first_name, last_name, email, phone_number, " +
                            "hire_date, job_id, salary, commission_pct, manager_id, department_id from Employees where EMPLOYEE_ID = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        	statement.setInt(1, employee.getEmployeeId());

			resultSet = statement.executeQuery();

			resultSet.first();
			resultSet.updateString(1, employee.getFirstName());
			resultSet.updateString(2, employee.getLastName());
			resultSet.updateString(3, employee.getEmail());
			resultSet.updateString(4, employee.getPhoneNumber());
			resultSet.updateDate(5, employee.getHireDate());
			resultSet.updateString(6,employee.getJobId());
			resultSet.updateFloat(7, employee.getSalary());
			resultSet.updateFloat(8, employee.getCommissionPercent());
			resultSet.updateObject(9, employee.getManagerId() == 0 ? null : employee.getManagerId());
			resultSet.updateInt(10, employee.getDepartmentId());
			resultSet.updateRow();
        	
            result = true;
        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
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
    public static boolean deleteEmployeeById(int employeeId){
        
        Statement statement = null;
        ResultSet resultSet = null;

        boolean result = false;

        try{
            connection = pool.getConnection();
            statement = connection.createStatement();
            String query = "delete from Employees where EMPLOYEE_ID = " + employeeId;
            
            statement.executeUpdate(query);
            result = true;
        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
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
        
        Statement statement = null;
        ResultSet resultSet = null;

        boolean result = false;

        try{
            connection = pool.getConnection();
            
            connection.setAutoCommit(false);
            
            statement = connection.createStatement();

            for(String sql : SQLs) {
            	statement.addBatch(sql);
            }
            
            int count[] = statement.executeBatch();

            for (int i = 0; i < count.length; i++) {
                System.out.println("SQL " + (i + 1) + " has affected " + count[i] + " times");
            }
            
            connection.commit();
            result = true;
        } catch (BatchUpdateException ex) {
        	try {
        	connection.rollback();
        	} catch(SQLException e) {
        		System.err.println(e.getMessage());
        	}
            ConnectionPool.printSQLException(ex);
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
    
    public static ArrayList<Department> getAllDepartments(){

    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Department> list = null;
        try{
            connection = pool.getConnection();

            statement = connection.createStatement();
            
            String query = "select * from Departments";
            
            resultSet = statement.executeQuery(query);
            
            list = new ArrayList<>();
            
            while(resultSet.next()) {
            	Department d = new Department();
            	
            	d.setId(resultSet.getInt("DEPARTMENT_ID"));
            	d.setName(resultSet.getString("DEPARTMENT_NAME"));
            	
            	list.add(d);
            }      

        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager getAllDepartments ex: " + ex);
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
    
    public static Department getDepartmentById(int departmentId){

    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Department d = null;
        try{
            connection = pool.getConnection();

            statement = connection.prepareStatement("select * from Departments where DEPARTMENT_ID = ?");
            statement.setInt(1, departmentId);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	d = new Department();
            	d.setId(resultSet.getInt("DEPARTMENT_ID"));
            	d.setName(resultSet.getString("DEPARTMENT_NAME"));            	
            }      

        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager getDepartmentById ex: " + ex);
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
        
        return d;
    }
    
    public static ArrayList<String> getAllJobIds(){

    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> list = null;
        try{
            connection = pool.getConnection();

            statement = connection.createStatement();
            
            String query = "select * from Jobs";
            
            resultSet = statement.executeQuery(query);
            
            list = new ArrayList<>();
            
            while(resultSet.next()) {            	
            	list.add(resultSet.getString("JOB_ID"));
            }      

        } catch (SQLException ex) {
            ConnectionPool.printSQLException(ex);
        } catch (Exception ex){
            System.out.println("DaManager getAllJobIds ex: " + ex);
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
}
