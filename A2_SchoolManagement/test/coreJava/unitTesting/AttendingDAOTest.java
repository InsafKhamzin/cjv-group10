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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AttendingDAOTest
{
    List<Attending> attList;
    AttendingDAO attDAO;
    boolean isDeleting;
    Integer idToDelete;
    Student stu;
    Course cou;

    @Before
    public void testPrep() throws IOException {
        
    }
    

    @Test
    public void registerStudentToCourseTest() throws StudentRegistrationException{
      
    }

    @Test
    public void getStudentCourseTest() {
      
    }
    
    @After
    public void cleanUpTestWork() throws ClassNotFoundException, IOException, SQLException {
       
    }
}
