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
    
    MHPage instance = new MHPage(0, "", "");
    
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
        instance.setConditions(cond);
        assertEquals(cond, instance.conditions);
        Condition n = new Condition("", "");
        Condition m = new Condition("1", "1");
        Condition o = new Condition("IASDG193712", "IASDG193712");
        Condition p = new Condition("This is a longer string.", "This is a longer string.");
        Condition q = new Condition("Joe Bob", "Joe Bob");
        Condition r = new Condition(";',./", ";',./");
        ArrayList<Condition> cond1 = null;
        cond1.add(n);
        instance.setConditions(cond1);
        assertEquals(cond1, instance.conditions);
        ArrayList<Condition> cond2 = null;
        cond2.add(m);
        instance.setConditions(cond2);
        assertEquals(cond2, instance.conditions);
        ArrayList<Condition> cond3 = null;
        cond3.add(o);
        instance.setConditions(cond3);
        assertEquals(cond3, instance.conditions);
        ArrayList<Condition> cond4 = null;
        cond4.add(p);
        instance.setConditions(cond4);
        assertEquals(cond4, instance.conditions);
        ArrayList<Condition> cond5 = null;
        cond5.add(q);
        instance.setConditions(cond5);
        assertEquals(cond5, instance.conditions);
        ArrayList<Condition> cond6 = null;
        cond6.add(r);
        instance.setConditions(cond6);
        assertEquals(cond6, instance.conditions);
        
        
    }

    /**
     * Test of setProcedures method, of class MHPage.
     */
    @Test
    public void testSetProcedures() {
        System.out.println("setProcedures");
        ArrayList<Procedure> proc = null;
        instance.setProcedures(proc);
        assertEquals(proc, instance.procedures);
    }

    /**
     * Test of setFamily method, of class MHPage.
     */
    @Test
    public void testSetFamily() {
        System.out.println("setFamily");
        ArrayList<FamilyMember> fam = null;
        instance.setFamily(fam);
        assertEquals(fam, instance.family);
        Condition n = new Condition("", "");
        Condition m = new Condition("1", "1");
        Condition o = new Condition("IASDG193712", "IASDG193712");
        Condition p = new Condition("This is a longer string.", "This is a longer string.");
        Condition q = new Condition("Joe Bob", "Joe Bob");
        Condition r = new Condition(";',./", ";',./");
        String s = "";
        String t = "1";
        String u = "IASDG193712";
        String v = "This is a longer string.";
        String w = "Joe Bob";
        String x = ";',./";
        ArrayList<Condition> cond1 = null;
        cond1.add(n);
        FamilyMember a = new FamilyMember(s, cond1);
        ArrayList<Condition> cond2 = null;
        cond2.add(m);
        FamilyMember b = new FamilyMember(t, cond2);
        ArrayList<Condition> cond3 = null;
        cond3.add(o);
        FamilyMember c = new FamilyMember(u, cond3);
        ArrayList<Condition> cond4 = null;
        cond4.add(p);
        FamilyMember d = new FamilyMember(v, cond4);
        ArrayList<Condition> cond5 = null;
        cond5.add(q);
        FamilyMember e = new FamilyMember(w, cond5);
        ArrayList<Condition> cond6 = null;
        cond6.add(q);
        FamilyMember f = new FamilyMember(x, cond6);
    }
    
}
