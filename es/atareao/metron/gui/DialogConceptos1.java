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

import es.atareao.alejandria.gui.ErrorDialog;
import es.atareao.alejandria.gui.JDateChooserTableCellEditor;
import es.atareao.alejandria.gui.JDateChooserTableCellRenderer;
import es.atareao.alejandria.gui.JMTable;
import es.atareao.alejandria.gui.JTextFieldTableCellEditor;
import es.atareao.alejandria.gui.JTextFieldTableCellRenderer;
import es.atareao.alejandria.gui.OperadorDeTablas;
import es.atareao.alejandria.lib.Convert;
import es.atareao.alejandria.lib.DateUtils;
import es.atareao.metron.lib.Concepto;
import es.atareao.metron.lib.Tipo;
import es.atareao.metron.lib.Unidad;
import es.atareao.queensboro.file.CompactDb;
import es.atareao.queensboro.gui.JWrapperComboBoxTableCellEditor;
import es.atareao.queensboro.gui.JWrapperComboBoxTableCellRenderer;
import es.atareao.queensboro.gui.JWrapperImageComboBoxTableCellEditor;
import es.atareao.queensboro.gui.JWrapperImageComboBoxTableCellRenderer;
import es.atareao.queensboro.val.ValidationException;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author  Lorenzo Carbonell
 */
public class DialogConceptos1 extends javax.swing.JDialog {
    
