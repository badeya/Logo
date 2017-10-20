package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Interpreteur;


public class Couleur implements Commandes,Node{

	@Override
	public void execute() {
		Interpreteur i = Interpreteur.getInstance();
		boolean couleurTrouve = false;
		try {
			String couleur = i.getCurrentLine().split(" ")[1];
		
			for (CouleurEnum c : CouleurEnum.values()) {
				
				if(c.getName().equals(couleur)){
					System.out.println("ok");
					i.getCrayon().setCouleur(c.getColor());
					couleurTrouve = true;
					break;
				}
			}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}finally {
			// TODO : Erreur
			if(!couleurTrouve){
				System.out.println("ERREUR : La couleur rentré est incorrect");
			}
			
		}
	}

	@Override
	public ArrayList<Node> getChildren() {
		return null;
	}
}




