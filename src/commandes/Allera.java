package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Allera implements Node {
	
	public int x;
	public int y;
	
	public Allera(String cmd) {
		try {
			this.x = Integer.valueOf(cmd.split(" ")[1].split(",")[0]);
			this.y = Integer.valueOf(cmd.split(" ")[1].split(",")[1]);
		} catch (Exception e) {
			Interpreteur.getInstance().setErreur(true);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterAllerA(this);
		
	}

}