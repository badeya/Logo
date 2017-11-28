package interpretation;

import java.util.ArrayList;

import arbre.Node;
import commandes.Allera;
import commandes.Avant;
import commandes.Couleur;
import commandes.Droite;
import commandes.Epaisseur;
import commandes.Gauche;
import commandes.Lever;
import commandes.Poser;
import commandes.Repeter;
import commandes.Script;
import javafx.scene.paint.Color;

public class Crayon implements VisiteurAST{

	private static Crayon instance = new Crayon(0, 1);
	public static  Crayon getInstance(){return Crayon.instance;}
	
	
	private Coordonne coord = new Coordonne(1, 1);
	private Color couleur = Color.BLACK;
	private boolean ecrit = true;
	private int orientation = 0;
	private int width = 5;
	
	private Crayon(int x,int y) {
		this.coord.setX(x);
		this.coord.setY(y);
	}
	
	public boolean ecrit(){
		return this.ecrit;
	}
	
	public void reset(){
		//Crayon.instance = new Crayon(1, 1);
		this.coord = new Coordonne(1,1);
		this.couleur  =Color.BLACK;
		this.ecrit = true;
		this.orientation = 0;
		this.width = 5;
	}
	
	@Override
	public void visiterCouleur(Couleur c) {
		this.couleur = c.getColor();
	}

	@Override
	public void visiterAllerA(Allera c) {
		Interpreteur.getInstance().getGc().setLineWidth(this.width);
		//if(ecrit) Interpreteur.getInstance().getGc().strokeLine(this.coord.getX(), this.coord.getY(), c.getX(), c.getY());
		this.coord = new Coordonne(c.getX(), c.getY());	
	}
	
	@Override
	public void visiterDroite(Droite c) {
		this.orientation += c.getOrientation();
		this.orientation = this.orientation%360;
	}
	
	@Override
	public void visiterEpaisseur(Epaisseur c) {
		this.width = c.getEpaisseur();
		
	}
	@Override
	public void visiterGauche(Gauche c) {
		this.orientation -= c.getOrientation();
		this.orientation = this.orientation%360;
		
	}
	@Override
	public void visiterLever(Lever c) {
		this.ecrit = false;
		
	}
	@Override
	public void visiterPoser(Poser c) {
		this.ecrit = true;
		
	}
	@Override
	public void visiterRepeter(Repeter n) {
		int nbrTour = n.getNbrDeTour();
		for(int i = 0; i < nbrTour;i++){
			this.visiterScript(n.getScript());
		}
	}
	
	@Override
	public void visiterScript(Script s) {
		ArrayList<Node> l = s.getList();
		for (Node n : l) {
			n.accept(this);
		}	
	}	
	
	@Override
	public void visiterAvant(Avant c) {
		Interpreteur i = Interpreteur.getInstance();
		double orientation = this.orientation;
		Coordonne coord = this.coord;
		
		
		double angle = 2.0 * Math.PI * (orientation/360);
		
		double newx = Math.cos(angle) * c.getDistance() + coord.getX();
		double newy =  Math.sin(angle) * c.getDistance() + coord.getY();
		
		
		if(this.ecrit){
			i.getGc().setLineWidth(this.width);
			i.getGc().setStroke(this.couleur);
			i.getGc().strokeLine(coord.getX(), coord.getY(), newx, newy);
		}
        Coordonne temp = check(newx,newy,i);
		this.coord = temp;
	}
	private Coordonne check(double newx, double newy,Interpreteur i){
        if (newx > i.getWidthCanvas()){ newx=i.getWidthCanvas();}
        if (newx < 0){ newx = 0;}
        if (newy > i.getHeighCanvas()){newy = i.getHeighCanvas();}
        if (newy < 0){newy = 0;}
        return new Coordonne(newx,newy);
    }
	

}
