/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.gui;

import ca.odell.glazedlists.gui.TableFormat;
import com.ballet.dom.Proveedor;

/**
 *
 * @author Isma
 */
public class ProveedoresTableFormat implements TableFormat<Proveedor>{

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)      return "id";
        else if(column == 1)      return "Nombre";
        else if(column == 2) return "Apellido";
        else if(column == 3) return "Direccion";
        else if(column == 4) return "Telefono";
        else if(column == 5) return "Banco";
        else if(column == 6) return "Nro Cuenta";
        
        throw new IllegalStateException();
    }

    @Override
    public Object getColumnValue(Proveedor prov, int column) {
        if(column == 0)      return prov.getId();
        else if(column == 1) return prov.getNombre();
        else if(column == 2) return prov.getApellido();
        else if(column == 3) return prov.getDireccion();
        else if(column == 4) return prov.getTelefono();
        else if(column == 5) return prov.getBanco();
        else if(column == 6) return prov.getNroCuenta();

        throw new IllegalStateException();
    }
    
}
