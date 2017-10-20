package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;

public class Lever implements Commandes,Node{

	@Override
	public void execute(){
		Interpreteur i = Interpreteur.getInstance();
		i.getCrayon().setEcrit(false);
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		return null;
	}

}
