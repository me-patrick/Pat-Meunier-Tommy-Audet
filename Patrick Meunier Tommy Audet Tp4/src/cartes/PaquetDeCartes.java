package cartes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.ConstructeurException;

/**
 * Classe permettant de représenter un paquet de cartes à jouer. Peut créer un paquet de cartes complet ou prendre un vecteur de carte comme paquet. Offre des services pour brasser le paquet, piger une carte dans le paquet, regarder une carte du paquet, retourner toutes les cartes du paquet.
 * @author Patrick Meunier
 *
 */
public class PaquetDeCartes implements Serializable
{
	/**
	 * Nombre d'échanges pour brasser un paquet de carte
	 */
	public static final int NBR_ECHANGE = 1000;
	/**
	 * Le paquet de cartes, une structure qui hérite de l'interface java "List"
	 */
	private List<Carte> paquet;

	private static final long serialVersionUID = -3742502342755309295L;
	/**
	 * Constructeur permettant de créer un paquet complet de cartes de 4 sortes X 13 cartes. Utilise les énumérations "SorteCartes" et "ValeurCartes".
	 */
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
	/**
	 * Constructeur avec paramètre permettant de faire des tests. On donne une liste de cartes organisée à notre goût.
	 * @param pPaquet - , un paquet de cartes. Ne peut-être "null"
	 * @throws ConstructeurException
	 */
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

	/**
	 * Brasse le paquet de cartes en provoquant un certain nombre d'échanges entre les cartes du paquet. Plus le nombre d'échanges est grand, mieux le paquet sera brassé. Utilise permuterCarte.
	 */
	public void brasser()
	{
		for (int i = 0; i < NBR_ECHANGE; i++)
		{
			permuterCarte(randomInt(0, paquet.size() - 1),
					randomInt(0, paquet.size() - 1));
		}
	}

	/**
	 * permet de donner un nombre entier aléatoire entre une valeur mininum ( min )  et maximum ( max ) 
	 * @param min - minimum
	 * @param max - maximum 
	 * @return un nombre entier aléatoire entre min et max
	 */
	private int randomInt(int min, int max)
	{
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	/**
	 * Permet de permuter 2 cartes dans le paquet selon leur position
	 * @param index1 - index d'une carte
	 * @param index2 - index d'une autre carte
	 */
	private void permuterCarte(int index1, int index2)
	{
		Carte temp = null;
		temp = paquet.get(index2);
		paquet.set(index2, paquet.get(index1));
		paquet.set(index1, temp);
	}
	/**
	 * Consulte, sans la retirer, une carte du paquet selon la position voulue. Ne modifie pas la visibilité de la carte consultée.
	 * @param pPosition  - , la position voulue entre 1 et le nombre de cartes dans le paquet.
	 * @return Carte, la carte choisie ou "null" si le paquet est vide ou si la position est invalide.
	 */
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
	
	/**
	 * Retire une carte du paquet selon la position voulue. Ne modifie pas la visibilité de la carte retirée.
	 * @param pPosition - , la position voulue entre 1 et le nombre de cartes dans le paquet.
	 * @return Carte, la carte enlevée ou "null" si le paquet est vide ou si la position est invalide.
	 */
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

	/**
	 * Rend toutes les cartes du paquet visibles ou invisibles (face cachée).
	 * @param visible, - vrai pour visible et faux pour face cachée
	 */
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

	/**
	 * Permet de savoir le nombre de cartes dans le paquet.
	 * @return int, le nombre de cartes.
	 */
	public int size()
	{
		return paquet.size();
	}

	/**
	 * Permet de savoir si le paquet de cartes est vide
	 * @return boolean, vrai si le paquet est vide
	 */
	public boolean isEmpty()
	{
		return paquet.size() == 0;
	}

	/**
	 * Valide si l'entier reçu en entrée est valide selon le nombre de cartes dans le paquet. Attention on parle ici de la position et non de l'index.
	 * @param position - , une position dans le paquet entre 1 et la taille du paquet
	 * @return boolean, vrai si l'entier est valide selon le nombre de cartes dans le paquet
	 */
	private boolean validerPosition(int position)
	{
		return position >= 1 && position <= size();
	}

}
