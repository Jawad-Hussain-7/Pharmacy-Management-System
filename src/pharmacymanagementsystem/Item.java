/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.util.ArrayList;
import java.util.Iterator;


public class Item {
    ArrayList <Medicine> items;

    public Item(ArrayList <Medicine> medicine) {
        this.items = medicine;
    }

    public void setItems(ArrayList<Medicine> items) {
        this.items = items;
    }
    
    public ArrayList getItems() {
        return items;
    }
    
    public Medicine getItem(int index)
    {
        return items.get(index);
    }
    
    public void Dispaly() {
        for(Object m : items)
        {
            System.out.println(m.toString());
        }
    }
}
