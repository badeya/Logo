package commandes;

import Interpretation.Interpreteur;
import erreur.ErreurCommandesAllerA;

public class Allera implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		
		try {
			
			int newx = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[0]);
			int newy = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[1]);
			
			i.getGc().strokeLine(i.getCrayon().getX(), i.getCrayon().getY(), newx, newy);
			i.getCrayon().setX(newx);
			i.getCrayon().setY(newy);
			
		} catch (Exception e) {
			ErreurCommandesAllerA.errSyntaxe();
		}
		
	}

}
