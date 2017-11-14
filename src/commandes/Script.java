package commandes;

import java.util.ArrayList;

import arbre.Node;

public class Script implements Node{
	
	
	private ArrayList<Node> l = new ArrayList<>();
	
	public Script(ArrayList<Node> l){
		this.l = l;
	}

	
	public ArrayList<Node> getChildren() {
		return l;
	}
}
