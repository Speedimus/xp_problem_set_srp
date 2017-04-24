package org.ownjoo.srp.domain;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class BillTest
{
	double expectedTax = 1.40;       //         1.40
	double expectedTip = 2.80;       //                2.80
	double expectedTotal = 18.20;    // 14.00 + 1.40 + 2.80
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
	}

	@Test
	public void shouldConstructDefault()
	{
		Bill actualBill = new Bill();
		assertNotNull(actualBill);
	}

	@Test
	public void shouldConstructWithListOfItems()
	{
		Bill actualBill = expectedBill;
		assertNotNull(actualBill);
	}

	@Test
	public void shouldSetAndGetTaxRate()
	{
		Bill actualBill = expectedBill;
		actualBill.setTaxRate(expectedTaxRate);
		assertEquals(expectedTaxRate, actualBill.getTaxRate());
	}

	@Test
	public void shouldSetAndGetTipRate()
	{
		Bill actualBill = expectedBill;
		actualBill.setTipRate(expectedTipRate);
		assertEquals(expectedTipRate, actualBill.getTipRate());
	}

	@Test
	public void shouldComputeTax()
	{
		Bill actualBill = expectedBill;
		assertEquals(expectedTax, actualBill.computeTax(expectedTaxRate).doubleValue(), 0);
	}

	@Test
	public void shouldComputeTip()
	{
		Bill actualBill = expectedBill;
		assertEquals(expectedTip, actualBill.computeTip(expectedTipRate).doubleValue(), 0);
	}

	@Test
	public void shouldComputeTotal()
	{
		Bill actualBill = expectedBill;
		assertEquals(expectedTotal, actualBill.computeTotal(expectedTaxRate, expectedTipRate).doubleValue(), 0);
	}

	@Test
	public void shouldGetItemsList()
	{
		assertTrue(expectedBill.getItems().size() > 0);
	}

}
