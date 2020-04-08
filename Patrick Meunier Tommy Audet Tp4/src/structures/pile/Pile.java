package structures.pile;
import exception.PileException;
import structures.pile.NoeudPile;

public class Pile
{
	private NoeudPile sommet;
	private int taille;
	
	public Pile()
	{
		sommet = null;
		taille = 0;
	}
	
	public boolean isEmpty()
	{
		return sommet == null;
	}
	
	public void vider()
	{
		sommet = null;
		taille = 0;
		System.gc();
	}
	
	public void empiler(Object pElement)
	{
		sommet = new NoeudPile(pElement, this.sommet);
		taille++;	
	}
	
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
	
	public Object depiler() throws PileException
	{
		Object retour = null;
		try
		{
		retour = getPremier();
		this.sommet = this.sommet.getPrecedent();
		taille--;
		}
		catch(PileException e)
		{
			throw new PileException("La pile est vide");
		}
		return retour;
	}
	
	public int size()
	{
		return taille;
	}
	
	@Override
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
