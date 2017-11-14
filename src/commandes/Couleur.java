package commandes;

import java.util.ArrayList;


import arbre.Node;
import interpretation.Interpreteur;
import javafx.scene.paint.Color;


public class Couleur implements Commandes,Node{
	
	Color c;
	
	public Couleur(Color c){
		this.c = c;
	}
	

	@Override
	public void execute(Integer... a) {
		Interpreteur.getInstance().getCrayon().setCouleur(c);
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		res.add(this);
		return res;
	}
}




