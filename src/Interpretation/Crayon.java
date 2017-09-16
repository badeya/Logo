package Interpretation;

import javafx.scene.paint.Color;

public class Crayon {

	private Coordonne coord;
	private Color couleur = Color.BLACK;
	private boolean ecrit = true;
	private int orientation;

	
	public Crayon(int x, int y) {
		coord = new Coordonne(x, y);
	}
	
	public Coordonne getCoord(){
		return coord;
	}
	
	public void setOrientation(int o){
		this.orientation = o;
	}
	
	public int getOrientation(){
		return this.orientation;
	}

	public int getX() {
		return coord.getX();
	}


	public void setX(int x) {
		coord.setX(x);
	}


	public int getY() {
		return coord.getY();
	}


	public void setY(int y) {
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


	public Coordonne getNewCoordForward(int distance) {
		
		if(this.orientation == 0){
			coord = new Coordonne(this.coord.getX()+distance, this.coord.getY());
			return coord;
		}
		if(this.orientation == 90){
			coord = new Coordonne(this.coord.getX(), this.coord.getY()+distance);
			return coord;
		}
		if(this.orientation == 180){
			coord = new Coordonne(this.coord.getX()-distance, this.coord.getY());
			return coord;
		}
		if(this.orientation == 270){
			coord = new Coordonne(this.coord.getX(), this.coord.getY()-distance);
			return coord;
		}
		
		return this.coord;
	}
	
	
	
	
}
