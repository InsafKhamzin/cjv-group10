package coreJava.unitTesting;

import coreJava.categoryInterface.ParameterizedTests;
import coreJava.dao.InstructorDAO;
import coreJava.dao.StudentDAO;
import coreJava.models.Instructor;
import coreJava.models.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Category(ParameterizedTests.class)
@RunWith(Parameterized.class)
public class InstructorDAOParameterizedTest
{
 
	@Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {21,"Ruthann Keener", "ruthann@hotmail.com", "Physics", 0, "78028", "Instructor"},
                {22,"Kati Rulapaugh", "kati.rulapaugh@hotmail.com", "Analyst", 0, "67410", "Instructor"},
                {23,"Loren Asar", "loren.asar@aol.com", "English", 1, "18518", "Admin"},
                {3,"mark", "mark@gmail.com", "History", 1, "667", "Wrong Credentials"},
        });
    }	
	
	private int id;
    private String fullName;
    private String email;
    private String subject;
    private int role;
    private String password;
    private String designation;

    public InstructorDAOParameterizedTest(int id, String fullName, String email, String subject,
                                       int role, String password, String designation) {
        this.id = id;
    	this.fullName = fullName;
        this.email = email;
        this.subject = subject;
        this.role = role;
        this.password = password;
        this.designation = designation;
    }
    
    
    @Test
    public  void shouldReturnCorrectInstructor() throws IOException, ClassNotFoundException {
        InstructorDAO instructorDAO = new InstructorDAO();
        Instructor instructor = instructorDAO.getInstructoByEmail(email);        
        assertThat(fullName, is(instructor.getFull_name()));
        assertThat(role, is(instructor.getAdmin_role()));

        String _designation = instructorDAO.validateUser(instructor, password);
        assertThat(designation, is(_designation));
        
        
    }
    
    
}
