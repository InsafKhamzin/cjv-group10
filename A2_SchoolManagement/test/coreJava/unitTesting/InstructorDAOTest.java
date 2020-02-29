package coreJava.unitTesting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.io.BufferedReader;
import java.io.File;
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
    
    
    public void TestPrep() throws NumberFormatException, IOException {
     
    }
    
    
    public void getAllInstructorsTest() throws ClassNotFoundException, IOException {
        
    }
}
