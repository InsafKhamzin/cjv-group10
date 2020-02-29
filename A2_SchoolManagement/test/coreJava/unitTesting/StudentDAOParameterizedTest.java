package coreJava.unitTesting;

import coreJava.categoryInterface.ParameterizedTests;
import coreJava.dao.StudentDAO;
import coreJava.models.Student;
import coreJava.systemInterface.StudentDAOI;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

@Category(ParameterizedTests.class)
@RunWith(Parameterized.class)
public class StudentDAOParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Josephine Darakjy", "josephine_darakjy@darakjy.org", 2.9, "48116", -1, true},
                {"Lenna Paprocki", "lpaprocki@hotmail.com", 3.3, "99501", -1, true},
                {"Roxane Campain", "roxane@hotmail.com", 2.5, "99708", -1, true},
                {"Jani Biddy", "jbiddy@yahoo.com", 2.2, "98104W", -1, false},
        });
    }

    private String fullName;
    private String email;
    private double gpa;
    private String password;
    private int role;
    private boolean outcome;

    public StudentDAOParameterizedTest(String fullName, String email, double gpa,
                                       String password, int role, boolean outcome) {
        this.fullName = fullName;
        this.email = email;
        this.gpa = gpa;
        this.password = password;
        this.role = role;
        this.outcome = outcome;
    }

    @Test
    public  void shouldReturnCorrectStudent() throws IOException, ClassNotFoundException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentByEmail(email);
        assertThat(fullName, is(student.getFull_name()));
        assertThat(gpa, is(student.getGpa()));
        assertThat(role, lessThan(0));

        boolean isValid = studentDAO.validateUser(password, student.getPass());

        assertThat(outcome, is(isValid));
    }
}
