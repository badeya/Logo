package commandes;


import arbre.Node;
import interpretation.Crayon;

/**
 * 
 * Lever du crayon
 *
 */
public class Lever implements Node{

	@Override
	public void accept(Crayon cr) {
		cr.visiterLever(this);
		
	}

	

}
