package coreJava.unitTesting;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.SampleDataTests;
import coreJava.dao.CourseDAO;
import coreJava.helpers.TestHelper;
import coreJava.models.Course;


public class CourseDAOTest
{
    List<Course> AllCourseList;
    List<Course> coursesByInsList;
    CourseDAO couDAO;
   
    public void testPrep() throws IOException {
        
    }
    
 
  
    public void getAllCoursesTest() throws ClassNotFoundException, IOException {
        
    }
    
    
    public void getCourseByInstructorTest() throws ClassNotFoundException, IOException {
       
    }
}
