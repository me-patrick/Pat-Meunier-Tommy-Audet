package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import cartes.PaquetDeCartes;
import cartes.SorteCartes;
import cartes.ValeurCartes;
import exception.ConstructeurException;
import cartes.Carte;

public class PaquetDeCartesTest
{

	
	PaquetDeCartes paquet2;
	PaquetDeCartes paquet3;
	PaquetDeCartes paquetTest;
	
	@Test
	public void testPaquetDeCartes()
	{
		// pour le test on regarde le syso pour voir si le syso fait du sense
		System.out.println("test de constructeur sans paramètre");

		paquetTest = new PaquetDeCartes();
	
		
		
		for (int i = 1; i <= paquetTest.size(); i++)
		{
			System.out.println(paquetTest.consulterCarte(i));
		}
		System.out.println();
	}

	@Before
	public void testPaquetDeCartesListOfCarte()
	{

		
		Carte[] liste1 = {new Carte(ValeurCartes.V_10,SorteCartes.COEUR),new Carte(ValeurCartes.V_7,SorteCartes.PIQUE),new Carte(ValeurCartes.V_10,SorteCartes.PIQUE)};
		paquet2 = new PaquetDeCartes(new ArrayList<Carte>(Arrays.asList(liste1)));
		Carte[] liste2 = {new Carte(ValeurCartes.V_10,SorteCartes.COEUR),new Carte(ValeurCartes.V_7,SorteCartes.PIQUE)};
		paquet3 = new PaquetDeCartes(new ArrayList<Carte>(Arrays.asList(liste2)));
	}

	@Test
	public void testBrasser()
	{
		// pour le test on regarde le syso pour voir si le syso fait du sense
		System.out.println("test de Brasser, avant brassage : ");
		for (int i = 1; i <= paquet2.size(); i++)
		{
			System.out.println(paquet2.consulterCarte(i));
		}
		System.out.println("test après brassage : ");
		paquet2.brasser();
		for (int i = 1; i <= paquet2.size(); i++)
		{
			System.out.println(paquet2.consulterCarte(i));
		}
		System.out.println();	
	}

	@Test
	public void testConsulterCarte()
	{
		assertTrue(new Carte(ValeurCartes.V_10,SorteCartes.COEUR).compareTo(paquet2.consulterCarte(1)) == 0);
		assertFalse(new Carte(ValeurCartes.V_9,SorteCartes.COEUR).compareTo(paquet2.consulterCarte(1)) == 0);
		assertTrue(new Carte(ValeurCartes.V_9,SorteCartes.COEUR).compareTo(paquet2.consulterCarte(1)) < 0);
	}

	@Test
	public void testPrendreCarte()
	{
		assertTrue(paquet2.size() == 3);
		Carte carte3 = paquet2.prendreCarte(1);
		assertTrue(paquet2.size() == 2);
		assertTrue(new Carte(ValeurCartes.V_10,SorteCartes.COEUR).compareTo(carte3) == 0);
	}

	@Test
	public void testRetournerToutesLesCartes()
	{
		PaquetDeCartes paquetTest2 = new PaquetDeCartes();
		paquetTest2.retournerToutesLesCartes(true);
		for(int i = 1 ; i <= paquetTest2.size() ; i++)
		{
			assertTrue(paquetTest2.consulterCarte(i).estVisible());
		}
		paquetTest2.retournerToutesLesCartes(false);
		for(int i = 1 ; i <= paquetTest2.size() ; i++)
		{
			assertFalse(paquetTest2.consulterCarte(i).estVisible());
		}
	}

	@Test
	public void testSize()
	{
		assertEquals(paquet2.size(),3);
		assertEquals(paquet3.size(),2);
	}

	@Test
	public void testIsEmpty()
	{
		assertFalse(paquet2.isEmpty());
		PaquetDeCartes paquet4 = new PaquetDeCartes(Arrays.asList());
		assertTrue(paquet4.isEmpty());
	}

}
