package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Crayon;

public class Script implements Node{


	ArrayList<Node> l = new ArrayList<>();
	
	
	public Script(ArrayList<Node> l){
		this.l = l;
	}
	
	public ArrayList<Node> getList(){return this.l;}
	

	@Override
	public void accept(Crayon cr) {
		cr.visiterScript(this);	
	}
	

}
