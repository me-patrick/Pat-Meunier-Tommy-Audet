package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import structures.pile.*;

public class NoeudPileTest
{
	private NoeudPile noeudTest1, noeudTest2;
	
	@Before
	public void testNoeudPile()
	{
		noeudTest1 = new NoeudPile(new Integer(1));
		noeudTest2 = new NoeudPile(new Integer(2),noeudTest1);
		assertEquals(noeudTest1.getElement(),noeudTest2.getPrecedent().getElement());
		assertEquals(noeudTest2.getElement(), 2);
	}
	
	@Test
	public void testGetElement()
	{
		System.out.println(noeudTest1.getElement());
		assertEquals(noeudTest1.getElement(),1);
	}
	
	@Test
	public void testSetElement()
	{
		noeudTest1.setElement("yo");
		System.out.println(noeudTest1.getElement());
		assertEquals(noeudTest1.getElement(),"yo");
	}
	
	@Test
	public void testGetPrecedent()
	{
		assertEquals(noeudTest2.getPrecedent(),noeudTest1);
	}
	
	@Test
	public void testSetPrecedent()
	{
		NoeudPile noeudTest3 = new NoeudPile("yoo");
		noeudTest2.setPrecedent(noeudTest3);
		assertEquals(noeudTest2.getPrecedent().getElement(),"yoo");
	}
	
	
}
