package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;

public class Epaisseur implements Commandes,Node{

	@Override
	public void execute(Integer... a) {
		Interpreteur i = Interpreteur.getInstance();
		try {
			int width = a[0];
			i.getCrayon().setWidth(width);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande Epaisseur n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		res.add(this);
		return res;
	}

}
