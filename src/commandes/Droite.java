package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Droite implements Node{
	
	int orientation;
	
	public Droite(String cmd){
		try {
			this.orientation = Integer.valueOf(cmd.split(" ")[1]);
		} catch (Exception e) {
			Interpreteur.getInstance().setErreur(true);
		}
	}
	
	public int getOrientation(){
		return orientation;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterDroite(this);
	}


}
