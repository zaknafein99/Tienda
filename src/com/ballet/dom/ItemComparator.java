/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.dom;

import java.util.Comparator;

/**
 *
 * @author isma
 */
public class ItemComparator implements Comparator<ItemStock> {

    @Override
    public int compare(ItemStock item1, ItemStock item2) {
        String itemAValue = item1.getDescripcion();
        String itemBValue = item2.getDescripcion();
        
        return itemAValue.compareTo(itemBValue);
    }
    
    
}
