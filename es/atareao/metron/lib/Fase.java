/*
 * ***********************Software description*********************************
 * Fase.java
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
import java.util.Vector;
import es.atareao.queensboro.db.Conector;
import es.atareao.queensboro.db.WrapperTable;
import es.atareao.queensboro.val.NotEmptyValidator;
import es.atareao.queensboro.val.NotNullValidator;
import es.atareao.queensboro.val.UniqueValidator;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Fase extends WrapperTable<Fase>{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Fase() throws SQLException{
        this(null);
    }
    public Fase(Conector conector) throws SQLException {
        super(Fase.class,conector,"public","fase");
        this.addValidator(new NotEmptyValidator(this,"numero"));
        this.addValidator(new NotNullValidator(this,"numero"));
        Vector<String> uniqueColumnNames=new Vector<String>();
        uniqueColumnNames.add("numero");
        uniqueColumnNames.add("cuadro_id");        
        this.addValidator(new UniqueValidator(this,uniqueColumnNames));
        uniqueColumnNames=new Vector<String>();
        uniqueColumnNames.add("fecha");
        uniqueColumnNames.add("cuadro_id");
        this.addValidator(new UniqueValidator(this,uniqueColumnNames));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("numero");
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
