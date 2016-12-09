/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhrs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian Bell-Williard
 */
public class SearchControllerTest {
    
    public SearchControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findPage method, of class SearchController.
     */
    @Test
    public void testFindPage() {
        System.out.println("findPage");
        long ID = 0L;
        String last = "";
        String first = "";
        MHPage expResult = null;
        MHPage result = SearchController.findPage(ID, last, first);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePage method, of class SearchController.
     */
    @Test
    public void testUpdatePage() {
        System.out.println("updatePage");
        MHPage p = null;
        int expResult = 0;
        int result = SearchController.updatePage(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
