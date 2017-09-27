package commandes;

import Interpretation.Interpreteur;

public class Gauche implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		
		
		try {
			int orientation = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			i.getCrayon().setOrientation(orientation);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande GAUCHE n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
		
	}

}
