/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class MHPage implements Serializable {
    //the class to represent the pages searchable/editable in our system
    int ID;
    String first;
    String last;
    ArrayList<Condition> conditions;
    ArrayList<Procedure> procedures;
    ArrayList<FamilyMember> family;
    public MHPage(int nID, String nFirst, String nLast){
        if(nFirst == null || nLast == null) throw new NullPointerException();
        ID = nID;
        first = nFirst.toUpperCase();
        last = nLast.toUpperCase();
        conditions = new ArrayList<>();
        procedures = new ArrayList<>();
        family = new ArrayList<>();
    }

    public MHPage(MHPage p) {
        this(p.ID, p.first, p.last);
        p.conditions.stream().forEach((c) -> {
            conditions.add(new Condition(c));
        });
        p.procedures.stream().forEach((pr) -> {
            procedures.add(new Procedure(pr));
        });
        p.family.stream().forEach((f) -> {
            family.add(new FamilyMember(f));
        });
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
