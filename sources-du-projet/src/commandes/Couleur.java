package commandes;

import interpretation.Interpreteur;


public class Couleur implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		boolean couleurTrouve = false;
		try {
			String couleur = i.getCurrentLine().split(" ")[1];
		
			for (CouleurEnum c : CouleurEnum.values()) {
				
				if(c.getName().equals(couleur)){
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
}




