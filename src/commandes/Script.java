package commandes;

import java.util.ArrayList;

import arbre.Node;
import interpretation.Crayon;

public class Script implements Node{


	ArrayList<Node> l;
	
	/**
	 * constructeur du script
	 * 
	 * @param l une liste de noeud
	 */
	public Script(ArrayList<Node> l){this.l = l;}
	
	/**
	 * constructeur du script
	 */
	public Script(){l = new ArrayList<>();}
	
	/**
	 * ajoute un noeud
	 * 
	 * @param n
	 */
	public void add(Node n){this.l.add(n);}
	
	/**
	 * retourn une liste de noeud
	 * 
	 * @return une liste de noeud
	 */
	public ArrayList<Node> getList(){return this.l;}
	

	@Override
	public void accept(Crayon cr) {
		cr.visiterScript(this);	
	}
	

}
