package commandes;

import interpretation.Interpreteur;

public class Epaisseur implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		try {
			int width = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			i.getCrayon().setWidth(width);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande Epaisseur n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
	}

}
