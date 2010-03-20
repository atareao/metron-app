/*
 * ***********************Software description*********************************
 * Adjunto.java
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

package es.atareao.metron.lib;

//
//********************************IMPORTACIONES*********************************
//

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import es.atareao.queensboro.db.Conector;
import es.atareao.queensboro.db.WrapperTable;
import es.atareao.queensboro.val.NotEmptyValidator;
import es.atareao.queensboro.val.NotNullValidator;
import es.atareao.queensboro.val.UniqueValidator;
import java.util.Vector;

/**
 *
 * @author Lorenzo Carbonell
 */
public class Adjunto extends WrapperTable<Adjunto>{
    // <editor-fold defaultstate="collapsed" desc=" Constantes  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Constructores  "> 
    public Adjunto() throws SQLException{
        this(null);
    }
    public Adjunto(Conector conector) throws SQLException {
        super(Adjunto.class,conector,"public","adjunto");
        this.addValidator(new NotEmptyValidator(this,"uri"));
        this.addValidator(new NotNullValidator(this,"uri"));
        this.addValidator(new NotEmptyValidator(this,"descripcion"));
        this.addValidator(new NotNullValidator(this,"descripcion"));
        Vector<String> uniqueColumnNames=new Vector<String>();
        uniqueColumnNames.add("concepto_id");
        uniqueColumnNames.add("cuadro_id");
        this.addValidator(new UniqueValidator(this,uniqueColumnNames));
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos  "> 
    @Override
    public String toString(){
        return this.getValue("descripcion");
    }
    public URI toURI() throws URISyntaxException{
        return new URI(this.getValue("uri"));
    }
    public File toFile() throws URISyntaxException{
        return new File(this.toURI());
    }
    public URL toURL() throws URISyntaxException, MalformedURLException{
        return this.toURI().toURL();
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos auxiliares  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Campos  "> 

    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Métodos de acceso  "> 

    // </editor-fold> 
}
