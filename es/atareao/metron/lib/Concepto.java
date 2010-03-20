/*
 * ***********************Software description*********************************
 * Concepto.java
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
import es.atareao.queensboro.val.OnlyOneValidator;
import es.atareao.queensboro.val.UniqueValidator;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Concepto extends WrapperTable<Concepto>{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Concepto() throws SQLException{
        this(null);
    }
    public Concepto(Conector conector) throws SQLException {
        super(Concepto.class,conector,"public","concepto");
        this.addValidator(new NotEmptyValidator(this,"codigo"));
        this.addValidator(new NotNullValidator(this,"codigo"));
        this.addValidator(new UniqueValidator(this,"codigo"));
        this.addValidator(new NotEmptyValidator(this,"descripcion"));
        this.addValidator(new NotNullValidator(this,"descripcion"));
        this.addValidator(new UniqueValidator(this,"descripcion"));
        this.addValidator(new OnlyOneValidator(this,"tipo_id","5"));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("codigo");
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
