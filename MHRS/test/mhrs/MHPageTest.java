/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhrs;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class MHPageTest {
    
    public MHPageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setConditions method, of class MHPage.
     */
    @Test
    public void testSetConditions() {
        System.out.println("setConditions");
        ArrayList<Condition> cond = null;
        MHPage instance = null;
        instance.setConditions(cond);
    }

    /**
     * Test of setProcedures method, of class MHPage.
     */
    @Test
    public void testSetProcedures() {
        System.out.println("setProcedures");
        ArrayList<Procedure> proc = null;
        MHPage instance = null;
        instance.setProcedures(proc);
    }

    /**
     * Test of setFamily method, of class MHPage.
     */
    @Test
    public void testSetFamily() {
        System.out.println("setFamily");
        ArrayList<FamilyMember> fam = null;
        MHPage instance = null;
        instance.setFamily(fam);
    }
    
}
