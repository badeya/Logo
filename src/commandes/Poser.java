package commandes;

import arbre.Node;
import interpretation.Crayon;

/**
 * 
 * Poser du crayon
 *
 */

public class Poser implements Node{

	@Override
	public void accept(Crayon cr) {
		cr.visiterPoser(this);
		
	}
	

	
}
