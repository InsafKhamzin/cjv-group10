package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coreJava.categoryInterface.ModifyLevelTests;
import coreJava.categoryInterface.SampleDataTests;
import coreJava.customExceptions.StudentRegistrationException;
import coreJava.dao.CourseDAO;
import coreJava.dao.InstructorDAO;
import coreJava.dao.TeachingDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;
import coreJava.models.Instructor;
import coreJava.models.Teaching;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
    	teaList = new ArrayList<Teaching>();
    	
    	BufferedReader reader = new BufferedReader(new FileReader("getInstructorCoursesTestData.txt"));
    	String read = null;
    	
    	reader.readLine();//to pass first line of column names
    	
    	while((read = reader.readLine()) != null) {
    		
    		Teaching tea = new Teaching();
    		String temp[] = read.split("\\s{2,}");
    		
    		tea.setTeaching_id(Integer.parseInt(temp[0]));
    		tea.setCourse_name(temp[1]);
    		tea.setMinimun_gpa(Double.parseDouble(temp[2]));
    		tea.setFull_name(temp[3]);
    		tea.setEmail(temp[4]);
    			
    		teaList.add(tea);
    	}
    	    	
    	reader.close(); 
    	
    	assertThat(teaList.size(), greaterThanOrEqualTo(1));
    }

    @Test
    @Category({ModifyLevelTests.class})
    public void assignInstructorToCourse() throws StudentRegistrationException, ClassNotFoundException, IOException {
    	
    	InstructorDAO insDAO = new InstructorDAO();
    	ins = insDAO.getInstructoByEmail("luke@gmail.com");
    	
    	CourseDAO couDAO = new CourseDAO();
    	cou = couDAO.getCourseById(2);
    	
    	teaDAO = new TeachingDAO();
    	idToDelete = teaDAO.assignInstructorToCourse(cou.getCourse_id(), ins.getInstructor_id());
    	
    	assertThat(idToDelete, greaterThanOrEqualTo(0));
    	
    	isDeleting = true;
    }


    @Test
    @Category({SampleDataTests.class})
    public void getIntructorsCoursesTest() {
    	teaDAO = new TeachingDAO();
    	List<Teaching> teaListFromDB = new ArrayList<>();
    	teaListFromDB = teaDAO.getIntructorsCourses();
    	
    	boolean valid = false;
    	
    	for(Teaching tea: teaList) {
    		valid=false;
    		for(Teaching teach:teaListFromDB) {
    			if(tea.getTeaching_id() == teach.getTeaching_id()
    					&& tea.getCourse_name().equals(teach.getCourse_name())
    					&& tea.getMinimun_gpa() == teach.getMinimun_gpa()
    					&& tea.getFull_name().equals(teach.getFull_name())
    					&& tea.getEmail().equals(teach.getEmail())) {
    				valid=true;
    			}
    			else
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
		   TestHelper.deleteRecordHelper("delete from Teaching where teaching_id = ", idToDelete);
		   idToDelete = -1;
		   isDeleting=false;
	   }
	   
	   assertThat(isDeleting, is(false));
		   
    }
}
