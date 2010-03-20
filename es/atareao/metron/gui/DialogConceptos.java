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
import es.atareao.alejandria.gui.JDateChooserTableCellEditor;
import es.atareao.alejandria.gui.JDateChooserTableCellRenderer;
import es.atareao.alejandria.gui.JTextFieldTableCellEditor;
import es.atareao.alejandria.gui.JTextFieldTableCellRenderer;
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
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
/**
 *
 * @author  Lorenzo Carbonell
 */
public class DialogConceptos extends javax.swing.JDialog {
    
    // <editor-fold defaultstate="collapsed" desc=" Constantes  ">
    public static final long serialVersionUID=0L;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Constructors  ">
    /** Creates new form SelectContact
     * @param parent
     * @param modal
     * @param conector 
     */
    public DialogConceptos(java.awt.Frame parent, boolean modal,CompactDb compactDb) {
        super(parent, modal);
        initComponents();
        this.setSize(990, 550);
        this.setLocationRelativeTo(null);
        this.jXTable.setUI(new DragDropRowTableUIOrdered());
        this.setCompactDb(compactDb);
        this.refresca();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable = new es.atareao.alejandria.laf.JLAFTable();
        jExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jXTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jXTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jXTableMouseReleased(evt);
            }
        });
        jXTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jXTableMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jXTableMouseMoved(evt);
            }
        });
        jXTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jXTableFocusLost(evt);
            }
        });
        jXTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jXTablePropertyChange(evt);
            }
        });
        jXTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jXTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 940, 430));

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

    private void jXTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTableKeyPressed
        int nfila=this.jXTable.getSelectedRow();
        int filas=this.jXTable.getRowCount();
        if(((nfila+1)==filas)&&(evt.getKeyCode()==40)){//Tecla abajo
            if((this.jXTable.getValueAt(nfila,1)==null)||((String)this.jXTable.getValueAt(nfila,1)).length()==0){
                if(this.saveRow(nfila)){
                    this.newRow();
                }
                return;
            }
            this.newRow();
            return;
        }
        if(evt.getKeyCode()==127){
            evt.consume();
            int[] filass=this.jXTable.getSelectedRows();
            if(filass.length>0){
                for(int seleccionado=filass.length-1;seleccionado>-1;seleccionado--){
                    int selectedRow=filass[seleccionado];
                    if(selectedRow>=0){
                        String selectedId=(String)this.jXTable.getValueAt(selectedRow,1);
                        try {
                            Concepto concepto = new Concepto(this.getCompactDb().getConector());
                            concepto.setId(selectedId);
                            concepto.read();
                            if(concepto.delete()){
                                this.jXTable.removeRowSelectionInterval(selectedRow,selectedRow);
                                this.getCompactDb().setModificado(true);
                                //this.refresca();
                            }
                        } catch (SQLException ex) {
                            ErrorDialog.manejaError(ex);
                        }
                    }
                }
                this.refresca();
            }
            return;
        }
    }//GEN-LAST:event_jXTableKeyPressed

    private void jXTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jXTablePropertyChange
        if(evt.getPropertyName().equals("Row selection changed")){
            System.out.println("Pues sí");
        }
    }//GEN-LAST:event_jXTablePropertyChange

    private void jXTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableMouseClicked
        int row = jXTable.rowAtPoint(evt.getPoint());
        int col = jXTable.columnAtPoint(evt.getPoint());
        jXTable.setRowSelectionInterval(row,row);

    }//GEN-LAST:event_jXTableMouseClicked

    private void jXTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableMousePressed

    }//GEN-LAST:event_jXTableMousePressed

    private void jXTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTableKeyReleased

    }//GEN-LAST:event_jXTableKeyReleased

    private void jXTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableMouseReleased

    }//GEN-LAST:event_jXTableMouseReleased

    private void jXTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTableMouseMoved

    }//GEN-LAST:event_jXTableMouseMoved

    private void jXTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXTableFocusLost

    }//GEN-LAST:event_jXTableFocusLost
    /*
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
     *
     */
   
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
            /*
            tableModel.addTableModelListener(new AbstractTableModelListener() {
                @Override
                protected void cellChanged(TableModel tableModel, int fila, int columna) {
                    if(((DragDropRowTableUIOrdered)jXTable.getUI()).isDraggingRow()){
                        return;
                    }
                    saveRow(fila);
                }
                //}
            });
             *
             * 
             */
            //
            tableModel.addTableModelListener(new Listener(jXTable));
            this.jXTable.getSelectionModel().addListSelectionListener(new SelectionListener(jXTable));
            this.jXTable.setModel(tableModel);
            //
            this.jXTable.setRowHeight(40);
            //
            this.jXTable.getColumnModel().getColumn(2).setCellRenderer(new JTextFieldTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(2).setCellEditor(new JTextFieldTableCellEditor());
            //
            JWrapperImageComboBoxTableCellEditor wcbeTipo=new JWrapperImageComboBoxTableCellEditor();
            JWrapperImageComboBoxTableCellRenderer wcbrTipo=new JWrapperImageComboBoxTableCellRenderer();
            Tipo tipo=new Tipo(this.getCompactDb().getConector());
            Vector<Tipo> tipos=tipo.find("orden");
            wcbeTipo.setElements(tipos);
            wcbrTipo.setElements(tipos);
            this.jXTable.getColumnModel().getColumn(3).setCellRenderer(wcbrTipo);
            this.jXTable.getColumnModel().getColumn(3).setCellEditor(wcbeTipo);
            //
            JWrapperComboBoxTableCellEditor wcbeUnidad=new JWrapperComboBoxTableCellEditor();
            JWrapperComboBoxTableCellRenderer wcbrUnidad=new JWrapperComboBoxTableCellRenderer();
            Unidad unidad=new Unidad(this.getCompactDb().getConector());
            Vector<Unidad> unidades=unidad.find("orden");
            wcbeUnidad.setElements(unidades);
            wcbrUnidad.setElements(unidades);
            this.jXTable.getColumnModel().getColumn(4).setCellRenderer(wcbrUnidad);
            this.jXTable.getColumnModel().getColumn(4).setCellEditor(wcbeUnidad);
            //
            this.jXTable.getColumnModel().getColumn(5).setCellRenderer(new JTextFieldTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(5).setCellEditor(new JTextFieldTableCellEditor());
            //
            this.jXTable.getColumnModel().getColumn(6).setCellRenderer(new JDateChooserTableCellRenderer());
            this.jXTable.getColumnModel().getColumn(6).setCellEditor(new JDateChooserTableCellEditor());
            //
            this.setColumnWidth(0,0);
            this.setColumnWidth(1,0);
            this.setColumnWidth(2,100);
            this.setColumnWidth(3,90);
            this.setColumnWidth(4,70);
            //this.setColumnWidth(5,100); Lo que sobra se lo queda esta
            this.setColumnWidth(6,150);
            //
            Concepto newConcepto=new Concepto(this.getCompactDb().getConector());
            for(Concepto concepto:newConcepto.find("orden")){
                Object[] fila={concepto.getValue("orden"),concepto.getValue("id"),concepto.getValue("codigo"),concepto.getValue("tipo_id"),concepto.getValue("unidad_id"),concepto.getValue("descripcion"),concepto.getValue("fecha")};
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
        String tipo="1";
        String unidad="1";
        if(fila>0){
            tipo=(String)this.jXTable.getValueAt(fila,3);
            unidad=(String)this.jXTable.getValueAt(fila,4);
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
            Concepto concepto = new Concepto(this.getCompactDb().getConector());
            concepto.setId((String) tableModel.getValueAt(fila,1));
            concepto.setValue("id", (String) tableModel.getValueAt(fila,1));
            concepto.setValue("orden", (String) tableModel.getValueAt(fila,0));
            concepto.setValue("codigo", (String) tableModel.getValueAt(fila,2));
            concepto.setValue("tipo_id", (String) tableModel.getValueAt(fila,3));
            concepto.setValue("unidad_id", (String) tableModel.getValueAt(fila,4));
            concepto.setValue("descripcion", (String) tableModel.getValueAt(fila,5));
            concepto.setValue("fecha", (String) tableModel.getValueAt(fila,6));
            //
            if (concepto.validate()) {
                Object valor = tableModel.getValueAt(fila, 1);
                if ((valor == null) || (valor.equals(""))) {
                    if (concepto.insert()) {
                        tableModel.setValueAt(Convert.toString(concepto.getLastInsertId()), fila, 1);
                        this._compactDb.setModificado(true);
                        return true;
                    }
                } else {
                    concepto.setId((String) tableModel.getValueAt(fila,1));
                    if (concepto.update()) {
                        this._compactDb.setModificado(true);
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
    private javax.swing.JButton jExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private es.atareao.alejandria.laf.JLAFTable jXTable;
    // End of variables declaration//GEN-END:variables
    private CompactDb _compactDb;
    private boolean _updatingRows=false;
    private boolean _modificado=false;
    private int _filaActual=-1;
    private int _filaAnterior=-1;
    private int _filaModificada=-1;

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

    class SelectionListener implements ListSelectionListener {
        JTable table;
        // It is necessary to keep the table since it is not possible
        // to determine the table from the event's source
        SelectionListener(JTable table) {
            this.table = table;
        }
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
                _filaAnterior=_filaActual;
                _filaActual=table.getSelectedRow();
                if(_filaModificada!=-1){
                    saveRow(_filaModificada);
                    _filaModificada=-1;
                }
            }
        }
    }
    class Listener implements TableModelListener {
        JTable table;
        Listener(JTable table) {
            this.table = table;
        }
        @Override
        public void tableChanged(TableModelEvent e) {
            if(e.getType()==TableModelEvent.UPDATE){
                if (e.getFirstRow() != TableModelEvent.HEADER_ROW) {
                    _filaModificada=e.getFirstRow();
                }
            }
        }
    }
}
