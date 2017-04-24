package org.ownjoo.srp.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class Bill
{
    private List<Item> items;

    private Double taxRate = 0.00;
    private Double tipRate = 0.00;

    public Bill()
    {
        this.items = new ArrayList<>();
    }

    public Bill(List<Item> list)
    {
        this.items = list;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public BigDecimal computeTax(Double taxRate)
    {
        this.setTaxRate(taxRate);
        return computeTax();
    }

    public BigDecimal computeTax() {
        Double total = 0.0;
        for (Item item : items) {
            total = total + ( item.getPrice() * item.getQuantity() );
        }
        BigDecimal result = new BigDecimal(total * this.taxRate);
        return result.round(new MathContext(2));
    }
    public BigDecimal computeTip(Double tipRate)
    {
        this.setTipRate(tipRate);
        return computeTip();
    }

    public BigDecimal computeTip() {
        Double total = 0.0;

        for (Item item : items) {
            total = total + ( item.getPrice() * item.getQuantity() );
        }
        BigDecimal result = new BigDecimal(total * this.tipRate);
        return result.round(new MathContext(2));
    }

    public BigDecimal computeTotal(Double taxRate, Double tipRate)
    {
        setTaxRate(taxRate);
        setTipRate(tipRate);
        return this.computeTotal();
    }

    public BigDecimal computeTotal()
    {
        BigDecimal total = new BigDecimal(0.0);
        for (Item item : items) {
            total = total.add(new BigDecimal(item.getPrice() * item.getQuantity()));
        }
        return total.add(this.computeTax()).add(this.computeTip());
    }

    public void setTaxRate(Double rate)
    {
        this.taxRate = rate;
    }

    public void setTipRate(Double rate)
    {
        this.tipRate = rate;
    }

    public Double getTaxRate()
    {
        return taxRate;
    }

    public Double getTipRate()
    {
        return tipRate;
    }
}
