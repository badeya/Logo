package interpretation;


/**
 * 
 * determine les coordonnes 
 *
 */

public class Coordonne {

	private double x;
	private double y;
	
	/**
	 * Constructeur de coordonnees
	 * 
	 * @param x
	 * @param y
	 */
	public Coordonne(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Mise à jour de la coordonnee x
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Mise à jour de la coordonnee y
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * toString des coordonees
	 */
	public String toString(){
		return "("+this.x+","+this.y+")";
	}

	
	
}
