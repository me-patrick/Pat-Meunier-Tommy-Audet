package cartes;

import java.util.ArrayList;
import java.util.Arrays;

import exception.PiocheException;
import structures.pile.Pile;

public class Pioche
{
	private Pile pioche;

	public Pioche(PaquetDeCartes paquet)
	{
		pioche = new Pile();
		while (!paquet.isEmpty())
		{
			pioche.empiler(paquet.prendreCarte(paquet.size()));
		}
	}

	public Carte piger()
	{
		return (Carte) pioche.depiler();
	}

	public String consulterDessus() throws PiocheException
	{
		String s = null;
		if (!pioche.isEmpty())
		{
			s = ((Carte) pioche.getPremier()).toStringCarte();
		}
		else
		{
			throw new PiocheException();
		}
		return s;
	}

	public boolean isEmpty()
	{
		return pioche.isEmpty();
	}

	public int size()
	{
		return pioche.size();
	}

}
