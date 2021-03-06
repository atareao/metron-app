/*
 * ***********************Software description*********************************
 * DialogUnidad.java
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
import es.atareao.alejandria.gui.JDateChooserTableCellEditor;
import es.atareao.alejandria.gui.JDateChooserTableCellRenderer;
import es.atareao.alejandria.lib.Convert;
import es.atareao.alejandria.lib.DateUtils;
import es.atareao.metron.lib.Unidad;
import es.atareao.queensboro.file.CompactDb;
import es.atareao.queensboro.val.ValidationException;
/**
 *
 * @author  Lorenzo Carbonell
 */
public class DialogUnidades extends javax.swing.JDialog {
    
    // <editor-fold defaultstate="collapsed" desc=" Constantes  ">
    public static final long serialVersionUID=0L;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Constructors  ">
    /** Creates new form SelectContact
     * @param parent
     * @param modal
     * @param conector 
     */
    public DialogUnidades(java.awt.Frame parent, boolean modal,CompactDb compactDb) {
        super(parent, modal);
        initComponents();
        this.setSize(710, 550);
        this.setLocationRelativeTo(null);
        this.jXTable.setUI(new DragDropRowTableUIOrdered());
        try {
            this.setCompactDb(compactDb);
            this.setUnidad(new Unidad(compactDb.getConector()));
            this.refresca();

        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable = new es.atareao.alejandria.laf.JLAFTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jXTableMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_add.png"))); // NOI18N
        jButton1.setToolTipText("Añadir");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_edit.png"))); // NOI18N
        jButton2.setToolTipText("Editar");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_new.png"))); // NOI18N
        jButton3.setToolTipText("Consultar");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_delete.png"))); // NOI18N
        jButton4.setToolTipText("Borrar");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, -1));

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
        //--------------------ADD---------------------------------
        try {
            DialogUnidad du = new DialogUnidad(new Unidad(this.getCompactDb().getConector()), Dialogo.OP_ADD);
            du.setVisible(true);
            if(du.getReturnStatus()==Dialogo.RET_OK){
                du.getUnidad().insert();
                this.getCompactDb().setModificado(true);
                this.refresca();
            }
        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //--------------------------EDIT-----------------------------------
        int fila=this.jXTable.getSelectedRow();
        if(fila>-1){
            if(this.jXTable.getValueAt(fila,1)!=null){
                String id=(String)this.jXTable.getValueAt(fila,1);
                try {
                    Unidad unidad=new Unidad(this.getCompactDb().getConector());
                    unidad.setId(id);
                    unidad.read();
                    DialogUnidad du = new DialogUnidad(unidad, Dialogo.OP_EDIT);
                    du.setVisible(true);
                    if(du.getReturnStatus()==Dialogo.RET_OK){
                        du.getUnidad().update();
                        this.getCompactDb().setModificado(true);
                        this.refresca();
                    }
                } catch (SQLException ex) {
                    ErrorDialog.manejaError(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //-------------------------------VIEW--------------------------------
        int fila=this.jXTable.getSelectedRow();
        if(fila>-1){
            if(this.jXTable.getValueAt(fila,1)!=null){
                String id=(String)this.jXTable.getValueAt(fila,1);
                try {
                    Unidad unidad=new Unidad(this.getCompactDb().getConector());
                    unidad.setId(id);
                    unidad.read();
                    DialogUnidad du = new DialogUnidad(unidad, Dialogo.OP_VIEW);
                    du.setVisible(true);
                } catch (SQLException ex) {
                    ErrorDialog.manejaError(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //------------------------------DELETE----------------------------
        int fila=this.jXTable.getSelectedRow();
        if(fila>-1){
            if(this.jXTable.getValueAt(fila,1)!=null){
                String id=(String)this.jXTable.getValueAt(fila,1);
                try {
                    Unidad unidad=new Unidad(this.getCompactDb().getConector());
                    unidad.setId(id);
                    unidad.read();
                    DialogUnidad du = new DialogUnidad(unidad, Dialogo.OP_DELETE);
                    du.setVisible(true);
                    if(du.getReturnStatus()==Dialogo.RET_OK){
                        du.getUnidad().delete();
                        this.getCompactDb().setModificado(true);
                        this.refresca();
                    }
                } catch (SQLException ex) {
                    ErrorDialog.manejaError(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
   
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
            //                         0      1        2            3           4
            String[] columnNames = {"ORDEN", "ID", "SIMBOLO", "DESCRIPCION", "FECHA"};
            final int nColumns = columnNames.length;
            tableModel.setColumnIdentifiers(columnNames);
            tableModel.setColumnCount(nColumns);
            //
            this.jXTable.setModel(tableModel);
            this.jXTable.setRowHeight(25);
            //
            this.jXTable.getColumnModel().getColumn(4).setCellRenderer(new JDateChooserTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(4).setCellEditor(new JDateChooserTableCellEditor());//this.jXTable,4
            //
            this.setColumnWidth(0,0);
            this.setColumnWidth(1,0);
            this.setColumnWidth(2,100);
            //this.setColumnWidth(3,100); Lo que sobra se lo queda esta
            this.setColumnWidth(4,150);
            //
            for(Unidad unidad:this.getUnidad().find("orden")){
                Object[] fila={unidad.getValue("orden"),unidad.getValue("id"),unidad.getValue("simbolo"),unidad.getValue("descripcion"),unidad.getValue("fecha")};
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
        int fila=this.jXTable.getRowCount()-1;
        if (fila<0){
            fila=0;
        }
        Object[] filadata={
            Convert.toString(fila),//Orden - 0
            "",//id - 1
            "",//simbolo
            "",//descripcion
            Convert.toStringDateSql(DateUtils.Ahora())//fecha
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
        DefaultTableModel tableModel=(DefaultTableModel)this.jXTable.getModel();
        this.getUnidad().setId((String) tableModel.getValueAt(fila,1));
        this.getUnidad().setValue("id", (String) tableModel.getValueAt(fila,1));
        this.getUnidad().setValue("orden", (String) tableModel.getValueAt(fila,0));
        this.getUnidad().setValue("simbolo", (String)tableModel.getValueAt(fila,2));
        this.getUnidad().setValue("descripcion", (String)tableModel.getValueAt(fila,3));
        this.getUnidad().setValue("fecha", (String)tableModel.getValueAt(fila,4));
        //
        try {
            if (this.getUnidad().validate()) {
                Object valor=tableModel.getValueAt(fila, 1);
                if ((valor==null)||(valor.equals(""))) {
                    if (this.getUnidad().insert()) {
                        tableModel.setValueAt(Convert.toString(this.getUnidad().getLastInsertId()), fila, 1);
                        return true;
                    }
                } else {
                    this.getUnidad().setId((String) tableModel.getValueAt(fila,1));
                    if (this.getUnidad().update()) {
                        return true;
                    }
                }
            }
        } catch (ValidationException ex) {
            ErrorDialog.manejaError(ex, false);
        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex, false);
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
    private javax.swing.JButton jExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private es.atareao.alejandria.laf.JLAFTable jXTable;
    // End of variables declaration//GEN-END:variables
    private Unidad _unidad;
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

    public Unidad getUnidad() {
        return _unidad;
    }

    public void setUnidad(Unidad unidad) {
        this._unidad = unidad;
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
