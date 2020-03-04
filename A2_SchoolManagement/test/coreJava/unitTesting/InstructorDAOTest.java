package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import coreJava.categoryInterface.SampleDataTests;
import coreJava.dao.InstructorDAO;
import coreJava.models.Instructor;

public class InstructorDAOTest
{
    List<Instructor> allInsList;
    InstructorDAO insDAO;
    
    @Before
    public void TestPrep() throws NumberFormatException, IOException {
    	allInsList = new ArrayList<>();
    	BufferedReader reader = new BufferedReader(new FileReader("getAllInstructorsTestData.txt"));
        String read = null;
    	
        reader.readLine();//to pass first line of column names
    	
        while((read = reader.readLine()) != null) {
     	   Instructor ins = new Instructor();
     	   String temp[] = read.split("\\s{2,}");
     	   
     	   ins.setInstructor_id(Integer.parseInt(temp[0]));
     	   ins.setFull_name(temp[1]);
     	   ins.setEmail(temp[2]);
     	   ins.setSpeciality(temp[3]);
     	   ins.setAdmin_role(Integer.parseInt(temp[4]));
     	   ins.setPass(temp[5]);
 		   
     	   allInsList.add(ins);
 	   }
        reader.close();
    }


    @Test
    @Category({SampleDataTests.class})
    public void getAllInstructorsTest() throws ClassNotFoundException, IOException {
        insDAO = new InstructorDAO();
        List<Instructor> insFromDb = insDAO.getAllInstructors();
        
        boolean valid = false;
        for(Instructor allInstructor : allInsList) {
        	for(Instructor instructorDB : insFromDb) {
        		if(allInstructor.getInstructor_id() == instructorDB.getInstructor_id() &&
        				allInstructor.getFull_name().equals(instructorDB.getFull_name()) &&
        				allInstructor.getEmail().equals(instructorDB.getEmail()) && 
        				allInstructor.getSpeciality().equals(instructorDB.getSpeciality()) &&
        				allInstructor.getAdmin_role() == instructorDB.getAdmin_role() &&
        				allInstructor.getPass().equals(instructorDB.getPass())) {
        			valid = true;
        			break;
        		}
        		else
        			valid = false;
        	}
        	if(!valid)
        		break;
        }
        assertThat(valid, equalTo(true));
    }
}
