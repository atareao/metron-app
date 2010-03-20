/*
 * ***********************Software description*********************************
 * Tipo.java
 * 
 * 
 * ***********************Software description*********************************
 * 
 * Copyright (C) 2010 - Lorenzo Carbonell
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

package es.atareao.metron.lib;

//
//********************************IMPORTACIONES*********************************
//

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import es.atareao.queensboro.db.Conector;
import es.atareao.queensboro.db.WrapperImage;
import es.atareao.queensboro.db.WrapperTable;
import es.atareao.queensboro.val.NotEmptyValidator;
import es.atareao.queensboro.val.NotNullValidator;
import es.atareao.queensboro.val.UniqueValidator;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Tipo extends WrapperTable<Tipo> implements WrapperImage{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Tipo() throws SQLException{
        this(null);
    }
    public Tipo(Conector conector) throws SQLException {
        super(Tipo.class,conector,"public","tipo");
        this.addValidator(new NotEmptyValidator(this,"tipo"));
        this.addValidator(new NotNullValidator(this,"tipo"));
        this.addValidator(new UniqueValidator(this,"tipo"));
        this.addValidator(new NotEmptyValidator(this,"descripcion"));
        this.addValidator(new NotNullValidator(this,"descripcion"));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("tipo");
    }
    /**
     * 
     * @return
     * @throws java.net.MalformedURLException
     */
    @Override
    public ImageIcon getImageIcon() throws MalformedURLException{
        if(this.getValue("url")!=null){
            URL url=this.getClass().getResource(this.getValue("url"));
            if(url!=null){
                return (new ImageIcon(url));
            }
        }
        throw new NullPointerException("Not exists");
    }
    @Override
    public String getDescripcion(){
        return this.getValue("tipo");
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Campos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  ">


    // </editor-fold> 
}
