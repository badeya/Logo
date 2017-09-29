package commandes;

import erreur.ErreurCommandesAvant;
import interpretation.Coordonne;
import interpretation.Interpreteur;

public class Avant implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		
		try {
			
			double orientation = i.getCrayon().getOrientation();
			Coordonne coord = i.getCrayon().getCoord();
			
			int distance = Integer.valueOf(i.getCurrentLine().split(" ")[1]);
			
			double angle = 2.0 * Math.PI * (orientation/360);
			
			double newx = Math.cos(angle) * distance + coord.getX();
			double newy =  Math.sin(angle) * distance + coord.getY();
			
			if(i.getCrayon().isEcrit()){
				i.getGc().strokeLine(coord.getX(), coord.getY(), newx, newy);
			}
            Coordonne c = check(newx,newy);
			i.getCrayon().setX(c.getX());
			i.getCrayon().setY(c.getY());
			
		} catch (Exception e) {
			
		  new ErreurCommandesAvant().afficherErreur();
		  }
		
	}

	private Coordonne check(double newx, double newy){
        if (newx > 375){
            newx=375;
        }
        if (newx < 0){
            newx = 0;
        }
        if (newy > 375){
            newy = 375;
        }
        if (newy < 0){
            newy = 0;
        }
        return new Coordonne(newx,newy);
    }

}
