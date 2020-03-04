package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.categoryInterface.ModifyLevelTests;
import coreJava.categoryInterface.SampleDataTests;
import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.AttendingDAO;
import coreJava.dao.CourseDAO;
import coreJava.dao.StudentDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Attending;
import coreJava.models.Course;
import coreJava.models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

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

    	attList = new ArrayList<Attending>();
    	
    	BufferedReader reader = new BufferedReader(new FileReader("getStudentCourseTestData.txt"));
    	String read = null;
    	
    	reader.readLine();//to pass first line of column names
    	
    	while((read = reader.readLine()) != null) {
    		
    		Attending att = new Attending();
    		String temp[] = read.split("\\s+");
    				
    		if(temp.length == 4) {
    			att.setAttending_id(Integer.parseInt(temp[0]));
    			att.setCourse_name(temp[1]);
    			att.setFull_name(temp[2]);
    			att.setEmail(temp[3]);
    		}
    		else {
    			att.setAttending_id(Integer.parseInt(temp[0]));
    			att.setCourse_name(temp[1]);
    			att.setFull_name(temp[2]+" "+temp[3]);
    			att.setEmail(temp[4]);
    		}
    		attList.add(att);
    	}
    	    	
    	reader.close();
    	
    	assertThat(attList.size(), greaterThanOrEqualTo(1));
    }
    

    @Test
    @Category({ModifyLevelTests.class})
    public void registerStudentToCourseTest() throws StudentRegistrationException, ClassNotFoundException, IOException {

    	StudentDAO stuDAO = new StudentDAO();
    	stu = stuDAO.getStudentByEmail("J@gmail.com");
    	
    	CourseDAO couDAO = new CourseDAO();
    	cou = couDAO.getCourseById(1);
    	
    	attDAO = new AttendingDAO();
    	
    	idToDelete = attDAO.registerStudentToCourse(stu, cou);
    	
    	assertThat(idToDelete, greaterThanOrEqualTo(0));
    	
    	isDeleting = true;
    }

    
    
    @Test
    @Category({SampleDataTests.class})
    public void getStudentCourseTest() {
      
    	//test that elements of attList is present in the Database
    	attDAO = new AttendingDAO();
    	List<Attending> attListFromDB = new ArrayList<>();
    	attListFromDB = attDAO.getStudentCourse(41);
    	
    	boolean valid = false;
    	
    	for(Attending att : attList) {
    		valid=false;
    		for(Attending attend : attListFromDB) {
    			if(att.getAttending_id() == attend.getAttending_id()
    					&& att.getCourse_name().equals(attend.getCourse_name())
    					&& att.getFull_name().equals(attend.getFull_name())
    					&& att.getEmail().equals(attend.getEmail())) {
    				valid = true;
    				break;
    			}else
    				continue;
    		}
    		if(valid == false)
    			break;
    	}
    	
    	
        assertThat(valid, equalTo(true));
    }
    
    
    @After
    public void cleanUpTestWork() throws ClassNotFoundException, IOException, SQLException {
       
    	if(isDeleting) {
    		TestHelper.deleteRecordHelper("delete from Attending where attending_id = ", idToDelete);
    		idToDelete = -1;
    		isDeleting = false;
    	}
    	
 	   assertThat(isDeleting, is(false));
    }
}
