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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Epaisseur other = (Epaisseur) obj;
		if (e != other.e)
			return false;
		return true;
	}

}
