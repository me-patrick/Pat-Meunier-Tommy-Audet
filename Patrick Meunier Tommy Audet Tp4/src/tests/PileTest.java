package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import structures.pile.*;
public class PileTest
{
	private Pile p;
	
	@Before
	public void testPile()
	{
		p = new Pile();
		assertTrue(p.isEmpty() == true);
	}

	@Test
	public void testIsEmpty()
	{
		assertTrue(p.isEmpty());
		p.empiler("yo");
		assertFalse(p.isEmpty());
	}

	@Test
	public void testVider()
	{
		p.empiler("yo");
		p.empiler("");
		p.vider();
		assertTrue(p.toString() == "vide!");
	}

	@Test
	public void testEmpiler()
	{
		p.empiler("yo");
		assertEquals(p.toString(), "yo, ");
	}

	@Test
	public void testGetPremier()
	{
		p.empiler("yo");
		p.empiler("yoo");
		assertEquals(p.getPremier(),"yoo");
		p.depiler();
		assertEquals(p.getPremier(), "yo");
	}

	@Test
	public void testDepiler()
	{
		p.empiler("yo");
		assertEquals(p.depiler(),"yo");
		assertTrue(p.isEmpty());
	}

	@Test
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
	public void testToString()
	{
		p.empiler("je suis");
		p.empiler("un test de");
		p.empiler("de Stack");
		assertEquals(p.toString(), "de Stack, un test de, je suis, ");
	}	
}
