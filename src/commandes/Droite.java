package commandes;

import interpretation.Interpreteur;

public class Droite implements Commandes{

	@Override
	public void execute(){
		Interpreteur i = Interpreteur.getInstance();
		try {
			int orientation = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			i.getCrayon().setOrientation((int)i.getCrayon().getOrientation()+orientation);
		} catch(Exception e) {
			System.out.println("ERREUR : La commande DROITE n'accepte que des nombres en paramétre");
			// TODO: erreur 
		}
		
	}

}
