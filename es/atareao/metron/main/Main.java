/*
 * ***********************Software description*********************************
 * Main.java
 * 
 * 
 * ***********************Software description*********************************
 * 
 * Copyright (C) 2008 - Lorenzo Carbonell
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
 */

package es.atareao.metron.main;

import java.io.File;
import javax.swing.UIManager;
import es.atareao.alejandria.gui.ErrorDialog;
import es.atareao.alejandria.lib.FileUtils;
import es.atareao.alejandria.lib.INIFile;
import es.atareao.metron.gui.Metron;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Main {
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Método Principal  "> 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String iniFileName = FileUtils.addPathFile(System.getProperty("user.dir"),"metron.ini").getAbsolutePath();
        INIFile iniFile = new INIFile(iniFileName);
        try {
            String laf=iniFile.getStringProperty("Preferencias","LookAndFeel");
            UIManager.setLookAndFeel(laf);
        } catch (Exception e) {
            ErrorDialog.manejaError(e);
        }
        Metron metron=new Metron(iniFile);
        metron.setVisible(true);
    }
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Campos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  "> 

    // </editor-fold> 


}
