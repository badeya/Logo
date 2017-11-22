package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Lever implements Node{

	@Override
	public void accept(Crayon cr) {
		cr.visiterLever(this);
		
	}

	

}
