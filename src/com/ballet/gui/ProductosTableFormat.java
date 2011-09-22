/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.gui;

import ca.odell.glazedlists.gui.TableFormat;
import com.ballet.dom.Producto;

/**
 *
 * @author Isma
 */
public class ProductosTableFormat implements TableFormat<Producto> {

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)      return "Descripción";
        else if(column == 1) return "Color";
        else if(column == 2) return "Talle";
        else if(column == 3) return "Proveedor";
        
        throw new IllegalStateException();
    }

    @Override
    public Object getColumnValue(Producto prod, int column) {
        if(column == 0)      return prod.getDescripcion();
        else if(column == 1) return prod.getColor();
        else if(column == 2) return prod.getTalle();
        else if(column == 3) return prod.getProveedor().getNombre();

        throw new IllegalStateException();
    }
    
}
