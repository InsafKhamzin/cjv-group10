package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.TeachingDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Teaching;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TeachingDAOTest
{
    List<Teaching> teaList;
    TeachingDAO teaDAO;
    Integer idToDelete;
    boolean isDeleting;
    Course cou;
    Instructor ins;
    
    @Before
    public void testPrep() throws NumberFormatException, IOException {
       
    }

    @Test
    public void assignInstructorToCourse() throws StudentRegistrationException{
        
    }


    @Test
    public void getIntructorsCoursesTest() {
       
    }
    
   @After
    public void cleanUpTestWork() throws ClassNotFoundException, IOException, SQLException {
       
    }
}
