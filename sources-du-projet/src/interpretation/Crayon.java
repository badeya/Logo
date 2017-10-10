package interpretation;

import javafx.scene.paint.Color;

public class Crayon {

	private static final Crayon INSTANCE = new Crayon(0, 1);
	
	
	private Coordonne coord = new Coordonne(0, 0);
	private Color couleur = Color.BLACK;
	private boolean ecrit = true;
	private int orientation = 0;
	private int width = 5;

	
	public Crayon(int x, int y) {
		coord = new Coordonne(x, y);
	}
	
	public static Crayon getInstance(){
		return Crayon.INSTANCE;
	}
	
	public void setWidth(int x){
		this.width = x;
	}
	
	public int getWidth(){
		return width;
	}
	
	public Coordonne getCoord(){
		return coord;
	}
	
	public void setOrientation(int o){
		this.orientation = o;
	}
	
	public double getOrientation(){
		return this.orientation;
	}

	public double getX() {
		return coord.getX();
	}


	public void setX(double x) {
		coord.setX(x);
	}


	public double getY() {
		return coord.getY();
	}


	public void setY(double y) {
		coord.setY(y);
	}


	public Color getCouleur() {
		return couleur;
	}


	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}


	public boolean isEcrit() {
		return ecrit;
	}

	public void setEcrit(boolean ecrit) {
		this.ecrit = ecrit;
	}	
	
	
}
