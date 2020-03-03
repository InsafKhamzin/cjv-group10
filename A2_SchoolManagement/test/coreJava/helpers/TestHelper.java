package coreJava.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import coreJava.dao.OracleConnection;
import coreJava.models.Attending;
import coreJava.models.Course;

public class TestHelper
{
    public static void deleteRecordHelper(String query, int idToDelete) throws ClassNotFoundException, IOException, SQLException {
       
    	Connection conn = null;
        Statement stmt = null;
        String sql = query + " where attending_id = " + idToDelete;
        OracleConnection Oracle = new OracleConnection();
            try
            {
                conn = Oracle.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
            catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                
            }
    }
    
    public static List<Course> coursesHelper(String fileName) throws IOException {
       List<Course> courses = new ArrayList<>();
       
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
       String read = null;
   	
       reader.readLine();//to pass first line of column names
   	
       while((read = reader.readLine()) != null) {
    	   Course c = new Course();
    	   String temp[] = read.split("\\s{2,}");
		   
    	   c.setCourse_id(Integer.parseInt(temp[0]));
		   c.setCourse_name(temp[1]);
		   c.setMinimun_gpa(Double.parseDouble((temp[2])));
		   courses.add(c);
	   }
       reader.close();
       
       return courses;
    }
}
