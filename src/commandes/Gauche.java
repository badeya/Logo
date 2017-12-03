package commandes;


import arbre.Node;
import interpretation.Crayon;


public class Gauche implements Node{

	int orientation;
	
	public Gauche(int orientation){
		this.orientation = orientation;
	}

	public int getOrientation(){
		return orientation;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterGauche(this);
		
	}

	 

}
