package org.ownjoo.srp;

import org.junit.Before;
import org.junit.Test;
import org.ownjoo.srp.domain.Bill;
import org.ownjoo.srp.domain.Item;
import org.ownjoo.srp.view.BillView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppUAT
{
	Double expectedTaxRate = 0.10;
	Double expectedTipRate = 0.20;

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
		assertFalse(receipt.getItemizedReceipt().isEmpty());
	}
}
