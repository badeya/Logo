package commandes;


import arbre.Node;
import interpretation.Crayon;
import javafx.scene.paint.Color;


public class Couleur implements Node{
	
	Color c;
	
	/**
	 * Constructeur de la couleur
	 * 
	 * @param  c couleur du crayon
	 *
	 */
	
	public Couleur(Color c){
		this.c = c;
	}
	
	/**
    * 
    * @return Une instance de la couleur
    */
	
	public Color getColor(){
		return c;
	}
	
	
	@Override
	public void accept(Crayon cr) {
		cr.visiterCouleur(this);
		
	}


}




