package Interpretation;

import javafx.scene.paint.Color;

public class Crayon {

	private Coordonne coord = new Coordonne(0, 0);
	private Color couleur = Color.BLACK;
	private boolean ecrit = true;
	private int orientation = 0;
	private int width = 5;

	
	public Crayon(int x, int y) {
		coord = new Coordonne(x, y);
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
		
	
		
		
		double angle = 2.0 * Math.PI * ((double)this.orientation/360);
		
		double newx = Math.cos(angle) * distance + this.coord.getX();
		double newy =  Math.sin(angle) * distance + this.coord.getY();
		this.coord = new Coordonne(newx, newy);
		return this.coord;
		
		
		
		
		/*	if(this.orientation == 0){
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
		
		return this.coord;*/
	}
	

	public void updateCrayon(String cmd) {
		String temp = cmd.split(" ")[0];
		switch (temp) {
		case "DROITE":
			this.orientation += Integer.valueOf(cmd.split(" ")[1]);
			break;
		case "GAUCHE":
			this.orientation -= Integer.valueOf(cmd.split(" ")[1]);
			break;
		case "POSER":
			this.ecrit = true;
			break;
		case "LEVER":
			this.ecrit = false;
			break;
		case "COULEUR":
			this.couleur = updateCouleur(cmd.split(" ")[1]);
			break;
		case "EPAISSEUR":
			this.width = Integer.valueOf(cmd.split(" ")[1]);
			break;

		default:
			break;
		}
		
	}

	private Color updateCouleur(String s) {
		
		for (Couleur c : Couleur.values()) {
			System.out.println("for");
			if(c.getName().equals(s)){
				System.out.println("if");
				return c.getColor();
			}
		}
		return Color.BLACK;
		
	}
	
	
	
	
}
