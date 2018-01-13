package main;

import interpretation.Interpreteur;

public class ControlleurMenu {
	
	/**
	 * mise à jours du canvas
	 * 
	 * @param s
	 */
	public void updateCanvas(String s){
		Interpreteur.getInstance().updateCanvas(s);
	}
	
}
