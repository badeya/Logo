package commandes;

import Interpretation.Interpreteur;

public class Lever implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		i.getCrayon().setEcrit(false);
		
	}

}
