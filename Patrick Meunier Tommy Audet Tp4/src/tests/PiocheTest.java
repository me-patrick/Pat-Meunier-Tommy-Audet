package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import structures.pile.*;
import cartes.Carte;
import cartes.PaquetDeCartes;
import cartes.Pioche;
import cartes.SorteCartes;
import cartes.ValeurCartes;

public class PiocheTest
{
	PaquetDeCartes paquet2;
	Pioche pioche1;

	@Before
	public void testPioche()
	{
		Carte[] liste1 =
		{ new Carte(ValeurCartes.V_10, SorteCartes.COEUR),
				new Carte(ValeurCartes.V_7, SorteCartes.PIQUE),
				new Carte(ValeurCartes.V_10, SorteCartes.PIQUE) };
		paquet2 = new PaquetDeCartes(
				new ArrayList<Carte>(Arrays.asList(liste1)));
		pioche1 = new Pioche(paquet2);
	}

	@Test
	public void testPioche1()
	{
		String s = "";
		while (!pioche1.isEmpty())
			s += pioche1.piger().toString();
		assertEquals(s, "10 ♥7 ♠10 ♠");
	}

	@Test
	public void testPiger()
	{
		assertEquals(3, pioche1.size());
		assertTrue(new Carte(ValeurCartes.V_10, SorteCartes.COEUR)
				.toStringCarte().equals(pioche1.piger().toStringCarte()));
		assertEquals(2, pioche1.size());
	}

	@Test
	public void testConsulterDessus()
	{
		assertEquals(3, pioche1.size());
		assertTrue(new Carte(ValeurCartes.V_10, SorteCartes.COEUR)
				.toStringCarte().equals(pioche1.consulterDessus()));
		assertEquals(3, pioche1.size());
	}

	@Test
	public void testIsEmpty()
	{
		assertFalse(pioche1.isEmpty());
		while (!pioche1.isEmpty())
		{
			assertFalse(pioche1.isEmpty());
			pioche1.piger();
		}
		assertTrue(pioche1.isEmpty());
	}

	@Test
	public void testSize()
	{
		assertEquals(3, pioche1.size());
	}

}
