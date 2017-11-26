package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Repeter implements Node{
	
	int nbrDeTour;
	Script s;
	
	// Le script contient les commande qui sont dans le for
	// nbrDeTour est le nombre de tour que la boulce effectu
	public Repeter(String commande,Script s){
		this.nbrDeTour = Integer.valueOf(commande.split(" ")[1]);
		this.s = s;
	}
	
	public int getNbrDeTour(){return this.nbrDeTour;}
	public Script getScript(){return this.s;}

	@Override
	public void accept(Crayon cr) {
		cr.visiterRepeter(this);
		
	}

	
	

}
