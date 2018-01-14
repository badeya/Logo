package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Droite implements Node{
	
	int orientation;
	
	/**
     * constructeur de droite 
     * @param orientation
     */
	
	public Droite(int orientation){
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
		cr.visiterDroite(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Droite other = (Droite) obj;
		if (orientation != other.orientation)
			return false;
		return true;
	}


}
