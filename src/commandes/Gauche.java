package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;

public class Gauche implements Commandes,Node{

	@Override
	public void execute(){
		
		Interpreteur i = Interpreteur.getInstance();
		try {
			int orientation = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			i.getCrayon().setOrientation((int)i.getCrayon().getOrientation()-orientation);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande GAUCHE n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		return null;
	}

}
