/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhrs;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;


/**
 *
 * @author Brian Bell-Williard
 */
public class TestJUnit {
    // TestJUnit Condition class
    @Test
    public void testConditionSetName(){
        Condition cond = new Condition();
        cond.setName("name");
        System.out.println("should print name: "+cond.name);
    }
    
    @Test
    public void testConditionSetNotes(){
        Condition cond = new Condition();
        cond.setNotes("notes");
        System.out.println("should print notes: "+cond.notes);
    }
    
    @Test
    public void testFamilyMemberSetRelationship(){
        FamilyMember fm = new FamilyMember("this should not be here", new ArrayList<Condition>());
        fm.setRelationship("r");
        System.out.println("should print r: "+fm.relationship);
    }
    
    @Test
    public void testFamilyMemberSetConditions(){
        FamilyMember fm = new FamilyMember("someRelationship", new ArrayList<Condition>());
        ArrayList<Condition> conds = new ArrayList<Condition>();
        conds.add(new Condition("a","b"));
        fm.setConditions(conds);
        System.out.println("should print ab: "+fm.conditions.get(0).name+fm.conditions.get(0).notes);       
    }
    
    @Test
    public void testMHPageSetConditions(){
        MHPage p = new MHPage((long)9000, "bob", "joe");
        ArrayList<Condition> conds = new ArrayList<Condition>();
        conds.add(new Condition("a","b"));
        p.setConditions(conds);
        System.out.println("should print ab: "+p.conditions.get(0).name+p.conditions.get(0).notes);
    }
    
    @Test
    public void testMHPageSetProcedures(){
        MHPage p = new MHPage((long)9000, "bob", "joe");
        ArrayList<Procedure> procs = new ArrayList<Procedure>();
        procs.add(new Procedure("a", new Date(), "b"));
        p.setProcedures(procs);
        System.out.println("should print atrueb: "+p.procedures.get(0).name+p.procedures.get(0).date+p.procedures.get(0).notes);
    }
    
    @Test
    public void testMHPageSetFamily(){
        MHPage p = new MHPage((long)9000, "bob", "joe");
        ArrayList<FamilyMember> fam = new ArrayList<FamilyMember>();
        fam.add(new FamilyMember("your mom", new ArrayList<Condition>()));
        p.setFamily(fam);
        System.out.println("should print your mom: "+(p.family.get(0).relationship));
    }
    
    @Test
    public void testPageViewGUISetPage(){
        MHPage p0 = new MHPage((long)9000, "bob", "joe");
        MHPage p1 = new MHPage((long)9001, "joe", "bob");
        PageViewGUI pvg = new PageViewGUI(p0);
        pvg.setPage(p1);
        
    }
    
    @Test
    public void testPageViewGUIEditMode(){
        MHPage p0 = new MHPage((long)9000, "bob", "joe");
        PageViewGUI pvg = new PageViewGUI(p0);
        pvg.editMode();
        System.out.println("should be in edit mode.");
    }
    
    @Test
    public void testPageViewGUIViewMode(){
        MHPage p0 = new MHPage((long)9000, "bob", "joe");
        PageViewGUI pvg = new PageViewGUI(p0);
        pvg.viewMode();
        System.out.println("should be in view mode.");
    }
    
    @Test
    public void testPageViewGUIUpdatePage(){
        MHPage p0 = new MHPage((long)9000, "bob", "joe");
        PageViewGUI pvg = new PageViewGUI(p0);
        boolean b = pvg.updatePage();
        System.out.println("should have updated page.");
    }
    
    @Test
    public void testPageViewGUIExitWithDialog(){
        MHPage p0 = new MHPage((long)9000, "bob", "joe");
        PageViewGUI pvg = new PageViewGUI(p0);
        pvg.exitWithDialog();
        System.out.println("should have exited with dialog.");
    }
    
    @Test
    public void testProcudureSetName(){
        Procedure p = new Procedure("a", new Date(), "b");
        p.setName("name");
        System.out.println("should be name: "+p.name);
    }
    
    @Test
    public void testProcudureSetDate(){
        Date d = new Date();
        Procedure p = new Procedure("a", new Date(), "b");
        p.setDate(d);
        System.out.println("should be "+d.toString()+": "+p.date.toString());
    }
    
    @Test
    public void testProcudureSetNotes(){
        Procedure p = new Procedure("a", new Date(), "b");
        p.setNotes("notes");
        System.out.println("should be notes: "+p.notes);
    }
}
