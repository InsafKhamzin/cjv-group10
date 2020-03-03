package coreJava.unitTesting;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.SampleDataTests;
import coreJava.dao.CourseDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;

@Category({SampleDataTests.class})
public class CourseDAOTest
{
    List<Course> AllCourseList;
    List<Course> coursesByInsList;
    CourseDAO couDAO;

    @Before
    public void testPrep() throws IOException {
        AllCourseList = TestHelper.coursesHelper("getAllCoursesTestData.txt");
        coursesByInsList = TestHelper.coursesHelper("getCourseByInstructorTestData.txt"); 
    }
    
 
    @Test
    @Category({SampleDataTests.class})
    public void getAllCoursesTest() throws ClassNotFoundException, IOException {
        couDAO = new CourseDAO();
        List<Course> courseFromDB = new ArrayList<>();
        courseFromDB = couDAO.getAllCourses();
        
        boolean valid = false;
        
        for (Course lCourse : coursesByInsList) {
	        for (Course course : courseFromDB) {
				if(lCourse.getCourse_id() == course.getCourse_id() &&
						lCourse.getCourse_name().equals(course.getCourse_name()) &&
								lCourse.getMinimun_gpa() == course.getMinimun_gpa()) {
					valid = true;
					break;
				} else
					continue;
			}
	        if(!valid)
	        	break;
        }
        assertThat(valid, equalTo(true));
    }

    @Test
    @Category({SampleDataTests.class})
    public void getCourseByInstructorTest() throws ClassNotFoundException, IOException {
    	couDAO = new CourseDAO();
        List<Course> courseFromDB = new ArrayList<>();
        courseFromDB = couDAO.getCourseByInstructor(23);
        
        boolean valid = false;
        
        for (Course lCourse : coursesByInsList) {
	        for (Course course : courseFromDB) {
				if(lCourse.getCourse_id() == course.getCourse_id() &&
						lCourse.getCourse_name().equals(course.getCourse_name()) &&
								lCourse.getMinimun_gpa() == course.getMinimun_gpa()) {
					valid = true;
					break;
				} else
					continue;
			}
	        if(!valid)
	        	break;
        }
        assertThat(valid, equalTo(true));
    }
}
