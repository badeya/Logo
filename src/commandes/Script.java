package commandes;

import java.util.ArrayList;

import arbre.Node;

public class Script implements Node{

	ArrayList<Node> l = new ArrayList<>();
	
	
	public Script(ArrayList<Node> l){
		this.l = l;
	}
	
	@Override
	public ArrayList<Node> getChildren() {
		return l;
	}

	
	
}
