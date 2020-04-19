package structures.pile;

import java.io.Serializable;

import exception.PileException;
import structures.pile.NoeudPile;

public class Pile implements Serializable
{
	
	private static final long serialVersionUID = -460427442119944675L;
	/**
	 * Pointeur pour le sommet de la pile
	 */
	private NoeudPile sommet;
	/**
	 * Conserve le nombre d'éléments dans la pile
	 */
	private int taille;

	/**
	 * Construit une pile vide
	 */
	public Pile()
	{
		sommet = null;
		taille = 0;
	}

	/**
	 * Vérifie si la pile est vide
	 * @return boolean, vrai si elle est vide
	 */
	public boolean isEmpty()
	{
		return sommet == null;
	}

	/**
	 * Vide la pile
	 */
	public void vider()
	{
		sommet = null;
		taille = 0;
		System.gc();
	}

	/**
	 * Empile un objet dans la pile.
	 * @param pElement, - l'élément à empiler
	 */
	public void empiler(Object pElement)
	{
		sommet = new NoeudPile(pElement, this.sommet);
		taille++;
	}

	/**
	 * Retourne l'objet contenu dans le noeud sur le dessus de la pile sans le dépiler. Lève une exception si la pile est vide.
	 * @return Object, l'objet sur le dessus de la pile.
	 * @throws PileException
	 */
	public Object getPremier() throws PileException
	{
		Object retour = null;

		if (!isEmpty())
		{
			retour = sommet.getElement();
		}
		else
		{
			throw new PileException("La pile est vide");
		}

		return retour;
	}

	/**
	 * Retourne l'objet dépilé. Lève une exception si la pile est vide. Se sert de getPremier()
	 * @return Object, l'élément dépilé
	 * @throws PileException
	 */
	public Object depiler() throws PileException
	{
		Object retour = null;
		try
		{
			retour = getPremier();
			this.sommet = this.sommet.getPrecedent();
			taille--;
		}
		catch (PileException e)
		{
			throw new PileException("La pile est vide");
		}
		return retour;
	}

	/**
	 * Retourne le nombre d'éléments dans la pile
	 * @return int, le nombre d'éléments dans la pile
	 */
	public int size()
	{
		return taille;
	}

	@Override
	/**
	 * Permet de créer une chaîne représentant les éléments qui sont dans la pile.
	 */
	public String toString()
	{
		NoeudPile temp = sommet;
		String s = (isEmpty()) ? "vide!" : "";

		while (temp != null)
		{
			s = s + temp.getElement() + ", ";
			temp = temp.getPrecedent();
		}

		return s;
	}

}
