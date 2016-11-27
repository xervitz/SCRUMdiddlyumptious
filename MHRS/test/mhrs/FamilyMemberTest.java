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
public class FamilyMemberTest {
    
    public FamilyMemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setRelationship method, of class FamilyMember.
     */
    @Test
    public void testSetRelationship() {
        System.out.println("setRelationship");
        String r = "";
        FamilyMember instance = new FamilyMember();
        instance.setRelationship(r);
    }

    /**
     * Test of setConditions method, of class FamilyMember.
     */
    @Test
    public void testSetConditions() {
        System.out.println("setConditions");
        ArrayList<Condition> c = null;
        FamilyMember instance = new FamilyMember();
        instance.setConditions(c);
    }
    
}
