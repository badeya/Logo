package commandes;

import interpretation.Interpreteur;

public class Poser implements Commandes{

	@Override
	public void execute(){
		Interpreteur i = Interpreteur.getInstance();
		i.getCrayon().setEcrit(true);
		
	}

}
