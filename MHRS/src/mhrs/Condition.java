/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

/**
 *
 * @author Benjamin
 */
public final class Condition {
    String name;
    String notes;
    public Condition(){}
    public Condition(String a, String b){
        this();
        setName(a);
        setNotes(b);
    }
    void setName(String n){
        name = n;
    }
    void setNotes(String n){
        notes = n;
    }
}
