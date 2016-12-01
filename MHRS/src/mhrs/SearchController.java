/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Benjamin
 */
public class SearchController {
    private static final String url = "jdbc:mysql://cr137.cse.lehigh.edu:3306/db02";
    private static final String username = "user02";
    private static final String password = "rude-snow";
    private static final String tablename = "medical_history_reports";
    public static MHPage findPage(long ID, String last, String first){
        MHPage result = null;
        StringBuilder query = new StringBuilder(String.format("SELECT * FROM %s WHERE", tablename));
        if(ID >= 0) query.append(String.format(" ID=%d", ID));
        if(ID >= 0 && (!last.isEmpty() || !first.isEmpty())) query.append(" AND");
        if(!last.isEmpty()) query.append(String.format(" LAST= '%s'", last));
        if(!last.isEmpty() && !first.isEmpty()) query.append(" AND");
        if(!first.isEmpty()) query.append(String.format(" FIRST='%s'", first));
        query.append(';');
        Connection con;
        Statement st = null;
        ResultSet rs;
        try {
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            rs = st.executeQuery(query.toString());
            if(rs.next()){ 
                byte[] pbytes = (byte[]) rs.getObject("PAGE");
                ByteArrayInputStream bstream = new ByteArrayInputStream(pbytes);
                ObjectInputStream objstream = new ObjectInputStream(bstream);
                result = (MHPage)objstream.readObject();
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public static int updatePage(MHPage p){
        String command = String.format("REPLACE INTO %s VALUES(?, ?, ?, ?)", tablename);
        Connection con;
        PreparedStatement st = null;
        int rows = 0;
        try {
            con = DriverManager.getConnection(url, username, password);
            st = con.prepareStatement(command);
            ByteArrayOutputStream bstream = new ByteArrayOutputStream();
            ObjectOutputStream objstream = new ObjectOutputStream(bstream);
            objstream.writeObject(p);
            byte[] pbytes = bstream.toByteArray();
            st.setInt(1, p.ID);
            st.setString(2, p.last);
            st.setString(3, p.first);
            st.setBytes(4, pbytes);
            rows = st.executeUpdate();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rows;
    }
}
