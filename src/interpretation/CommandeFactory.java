package interpretation;

import commandes.Allera;
import commandes.Avant;
import commandes.Commandes;
import commandes.Couleur;
import commandes.Droite;
import commandes.Epaisseur;
import commandes.Gauche;
import commandes.Lever;
import commandes.Poser;

public class CommandeFactory {
	
	// singleton 
	private static final CommandeFactory INSTANCE = new CommandeFactory();
	public static CommandeFactory getInstance(){ return CommandeFactory.INSTANCE; }
	// Fin du singleton
	
	
	private String commande;
	
	public Commandes getCommande(String commande){
		this.commande = commande;
		return makeCommand();
	}

	public Commandes makeCommand(){

		switch(this.commande){
		case "DROITE":
			return new Droite(0);
		case "GAUCHE":
			return new Gauche(0);
		case "LEVER":
			return new Lever();
		case "POSER":
			return new Poser();
		case "EPAISSEUR":
			return new Epaisseur();
		case "COULEUR":
			return new Couleur(null);
		case "AVANT":
			return new Avant(0);
		case "ALLERA":
			return new Allera(0,0);
		default:
			return null;


		}
	}

}
