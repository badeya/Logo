package commandes;


import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Epaisseur implements Node{
	
	int e;
	
	public Epaisseur(String cmd) {
		try {
			this.e = Integer.valueOf(cmd.split(" ")[1]);
		} catch (Exception e) {
			Interpreteur.getInstance().setErreur(true);
		}
	}
	
	public int getEpaisseur(){
		return e;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterEpaisseur(this);
	}



}