    // <editor-fold defaultstate="collapsed" desc=" Constantes  ">
    public static final long serialVersionUID=0L;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Constructors  ">
    /** Creates new form SelectContact
     * @param parent
     * @param modal
     * @param conector 
     */
    public DialogConceptos1(java.awt.Frame parent, boolean modal,CompactDb compactDb) {
        super(parent, modal);
        initComponents();
        this.setSize(990, 550);
        this.setLocationRelativeTo(null);
        this.setCompactDb(compactDb);
        OperadorDeTablas operador=new OperadorDeTablasImpl(jMTable1,this);
        jMTable1.setOperador(operador);
        jMTable1.refresca();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMTable1 = new es.atareao.alejandria.gui.JMTable();
        jExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jMTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 960, 450));

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
        getContentPane().add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, -1, -1));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        this.doClose();
    }//GEN-LAST:event_jExitActionPerformed
    // <editor-fold defaultstate="collapsed" desc=" Methods  ">
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Auxiliary Methods  ">
    private void doClose() {
        setVisible(false);
        dispose();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Fields  ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jExit;
    private es.atareao.alejandria.gui.JMTable jMTable1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private CompactDb _compactDb;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Access Methods  ">
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

    private class OperadorDeTablasImpl extends OperadorDeTablas {
        private JDialog _dialog;

        public OperadorDeTablasImpl(JMTable table,JDialog dialog) {
            super(table);
            _dialog=dialog;
        }

        @Override
        public void refresca() {
            try {
                DefaultTableModel tableModel = new DefaultTableModel() {
                    public static final long serialVersionUID=0L;
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        try {
                            switch (columnIndex) {
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    return true;
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
                //                         0      1       2        3        4           5           6
                String[] columnNames = {"ORDEN", "ID", "CODIGO", "TIPO", "UNIDAD","DESCRIPCION", "FECHA"};
                final int nColumns = columnNames.length;
                tableModel.setColumnIdentifiers(columnNames);
                tableModel.setColumnCount(nColumns);
                //
                jMTable1.setDefaultTableModel(tableModel);
                jMTable1.setRowHeight(40);
                //
                jMTable1.getColumn(2).setCellRenderer(new JTextFieldTableCellRenderer());
                jMTable1.getColumn(2).setCellEditor(new JTextFieldTableCellEditor());
                //
                JWrapperImageComboBoxTableCellEditor wcbeTipo=new JWrapperImageComboBoxTableCellEditor();
                JWrapperImageComboBoxTableCellRenderer wcbrTipo=new JWrapperImageComboBoxTableCellRenderer();
                Tipo tipo=new Tipo(getCompactDb().getConector());
                Vector<Tipo> tipos=tipo.find("orden");
                wcbeTipo.setElements(tipos);
                wcbrTipo.setElements(tipos);
                jMTable1.getColumn(3).setCellRenderer(wcbrTipo);
                jMTable1.getColumn(3).setCellEditor(wcbeTipo);
                //
                JWrapperComboBoxTableCellEditor wcbeUnidad=new JWrapperComboBoxTableCellEditor();
                JWrapperComboBoxTableCellRenderer wcbrUnidad=new JWrapperComboBoxTableCellRenderer();
                Unidad unidad=new Unidad(getCompactDb().getConector());
                Vector<Unidad> unidades=unidad.find("orden");
                wcbeUnidad.setElements(unidades);
                wcbrUnidad.setElements(unidades);
                jMTable1.getColumn(4).setCellRenderer(wcbrUnidad);
                jMTable1.getColumn(4).setCellEditor(wcbeUnidad);
                //
                jMTable1.getColumn(5).setCellRenderer(new JTextFieldTableCellRenderer());
                jMTable1.getColumn(5).setCellEditor(new JTextFieldTableCellEditor());
                //
                jMTable1.getColumn(6).setCellRenderer(new JDateChooserTableCellRenderer());
                jMTable1.getColumn(6).setCellEditor(new JDateChooserTableCellEditor());
                //
                jMTable1.setColumnWidth(0,0);
                jMTable1.setColumnWidth(1,0);
                jMTable1.setColumnWidth(2,100);
                jMTable1.setColumnWidth(3,90);
                jMTable1.setColumnWidth(4,70);
                //jMTable1.setColumnWidth(5,100); Lo que sobra se lo queda esta
                jMTable1.setColumnWidth(6,150);
                //
                Concepto newConcepto=new Concepto(getCompactDb().getConector());
                for(Concepto concepto:newConcepto.find("orden")){
                    Object[] fila={concepto.getValue("orden"),concepto.getValue("id"),concepto.getValue("codigo"),concepto.getValue("tipo_id"),concepto.getValue("unidad_id"),concepto.getValue("descripcion"),concepto.getValue("fecha")};
                    tableModel.addRow(fila);
                }
                if((jMTable1.getRowCount()==0)||(((String)jMTable1.getValueAt(0,0)).equals(""))){
                    this.newRow();
                }
            } catch (SQLException ex) {
                ErrorDialog.manejaError(ex);
            }

        }

        @Override
        public boolean saveRow(int row,int column) {
            if(row<jMTable1.getRowCount()){
                try {
                    DefaultTableModel tableModel = jMTable1.getDefaultTableModel();
                    Concepto concepto = new Concepto(getCompactDb().getConector());
                    Concepto conceptoAntes = new Concepto(getCompactDb().getConector());
                    concepto.setId((String) tableModel.getValueAt(row,1));
                    if((((String) tableModel.getValueAt(row,1))==null)||(((String) tableModel.getValueAt(row,1)).length()==0)){
                        conceptoAntes=null;
                    }else{
                        conceptoAntes.setId((String) tableModel.getValueAt(row,1));
                        conceptoAntes.read();
                    }
                    try{

                        concepto.setValue("id", (String) tableModel.getValueAt(row,1));
                        concepto.setValue("orden", (String) tableModel.getValueAt(row,0));
                        concepto.setValue("codigo", (String) tableModel.getValueAt(row,2));
                        concepto.setValue("tipo_id", (String) tableModel.getValueAt(row,3));
                        concepto.setValue("unidad_id", (String) tableModel.getValueAt(row,4));
                        concepto.setValue("descripcion", (String) tableModel.getValueAt(row,5));
                        concepto.setValue("fecha", (String) tableModel.getValueAt(row,6));
                        //
                        if (concepto.validate()) {
                            Object valor = tableModel.getValueAt(row, 1);
                            if ((valor == null) || (valor.equals(""))) {
                                if (concepto.insert()) {
                                    tableModel.setValueAt(Convert.toString(concepto.getLastInsertId()), row, 1);
                                    _compactDb.setModificado(true);
                                    return true;
                                }
                            } else {
                                concepto.setId((String) tableModel.getValueAt(row,1));
                                if (concepto.update()) {
                                    _compactDb.setModificado(true);
                                    return true;
                                }
                            }
                        }
                    } catch (ValidationException ex) {
                        if((((String) tableModel.getValueAt(row,1))==null)||(((String) tableModel.getValueAt(row,1)).length()==0)){
                            if(row==tableModel.getRowCount()-1){
                                System.out.println("Borrando");
                                jMTable1.getDefaultTableModel().removeRow(row);
                                System.out.println("He borrado la fila: "+row);
                                row--;
                                System.out.println("Ahora la fila actual es :"+row);
                                jMTable1.setFilaModificada(-1);
                                jMTable1.setFilaActual(row);
                                jMTable1.setFilaAnterior(row);
                            }
                        }
                        ErrorDialog.manejaError(ex);
                        if(conceptoAntes!=null){
                            jMTable1.setValueAt(conceptoAntes.getValue("orden"),row,0);
                            jMTable1.setValueAt(conceptoAntes.getValue("codigo"),row,2);
                            jMTable1.setValueAt(conceptoAntes.getValue("tipo_id"),row,3);
                            jMTable1.setValueAt(conceptoAntes.getValue("unidad_id"),row,4);
                            jMTable1.setValueAt(conceptoAntes.getValue("descripcion"),row,5);
                            jMTable1.setValueAt(conceptoAntes.getValue("fecha"),row,6);
                        }
                        jMTable1.setRowSelectionInterval(row,row);
                        jMTable1.setColumnSelectionInterval(column, column);
                        jMTable1.requestFocus();
                        return false;
                    }
                }catch (SQLException ex) {
                    ErrorDialog.manejaError(ex);
                    return false;
                }
            }
            return false;
        }

        @Override
        public boolean newRow() {
            int fila=jMTable1.getRowCount()-1;
            if (fila<0){
                fila=0;
            }
            String tipo="1";
            String unidad="1";
            if(fila>0){
                tipo=(String)jMTable1.getValueAt(fila,3);
                unidad=(String)jMTable1.getValueAt(fila,4);
            }
            Object[] filadata={
                Convert.toString(fila),//Orden - 0
                "",//id - 1
                Convert.toString(fila),//codigo - 2
                tipo,//tipo - 3
                unidad,//unidad - 4
                "",//descripcion - 5
                Convert.toStringDateSql(DateUtils.Ahora())//fecha - 6
            };
            return this.newRow(filadata);
        }

        @Override
        public boolean deleteRow(int row) {
            String selectedId=(String)jMTable1.getValueAt(row,1);
            try {
                Concepto concepto = new Concepto(getCompactDb().getConector());
                concepto.setId(selectedId);
                concepto.read();
                if(concepto.delete()){
                    jMTable1.removeRowSelectionInterval(row,row);
                    getCompactDb().setModificado(true);
                    return true;
                }
            } catch (SQLException ex) {
                ErrorDialog.manejaError(ex);
            }
            return false;
        }
    }
    
    // </editor-fold>

}
