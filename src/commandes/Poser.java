package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;

public class Poser implements Commandes,Node{

	@Override
	public void execute(){
		Interpreteur i = Interpreteur.getInstance();
		i.getCrayon().setEcrit(true);
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		return null;
	}

}
