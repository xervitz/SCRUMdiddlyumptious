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
        String n = "";
        String m = "1";
        String o = "IASDG193712";
        String p = "This is a longer string.";
        String q = "Joe Bob";
        String r = ";',./";
        String s = "Brother";
        FamilyMember instance = new FamilyMember();
        instance.setRelationship(n);
        assertEquals(n , instance.relationship);
        instance.setRelationship(m);
        assertEquals(m , instance.relationship);
        instance.setRelationship(o);
        assertEquals(o , instance.relationship);
        instance.setRelationship(p);
        assertEquals(p , instance.relationship);
        instance.setRelationship(q);
        assertEquals(q , instance.relationship);
        instance.setRelationship(r);
        assertEquals(r , instance.relationship);
        instance.setRelationship(s);
        assertEquals(s , instance.relationship);
        instance.setRelationship(null);
        assertEquals(null, instance.relationship);
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
        ArrayList<Condition> cond = null;
        instance.setConditions(cond);
        assertEquals(cond, instance.conditions);
        Condition n = new Condition("", "");
        Condition m = new Condition("1", "1");
        Condition o = new Condition("IASDG193712", "IASDG193712");
        Condition p = new Condition("This is a longer string.", "This is a longer string.");
        Condition q = new Condition("Joe Bob", "Joe Bob");
        Condition r = new Condition(";',./", ";',./");
        ArrayList<Condition> cond1 = new ArrayList<>();
        cond1.add(n);
        instance.setConditions(cond1);
        assertEquals(cond1, instance.conditions);
        ArrayList<Condition> cond2 = new ArrayList<>();
        cond2.add(m);
        instance.setConditions(cond2);
        assertEquals(cond2, instance.conditions);
        ArrayList<Condition> cond3 = new ArrayList<>();
        cond3.add(o);
        instance.setConditions(cond3);
        assertEquals(cond3, instance.conditions);
        ArrayList<Condition> cond4 = new ArrayList<>();
        cond4.add(p);
        instance.setConditions(cond4);
        assertEquals(cond4, instance.conditions);
        ArrayList<Condition> cond5 = new ArrayList<>();
        cond5.add(q);
        instance.setConditions(cond5);
        assertEquals(cond5, instance.conditions);
        ArrayList<Condition> cond6 = new ArrayList<>();
        cond6.add(r);
        instance.setConditions(cond6);
        assertEquals(cond6, instance.conditions);
        instance.setConditions(null);
        assertEquals(null, instance.conditions);
    }
    
}
