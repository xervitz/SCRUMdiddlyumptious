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
