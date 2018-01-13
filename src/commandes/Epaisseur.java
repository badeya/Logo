package commandes;


import arbre.Node;
import interpretation.Crayon;

/**
 *  Epaisseur du crayon
 */
public class Epaisseur implements Node{
	
	int e;
	
	/**
	 * 
	 *  constructeur de l'Epaisseur
	 */
	
	public Epaisseur(int e) {
		this.e = e;
	}
	
	/**
     * Retourne l'epaisseur
     * 
     * @return Une instance de l'epaisseur.
     */
	public int getEpaisseur(){
		return e;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterEpaisseur(this);
	}



}
