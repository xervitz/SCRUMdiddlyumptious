/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Benjamin
 */
public class SearchController {
    public static MHPage findPage(long ID, String last, String first){
        //TODO: Replace with database search
        //DUMMY CODE
        MHPage result = new MHPage(ID, first, last);
        ArrayList<Condition> cond = new ArrayList<>();
        ArrayList<Procedure> proc = new ArrayList<>();
        ArrayList<FamilyMember> fam = new ArrayList<>();
        cond.add(new Condition("Tinnitus", "keep away from loud noises"));
        cond.add(new Condition("Depression", "keep away from memes"));
        cond.add(new Condition("Heat Vision", "keep sunglasses on at all times"));

        proc.add(new Procedure("Vasectomy", Date.from(Instant.now()), "went smoothly"));
        proc.add(new Procedure("Heart Surgery", Date.from(Instant.EPOCH), "just barely survived"));

        ArrayList<Condition> cond1 = new ArrayList<>();
        cond1.add(new Condition("Testicular Cancer", "o no"));
        cond1.add(new Condition("Rabies", "from kissing his dog"));

        ArrayList<Condition> cond2 = new ArrayList<>();
        cond2.add(new Condition("Stanky Leg", "ooh watch me, watch me\n now watch me whip\n now watch me nay-nay"));
        fam.add(new FamilyMember("Father", cond1));
        fam.add(new FamilyMember("Son", cond2));

        result.setConditions(cond);
        result.setProcedures(proc);
        result.setFamily(fam);
        return result;
    }
}
