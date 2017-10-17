package commandes;

import interpretation.Interpreteur;

public class Lever implements Commandes{

	@Override
	public void execute(){
		Interpreteur i = Interpreteur.getInstance();
		i.getCrayon().setEcrit(false);
		
	}

}
