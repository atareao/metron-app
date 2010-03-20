/*
 * ***********************Software description*********************************
 * DialogCuadros.java
 *
 *
 * ***********************Software description*********************************
 *
 * Copyright (C) 15 de junio de 2008 - Lorenzo Carbonell
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * **************************Software License***********************************
 *
 *
 */
package es.atareao.metron.gui;

import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import es.atareao.alejandria.gui.ErrorDialog;
import es.atareao.alejandria.gui.JCheckBoxTableCellEditor;
import es.atareao.alejandria.gui.JCheckBoxTableCellRenderer;
import es.atareao.alejandria.gui.JDateChooserTableCellEditor;
import es.atareao.alejandria.gui.JDateChooserTableCellRenderer;
import es.atareao.alejandria.gui.JNumericFieldTableCellEditor;
import es.atareao.alejandria.gui.JNumericFieldTableCellRenderer;
import es.atareao.alejandria.lib.Convert;
import es.atareao.alejandria.lib.DateUtils;
import es.atareao.metron.lib.Cuadro;
import es.atareao.metron.lib.Fase;
import es.atareao.queensboro.db.Condition;
import es.atareao.queensboro.file.CompactDb;
import es.atareao.queensboro.val.ValidationException;
/**
 *
 * @author  Lorenzo Carbonell
 */
public class DialogFases extends javax.swing.JDialog {
    
