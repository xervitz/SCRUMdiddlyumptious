/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhrs;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class ProcedureTest {
    
    public ProcedureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setName method, of class Procedure.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "";
        Procedure instance = new Procedure();
        instance.setName(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Procedure.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date d = null;
        Procedure instance = new Procedure();
        instance.setDate(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotes method, of class Procedure.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String n = "";
        Procedure instance = new Procedure();
        instance.setNotes(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
