package cartes;

import java.io.Serializable;
import exception.*;

/**
 * Classe permettant de représenter l'abstration d'une carte à jouer. Les objets de cette classe peuvent servir à produire un paquet de cartes.
 * @author Patrick Meunier 
 *
 */
public class Carte implements Comparable<Carte>, Serializable
{
	/**
	 * Image du dos de la carte
	 */
	public static final char IMAGE_DOS = 9786;
	
	private static final long serialVersionUID = 8196721120250324474L;
	/**
	 * La valeur de la carte. Un attribut de type "ValeurCartes" une énumération.
	 */
	private SorteCartes sorte;
	/**
	 * La sorte de la carte (Coeur, carreau, pique et trèfle). Un attribut de type "SorteCartes" une énumération.
	 */
	private ValeurCartes valeur;
	/**
	 * Un boolean pour savoir si une carte est face visible (vrai) ou pas (faux)
	 */
	private boolean visible = false;
	/**
	 * Constructeur avec paramètres.
	 * @param pValeur valeur = la valeur de la carte
	 * @param pSorte sorte - la sorte de la carte
	 * @throws ConstructeurException
	 */
	public Carte(ValeurCartes pValeur, SorteCartes pSorte)
			throws ConstructeurException
	{
		if (pValeur != null && pSorte != null)
		{
			setSorte(pSorte);
			setValeur(pValeur);
		}
		else
		{
			throw new ConstructeurException();
		}
	}
	/**
	 * Obtenir la valeur de la carte
	 * @return ValeurCartes un objet de l'énumération
	 */
	public ValeurCartes getValeur()
	{
		return valeur;
	}

	/**
	 * Mettre à jour la valeur de la carte
	 * @param pValeur valeur - la noouvelle valeur de la carte, null n'est pas accepté
	 */
	private void setValeur(ValeurCartes pValeur)
	{
		if (pValeur != null)
			this.valeur = pValeur;
	}

	/**
	 * Obtenir une string de la valeur de la carte
	 * @return String, la chaine représentant la valeur de la carte
	 */
	public String getValeurSymbole()
	{
		return valeur.getSymbole();
	}

	/**
	 * Obtenir la sorte de carte (Coeur, carreau, pique et trèfle)
	 * @return SorteCartes, un objet énumération qui représente la sorte de la carte
	 */
	public SorteCartes getSorte()
	{
		return sorte;
	}

	/**
	 * Mettre à jour la sorte de carte
	 * @param pSorte la nouvelle sorte de carte, null n'est pas accepté
	 */
	private void setSorte(SorteCartes pSorte)
	{
		if (pSorte != null)
			this.sorte = pSorte;
	}

	/**
	 * Obtenir la représentation caractère pour la sorte de carte.
	 * @return char, le caractère représentant la sorte de carte.
	 */
	public char getSorteSymbole()
	{
		return sorte.getSymbole();
	}

	/**
	 * Permet de savoir si une carte est visible (face vers le haut ou pas)
	 * @return boolean, vrai si la face est vers le haut
	 */
	public boolean estVisible()
	{
		return visible;
	}

	/**
	 * Permet de modifier la visibilité d'une carte (retourne la carte), soit on voit le dos avec "false" ou sa face visible avec "true"
	 * @param pVisible - , vrai si on veut que la carte soit visible, faux sinon.
	 */
	public void setVisible(boolean pVisible)
	{
		this.visible = pVisible;
	}

	/**
	 * Retourne l'image de la carte selon sa visibilité. Soit le dos de la carte ou sa face visible.
	 * @return String, l'image de la carte. Une concaténation du symbole de la valeur et du symbole de la sorte OU l'image du dos
	 */
	
	public String toStringCarte()
	{
		String s = "";
		if (visible == true)
		{
			s = getValeurSymbole() + " "
					+ Character.toString(getSorteSymbole());
		}
		else if (visible == false)
		{
			s = Character.toString(IMAGE_DOS);
		}
		return s;
	}

	@Override
	/**
	 * Permet de savoir si deux cartes sont égales en terme de valeur et de sorte. Attention pour pouvoir dire si deux cartes sont égales, il faut qu'elles soient les deux faces visibles, sinon on ne peut pas conclure qu'elles sont égales. Il ne faut pas modifier leur visibilité pour faire les comparaisons.
	 * @param obj - , l'objet à comparer avec l'objet courant "this"
	 * @return boolean, vrai si les deux cartes sont visibles et qu'elles ont la même valeur et la même sorte.
	 */
	public boolean equals(Object obj)
	{
		boolean egal = false;
		if (obj instanceof Carte)
		{
			egal = ((Carte) obj).estVisible() && this.estVisible()
					&& this.toString().equals(((Carte) obj).toString());
		}
		return egal;
	}

	@Override
	/**Compare 2 cartes selon leur valeur et leur sorte. Si la carte courante est < à celle reçue en entrée on retourne une valeur négative, si la carte courante est > à celle reçue en entrée on retourne une valeur positive, sinon on retourne 0.
	 *@param obj, - l'objet carte à comparer
	 *@return int, une valeur négative ou = à 0 ou positive selon que l'objet courant est plus < ou = ou > que l'objet reçu en entrée.
	 */
	public int compareTo(Carte obj)
	{
		int i = 0;
		if (this.getValeur().getValeur() == 1
				&& obj.getValeur().getValeur() != 1)
		{
			i = 1;
		}
		else if (this.getValeur().getValeur() != 1
				&& obj.getValeur().getValeur() == 1)
		{
			i = -1;
		}
		else if (this.getValeur().getValeur() > obj.getValeur().getValeur())
		{
			i = 1;
		}
		else if (this.getValeur().getValeur() < obj.getValeur().getValeur())
		{
			i = -1;
		}
		else
		{
			if (this.getSorteSymbole() == obj.getSorteSymbole())
			{
				i = 0;
			}
			else
			{
				i = Character.compare(this.getSorteSymbole(),
						obj.getSorteSymbole());
			}
		}
		return i;
	}

	@Override
	/**
	 * Obtenir une chaîne des infos au sujet d'une carte. Pour les tests
	 */
	public String toString()
	{
		return getValeurSymbole() + " " + Character.toString(getSorteSymbole());
	}
}
