/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.dom;

import java.util.List;
import ca.odell.glazedlists.TextFilterator;
/**
 *
 * @author isma
 */
public class ItemTextFilterator implements TextFilterator<ItemStock> {

    @Override
    public void getFilterStrings(List<String> baseList, ItemStock item) {
        baseList.add(item.getDescripcion());
        baseList.add(item.getColor());
        baseList.add(item.getFechaCompra().toString());
        baseList.add(item.getProveedor().getNombre());
    }
    
    
    
}
