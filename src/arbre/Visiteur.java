package arbre;

import sun.misc.Queue;

public class Visiteur {
	
	
	private Queue<Node> q = new Queue<Node>();
	
	
	public Visiteur(Node racine){
		for (Node n : racine.getChildren()) {
			q.enqueue(n);
		}
	}
	
	public void excuteTree(){
		System.out.println(q);
	}

	
	
	
}
