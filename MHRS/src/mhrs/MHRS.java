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
        // TODO code application logic here
        //SearchGUI.main(null);
        MHPage p = null;
        try {
            p = new MHPage(0, "John", "Smith");
            ArrayList<Condition> cond = new ArrayList<>();
            ArrayList<Procedure> proc = new ArrayList<>();
            ArrayList<FamilyMember> fam = new ArrayList<>();
            Condition c1 = new Condition();
            c1.setName("Tinnitus");
            c1.setNotes("keep away from loud noises");
            cond.add(c1);
            Procedure p1 = new Procedure();
            p1.setName("Vasectomy");
            p1.setDate(Date.from(Instant.EPOCH));
            p1.setNotes("went smoothly");
            proc.add(p1);
            FamilyMember f1 = new FamilyMember();
            f1.setRelationship("Father");
            f1.setConditions(cond);
            fam.add(f1);
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
