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
    int ID;
    String first;
    String last;
    ArrayList<Condition> conditions;
    ArrayList<Procedure> procedures;
    ArrayList<FamilyMember> family;
    public MHPage(int nID, String nFirst, String nLast){
        ID = nID;
        first = nFirst;
        last = nLast;
    }
    void setConditions(ArrayList<Condition> cond){
        conditions = cond;
    }
    void setProcedures(ArrayList<Procedure> proc){
        procedures = proc;
    }
    void setFamily(ArrayList<FamilyMember> fam){
        family = fam;
    }
}
