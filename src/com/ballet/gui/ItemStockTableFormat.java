/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.gui;

import ca.odell.glazedlists.gui.TableFormat;
import com.ballet.dom.ItemStock;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 *
 * @author isma
 */
public class ItemStockTableFormat implements TableFormat<ItemStock>{
      @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        if(column == 0)      return "id";
        else if(column == 1) return "Descripción";
        else if(column == 2) return "Color";
        else if(column == 3) return "Talle";
        else if(column == 4) return "Proveedor";
        else if(column == 5) return "Compra";
        else if(column == 6) return "Fecha Compra";
        
        throw new IllegalStateException();
    }

    @Override
    public Object getColumnValue(ItemStock prod, int column) {
        if(column == 0)      return prod.getId();
        else if(column == 1) return prod.getDescripcion();
        else if(column == 2) return prod.getColor();
        else if(column == 3) return prod.getTalle();
        else if(column == 4) return prod.getProveedor().getNombre();
        else if(column == 5) return prod.getPrecioCompra();
        else if(column == 6){
//        String s = DateFormat.getDateInstance(DateFormat.MEDIUM).format(prod.getFechaCompra());
        Format formatter = new SimpleDateFormat("dd-MM-yy");
        String s = formatter.format(prod.getFechaCompra());
        return s;
}
        throw new IllegalStateException();
    }
}
