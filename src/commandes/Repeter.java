package commandes;
import java.util.ArrayList;

import arbre.Node;
import interpretation.VisiteurAST;

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
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new  ArrayList<>();
		for (int i = 0; i < nbrDeTour; i++) {
			res.addAll(s.getChildren());
		}
		return res;
	}
	
	public void accept (VisiteurAST v) {
		v.visitRepeter(this);
	}
	

}
