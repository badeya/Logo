package commandes;

import interpretation.Interpreteur;

public class Lever implements Commandes{

	@Override
	public void updateCrayon(Interpreteur i) {
		i.getCrayon().setEcrit(false);
		
	}

}
