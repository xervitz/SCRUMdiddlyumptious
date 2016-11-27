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
public class ConditionTest {
    
    public ConditionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setName method, of class Condition.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "";
        Condition instance = new Condition();
        instance.setName(n);
    }

    /**
     * Test of setNotes method, of class Condition.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String n = "";
        Condition instance = new Condition();
        instance.setNotes(n);
    }
    
}
