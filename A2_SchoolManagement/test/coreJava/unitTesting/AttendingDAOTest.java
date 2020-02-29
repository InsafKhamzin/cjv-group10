package coreJava.unitTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.AttendingDAO;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Student;

public class AttendingDAOTest
{
    List<Attending> attList;
    AttendingDAO attDAO;
    boolean isDeleting;
    Integer idToDelete;
    Student stu;
    Course cou;
    
    public void testPrep() throws IOException {
        
    }
    
    
    public void registerStudentToCourseTest() throws StudentRegistrationException{
      
    }
    
    
    public void getStudentCourseTest() {
      
    }
    
  
    public void cleanUpTestWork() throws ClassNotFoundException, IOException, SQLException {
       
    }
}
