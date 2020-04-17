package cartes;

import java.util.ArrayList;
import java.util.List;

import exception.ConstructeurException;

public class PaquetDeCartes
{
	public static final int NBR_ECHANGE = 1000;
	private List<Carte> paquet;

	public PaquetDeCartes()
	{
		paquet = new ArrayList<Carte>();
		SorteCartes[] sorte = SorteCartes.values();
		ValeurCartes[] valeur = ValeurCartes.values();
		for (int i = 0; i < sorte.length; i++)
		{
			for (int j = 0; j < valeur.length; j++)
			{
				paquet.add(new Carte(valeur[j], sorte[i]));
			}
		}
	}

	public PaquetDeCartes(List<Carte> pPaquet) throws ConstructeurException
	{
		if (pPaquet != null)
		{
			paquet = pPaquet;
		}
		else
		{
			throw new ConstructeurException();
		}
	}

	public void brasser()
	{
		for (int i = 0; i < NBR_ECHANGE; i++)
		{
			permuterCarte(randomInt(0, paquet.size() - 1),
					randomInt(0, paquet.size() - 1));
		}
	}

	private int randomInt(int min, int max)
	{
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	private void permuterCarte(int index1, int index2)
	{
		Carte temp = null;
		temp = paquet.get(index2);
		paquet.set(index2, paquet.get(index1));
		paquet.set(index1, temp);
	}

	public Carte consulterCarte(int pPosition)
	{
		Carte temp = null;
		if (validerPosition(pPosition) && !isEmpty())
		{
			temp = paquet.get(pPosition - 1);
		}
		else if (isEmpty() || !validerPosition(pPosition))
		{
			temp = null;
		}
		return temp;
	}

	public Carte prendreCarte(int pPosition)
	{
		Carte temp = null;
		if (validerPosition(pPosition) && !isEmpty())
		{
			temp = paquet.remove(pPosition - 1);
		}
		else if (isEmpty() || !validerPosition(pPosition))
		{
			temp = null;
		}
		return temp;
	}

	public void retournerToutesLesCartes(boolean visible)
	{
		if (visible == true)
		{
			for (int i = 0; i < paquet.size(); i++)
			{
				paquet.get(i).setVisible(true);
			}
		}
		else if (visible == false)
		{
			for (int i = 0; i < paquet.size(); i++)
			{
				paquet.get(i).setVisible(false);
			}
		}
	}

	public int size()
	{
		return paquet.size();
	}

	public boolean isEmpty()
	{
		return paquet.size() == 0;
	}

	private boolean validerPosition(int position)
	{
		return position >= 1 && position <= size();
	}

}
