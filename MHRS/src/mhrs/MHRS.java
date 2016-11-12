/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class MHRS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SearchGUI.main(null);
        //To test the edit functions, create some dummy objects and pass to the pageviewer
        MHPage p = null;
        try {
            p = new MHPage(0, "John", "Smith");
            ArrayList<Condition> cond = new ArrayList<>();
            ArrayList<Procedure> proc = new ArrayList<>();
            ArrayList<FamilyMember> fam = new ArrayList<>();
            
            //uncomment below for some example objects, or fill in the blank form manually
            
//            cond.add(new Condition("Tinnitus", "keep away from loud noises"));
//            cond.add(new Condition("Depression", "keep away from memes"));
//            cond.add(new Condition("Heat Vision", "keep sunglasses on at all times"));
//            
//            proc.add(new Procedure("Vasectomy", Date.from(Instant.now()), "went smoothly"));
//            proc.add(new Procedure("Heart Surgery", Date.from(Instant.EPOCH), "just barely survived"));
            
//            ArrayList<Condition> cond1 = new ArrayList<>();
//            cond1.add(new Condition("Testicular Cancer", "o no"));
//            cond1.add(new Condition("Rabies", "from kissing his dog"));
            
//            ArrayList<Condition> cond2 = new ArrayList<>();
//            cond2.add(new Condition("Stanky Leg", "ooh watch me, watch me\n now watch me whip\n now watch me nay-nay"));
//            fam.add(new FamilyMember("Father", cond1));
//            fam.add(new FamilyMember("Son", cond2));
            
            p.setConditions(cond);
            p.setProcedures(proc);
            p.setFamily(fam);
        } catch (Exception ex) {
            Logger.getLogger(MHRS.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        PageViewGUI.main(p);
    }
}
