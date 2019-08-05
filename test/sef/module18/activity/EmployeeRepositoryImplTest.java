package sef.module18.activity;


import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


public class EmployeeRepositoryImplTest extends TestCase {

    private Connection conn;
    private String url ;
    private String username;
    private String password;
    Log logger = LogFactory.getLog(this.getClass());

    public void setUp() throws Exception{
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

    public void testfindEmployeeByID() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            Employee result = empl_rep.findEmployeeByID(1);
            assertEquals(result.getFirstName().toUpperCase(), "JOHN");
            assertEquals(result.getLastName().toUpperCase(), "DOE");
            assertEquals(result.getProfLevel(), 1);
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testNofindEmployeeByID(){
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            Employee result = empl_rep.findEmployeeByID(6);
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

    public void testfindEmployeeByName() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByName("J", "DOE");
            assertEquals(2, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JOHN");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 1);


            assertEquals(results.get(1).getFirstName().toUpperCase(), "JANE");
            assertEquals(results.get(1).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(1).getProfLevel(), 2);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testNofindEmployeeByName() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByName("Ivan", "Ivanov");
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

    public void testfindEmployeeByProfLevel() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByProfLevel(1);
           // assertEquals(2, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JOHN");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 1);

            assertEquals(results.get(1).getFirstName().toUpperCase(), "SCOTT");
            assertEquals(results.get(1).getLastName().toUpperCase(), "FEIST");
            assertEquals(results.get(1).getProfLevel(), 1);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }


    public void testNofindEmployeeByProfLevel() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByProfLevel(4);
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

    public void testfindEmployeeByProject() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByProject(3);
            assertEquals(2, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JANE");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 2);

            assertEquals(results.get(1).getFirstName().toUpperCase(), "JAMES");
            assertEquals(results.get(1).getLastName().toUpperCase(), "DONNELL");
            assertEquals(results.get(1).getProfLevel(), 3);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch ( HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testNofindEmployeeByProject() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            List <Employee>results = empl_rep.findEmployeeByProject(4);
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

    public void testinsertEmployee() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            int result = empl_rep.insertEmployee(new EmployeeImpl(8,"Jack", "Bauer", 1));
            assertNotNull(result);

        } catch (AssertionFailedError e) {
            System.out.println(e.getCause().getMessage());
            fail();
        }catch(HRSSystemException e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }


    public void testupdateEmployee() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            boolean result = empl_rep.updateEmployee(new EmployeeImpl(8,"Ivan", "Bauer", 1));
            assertTrue(result);

        } catch (AssertionFailedError e) {
            System.out.println(e.getCause().getMessage());
            fail();
        }catch(HRSSystemException e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
    }

    public void testNoupdateEmployee() {
        EmployeeRepository empl_rep = new EmployeeRepositoryImpl(conn);
        try {
            boolean result = empl_rep.updateEmployee(new EmployeeImpl(101,"Ivan", "Bauer", 1));
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