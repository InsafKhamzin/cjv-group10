package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.io.IOException;
import java.sql.SQLException;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.TeachingDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Teaching;

public class TeachingDAOTest
{
    List<Teaching> teaList;
    TeachingDAO teaDAO;
    Integer idToDelete;
    boolean isDeleting;
    Course cou;
    Instructor ins;
    
    
    public void testPrep() throws NumberFormatException, IOException {
       
    }
    
    public void assignInstructorToCourse() throws StudentRegistrationException{
        
    }
    
    
    public void getIntructorsCoursesTest() {
       
    }
    
   
    public void cleanUpTestWork() throws ClassNotFoundException, IOException, SQLException {
       
    }
}
