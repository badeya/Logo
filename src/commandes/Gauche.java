package commandes;


import arbre.Node;
import interpretation.Crayon;


public class Gauche implements Node{

	int orientation;
	
	/**
     * constructeur de Gauche
     * 
     * @param orientation
     */
	
	public Gauche(int orientation){
		this.orientation = orientation;
	}
	/**
     * Retourne l'oritentation.
     * 
     * @return Une instance de l'orientation.
     */
	public int getOrientation(){
		return orientation;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterGauche(this);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gauche other = (Gauche) obj;
		if (orientation != other.orientation)
			return false;
		return true;
	}
	
	

	 

}
