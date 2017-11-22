package commandes;


import arbre.Node;
import interpretation.Crayon;
import javafx.scene.paint.Color;


public class Couleur implements Node{
	
	Color c;
	
	public Couleur(Color c){
		this.c = c;
	}
	
	public Color getColor(){
		return c;
	}
	

	@Override
	public void accept(Crayon cr) {
		cr.visiterCouleur(this);
		
	}


}




