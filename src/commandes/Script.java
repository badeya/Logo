package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Crayon;

public class Script implements Node{


	ArrayList<Node> l;
	
	
	public Script(ArrayList<Node> l){this.l = l;}
	public Script(){l = new ArrayList<>();}
	
	public void add(Node n){this.l.add(n);}
	
	public ArrayList<Node> getList(){return this.l;}
	

	@Override
	public void accept(Crayon cr) {
		cr.visiterScript(this);	
	}
	

}
