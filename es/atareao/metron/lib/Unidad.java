/*
 * ***********************Software description*********************************
 * Unidad.java
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

import java.sql.SQLException;
import es.atareao.queensboro.db.Conector;
import es.atareao.queensboro.db.WrapperTable;
import es.atareao.queensboro.val.NotEmptyValidator;
import es.atareao.queensboro.val.NotNullValidator;
import es.atareao.queensboro.val.UniqueValidator;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Unidad extends WrapperTable<Unidad>{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Unidad() throws SQLException{
        this(null);
    }
    public Unidad(Conector conector) throws SQLException {
        super(Unidad.class,conector,"public","unidad");
        this.addValidator(new NotEmptyValidator(this,"simbolo"));
        this.addValidator(new NotNullValidator(this,"simbolo"));
        this.addValidator(new UniqueValidator(this,"simbolo"));
        this.addValidator(new NotEmptyValidator(this,"descripcion"));
        this.addValidator(new NotNullValidator(this,"descripcion"));
        this.addValidator(new UniqueValidator(this,"descripcion"));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("simbolo");
    }

    public String getDescripcion(){
        return this.getValue("descripcion");
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Campos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  "> 

    // </editor-fold> 
}
