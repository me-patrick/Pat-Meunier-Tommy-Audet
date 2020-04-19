package structures.pile;

import java.io.Serializable;

/**
 * Classe d'implémentation d'un noeud auto-référencé d'une pile
 * @author Patrick Meunier
 *
 */
public class NoeudPile implements Serializable
{
	private static final long serialVersionUID = -100106444972236145L;
	/**
	 * Élément à conserver
	 */
	private Object element;
	/**
	 * Pointeur sur le noeud qui est en dessous
	 */
	private NoeudPile precedent;

	/**
	 * Constructeur d'un noeud auto-référencé d'une pile
	 * @param pElement, - élément à mettre dans le noeud
	 */
	public NoeudPile(Object pElement)
	{
		this(pElement, null);
	}

	/**
	 * Constructeur d'un noeud auto-référencé d'une pile
	 * @param pElement, - élément à mettre dans le noeud
	 * @param pPrecedent, - référence à l'élémenent précédant dans la pile
	 */
	public NoeudPile(Object pElement, NoeudPile pPrecedent)
	{
		setElement(pElement);
		setPrecedent(pPrecedent);
	}

	/**
	 * Obtenir l'élément contenu dans le noeud
	 * @return Object, l'objet dans le noeud
	 */
	public Object getElement()
	{
		return element;
	}

	/**
	 * Modifier la valeur de l'élément contenu dans le noeud
	 * @param pElement , - l'élément à mettre à jour
	 */
	public void setElement(Object pElement)
	{
		this.element = pElement;
	}

	/**
	 * Obtenir une référence sur le noeud précédent.
	 * @return NoeudPile, le pointeur sur le noeud précédent
	 */
	public NoeudPile getPrecedent()
	{
		return this.precedent;
	}

	/**
	 * Modifier la valeur de la référence du noeud précédent.
	 * @param pPrecedent, - le pointeur du nouveau précédent
	 */
	public void setPrecedent(NoeudPile pPrecedent)
	{
		this.precedent = pPrecedent;
	}

}
