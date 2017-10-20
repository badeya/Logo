package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;

public class Epaisseur implements Commandes,Node{

	@Override
	public void execute() {
		Interpreteur i = Interpreteur.getInstance();
		try {
			int width = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			i.getCrayon().setWidth(width);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande Epaisseur n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		return null;
	}

}
