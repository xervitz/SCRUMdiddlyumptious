/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class MHPage {
    //the class to represent the pages searchable/editable in our system
    final int ID;
    final String first;
    final String last;
    ArrayList<Condition> conditions;
    ArrayList<Procedure> procedures;
    ArrayList<FamilyMember> family;
    public MHPage(int nID, String nFirst, String nLast) throws Exception{
        if(nID < 0){
            throw new Exception("ID out of bounds");
        }
        ID = nID;
        first = nFirst.toUpperCase();
        last = nLast.toUpperCase();
    }

    MHPage(MHPage p) throws Exception {
        this(p.ID, p.first, p.last);
        ArrayList<Condition> cond = new ArrayList<>();
        p.conditions.stream().forEach((c) -> {
            cond.add(new Condition(c));
        });
        setConditions(cond);
        ArrayList<Procedure> proc = new ArrayList<>();
        p.procedures.stream().forEach((pr) -> {
            proc.add(new Procedure(pr));
        });
        setProcedures(p.procedures);
        ArrayList<FamilyMember> fam = new ArrayList<>();
        p.family.stream().forEach((f) -> {
            fam.add(new FamilyMember(f));
        });
        setFamily(p.family);
    }
    final void setConditions(ArrayList<Condition> cond){
        conditions = cond;
    }
    final void setProcedures(ArrayList<Procedure> proc){
        procedures = proc;
    }
    final void setFamily(ArrayList<FamilyMember> fam){
        family = fam;
    }
}
