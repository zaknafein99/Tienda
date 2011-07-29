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
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)      return "Nombre";
        else if(column == 1) return "Apellido";
        else if(column == 2) return "Direccion";
        else if(column == 3) return "Telefono";
        else if(column == 4) return "Banco";
        else if(column == 5) return "Nro Cuenta";
        
        throw new IllegalStateException();
    }

    @Override
    public Object getColumnValue(Proveedor prov, int column) {
        if(column == 0)      return prov.getNombre();
        else if(column == 1) return prov.getApellido();
        else if(column == 2) return prov.getDireccion();
        else if(column == 3) return prov.getTelefono();
        else if(column == 4) return prov.getBanco();
        else if(column == 5) return prov.getNroCuenta();

        throw new IllegalStateException();
    }
    
}
