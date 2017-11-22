package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Poser implements Node{

	@Override
	public void accept(Crayon cr) {
		cr.visiterPoser(this);
		
	}

	
}
