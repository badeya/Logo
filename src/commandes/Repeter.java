package commandes;

import arbre.Node;
import interpretation.Crayon;

/**
 * 
 * Noeud repeter
 *
 */
public class Repeter implements Node{
	
	int nbrDeTour;
	Script s;
	
	/**
	 * 
	 *  @param nbTour est le nombre de tour que la boulce effectuer
	 *  @param s Le script contient les commande qui sont dans le for
	*/ 
	public Repeter(int nbrTour,Script s){
		this.nbrDeTour = nbrTour;
		this.s = s;
	}
	
	/**
     * Retourne le nombre de tours.
     * 
     * @return Une instance du nombre de tours.
     */
	public int getNbrDeTour(){return this.nbrDeTour;}
	
	/**
     * Retourne un script.
     * 
     * @return Une instance du script.
     */
	public Script getScript(){return this.s;}

	@Override
	public void accept(Crayon cr) {
		cr.visiterRepeter(this);
		
	}

	
	

}
