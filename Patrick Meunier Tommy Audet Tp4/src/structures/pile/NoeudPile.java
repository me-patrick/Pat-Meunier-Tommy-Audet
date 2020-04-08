package structures.pile;



public class NoeudPile
{
	private Object element;
	private NoeudPile precedent;
	
	public NoeudPile(Object pElement)
	{
		this(pElement,null);
	}
	
	public NoeudPile(Object pElement, NoeudPile pPrecedent)
	{
		setElement(pElement);
		setPrecedent(pPrecedent);
	}
	
	public Object getElement()
	{
		return element;
	}
	
	public void setElement(Object pElement)
	{
		this.element = pElement;
	}
	
	public NoeudPile getPrecedent()
	{
		return this.precedent;
	}
	
	public void setPrecedent(NoeudPile pPrecedent)
	{
		this.precedent = pPrecedent;
	}
	
	
}	

