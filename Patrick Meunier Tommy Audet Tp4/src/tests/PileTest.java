package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import structures.pile.*;
/**
 * test de classe Pile
 * @author Patrick Meunier
 *
 */
public class PileTest
{
	private Pile p;

	@Before
	/**
	 * test et création d'une pile pour faire des test
	 */
	public void testPile()
	{
		p = new Pile();
		assertTrue(p.isEmpty() == true);
	}

	@Test
	/**
	 * test de isEmpty()
	 */
	public void testIsEmpty()
	{
		assertTrue(p.isEmpty());
		p.empiler("yo");
		assertFalse(p.isEmpty());
	}

	@Test
	/**
	 * test de vider()
	 */
	public void testVider()
	{
		p.empiler("yo");
		p.empiler("");
		p.vider();
		assertTrue(p.toString() == "vide!");
	}

	@Test
	/**
	 * test de empiler()
	 */
	public void testEmpiler()
	{
		p.empiler("yo");
		assertEquals(p.toString(), "yo, ");
	}

	@Test
	/**
	 * test de getPremier()
	 */
	public void testGetPremier()
	{
		p.empiler("yo");
		p.empiler("yoo");
		assertEquals(p.getPremier(), "yoo");
		p.depiler();
		assertEquals(p.getPremier(), "yo");
	}

	@Test
	/**
	 * test de depiler()
	 */
	public void testDepiler()
	{
		p.empiler("yo");
		assertEquals(p.depiler(), "yo");
		assertTrue(p.isEmpty());
	}

	@Test
	/**
	 * test de size()
	 */
	public void testSize()
	{
		p.empiler("yo");
		p.empiler("yo");
		p.empiler("yo");
		p.empiler("yo");
		p.empiler("yo");
		p.empiler("yo");
		p.empiler("yo");
		assertEquals(p.size(), 7);
		p.depiler();
		assertEquals(p.size(), 6);
	}

	@Test
	/**
	 * test de toString() (Override)
	 */
	public void testToString()
	{
		p.empiler("je suis");
		p.empiler("un test de");
		p.empiler("de Stack");
		assertEquals(p.toString(), "de Stack, un test de, je suis, ");
	}
}
