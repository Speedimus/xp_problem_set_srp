package org.ownjoo.srp;

import org.ownjoo.srp.domain.Item;
import org.ownjoo.srp.domain.Bill;
import org.ownjoo.srp.view.BillView;

import java.util.Arrays;
import java.util.List;

class App {

    public static void main(String[] args) {
        Item burger         =   new Item("Burger"           , 4.0, 2);
        Item macAndCheese   =   new Item("Mac and Cheese"   , 6.0, 1);
        Item sprite         =   new Item("Sprite"           , 1.0, 3);

        List<Item> foodItems = Arrays.asList(burger, macAndCheese, sprite);
        Bill bill = new Bill(foodItems);
        BillView view = new BillView(bill);
        view.printItemizedReceipt();
    }
}
