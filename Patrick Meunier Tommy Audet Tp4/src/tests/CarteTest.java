package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cartes.Carte;
import cartes.SorteCartes;
import cartes.ValeurCartes;
import exception.ConstructeurException;
import org.junit.Test;

public class CarteTest
{

	private Carte carte1,carte2;
	
	@Before
	public void testCarte() 
	{
		carte1 = new Carte(ValeurCartes.V_5,SorteCartes.CARREAU);
		carte2 = new Carte(ValeurCartes.V_AS,SorteCartes.PIQUE);	
	}
	
	@Test
	public void testGetValeur()
	{
		assertEquals(carte1.getValeur(),ValeurCartes.V_5);
		assertEquals(carte2.getValeur(),ValeurCartes.V_AS);
	}

	@Test
	public void testGetValeurSymbole()
	{
		assertEquals(carte1.getValeurSymbole(),"5");
		Carte carte3 = new Carte(ValeurCartes.V_JACK,SorteCartes.CARREAU);
		assertEquals(carte3.getValeurSymbole(),"J");
	}

	@Test
	public void testGetSorte()
	{
		assertEquals(carte1.getSorte(),SorteCartes.CARREAU);
		assertEquals(carte2.getSorte(),SorteCartes.PIQUE);
	}

	@Test
	public void testGetSorteSymbole()
	{
		assertEquals(carte1.getSorteSymbole(),SorteCartes.CARREAU.getSymbole());
		assertEquals(carte2.getSorteSymbole(),SorteCartes.PIQUE.getSymbole());
	}

	@Test
	public void testEstVisible()
	{
		carte1.setVisible(true);
		assertTrue(carte1.estVisible());
		assertFalse(carte2.estVisible());
	}

	@Test
	public void testSetVisible()
	{
		carte1.setVisible(true);
		assertTrue(carte1.estVisible());
		carte1.setVisible(false);
		assertFalse(carte1.estVisible());
	}

	@Test
	public void testToStringCarte()
	{
		assertEquals(carte1.toStringCarte(),"☺");
		carte1.setVisible(true);
		assertEquals(carte1.toStringCarte(),"5 ♦");
	}

	@Test
	public void testEqualsObject()
	{
		Carte carte3 = new Carte(ValeurCartes.V_5,SorteCartes.CARREAU);
		assertFalse(carte3.equals(carte1));
		carte1.setVisible(true);
		assertFalse(carte3.equals(carte1));
		carte3.setVisible(true);
		assertTrue(carte3.equals(carte1));
		assertFalse(carte2.equals(carte1));
	}

	@Test
	public void testCompareTo()
	{
		assertTrue(carte1.compareTo(carte2) < 0);
		assertTrue(carte2.compareTo(carte1) > 0);
		Carte carte3 = new Carte(ValeurCartes.V_7,SorteCartes.COEUR);
		Carte carte4 = new Carte(ValeurCartes.V_7,SorteCartes.PIQUE);
		Carte carte5 = new Carte(ValeurCartes.V_5,SorteCartes.CARREAU);
		assertFalse(carte3.compareTo(carte4) == 0);
		assertTrue(carte1.compareTo(carte5) == 0);
		assertTrue(carte1.compareTo(carte4) < 0);
	}

	@Test
	public void testToString()
	{
		assertEquals(carte1.toString(),"5 ♦");
	}
	
}
