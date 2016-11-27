/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhrs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class PageViewGUITest {
    
    public PageViewGUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setPage method, of class PageViewGUI.
     */
    @Test
    public void testSetPage() {
        System.out.println("setPage");
        MHPage p = null;
        PageViewGUI instance = null;
        instance.setPage(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PageViewGUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        MHPage p = null;
        PageViewGUI.main(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
