package commandes;

import Interpretation.Interpreteur;

public class Poser implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		i.getCrayon().setEcrit(true);
		
	}

}
