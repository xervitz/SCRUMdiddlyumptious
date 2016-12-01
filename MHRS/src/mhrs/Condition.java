/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.io.Serializable;

/**
 *
 * @author Benjamin
 */
public final class Condition implements Serializable{
    //represents a medical condition the patient has or has had
    String name;
    String notes;
    public Condition(){}
    public Condition(String a, String b){
        this();
        setName(a);
        setNotes(b);
    }
    public Condition(Condition c){
        this();
        setName(c.name);
        setNotes(c.notes);
    }
    void setName(String n){
        name = n;
    }
    void setNotes(String n){
        notes = n;
    }
}
