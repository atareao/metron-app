/*
 * ***********************Software description*********************************
 * Descomposicion.java
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
import es.atareao.queensboro.val.UniqueValidator;
import java.util.Vector;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Descomposicion extends WrapperTable<Descomposicion>{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Descomposicion() throws SQLException{
        this(null);
    }
    public Descomposicion(Conector conector) throws SQLException {
        super(Descomposicion.class,conector,"public","descomposicion");
        Vector<String> uniqueColumnNames=new Vector<String>();
        uniqueColumnNames.add("concepto_id");
        uniqueColumnNames.add("concepto_padre_id");
        uniqueColumnNames.add("cuadro_id");
        this.addValidator(new UniqueValidator(this,uniqueColumnNames));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("rendimiento");
    }

    public String getConceptoPadreId(){
        return this.getValue("concepto_padre_id");
    }

    public String getConceptoId(){
        return this.getValue("concepto_id");
    }

    public String getCuadroId(){
        return this.getValue("cuadro_id");
    }

    public String getFactor(){
        return this.getValue("factor");
    }

    public String getRendimiento(){
        return this.getValue("rendimiento");
    }

    public String getFecha(){
        return this.getValue("fecha");
    }

    public String getOrden(){
        return this.getValue("orden");
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Campos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  "> 

    // </editor-fold> 
}
