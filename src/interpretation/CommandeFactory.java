package interpretation;

import arbre.Node;
import commandes.*;

public class CommandeFactory {
	
	// singleton 
	private static final CommandeFactory INSTANCE = new CommandeFactory();
	public static CommandeFactory getInstance(){ return CommandeFactory.INSTANCE; }
	// Fin du singleton
	
	
	private String commande;
	
	public Node getCommande(String commande){
		if(doesNeedInt(commande.split(" ")[0].toUpperCase())){
			if(commande.split(" ").length != 2){
				System.out.println("Erreur  todo : CommandeFactory l20");
			}else{
				try{
					Integer.valueOf(commande.split(" ")[1]);
				}catch (Exception e) {
					
					System.out.println("Erreur  todo : CommandeFactory l25");
				}
			}
		}
		this.commande = commande;
		return makeCommand();
	}
	
	public boolean doesNeedInt(String s){
		switch(s){
		case "DROITE":
			return true;
		case "GAUCHE":
			return true;
		case "LEVER":
			return false;
		case "POSER":
			return false;
		case "EPAISSEUR":
			return false;
		case "COULEUR":
			return false;
		case "AVANT":
			return true;
		case "ALLERA":
			return true;
		default:
			return false;
		}
	}

	public Node makeCommand(){
		
		switch(this.commande.split(" ")[0].toUpperCase()){
		case "DROITE":
			return new Droite(Integer.valueOf(commande.split(" ")[1]));
		case "GAUCHE":
			return new Gauche(Integer.valueOf(commande.split(" ")[1]));
		case "LEVER":
			return new Lever();
		case "POSER":
			return new Poser();
		case "EPAISSEUR":
			return new Epaisseur(Integer.valueOf(commande.split(" ")[1]));
		case "COULEUR":
			return new Couleur(CouleurEnum.getColor(commande.split(" ")[1]));
		case "AVANT":
			return new Avant(Integer.valueOf(commande.split(" ")[1]));
		case "ALLERA":
			return new Allera(0,0);
		default:
			return null;


		}
	}

}
