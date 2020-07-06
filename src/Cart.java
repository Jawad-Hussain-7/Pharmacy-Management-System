/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;


public class Cart {

    ArrayList<Medicine> cart=new ArrayList <Medicine> ();
    
    public void AddItem(Medicine med) {
        
        cart.add(med);
    }

    public void RemoveItem(int Index) {
        cart.remove(Index);
    }

    public int calculateBill() {
        int bill=0;
        for(Medicine m : cart)
        {
           m.calculatePrice();
           bill=bill+m.getPrice();
        }
        return bill;
    }
}
