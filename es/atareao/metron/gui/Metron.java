/*
 * ***********************Software description*********************************
 * Metron.java
 *
 *
 * ***********************Software description*********************************
 *
 * Copyright (C) 16 de julio de 2008 - Lorenzo Carbonell
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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import es.atareao.alejandria.gui.AboutDialogo;
import es.atareao.alejandria.gui.ErrorDialog;
import es.atareao.alejandria.lib.AppUtil;
import es.atareao.alejandria.lib.Convert;
import es.atareao.alejandria.lib.FileUtils;
import es.atareao.alejandria.lib.INIFile;
import es.atareao.alejandria.lib.Preferencias;
import es.atareao.queensboro.file.CompactDb;

/**
 *
 * @author  Lorenzo Carbonell
 */
public class Metron extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc=" Constantes  ">
    private final static long serialVersionUID=1L;
    //
    private final static String VERSION="01.00.20100221";
    private final static String APPNAME="Metron";
    private final static String EXT="met";
    private final static String AUTHOR="Lorenzo Carbonell";
    private final static String EMAIL="atareao@atareao.es";
    private final static String YEAR="2010";
    //
    private final static int AC_NUEVO=0;
    private final static int AC_ABRIR=1;
    private final static int AC_CERRAR=2;
    private final static int AC_GUARDAR=3;
    private final static int AC_GUARDAR_COMO=4;
    //
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Constructores  ">
    /** Creates new form Metron
     * @param inifile 
     */
    public Metron(INIFile inifile) {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(Convert.toInt(pantalla.width*0.95), Convert.toInt(pantalla.height*0.25));
        this.setLocationRelativeTo(null);
        this.setPreferencias(new Preferencias(inifile));
        this.setCompactDb(new CompactDb(this,APPNAME,EXT,"/es/atareao/metron/sql/metron.sql",true));
        AppUtil.verificaVersion(this,APPNAME,VERSION);
        this.loadRecentFiles();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuArchivoNuevo = new javax.swing.JMenuItem();
        jMenuArchivoAbrir = new javax.swing.JMenuItem();
        jMenuArchivoCerrar = new javax.swing.JMenuItem();
        jMenuArchivoGuardar = new javax.swing.JMenuItem();
        jMenuArchivoGuardarComo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuArchivoFiles = new javax.swing.JMenu();
        jMenuArchivoFile0 = new javax.swing.JMenuItem();
        jMenuArchivoFile1 = new javax.swing.JMenuItem();
        jMenuArchivoFile2 = new javax.swing.JMenuItem();
        jMenuArchivoFile3 = new javax.swing.JMenuItem();
        jMenuArchivoFile4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuArchivoSalir = new javax.swing.JMenuItem();
        jMenuEditar = new javax.swing.JMenu();
        jMenuEditarUnidades = new javax.swing.JMenuItem();
        jMenuEditarCuadros = new javax.swing.JMenuItem();
        jMenuEditarFases = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuEditarConceptos = new javax.swing.JMenuItem();
        jMenuHerramientas = new javax.swing.JMenu();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuAyudaAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Metron");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/metron/img/ic_icono.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(50, 50));
        jToolBar1.setMinimumSize(new java.awt.Dimension(50, 50));
        jToolBar1.setPreferredSize(new java.awt.Dimension(50, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_new.png"))); // NOI18N
        jButton1.setToolTipText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_open.png"))); // NOI18N
        jButton2.setToolTipText("Abrir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_save.png"))); // NOI18N
        jButton3.setToolTipText("Guardar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_save_as.png"))); // NOI18N
        jButton4.setToolTipText("Guardar como...");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_print.png"))); // NOI18N
        jButton5.setToolTipText("Imprimir");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator3);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_mano_obra.png"))); // NOI18N
        jButton7.setToolTipText("Mano de obra");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_maquinaria.png"))); // NOI18N
        jButton8.setToolTipText("Maquinaria");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_materiales.png"))); // NOI18N
        jButton9.setToolTipText("Materiales");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_partida.png"))); // NOI18N
        jButton10.setToolTipText("Partidas");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton10);
        jToolBar1.add(jSeparator4);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_copy.png"))); // NOI18N
        jButton11.setToolTipText("Copiar");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_cut.png"))); // NOI18N
        jButton12.setToolTipText("Cortar");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/atareao/img/png/button_paste.png"))); // NOI18N
        jButton13.setToolTipText("Pegar");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton13);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuArchivo.setText("Archivo");

        jMenuArchivoNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoNuevo.setText("Nuevo");
        jMenuArchivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoNuevoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoNuevo);

        jMenuArchivoAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoAbrir.setText("Abrir");
        jMenuArchivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoAbrirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoAbrir);

        jMenuArchivoCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoCerrar.setText("Cerrar");
        jMenuArchivoCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoCerrarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoCerrar);

        jMenuArchivoGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuArchivoGuardar.setText("Guardar");
        jMenuArchivoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoGuardarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoGuardar);

        jMenuArchivoGuardarComo.setText("Guardar como ...");
        jMenuArchivoGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoGuardarComoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoGuardarComo);
        jMenuArchivo.add(jSeparator2);

        jMenuArchivoFiles.setText("Recientes");

        jMenuArchivoFile0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoFile0ActionPerformed(evt);
            }
        });
        jMenuArchivoFiles.add(jMenuArchivoFile0);

        jMenuArchivoFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoFile1ActionPerformed(evt);
            }
        });
        jMenuArchivoFiles.add(jMenuArchivoFile1);

        jMenuArchivoFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoFile2ActionPerformed(evt);
            }
        });
        jMenuArchivoFiles.add(jMenuArchivoFile2);

        jMenuArchivoFile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoFile3ActionPerformed(evt);
            }
        });
        jMenuArchivoFiles.add(jMenuArchivoFile3);

        jMenuArchivoFile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoFile4ActionPerformed(evt);
            }
        });
        jMenuArchivoFiles.add(jMenuArchivoFile4);

        jMenuArchivo.add(jMenuArchivoFiles);
        jMenuArchivo.add(jSeparator1);

        jMenuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuArchivoSalir.setText("Salir");
        jMenuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuArchivoSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuEditar.setText("Editar");

        jMenuEditarUnidades.setText("Unidades");
        jMenuEditarUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarUnidadesActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuEditarUnidades);

        jMenuEditarCuadros.setText("Cuadros");
        jMenuEditarCuadros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarCuadrosActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuEditarCuadros);

        jMenuEditarFases.setText("Fases");
        jMenuEditarFases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarFasesActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuEditarFases);
        jMenuEditar.add(jSeparator5);

        jMenuEditarConceptos.setText("Conceptos");
        jMenuEditarConceptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarConceptosActionPerformed(evt);
            }
        });
        jMenuEditar.add(jMenuEditarConceptos);

        jMenuBar1.add(jMenuEditar);

        jMenuHerramientas.setText("Herramientas");
        jMenuHerramientas.setEnabled(false);
        jMenuBar1.add(jMenuHerramientas);

        jMenuAyuda.setText("Ayuda");

        jMenuAyudaAcercade.setText("A cerca de ...");
        jMenuAyudaAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAyudaAcercadeActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuAyudaAcercade);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoSalirActionPerformed
        this.doExit();
    }//GEN-LAST:event_jMenuArchivoSalirActionPerformed

    private void jMenuAyudaAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAyudaAcercadeActionPerformed
        AboutDialogo ad = new AboutDialogo(this, true);
        ad.setApplicationName(APPNAME);
        ad.setVersion(VERSION);
        ad.setYear(YEAR);
        ad.setAuthor(AUTHOR);
        ad.setEmail(EMAIL);
        String texto = "El metro es la unidad de longitud del Sistema " +
        "Internacional de Unidades. Se define como la longitud del trayecto " +
        "recorrido en el vacío por la luz durante un tiempo de 1/299 792 458 de " +
        "segundo (unidad de tiempo) (aprox. 3,34 ns).\r\n\r\n"+
        "Inicialmente fue creada por la Academia de Ciencias Francesa en 1791 y " +
        "definida como la diezmillonésima parte de la distancia que separa el " +
        "polo de la línea del ecuador terrestre. Si este valor se expresara de " +
        "manera análoga a como se define la milla náutica, se correspondería con " +
        "la longitud de meridiano terrestre que forma un arco de 1/10 de segundo " +
        "de grado centesimal.\r\n\r\n"+
        "Se realizaron mediciones cuidadosas al respecto que en 1889 se " +
        "corporizaron en un metro patrón de platino e iridio depositado en la " +
        "Oficina Internacional de Pesos y Medidas (París).";
        ad.setTexto(texto);
        ad.setImage("/es/atareao/metron/img/ic_logo.png");
        ad.setVisible(true);        
    }//GEN-LAST:event_jMenuAyudaAcercadeActionPerformed

    private void jMenuArchivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoAbrirActionPerformed
        this.doAction(AC_ABRIR);
    }//GEN-LAST:event_jMenuArchivoAbrirActionPerformed
    private void jMenuArchivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoNuevoActionPerformed
        this.doAction(AC_NUEVO);
    }//GEN-LAST:event_jMenuArchivoNuevoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.doExit();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuArchivoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoGuardarActionPerformed
        this.doAction(AC_GUARDAR);
    }//GEN-LAST:event_jMenuArchivoGuardarActionPerformed

    private void jMenuArchivoCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoCerrarActionPerformed
        this.doAction(AC_CERRAR);
    }//GEN-LAST:event_jMenuArchivoCerrarActionPerformed

    private void jMenuArchivoGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoGuardarComoActionPerformed
        this.doAction(AC_GUARDAR_COMO);
}//GEN-LAST:event_jMenuArchivoGuardarComoActionPerformed

    private void jMenuArchivoFile0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoFile0ActionPerformed
        File file=new File(this.jMenuArchivoFile0.getText());
        this.doActionOpenFile(file);
    }//GEN-LAST:event_jMenuArchivoFile0ActionPerformed

    private void jMenuArchivoFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoFile1ActionPerformed
        File file=new File(this.jMenuArchivoFile1.getText());
        this.doActionOpenFile(file);
    }//GEN-LAST:event_jMenuArchivoFile1ActionPerformed

    private void jMenuArchivoFile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoFile2ActionPerformed
        File file=new File(this.jMenuArchivoFile2.getText());
        this.doActionOpenFile(file);
    }//GEN-LAST:event_jMenuArchivoFile2ActionPerformed

    private void jMenuArchivoFile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoFile3ActionPerformed
        File file=new File(this.jMenuArchivoFile3.getText());
        this.doActionOpenFile(file);
    }//GEN-LAST:event_jMenuArchivoFile3ActionPerformed

    private void jMenuArchivoFile4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoFile4ActionPerformed
        File file=new File(this.jMenuArchivoFile4.getText());
        this.doActionOpenFile(file);
    }//GEN-LAST:event_jMenuArchivoFile4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.doAction(AC_NUEVO);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuEditarUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarUnidadesActionPerformed
        if(this.getCompactDb()!=null){
            if(this.getCompactDb().isOpened()){
                DialogUnidades du=new DialogUnidades(this,true,this.getCompactDb());
                du.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuEditarUnidadesActionPerformed

    private void jMenuEditarCuadrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarCuadrosActionPerformed
        if(this.getCompactDb()!=null){
            if(this.getCompactDb().isOpened()){
                DialogCuadros dc=new DialogCuadros(this,true,this.getCompactDb());
                dc.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuEditarCuadrosActionPerformed

    private void jMenuEditarFasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarFasesActionPerformed
        if(this.getCompactDb()!=null){
            if(this.getCompactDb().isOpened()){
                DialogFases df=new DialogFases(this,true,this.getCompactDb());
                df.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuEditarFasesActionPerformed

    private void jMenuEditarConceptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarConceptosActionPerformed
        if(this.getCompactDb()!=null){
            if(this.getCompactDb().isOpened()){
                DialogConceptos1 dc=new DialogConceptos1(this,true,this.getCompactDb());
                dc.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuEditarConceptosActionPerformed
   
    // <editor-fold defaultstate="collapsed" desc=" Métodos  ">

        //
    //********************************ACCIONES**********************************
    //
    // <editor-fold defaultstate="collapsed" desc="  Acciones  ">
    private void doWhenOpenFile(boolean isFileOpened){
        /*
        this.jTabbedPane1.setVisible(isFileOpened);
        this.jButton1.setEnabled(isFileOpened);
        this.jButton2.setEnabled(isFileOpened);
        this.jButton3.setEnabled(isFileOpened);
        this.jButton4.setEnabled(isFileOpened);
        if(this.jTabbedPane1.getSelectedIndex()==TAB_PARTES){
            this.jButton5.setEnabled(isFileOpened);
            this.jButton6.setEnabled(isFileOpened);
            this.jButton11.setEnabled(isFileOpened);
        }
        this.jButton9.setEnabled(isFileOpened);
        this.jButton10.setEnabled(isFileOpened);
         */
        this.jMenuArchivoCerrar.setEnabled(isFileOpened);
        this.jMenuArchivoGuardar.setEnabled(isFileOpened);
        this.jMenuArchivoGuardarComo.setEnabled(isFileOpened);
    }
    private void doActionOpenFile(File file){
        this.getCompactDb().setDefaultDir(this.getDefaultDir());
        if(this.getCompactDb().open(file)){
            this.setDefaultDir(this.getCompactDb().getDefaultDir());
            this.addRecentFile(this.getCompactDb().getFile().getAbsolutePath());
            this.loadFile();
            /*
            this.jTabbedPane1.setVisible(true);
             */
        }
    }
    private void doAction(int action){
        boolean doit=false;
        this.getCompactDb().setDefaultDir(this.getDefaultDir());
        switch (action){
            case AC_ABRIR:
                doit=this.getCompactDb().open();
                if(doit){
                    this.loadFile();
                    this.doWhenOpenFile(true);
                    this.setDefaultDir(this.getCompactDb().getDefaultDir());
                    this.addRecentFile(this.getCompactDb().getFile().getAbsolutePath());
                }
                break;
            case AC_CERRAR:
                doit=this.getCompactDb().close();
                if(doit){
                    this.doWhenOpenFile(false);
                }
                break;
            case AC_GUARDAR:
                doit=this.getCompactDb().save();
                this.setDefaultDir(this.getCompactDb().getDefaultDir());
                this.addRecentFile(this.getCompactDb().getFile().getAbsolutePath());
                break;
            case AC_GUARDAR_COMO:
                doit=this.getCompactDb().saveAs();
                this.setDefaultDir(this.getCompactDb().getDefaultDir());
                this.addRecentFile(this.getCompactDb().getFile().getAbsolutePath());
                break;
            case AC_NUEVO:
                doit=this.getCompactDb().create();
                if(doit){
                    this.loadFile();
                    this.doWhenOpenFile(true);
                    this.setDefaultDir(this.getCompactDb().getDefaultDir());
                    this.addRecentFile(this.getCompactDb().getFile().getAbsolutePath());
                }
                break;
        }
    }
    // </editor-fold>
    private void loadRecentFiles(){
        String file0=this.getPreferencias().getPreferencia("File0");
        String file1=this.getPreferencias().getPreferencia("File1");
        String file2=this.getPreferencias().getPreferencia("File2");
        String file3=this.getPreferencias().getPreferencia("File3");
        String file4=this.getPreferencias().getPreferencia("File4");
        this.jMenuArchivoFile0.setText(file0);
        this.jMenuArchivoFile1.setText(file1);
        this.jMenuArchivoFile2.setText(file2);
        this.jMenuArchivoFile3.setText(file3);
        this.jMenuArchivoFile4.setText(file4);
    }
    private void loadFile(){
        try {
            /*
            /////
            this.setSubcontratista(new Subcontratista(this.getCompactDb().getConector()));
            this.setRecurso(new Familia(this.getCompactDb().getConector()));
            this.setPrecio(new Precio(this.getCompactDb().getConector()));
            this.setElemento(new Recurso(this.getCompactDb().getConector()));
            this.setPartes(new Partes(this.getCompactDb().getConector()));
            this.setParte(new Parte(this.getCompactDb().getConector()));
            this.setUnidadCoste(new UnidadCoste(this.getCompactDb().getConector()));
            this.setReport(new Report(this.getCompactDb().getConector()));
            ////
            this.filtraSubcontratistas(false);
            this.filtraFamilias(false);
            this.filtraPrecios(false);
            this.filtraRecursos(false);
            this.filtraPartes(true);
            this.filtraUnidadesCoste(false);
            this.filtraInformes(false);
             */
        } catch (Exception ex) {
            ErrorDialog.manejaError(ex, true);
        }
    }
    private void doExit() {
        this.getPreferencias().save();
        try {
            File dir = new File(System.getProperty("user.dir") + File.separator + "tmp");
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        } catch (Exception ex) {
            ErrorDialog.manejaError(ex, true);
        }
        this.getCompactDb().close();
        System.exit(0);
    }
    private void addRecentFile(String file){
        String file0=this.getPreferencias().getPreferencia("File0");
        String file1=this.getPreferencias().getPreferencia("File1");
        String file2=this.getPreferencias().getPreferencia("File2");
        String file3=this.getPreferencias().getPreferencia("File3");
        String file4=this.getPreferencias().getPreferencia("File4");
        if(file!=null){
            if(file.equals(file0)){
                return;
            }
            if(file.equals(file1)){
                file1=file0;
                file0=file;
            }else if(file.equals(file2)){
                file2=file0;
                file0=file;
            }else if(file.equals(file3)){
                file3=file0;
                file0=file;
            }else if(file.equals(file4)){
                file4=file0;
                file0=file;
            }else{
                file4=file3;
                file3=file2;
                file2=file1;
                file1=file0;
                file0=file;
            }
        }else{
            file0=file1;
            file1=file2;
            file2=file3;
            file3=file4;
            file4=null;

        }
        if(file0!=null){
            this.jMenuArchivoFile0.setText(file0);
            this.getPreferencias().setPreferencia("File0", file0);
        }else{
            this.jMenuArchivoFile0.setText("");
        }
        if(file1!=null){
            this.jMenuArchivoFile1.setText(file1);
            this.getPreferencias().setPreferencia("File1", file1);
        }else{
            this.jMenuArchivoFile1.setText("");
        }
        if(file2!=null){
            this.jMenuArchivoFile2.setText(file2);
            this.getPreferencias().setPreferencia("File2", file2);
        }else{
            this.jMenuArchivoFile2.setText("");
        }
        if(file3!=null){
            this.jMenuArchivoFile3.setText(file3);
            this.getPreferencias().setPreferencia("File3", file3);
        }else{
            this.jMenuArchivoFile3.setText("");
        }
        if(file4!=null){
            this.jMenuArchivoFile4.setText(file4);
            this.getPreferencias().setPreferencia("File4", file4);
        }else{
            this.jMenuArchivoFile4.setText("");
        }
        this.getPreferencias().save();
    }

        private void exectuteReport(String report){
        report="./Informes/"+report;
        try {
            //Map<String,String> parameters = this.getPartes().getParameters();
            JasperReport jasperReport=JasperCompileManager.compileReport("report");
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null,this.getCompactDb().getConector().getConexion());
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            ErrorDialog.manejaError(ex,false);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  ">


    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Campos  ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuItem jMenuArchivoAbrir;
    private javax.swing.JMenuItem jMenuArchivoCerrar;
    private javax.swing.JMenuItem jMenuArchivoFile0;
    private javax.swing.JMenuItem jMenuArchivoFile1;
    private javax.swing.JMenuItem jMenuArchivoFile2;
    private javax.swing.JMenuItem jMenuArchivoFile3;
    private javax.swing.JMenuItem jMenuArchivoFile4;
    private javax.swing.JMenu jMenuArchivoFiles;
    private javax.swing.JMenuItem jMenuArchivoGuardar;
    private javax.swing.JMenuItem jMenuArchivoGuardarComo;
    private javax.swing.JMenuItem jMenuArchivoNuevo;
    private javax.swing.JMenuItem jMenuArchivoSalir;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuItem jMenuAyudaAcercade;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEditar;
    private javax.swing.JMenuItem jMenuEditarConceptos;
    private javax.swing.JMenuItem jMenuEditarCuadros;
    private javax.swing.JMenuItem jMenuEditarFases;
    private javax.swing.JMenuItem jMenuEditarUnidades;
    private javax.swing.JMenu jMenuHerramientas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    //
    private Preferencias _preferencias;
    private CompactDb _compactDb;
    //
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  ">
        private void setDefaultDir(File file){
        String str=file.toURI().toString();
        this.getPreferencias().setPreferencia("DefaultDir", str);
    }
    private File getDefaultDir(){
        String str=this.getPreferencias().getPreferencia("DefaultDir");
        if(str!=null){
            try {
                URI uri = new URI(str);
                return new File(uri);
            } catch (URISyntaxException ex) {
                return FileUtils.getApplicationPath();
            }
        }
        return FileUtils.getApplicationPath();
    }
    /**
     * @return the _preferencias
     */
    public Preferencias getPreferencias() {
        return _preferencias;
    }

    /**
     * @param preferencias the _preferencias to set
     */
    public void setPreferencias(Preferencias preferencias) {
        this._preferencias = preferencias;
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
