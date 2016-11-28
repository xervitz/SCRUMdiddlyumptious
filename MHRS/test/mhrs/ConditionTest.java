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
        String m = "1";
        String o = "IASDG193712";
        String p = "This is a longer string.";
        String q = "Joe Bob";
        String r = ";',./";
        Condition instance = new Condition();
        instance.setName(n);
        assertEquals(n , instance.name);
        instance.setName(m);
        assertEquals(m , instance.name);
        instance.setName(o);
        assertEquals(o , instance.name);
        instance.setName(p);
        assertEquals(p , instance.name);
        instance.setName(q);
        assertEquals(q , instance.name);
        instance.setName(r);
        assertEquals(r , instance.name);
        
    }

    /**
     * Test of setNotes method, of class Condition.
     */
    @Test
    public void testSetNotes() {
        System.out.println("setNotes");
        String n = "";
        String m = "1";
        String o = "IASDG193712";
        String p = "This is a longer string.";
        String q = "Joe Bob";
        String r = ";',./";
        Condition instance = new Condition();
        instance.setNotes(n);
        assertEquals(n , instance.notes);
        instance.setNotes(m);
        assertEquals(m , instance.notes);
        instance.setNotes(o);
        assertEquals(o , instance.notes);
        instance.setNotes(p);
        assertEquals(p , instance.notes);
        instance.setNotes(q);
        assertEquals(q , instance.notes);
        instance.setNotes(r);
        assertEquals(r , instance.notes);
    }
    
}
