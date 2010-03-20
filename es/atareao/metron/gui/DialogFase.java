/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DialogModificarUnidad.java
 *
 * Created on 07-mar-2010, 12:37:43
 */

package es.atareao.metron.gui;

import es.atareao.alejandria.gui.ErrorDialog;
import es.atareao.alejandria.lib.Convert;
import es.atareao.alejandria.val.gui.GuiNotEmptyValidator;
import es.atareao.alejandria.val.gui.GuiPositiveValidator;
import es.atareao.metron.lib.Cuadro;
import es.atareao.metron.lib.Fase;
import java.awt.Component;
import java.sql.SQLException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author atareao
 */
public class DialogFase extends javax.swing.JDialog implements Dialogo {
    //
    //******************************CONSTRUCTORES*******************************
    //

    /** Creates new form DialogModificarUnidad */
    public DialogFase(Fase fase,Cuadro cuadro,int operacion) {
        super(new JFrame(),true);
        initComponents();
        this.setSize(430, 360);
        this.setLocationRelativeTo(null);
        String variable="Fase";
        //
        switch (operacion){
            case OP_ADD:
                this.setTitle("Añadir "+variable);
                break;
            case OP_EDIT:
                this.setTitle("Editar "+variable);
                break;
            case OP_DELETE:
                this.setTitle("Borrar "+variable);
                this.doNotEditable();
                break;
            case OP_VIEW:
                this.setTitle("Consultar "+variable);
                this.doNotEditable();
                break;
        }
        try {
            this.jCuadro.setElements(cuadro.find("orden"));
            this.jCuadro.setSelectedId(cuadro.getId());
        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
        this.setFase(fase);
    }
    //
    //**************************METODOS AUXILIARES******************************
    //
    private boolean valida(JComponent main){
        boolean ans=true;
        InputVerifier iv=main.getInputVerifier();
        if(iv!=null){
            if(!iv.verify(main)){
                ans=false;
            }
        }
        for(Component c:main.getComponents()){
            if(c instanceof JComponent){
                if(!valida(((JComponent)c))){
                    ans=false;
                }
            }
        }
        return ans;
    }
    private boolean valida(){
        return this.valida(this.jPanel1);
    }
    private void doClose(int retStatus) {
        if(retStatus==RET_OK){
            /*
            if((Convert.toLong(this.getFase().getId())>0)&&(Convert.toLong(this.getFase().getId())<4)){
                JOptionPane.showMessageDialog(this,"Este registro no se puede modificar ni borrar.","ATENCIÓN",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
             */
            if(this.valida()){
                try {
                    Fase fd=this.fromDialog();
                    if((fd!=null)&&(fd.validate())){
                        this._fase=fd;
                    }else{
                        return;
                    }
                } catch (Exception ex) {
                     ErrorDialog.manejaError(ex,false);
                     return;
                }
            }
        }
        this.setReturnStatus(retStatus);
        setVisible(false);
        dispose();
    }

    private void doNotEditable(){
        this.jDescripcion.setEditable(false);
        this.jFecha.setEditable(false);
        //
        this.jDescripcion.setBackground(java.awt.SystemColor.info);
        this.jFecha.setBackground(java.awt.SystemColor.info);
    }

    private Fase fromDialog(){
        try {
            Fase fase = new Fase(this._fase.getConector());
            fase.setId(this._fase.getId());
            fase.setValue("numero",this.jNumero.getText());
            fase.setValue("descripcion", this.jDescripcion.getText());
            fase.setValue("fecha", Convert.toStringDateSql(this.jFecha.getDate()));
            fase.setValue("aprobada",Convert.toString(this.jAprobada.isSelected()));
            fase.setValue("fecha_aprobada", Convert.toStringDateSql(this.jFechaAprobada.getDate()));
            fase.setValue(("cuadro_id"),this.jCuadro.getSelectedId());
            return fase;
        } catch (SQLException ex) {
            ErrorDialog.manejaError(ex);
        }
        return null;
    }
    private void toDialog(){
        this.jCuadro.setSelectedId(this._fase.getValue("cuadro_id"));
        this.jNumero.setDouble(this._fase.getValue("numero"));
        this.jDescripcion.setText(this._fase.getValue("descripcion"));
        this.jFecha.setDate(Convert.toDateSql(this._fase.getValue("fecha")));
        this.jAprobada.setSelected(Convert.toBoolean(this._fase.getValue("aprobada")));
        this.jFechaAprobada.setDate(Convert.toDateSql(this._fase.getValue("fecha_aprobada")));
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCuadro = new es.atareao.queensboro.gui.JWrapperComboBox();
        jNumero = new es.atareao.alejandria.gui.JNumericField();
        jDescripcion = new javax.swing.JTextField();
        jFecha = new es.atareao.alejandria.gui.JDateChooser();
        jAprobada = new javax.swing.JCheckBox();
        jFechaAprobada = new es.atareao.alejandria.gui.JDateChooser();
        jAceptar = new javax.swing.JButton();
        jCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Cuadro:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jLabel5.setText("Número:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 30));

        jLabel2.setText("Descripción:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 30));

        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 150, 30));

        jLabel6.setText("Aprobada:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 30));

        jLabel7.setText("Fecha de aprobación:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 30));

        jCuadro.setEnabled(false);
        jPanel1.add(jCuadro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 230, 30));

        jNumero.setDouble(1.0);
        jNumero.setInputVerifier(new GuiPositiveValidator(this,jNumero));
        jPanel1.add(jNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 230, 30));

        jDescripcion.setInputVerifier(new GuiNotEmptyValidator(this,jDescripcion));
        jPanel1.add(jDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 230, 30));
        jPanel1.add(jFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 230, 30));

        jAprobada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jAprobadaItemStateChanged(evt);
            }
        });
        jPanel1.add(jAprobada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 230, 30));

        jFechaAprobada.setEnabled(false);
        jPanel1.add(jFechaAprobada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 400, 250));

        jAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_ok.png"))); // NOI18N
        jAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jAceptar.setBorderPainted(false);
        jAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_cancel.png"))); // NOI18N
        jCancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jCancelar.setBorderPainted(false);
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAceptarActionPerformed
        this.doClose(Dialogo.RET_OK);
    }//GEN-LAST:event_jAceptarActionPerformed

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        this.doClose(Dialogo.RET_CANCEL);
    }//GEN-LAST:event_jCancelarActionPerformed

    private void jAprobadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jAprobadaItemStateChanged
        this.jFechaAprobada.setEnabled(this.jAprobada.isSelected());
    }//GEN-LAST:event_jAprobadaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAceptar;
    private javax.swing.JCheckBox jAprobada;
    private javax.swing.JButton jCancelar;
    private es.atareao.queensboro.gui.JWrapperComboBox jCuadro;
    private javax.swing.JTextField jDescripcion;
    private es.atareao.alejandria.gui.JDateChooser jFecha;
    private es.atareao.alejandria.gui.JDateChooser jFechaAprobada;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private es.atareao.alejandria.gui.JNumericField jNumero;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private Fase _fase;
    private int _returnStatus = RET_CANCEL;
    //
    //**************************METODOS DE ACCESO*******************************
    //

    @Override
    public int getReturnStatus() {
        return _returnStatus;
    }

    @Override
    public void setReturnStatus(int returnStatus) {
        this._returnStatus = returnStatus;
    }

    /**
     * @return the _fase
     */
    public Fase getFase() {
        return _fase;
    }

    /**
     * @param fase the _fase to set
     */
    public void setFase(Fase fase) {
        this._fase = fase;
        this.toDialog();
    }
}
