package commandes;

import arbre.Node;
import interpretation.Coordonne;
import interpretation.Crayon;

/**
 * 
 * Classe implémentant les courbes de Bezier
 *
 */

public class Bezier  implements Node{

	Coordonne c1;
	Coordonne c2;
	
	/**
	 * Constructeur des courbes de bézier
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Bezier(int x1,int y1,int x2,int y2) {
		this.c1 = new Coordonne(x1, y1);
		this.c2 = new Coordonne(x2, y2);
	}
	
	/**
	 * 
	 * @return une instance de la coordonnée 1
	 */
	public Coordonne getC1(){
		return this.c1;
	}
	
	/**
	 * 
	 * @return une instance de la coordonnée 2
	 */
	public Coordonne getC2(){
		return this.c2;
	}
	
	@Override
	public void accept(Crayon cr) {
		cr.visiterBezier(this);
		
	}

}
