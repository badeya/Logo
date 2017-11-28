package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Repeter implements Node{
	
	int nbrDeTour;
	Script s;
	
	// Le script contient les commande qui sont dans le for
	// nbrDeTour est le nombre de tour que la boulce effectu
	public Repeter(String commande,Script s){
		try{
			this.nbrDeTour = Integer.valueOf(commande.split(" ")[1]);
		}catch (Exception e) {
			Interpreteur.getInstance().setErreur(true);
		}
		this.s = s;
	}
	
	public int getNbrDeTour(){return this.nbrDeTour;}
	public Script getScript(){return this.s;}

	@Override
	public void accept(Crayon cr) {
		cr.visiterRepeter(this);
		
	}

	
	

}
