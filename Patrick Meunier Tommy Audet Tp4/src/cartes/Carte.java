package cartes;

import java.io.Serializable;
import exception.*;

public class Carte implements Comparable<Carte>,Serializable
{
	public static final char IMAGE_DOS = 9786;
	private static final long serialVersionUID = 8196721120250324474L;
	private SorteCartes sorte;
	private ValeurCartes valeur;
	private boolean visible = false;
	
	public Carte(ValeurCartes pValeur, SorteCartes pSorte) throws ConstructeurException
	{
		if(pValeur != null && pSorte != null)
		{
			setSorte(pSorte);
			setValeur(pValeur);
		}
		else
		{
			throw new ConstructeurException();
		}
	}
	
	public ValeurCartes getValeur()
	{
		return valeur;
	}
	
	private void setValeur(ValeurCartes pValeur)
	{
		if(pValeur != null)
			this.valeur = pValeur;
	}
	
	public String getValeurSymbole()
	{
		return valeur.getSymbole();
	}
	
	public SorteCartes getSorte()
	{
		return sorte;
	}
	
	private void setSorte(SorteCartes pSorte)
	{
		if(pSorte != null)
		    this.sorte = pSorte;
	}
	
	public char getSorteSymbole()
	{
		return sorte.getSymbole();
	}
	
	public boolean estVisible()
	{
		return visible;
	}
	
	public void setVisible(boolean pVisible)
	{
		this.visible = pVisible;
	}
	
	public String toStringCarte()
	{
		String s = "";
		if(visible == true)
		{
			s = getValeurSymbole() + " " + Character.toString(getSorteSymbole());
		}
		else if(visible == false)
		{
			s = Character.toString(IMAGE_DOS);
		}
		return s;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean egal = false;
		if(obj instanceof Carte)
		{
			egal = ((Carte)obj).estVisible() && this.estVisible()
						&& this.toString().equals(((Carte)obj).toString());
		}
		return egal;
	}
	
	public int compareTo(Carte obj)
	{
		int i = 0;
		if(this.getValeur().getValeur() == 1 && obj.getValeur().getValeur() != 1)
		{
			i = 1;
		}
		else if(this.getValeur().getValeur() != 1 && obj.getValeur().getValeur() == 1)
		{
			i = -1;
		}
		else if(this.getValeur().getValeur() > obj.getValeur().getValeur())
		{
			i = 1;
		}
		else if(this.getValeur().getValeur() < obj.getValeur().getValeur())
		{
			i = -1;
		}
//		else if(this.getValeur().getValeur() == 1 && obj.getValeur().getValeur() != 1)
//		{
//			i = 1;
//		}
//		else if(this.getValeur().getValeur() != 1 && obj.getValeur().getValeur() == 1)
//		{
//			i = -1;
//		}
		else
		{
			if(this.getSorteSymbole() == obj.getSorteSymbole())
			{
				i = 0;
			}
			else
			{
				i = Character.compare(this.getSorteSymbole(), obj.getSorteSymbole());
			}	
		}
		return i;
	}
	
	@Override
	public String toString()
	{
		return getValeurSymbole() + " " + Character.toString(getSorteSymbole());
	}
}
