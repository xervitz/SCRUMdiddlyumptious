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
    String relationship;
    ArrayList<Condition> conditions;
    public FamilyMember(){}
    public FamilyMember(String r, ArrayList<Condition> c){
        this();
        setRelationship(r);
        setConditions(c);
    }
    void setRelationship(String r){
        relationship = r;
    }
    void setConditions(ArrayList<Condition> c){
        conditions = c;
    }
}
