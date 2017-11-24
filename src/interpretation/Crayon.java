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

	private static final Crayon INSTANCE = new Crayon(0, 1);
	public static  Crayon getInstance(){return Crayon.INSTANCE;}
	
	
	private Coordonne coord = new Coordonne(1, 1);
	private Color couleur = Color.BLACK;
	private boolean ecrit = true;
	private int orientation = 0;
	private int width = 5;
	
	private Crayon(int x,int y) {
		this.coord.setX(x);
		this.coord.setY(y);
	}
	
	@Override
	public void visiterCouleur(Couleur c) {
		this.couleur = c.getColor();
		
	}

	@Override
	public void visiterAllerA(Allera c) {
		if(ecrit) Interpreteur.getInstance().getGc().strokeLine(this.coord.getX(), this.coord.getY(), c.getX(), c.getY());
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
		// TODO Auto-generated method stub
		
	}
	

}
