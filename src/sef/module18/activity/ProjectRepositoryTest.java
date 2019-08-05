package sef.module18.activity;

import junit.framework.TestCase;

public class ProjectRepositoryTest extends TestCase {
    ProjectRepositoryImplTest runTest = new ProjectRepositoryImplTest();
    public void setUp()throws Exception { runTest.setUp(); }
    public void testfindProjectByID() { runTest.testfindProjectByID(); }
    public void testNofindProjectByID() { runTest.testNofindProjectByID(); }
    public void testfindProjectByName() { runTest.testfindProjectByName(); }
    public void testNofindProjectByName() { runTest.testNofindProjectByName(); }
    public void testfindProjectByEmployee() { runTest.testfindProjectByEmployee(); }
    public void testNofindProjectByEmployee() { runTest.testNofindProjectByEmployee(); }
    public void testinsertProject() { runTest.testinsertProject(); }
    public void testupdateProject() { runTest.testupdateProject(); }
    public void testNoupdateProject() { runTest.testNoupdateProject(); }
    public void tearDown() throws Exception { runTest.tearDown(); }
}
