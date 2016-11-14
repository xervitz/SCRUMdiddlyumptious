/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Benjamin
 * @author Brian
 */
public final class PageViewGUI extends javax.swing.JFrame {

    private static PageViewGUI instance;
    private static PageViewGUI getInstance() {
        return instance;
    }
    private MHPage page, prev;
    private enum Mode{VIEW, EDIT};
    private Mode mode;
    
    public void setPage(MHPage p){
        //set the page data field, display its contents in GUI
        prev = p; //keep a copy of the unedited page in case the changes are rolled back
        try {
            page = new MHPage(p);
        } catch (Exception ex) {
            Logger.getLogger(PageViewGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        patientID.setText(String.format("%08d", page.ID));
        patientName.setText(page.last + ", " + page.first);
        patientID.setEnabled(false);
        patientName.setEnabled(false);
        // fill in conditions, procedures, and familyMember tables
        DefaultTableModel condModel = (DefaultTableModel)conditionTable.getModel();
        DefaultTableModel procModel = (DefaultTableModel)procedureTable.getModel();
        DefaultTableModel famModel = (DefaultTableModel)familyTable.getModel();
        //remove existing rows first
        while(condModel.getRowCount()!=0)condModel.removeRow(condModel.getRowCount()-1);
        while(procModel.getRowCount()!=0)procModel.removeRow(procModel.getRowCount()-1);
        while(famModel.getRowCount()!=0)famModel.removeRow(famModel.getRowCount()-1);
        for(int i = 0; i < page.conditions.size(); i++){
            condModel.addRow(new Object[] {page.conditions.get(i).name, page.conditions.get(i).notes});
        }
        int totWidth = conditionTable.getBounds().width;
        int prefWidth = totWidth/3;
        TableColumnModel condColModel = conditionTable.getColumnModel();
        condColModel.getColumn(0).setPreferredWidth(prefWidth);
        condColModel.getColumn(1).setPreferredWidth(totWidth - prefWidth);
        for(int i = 0; i < page.procedures.size(); i++){
            procModel.addRow(new Object[] {page.procedures.get(i).name, page.procedures.get(i).date, page.procedures.get(i).notes});
        }
        for(int i = 0; i < page.family.size(); i++){
            ArrayList<Condition> memConds = page.family.get(i).conditions;
            for(int j = 0; j < memConds.size(); j++){
                famModel.addRow(new Object[] {page.family.get(i).relationship, memConds.get(j).name, memConds.get(j).notes});
            }
        }
    }
    /**
     * Creates new form PageViewGUI
     */
    private PageViewGUI() {
        initComponents();
        viewMode();
        instance = this; //store reference for use in static methods
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); //centers frame on screen
    }
    
    private void editMode(){
        //enable editing for editable fields
        //note that ID and name are not editable
        mode = Mode.EDIT;
        this.setTitle("Medical History Report System - Edit");
        editButton.setText("Save");
        if(conditionTable.isEditing())conditionTable.getCellEditor().stopCellEditing();
        conditionTable.clearSelection();
        if(procedureTable.isEditing())procedureTable.getCellEditor().stopCellEditing();
        procedureTable.clearSelection();
        if(familyTable.isEditing())familyTable.getCellEditor().stopCellEditing();
        familyTable.clearSelection();
        newConditionButton.setVisible(true);
        newProcedureButton.setVisible(true);
        newFamilyMemberButton.setVisible(true);
    }
    
    private void viewMode(){
        //disable editing for editable fields
        mode = Mode.VIEW;
        this.setTitle("Medical History Report System - View");
        editButton.setText("Edit");
        if(conditionTable.isEditing())conditionTable.getCellEditor().stopCellEditing();
        conditionTable.clearSelection();
        if(procedureTable.isEditing())procedureTable.getCellEditor().stopCellEditing();
        procedureTable.clearSelection();
        if(familyTable.isEditing())familyTable.getCellEditor().stopCellEditing();
        familyTable.clearSelection();
        newConditionButton.setVisible(false);
        newProcedureButton.setVisible(false);
        newFamilyMemberButton.setVisible(false);
    }

    private boolean updatePage(){
        //send all the changes made by editor to a page object
        //note that the fields of the page are deleted by giving an empty string in column 0
        DefaultTableModel condModel = (DefaultTableModel)conditionTable.getModel();
        DefaultTableModel procModel = (DefaultTableModel)procedureTable.getModel();
        DefaultTableModel famModel = (DefaultTableModel)familyTable.getModel();
        ArrayList<Condition> cond = new ArrayList<>();
        ArrayList<Procedure> proc = new ArrayList<>();
        ArrayList<FamilyMember> fam = new ArrayList<>();
        for(int i = 0; i < condModel.getRowCount(); i++){
            String name = (String)condModel.getValueAt(i, 0);
            if(!name.isEmpty())cond.add(new Condition(name, (String)condModel.getValueAt(i, 1)));
        }
        for(int i = 0; i < procModel.getRowCount(); i++){
            Date date = new Date();
            String name = (String)procModel.getValueAt(i, 0);
            if(!name.isEmpty())proc.add(new Procedure(name, (Date)procModel.getValueAt(i, 1), (String)procModel.getValueAt(i, 2)));
        }
        for(int i = 0; i < famModel.getRowCount(); i++){
            String relationship = (String)famModel.getValueAt(i, 0);
            if(!relationship.isEmpty()){
                ArrayList<Condition> famCond = new ArrayList<>();
                famCond.add(new Condition((String)famModel.getValueAt(i, 1), (String)famModel.getValueAt(i, 2)));
                fam.add(new FamilyMember(relationship, famCond));
            }
        }
        page.setConditions(cond);
        page.setProcedures(proc);
        page.setFamily(fam);
        setPage(page);
        //TODO: store prev in database, return update success
        return true;
    }
    
    public PageViewGUI(MHPage p){
        this();
        setPage(p);   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientID = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        patientName = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        procedureTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        familyTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        conditionTable = new javax.swing.JTable();
        newConditionButton = new javax.swing.JButton();
        newProcedureButton = new javax.swing.JButton();
        newFamilyMemberButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(patientID);

        jScrollPane3.setViewportView(patientName);

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Conditions");

        jLabel4.setText("Procedures");

        jLabel5.setText("Family");

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        procedureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.util.Date.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int col){
                return (mode == Mode.EDIT);
            }
        });
        jScrollPane6.setViewportView(procedureTable);

        familyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Relationship", "Condition Name", "Condition Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int col){
                return (mode == Mode.EDIT);
            }
        });
        jScrollPane7.setViewportView(familyTable);

        conditionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column){
                return (mode == Mode.EDIT);
            }
        });
        jScrollPane8.setViewportView(conditionTable);

        newConditionButton.setText("+");
        newConditionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newConditionButtonActionPerformed(evt);
            }
        });

        newProcedureButton.setText("+");
        newProcedureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProcedureButtonActionPerformed(evt);
            }
        });

        newFamilyMemberButton.setText("+");
        newFamilyMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFamilyMemberButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editButton)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newConditionButton)
                    .addComponent(newProcedureButton)
                    .addComponent(newFamilyMemberButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newConditionButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newProcedureButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newFamilyMemberButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(editButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        //switches between edit and save modes
        if(mode == Mode.EDIT){
            //display confirmation dialog
            SaveConfirmDialog saveConf = new SaveConfirmDialog(this, true);
            saveConf.setVisible(true);
            switch(saveConf.getReturnStatus()){
                case SaveConfirmDialog.RET_SAVE:
                    //save the changes
                    viewMode();
                    updatePage();
                    return;
                case SaveConfirmDialog.RET_DISCARD:
                    //discard the changes
                    viewMode();
                    setPage(prev);
                default:
                    //continue editing
            }
            
        } else if(mode == Mode.VIEW)editMode();
    }//GEN-LAST:event_editButtonActionPerformed

    //These methods each add a single empty row to their respective tables
    
    private void newConditionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newConditionButtonActionPerformed
        DefaultTableModel condModel = (DefaultTableModel)conditionTable.getModel();
        condModel.addRow(new Object[] {"", ""});
    }//GEN-LAST:event_newConditionButtonActionPerformed

    private void newProcedureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProcedureButtonActionPerformed
        DefaultTableModel procModel = (DefaultTableModel)procedureTable.getModel();
        procModel.addRow(new Object[] {"", new Date(), ""});
    }//GEN-LAST:event_newProcedureButtonActionPerformed

    private void newFamilyMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFamilyMemberButtonActionPerformed
        DefaultTableModel famModel = (DefaultTableModel)familyTable.getModel();
        famModel.addRow(new Object[] {"", "", ""});
    }//GEN-LAST:event_newFamilyMemberButtonActionPerformed

    private void exitWithDialog(){
        //only exit if changes are saved, or ask before discarding them
        if(mode == Mode.EDIT){
            SaveConfirmDialog saveConf = new SaveConfirmDialog(this, true);
            saveConf.setVisible(true);
            switch(saveConf.getReturnStatus()){
                case SaveConfirmDialog.RET_SAVE:
                    updatePage();
                    System.exit(0);
                case SaveConfirmDialog.RET_DISCARD:
                    setPage(prev);
                    System.exit(0);
                default:
            }
        } else if(mode == Mode.VIEW)System.exit(0);
    }
    /**
     * @param p
     */
    public static void main(MHPage p) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PageViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(PageViewGUI.getInstance()==null)instance = new PageViewGUI(p);
                //use our custom exit code when X is clicked
                PageViewGUI.getInstance().setDefaultCloseOperation(PageViewGUI.DO_NOTHING_ON_CLOSE);
                PageViewGUI.getInstance().addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        PageViewGUI.getInstance().exitWithDialog();
                    }
                });
                PageViewGUI.getInstance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTable conditionTable;
    private javax.swing.JButton editButton;
    private javax.swing.JTable familyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JButton newConditionButton;
    private javax.swing.JButton newFamilyMemberButton;
    private javax.swing.JButton newProcedureButton;
    private javax.swing.JTextPane patientID;
    private javax.swing.JTextPane patientName;
    private javax.swing.JTable procedureTable;
    // End of variables declaration//GEN-END:variables
}
