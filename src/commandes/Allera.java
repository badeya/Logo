package commandes;

import Interpretation.Coordonne;
import Interpretation.Crayon;
import Interpretation.Interpreteur;
import erreur.ErreurCommandesAllerA;
import main.Main;
import main.Test;

public class Allera implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		
		try {
			
			int newx = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[0]);
			int newy = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[1]);
			
			if(i.getCrayon().isEcrit()){
				i.getGc().strokeLine(i.getCrayon().getX(), i.getCrayon().getY(), newx, newy);
			}

            Coordonne c = check(newx,newy);
            i.getCrayon().setX(c.getX());
            i.getCrayon().setY(c.getY());
			
		} catch (Exception e) {
			new ErreurCommandesAllerA().afficherErreur();
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
