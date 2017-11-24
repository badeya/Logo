package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Repeter implements Node{
	
	int nbrDeTour;
	Script s;
	
	// Le script contient les commande qui sont dans le for
	// nbrDeTour est le nombre de tour que la boulce effectu
	public Repeter(int nbrDeTour,Script s){
		this.nbrDeTour = nbrDeTour;
		this.s = s;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterRepeter(this);
		
	}

	
	

}
