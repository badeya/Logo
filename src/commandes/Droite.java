package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Droite implements Node{
	
	int orientation;
	
	public Droite(int orientation){
		this.orientation = orientation;
	}
	
	public int getOrientation(){
		return orientation;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterDroite(this);
	}


}
