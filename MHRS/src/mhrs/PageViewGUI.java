/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhrs;

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
    private MHPage page, prev;
    private enum Mode{VIEW, EDIT};
    private Mode mode;
    
    public void setPage(MHPage p){
        page = p;
        try {
            prev = new MHPage(p);
        } catch (Exception ex) {
            Logger.getLogger(PageViewGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        patientID.setText(String.format("%08d", page.ID));
        patientName.setText(page.last + ", " + page.first);
        patientID.setEnabled(false);
        patientName.setEnabled(false);
        // fill in conditions, procedures, and familyMember sections
        DefaultTableModel condModel = (DefaultTableModel)conditionTable.getModel();
        DefaultTableModel procModel = (DefaultTableModel)procedureTable.getModel();
        DefaultTableModel famModel = (DefaultTableModel)familyTable.getModel();
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
    }
    
    private void editMode(){
        mode = Mode.EDIT;
        this.setTitle("Medical History Report System - Edit");
        editButton.setText("Save");
        if(conditionTable.isEditing())conditionTable.getCellEditor().stopCellEditing();
        conditionTable.clearSelection();
        if(procedureTable.isEditing())procedureTable.getCellEditor().stopCellEditing();
        procedureTable.clearSelection();
        if(familyTable.isEditing())familyTable.getCellEditor().stopCellEditing();
        familyTable.clearSelection();
    }
    
    private void viewMode(){
        mode = Mode.VIEW;
        this.setTitle("Medical History Report System - View");
        editButton.setText("Edit");
        if(conditionTable.isEditing())conditionTable.getCellEditor().stopCellEditing();
        conditionTable.clearSelection();
        if(procedureTable.isEditing())procedureTable.getCellEditor().stopCellEditing();
        procedureTable.clearSelection();
        if(familyTable.isEditing())familyTable.getCellEditor().stopCellEditing();
        familyTable.clearSelection();
    }

    private boolean updatePage(){
        DefaultTableModel condModel = (DefaultTableModel)conditionTable.getModel();
        DefaultTableModel procModel = (DefaultTableModel)procedureTable.getModel();
        DefaultTableModel famModel = (DefaultTableModel)familyTable.getModel();
        ArrayList<Condition> cond = new ArrayList<>();
        ArrayList<Procedure> proc = new ArrayList<>();
        ArrayList<FamilyMember> fam = new ArrayList<>();
        for(int i = 0; i < condModel.getRowCount(); i++){
            cond.add(new Condition((String)condModel.getValueAt(i, 0), (String)condModel.getValueAt(i, 1)));
        }
        for(int i = 0; i < procModel.getRowCount(); i++){
            Date date = new Date();
            proc.add(new Procedure((String)procModel.getValueAt(i, 0), (Date)procModel.getValueAt(i, 1), (String)procModel.getValueAt(i, 2)));
        }
        for(int i = 0; i < famModel.getRowCount(); i++){
            String relationship = (String)famModel.getValueAt(i, 0);
            ArrayList<Condition> famCond = new ArrayList<>();
            famCond.add(new Condition((String)famModel.getValueAt(i, 1), (String)famModel.getValueAt(i, 2)));
            fam.add(new FamilyMember(relationship, famCond));
        }
        page.setConditions(cond);
        page.setProcedures(proc);
        page.setFamily(fam);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 936, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addGap(17, 17, 17))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(editButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(mode == Mode.EDIT){
            SaveConfirmDialog saveConf = new SaveConfirmDialog(this, true);
            saveConf.main(null);
            switch(saveConf.getReturnStatus()){
                case SaveConfirmDialog.RET_SAVE:
                    viewMode();
                    updatePage();
                    return;
                case SaveConfirmDialog.RET_DISCARD:
                    initComponents();
                    setPage(prev);
                    viewMode();
                default:
                    return;
            }
            
        } else if(mode == Mode.VIEW)editMode();
    }//GEN-LAST:event_editButtonActionPerformed

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
            public void run() {
                new PageViewGUI(p).setVisible(true);
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
    private javax.swing.JTextPane patientID;
    private javax.swing.JTextPane patientName;
    private javax.swing.JTable procedureTable;
    // End of variables declaration//GEN-END:variables
}
