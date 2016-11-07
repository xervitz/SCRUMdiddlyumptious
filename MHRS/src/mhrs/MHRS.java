/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

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
        } catch (Exception ex) {
            Logger.getLogger(MHRS.class.getName()).log(Level.SEVERE, null, ex);
        }
        PageViewGUI.main(p);
    }
    
}
