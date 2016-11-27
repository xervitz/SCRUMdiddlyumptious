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
public class SaveConfirmDialogTest {
    
    public SaveConfirmDialogTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getReturnStatus method, of class SaveConfirmDialog.
     */
    @Test
    public void testGetReturnStatus() {
        System.out.println("getReturnStatus");
        SaveConfirmDialog instance = null;
        int expResult = 0;
        int result = instance.getReturnStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class SaveConfirmDialog.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SaveConfirmDialog.main(args);
    }
    
}
