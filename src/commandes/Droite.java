package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Droite implements Commandes,Node{
	
	int orientation;
	
	public Droite(int orientation){
		this.orientation = orientation;
	}

	@Override
	public void execute(Integer... a){
		Crayon c = Interpreteur.getInstance().getCrayon();
		orientation = a[0];
		c.setOrientation((int) (c.getOrientation()+orientation));
		
		
	}

	@Override
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		res.add(this);
		return res;
	}

}
