package org.ownjoo.srp.view;

import org.ownjoo.srp.domain.Bill;
import org.ownjoo.srp.domain.Item;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class BillView
{
    private Bill bill;

    public BillView(Bill bill)
    {
        this.bill = bill;
    }

    public void printItemizedReceipt()
    {
        System.out.println(getItemizedReceipt());
    }

    public String getItemizedReceipt() {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder output = new StringBuilder();
        String endl = "\n";
        String hRule = "--------------------" + endl;
        for (Item item : bill.getItems())
        {
            output.append(item.getName() +
                    "(" +
                    n.format(item.getQuantity()) +
                    ") " +
                    n.format(item.getPrice() * item.getQuantity()) +
                    endl);
        }
        output.append(hRule);
        output.append("tax:          " + n.format(bill.computeTax()) + endl);
        output.append(hRule);
        output.append("tip:          " + n.format(bill.computeTip()) + endl);
        output.append(hRule);
        output.append("total:        " + n.format(bill.computeTotal()) + endl);

        return output.toString();
    }
}
