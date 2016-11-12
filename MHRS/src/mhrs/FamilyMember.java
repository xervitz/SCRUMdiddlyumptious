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
public final class FamilyMember {
    //represents a member of the patient's family with relevant medical conditions
    String relationship;
    ArrayList<Condition> conditions;
    public FamilyMember(){}
    public FamilyMember(String r, ArrayList<Condition> c){
        this();
        setRelationship(r);
        setConditions(c);
    }
    public FamilyMember(FamilyMember f){
        ArrayList<Condition> cond = new ArrayList<>();
        for(Condition c:f.conditions)cond.add(new Condition(c));
        setRelationship(f.relationship);
        setConditions(cond);
    }
    void setRelationship(String r){
        relationship = r;
    }
    void setConditions(ArrayList<Condition> c){
        conditions = c;
    }
}
