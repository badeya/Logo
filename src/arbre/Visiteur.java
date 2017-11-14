package arbre;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import commandes.*;

public class Visiteur {
	
	
	private Queue<Node> q = new ArrayDeque<Node>();
	
	
	public Visiteur(Script racine){
		q.addAll(racine.getChildren());
		
	}
	
	public void excuteTree(){
		
		while(q.peek()!=null){		
			System.out.println(q.poll());
			
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Node> l = new ArrayList<>();
		l.add(new Allera(10,10));
		l.add(new Gauche(90));
		l.add(new Avant(90));
		Script s = new Script(l);
		
		
		ArrayList<Node> list = new ArrayList<>();
		list.add(new Avant(20));
		list.add(new Repeter(2, s));
		
		Script scr = new Script(list);
		
		Visiteur v = new Visiteur(scr);
		
		try{v.excuteTree();}catch(Exception e){e.printStackTrace();}

		
	}
	
	
	
}
