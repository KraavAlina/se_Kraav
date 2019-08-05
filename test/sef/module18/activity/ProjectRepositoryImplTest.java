package sef.module18.activity;

import java.util.List;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class ProjectRepositoryImplTest extends TestCase  {

    private Connection conn;
    private String url ;
    private String username;
    private String password;
    Log logger = LogFactory.getLog(this.getClass());

    public void setUp()throws Exception{
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~/test";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");
    }

    public void tearDown() throws Exception{
        try{
            super.tearDown();
            conn.close();
            System.out.println("Connection closed!");
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            logger.error(sef.module.percentage.Percentage.setFailedCount(true,4));
        }
    }

    public void testfindProjectByID() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            Project result = proj_rep.findProjectByID(1);
            assertEquals(result.getProjectName().toUpperCase(), "ONLINE INSURANCE SYSTEM");
            assertEquals(result.getProjectDescription().toUpperCase(), "A WEB APPLICATION THAT AUTOMATES INSURANCE TRANSACTIONS.");
            assertEquals(result.getProjectID(), 1);
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }

    }

    public void testNofindProjectByID() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            Project result = proj_rep.findProjectByID(0);
            assertEquals(result, null);
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testfindProjectByName() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            List <Project> results = proj_rep.findProjectByName("Online");
            assertEquals(2, results.size());

            assertEquals(results.get(0).getProjectName().toUpperCase(), "ONLINE INSURANCE SYSTEM");
            assertEquals(results.get(0).getProjectDescription().toUpperCase(), "A WEB APPLICATION THAT AUTOMATES INSURANCE TRANSACTIONS.");
            assertEquals(results.get(0).getProjectID(), 1);

            assertEquals(results.get(1).getProjectName().toUpperCase(), "ONLINE SHOPPING SYSTEM");
            assertEquals(results.get(1).getProjectDescription().toUpperCase(), "A WEB APPLICATION THAT HANDLES SHOPPING TRANSACTIONS ONLINE.");
            assertEquals(results.get(1).getProjectID(), 4);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testNofindProjectByName() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            List <Project> results = proj_rep.findProjectByName("Online SQL");
            assertEquals(0, results.size());


        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testfindProjectByEmployee() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            List <Project> results = proj_rep.findProjectByEmployee(1);
            assertEquals(1, results.size());

            assertEquals(results.get(0).getProjectName().toUpperCase(), "ONLINE INSURANCE SYSTEM");
            assertEquals(results.get(0).getProjectDescription().toUpperCase(), "A WEB APPLICATION THAT AUTOMATES INSURANCE TRANSACTIONS.");
            assertEquals(results.get(0).getProjectID(), 1);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testNofindProjectByEmployee() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            List <Project> results = proj_rep.findProjectByEmployee(5);
            assertEquals(0, results.size());

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testinsertProject() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            int result = proj_rep.insertProject(new ProjectImpl(5,"Online chat", "Introducing online posting."));
            assertNotNull(result);

        } catch (AssertionFailedError e) {
            System.out.println(e.getCause().getMessage());
            fail();
        }catch(HRSSystemException e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
    public void testupdateProject() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            boolean result = proj_rep.updateProject(new ProjectImpl(15,"Online chat", "Introducing online posting and smile."));
            assertTrue(result);

        } catch (AssertionFailedError e) {
            System.out.println(e.getCause().getMessage());
            fail();
        }catch(HRSSystemException e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }

    }

    public void testNoupdateProject() {
        ProjectRepository proj_rep = new ProjectRepositoryImpl(conn);
        try {
            boolean result = proj_rep.updateProject(new ProjectImpl(7,"Online chat", "Introducing online posting and smile."));
            assertFalse(result);

        } catch (AssertionFailedError e) {
            System.out.println(e.getCause().getMessage());
            fail();
        }catch(HRSSystemException e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }
}