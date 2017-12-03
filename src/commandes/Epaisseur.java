package commandes;


import arbre.Node;
import interpretation.Crayon;

public class Epaisseur implements Node{
	
	int e;
	
	public Epaisseur(int e) {
		this.e = e;
	}
	
	public int getEpaisseur(){
		return e;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterEpaisseur(this);
	}



}