    // <editor-fold defaultstate="collapsed" desc=" Constantes  ">
    public static final long serialVersionUID=0L;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Constructors  ">
    /** Creates new form SelectContact
     * @param parent
     * @param modal
     * @param conector 
     */
    public DialogFases(java.awt.Frame parent, boolean modal,CompactDb compactDb) {
        super(parent, modal);
        initComponents();
        this.setSize(710, 550);
        this.setLocationRelativeTo(null);
        this.jXTable.setUI(new DragDropRowTableUIOrdered());
        try {
            this.setCompactDb(compactDb);
            Cuadro cuadro=new Cuadro(compactDb.getConector());
            this.jCuadro.setElements(cuadro.find("orden"));
            this.refresca();

        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCuadro = new es.atareao.queensboro.gui.JWrapperComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable = new es.atareao.alejandria.laf.JLAFTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCuadro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCuadroItemStateChanged(evt);
            }
        });
        jPanel1.add(jCuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 510, 30));

        jXTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jXTableMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, 600, 380));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_add.png"))); // NOI18N
        jButton1.setToolTipText("Añadir");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_edit.png"))); // NOI18N
        jButton2.setToolTipText("Editar");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_new.png"))); // NOI18N
        jButton3.setToolTipText("Consultar");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_delete.png"))); // NOI18N
        jButton4.setToolTipText("Borrar");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, -1, -1));

        jLabel1.setText("Cuadro:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 450));

        jExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_exit.png"))); // NOI18N
        jExit.setToolTipText("Salir");
        jExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jExit.setBorderPainted(false);
        jExit.setMaximumSize(new java.awt.Dimension(40, 40));
        jExit.setMinimumSize(new java.awt.Dimension(40, 40));
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        getContentPane().add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        this.doClose();
    }//GEN-LAST:event_jExitActionPerformed

    private void jXTableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableMouseDragged
        int fromRow=((DragDropRowTableUIOrdered)this.jXTable.getUI()).getFromRow();
        int toRow=((DragDropRowTableUIOrdered)this.jXTable.getUI()).getToRow();
        this.saveRow(fromRow);
        this.saveRow(toRow);
    }//GEN-LAST:event_jXTableMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.doOperacion(Dialogo.OP_ADD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.doOperacion(Dialogo.OP_EDIT);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.doOperacion(Dialogo.OP_VIEW);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.doOperacion(Dialogo.OP_DELETE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCuadroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCuadroItemStateChanged
        this.refresca();
    }//GEN-LAST:event_jCuadroItemStateChanged
    private void doOperacion(int operacion){
        if(operacion==Dialogo.OP_ADD){
            try {
                Fase fase=new Fase(this.getCompactDb().getConector());
                fase.setValue("cuadro_id",this.jCuadro.getSelectedId());
                int numero=1;
                if(this.jXTable.getRowCount()>0){
                    int ufila=this.jXTable.getRowCount()-1;
                    numero=Convert.toInt(this.jXTable.getValueAt(ufila,2))+1;
                }
                fase.setValue("numero", Convert.toString(numero));
                String descripcion=((Cuadro)this.jCuadro.getSelectedItem()).getValue("descripcion")+" nº "+Convert.toString(numero);
                fase.setValue("descripcion",descripcion);
                fase.setValue("fecha", Convert.toStringDateSql(DateUtils.Ahora()));
                fase.setValue("aprobada","false");
                fase.setValue("fecha_aprobada", Convert.toStringDateSql(DateUtils.Ahora()));
                DialogFase df = new DialogFase(fase,(Cuadro)this.jCuadro.getSelectedItem(), Dialogo.OP_ADD);
                df.setVisible(true);
                if(df.getReturnStatus()==Dialogo.RET_OK){
                    df.getFase().insert();
                    this.getCompactDb().setModificado(true);
                    this.refresca();
                }
            } catch (SQLException ex) {
                ErrorDialog.manejaError(ex);
            }
        }else{
            int fila=this.jXTable.getSelectedRow();
            if(fila>-1){
                if(this.jXTable.getValueAt(fila,1)!=null){
                    String id=(String)this.jXTable.getValueAt(fila,1);
                    try {
                        Fase fase=new Fase(this.getCompactDb().getConector());
                        fase.setId(id);
                        fase.read();
                        DialogFase df = new DialogFase(fase,(Cuadro)this.jCuadro.getSelectedItem(),operacion);
                        df.setVisible(true);
                        if(df.getReturnStatus()==Dialogo.RET_OK){
                            switch(operacion){
                                case Dialogo.OP_DELETE:
                                    df.getFase().delete();
                                    this.getCompactDb().setModificado(true);
                                    this.refresca();
                                    break;
                                case Dialogo.OP_EDIT:
                                    df.getFase().update();
                                    this.getCompactDb().setModificado(true);
                                    this.refresca();
                                    break;
                                case Dialogo.OP_VIEW:
                                    break;
                            }
                        }
                    } catch (SQLException ex) {
                        ErrorDialog.manejaError(ex);
                    }
                }
            }
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc=" Methods  ">
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Auxiliary Methods  ">
    private void doClose() {
        setVisible(false);
        dispose();
    }
    private void setColumnWidth(int column,int width){
        this.jXTable.getColumn(column).setMinWidth(width);
        this.jXTable.getColumn(column).setMaxWidth(width);
        this.jXTable.getColumn(column).setWidth(width);        
        this.jXTable.getColumn(column).setPreferredWidth(width);
    }

    private void refresca(){
        try {
            DefaultTableModel tableModel = new DefaultTableModel() {
                public static final long serialVersionUID=0L;
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    try {
                        switch (columnIndex) {
                            default:
                                return false;
                        }
                    } catch (Exception ex) {
                        return false;
                    }
                }

                @Override
                public Class getColumnClass(int columnIndex) {
                    if (dataVector == null) {
                        return Object.class;
                    }
                    Object[] row = ((Vector) dataVector.get(0)).toArray();
                    return row[columnIndex] == null ? Object.class : row[columnIndex].getClass();
                }
            };
            //                         0      1     2          3           4         5             6
            String[] columnNames = {"ORDEN", "ID", "Nº", "DESCRIPCION", "FECHA", "APROBADA", "APROBACION"};
            final int nColumns = columnNames.length;
            tableModel.setColumnIdentifiers(columnNames);
            tableModel.setColumnCount(nColumns);
            //
            this.jXTable.setModel(tableModel);
            this.jXTable.setRowHeight(25);
            this.jXTable.getColumnModel().getColumn(2).setCellRenderer(new JNumericFieldTableCellRenderer(0));
            this.jXTable.getColumnModel().getColumn(2).setCellEditor(new JNumericFieldTableCellEditor(0));//this.jXTable,4
            //
            this.jXTable.getColumnModel().getColumn(4).setCellRenderer(new JDateChooserTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(4).setCellEditor(new JDateChooserTableCellEditor());//this.jXTable,4
            //
            this.jXTable.getColumnModel().getColumn(5).setCellRenderer(new JCheckBoxTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(5).setCellEditor(new JCheckBoxTableCellEditor());//this.jXTable,4
            //
            this.jXTable.getColumnModel().getColumn(6).setCellRenderer(new JDateChooserTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(6).setCellEditor(new JDateChooserTableCellEditor());//this.jXTable,4
            //
            this.setColumnWidth(0,0);
            this.setColumnWidth(1,0);
            this.setColumnWidth(2,30);
            //this.setColumnWidth(2,100); Lo que sobra se lo queda esta
            this.setColumnWidth(4,100);
            this.setColumnWidth(5,100);
            this.setColumnWidth(6,100);
            //
            Fase newFase=new Fase(this.getCompactDb().getConector());
            for(Fase fase:newFase.find(new Condition("cuadro_id",this.jCuadro.getSelectedId()), "orden")){
                Object[] fila={fase.getValue("orden"),fase.getValue("id"),fase.getValue("numero"),fase.getValue("descripcion"),fase.getValue("fecha"),fase.getValue("aprobada"),fase.getValue("fecha_aprobada")};
                tableModel.addRow(fila);
            }
            if((this.jXTable.getRowCount()==0)||(((String)this.jXTable.getValueAt(0,0)).equals(""))){
                this.newRow();
            }
        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }            
    }

    private boolean newRow(){
        int numero=0;
        int fila=this.jXTable.getRowCount()-1;
        if (fila<0){
            fila=0;
        }
        if(this.jXTable.getRowCount()>0){
            int ufila=this.jXTable.getRowCount()-1;
            numero=Convert.toInt(this.jXTable.getValueAt(ufila,2))+1;
        }
        String descripcion=((Cuadro)this.jCuadro.getSelectedItem()).getValue("descripcion")+" nº "+Convert.toString(numero);
        Object[] filadata={
            Convert.toString(fila),//Orden - 0
            "",//id - 1
            Convert.toString(numero),//numero - 2
            descripcion,//descripcion - 3
            Convert.toStringDateSql(DateUtils.Ahora()),//fecha - 4
            "false",//aprobada - 5
            Convert.toStringDateSql(DateUtils.Ahora())//fecha_aprobada - 6
        };
        ((DefaultTableModel)this.jXTable.getModel()).addRow(filadata);
        int selectedRow=this.jXTable.getSelectedRow();
        int selectedColumn=this.jXTable.getSelectedColumn();
        if(!this.saveRow(fila)){
            this.refresca();
            this.jXTable.setColumnSelectionInterval(selectedColumn, selectedColumn);
            this.jXTable.setRowSelectionInterval(selectedRow-1, selectedRow-1);
            return false;
        }
        return true;
    }
    private boolean saveRow(int fila){
        try {
            DefaultTableModel tableModel = (DefaultTableModel) this.jXTable.getModel();
            Fase fase = new Fase(this.getCompactDb().getConector());
            fase.setId((String) tableModel.getValueAt(fila,1));
            fase.setValue("id", (String) tableModel.getValueAt(fila,1));
            fase.setValue("orden", (String) tableModel.getValueAt(fila,0));
            fase.setValue("numero", (String) tableModel.getValueAt(fila,2));
            fase.setValue("descripcion", (String) tableModel.getValueAt(fila,3));
            fase.setValue("fecha", (String) tableModel.getValueAt(fila,4));
            fase.setValue("aprobada", (String) tableModel.getValueAt(fila,5));
            fase.setValue("fecha_aprobada", (String) tableModel.getValueAt(fila,6));
            //
            fase.setValue("cuadro_id", this.jCuadro.getSelectedId());
            //
            if (fase.validate()) {
                Object valor = tableModel.getValueAt(fila, 1);
                if ((valor == null) || (valor.equals(""))) {
                    if (fase.insert()) {
                        tableModel.setValueAt(Convert.toString(fase.getLastInsertId()), fila, 1);
                        return true;
                    }
                } else {
                    fase.setId((String) tableModel.getValueAt(fila,1));
                    if (fase.update()) {
                        return true;
                    }
                }
            }
        } catch (ValidationException ex) {
                ErrorDialog.manejaError(ex);
        }catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
        return false;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Fields  ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private es.atareao.queensboro.gui.JWrapperComboBox jCuadro;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private es.atareao.alejandria.laf.JLAFTable jXTable;
    // End of variables declaration//GEN-END:variables
    private CompactDb _compactDb;
    private boolean _updatingRows=false;
    private boolean _modificado=false;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Access Methods  ">
    public boolean isUpdatingRows() {
        return _updatingRows;
    }

    public void setUpdatingRows(boolean updatingRows) {
        this._updatingRows = updatingRows;
    }

    public boolean isModificado() {
        return _modificado;
    }

    public void setModificado(boolean modificado) {
        this._modificado = modificado;
    }

    /**
     * @return the _compactDb
     */
    public CompactDb getCompactDb() {
        return _compactDb;
    }

    /**
     * @param compactDb the _compactDb to set
     */
    public void setCompactDb(CompactDb compactDb) {
        this._compactDb = compactDb;
    }
    
    // </editor-fold>
}
