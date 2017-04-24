package org.ownjoo.srp.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest
{
	String expectedName;
	Double expectedPrice;
	int expectedQuantity;

	@Before
	public void setupEach()
	{
		expectedName = "name";
		expectedPrice = 1.11;
		expectedQuantity = 0;
	}

	@Test
	public void shouldDefaultConstruct()
	{
		assertNotNull(new Item());
	}

	@Test
	public void shouldConstructWithArgs()
	{
		assertNotNull(new Item(expectedName,expectedPrice,expectedQuantity));
	}

	@Test
	public void shouldReturnCorrectValues()
	{
		Item actual = new Item(expectedName, expectedPrice, expectedQuantity);
		assertEquals(expectedName,actual.getName());
		assertEquals(expectedPrice, actual.getPrice());
		assertEquals(expectedQuantity, actual.getQuantity());
	}
}
