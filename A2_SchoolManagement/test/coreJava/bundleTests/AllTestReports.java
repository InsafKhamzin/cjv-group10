package coreJava.bundleTests;

import coreJava.categoryInterface.ModifyLevelTests;
import coreJava.categoryInterface.ParameterizedTests;
import coreJava.categoryInterface.SampleDataTests;
import coreJava.unitTesting.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({ModifyLevelTests.class, ParameterizedTests.class,
        SampleDataTests.class})

@Suite.SuiteClasses({AttendingDAOTest.class, CourseDAOTest.class,
        InstructorDAOParameterizedTest.class, InstructorDAOTest.class,
        StudentDAOParameterizedTest.class, TeachingDAOTest.class})
public class AllTestReports
{
}
