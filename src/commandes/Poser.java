package commandes;

import interpretation.Interpreteur;

public class Poser implements Commandes{

	@Override
	public void execute(){
		i.getCrayon().setEcrit(true);
		
	}

}
