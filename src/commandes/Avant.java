package commandes;

import Interpretation.Coordonne;
import Interpretation.Interpreteur;
import erreur.ErreurCommandesAvant;

public class Avant implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		
		try {
			
			double orientation = i.getCrayon().getOrientation();
			Coordonne coord = i.getCrayon().getCoord();
			
			int distance = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			
			double angle = 2.0 * Math.PI * ((double)orientation/360);
			
			double newx = Math.cos(angle) * distance + coord.getX();
			double newy =  Math.sin(angle) * distance + coord.getY();
			
			if(i.getCrayon().isEcrit()){
				i.getGc().strokeLine(coord.getX(), coord.getY(), newx, newy);
			}
		
			i.getCrayon().setX(newx);
			i.getCrayon().setY(newy);
			
		} catch (Exception e) {
			
		  new ErreurCommandesAvant().afficherErreur();
		  }
		
	}

}
