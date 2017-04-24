package org.ownjoo.srp.view;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.ownjoo.srp.domain.Bill;
import org.ownjoo.srp.domain.Item;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BillViewTest
{
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	Double expectedTax = 1.40;             //         1.40
	Double expectedTip = 2.80;             //                2.80
	Double expectedTotal = 18.20;          // 14.00 + 1.40 + 2.80
	Double expectedTaxRate = 0.10;
	Double expectedTipRate = 0.20;
	String expectedTaxLine = "tax:          " + n.format(expectedTax);
	String expectedTipLine = "tip:          " + n.format(expectedTip);
	String expectedTotalLine = "total:        " + n.format(expectedTotal);

	List<Item> expectedItems;
	Bill expectedBill;

	@Before
	public void setupEach()
	{
		expectedItems = new ArrayList<>();
		expectedItems.add(new Item("item0", 1.00, 1));
		expectedItems.add(new Item("item1", 2.00, 2));
		expectedItems.add(new Item("item2", 3.00, 3));
		expectedBill = new Bill(expectedItems);
		expectedBill.setTaxRate(expectedTaxRate);
		expectedBill.setTipRate(expectedTipRate);
	}

	@Test
	public void shouldViewFormattedReceipt()
	{
		BillView receipt = new BillView(expectedBill);
		assertTrue(receipt.getItemizedReceipt().contains(expectedTaxLine));
		assertTrue(receipt.getItemizedReceipt().contains(expectedTipLine));
		assertTrue(receipt.getItemizedReceipt().contains(expectedTotalLine));
	}
}
