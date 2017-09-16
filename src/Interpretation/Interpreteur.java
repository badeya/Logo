package Interpretation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Test;

public class Interpreteur {

	Canvas c;
	GraphicsContext gc;
	Crayon crayon;
	
	final static String CODE = ""
			+ "AVANT 20\n"
			+ "LEVER\n"
			+ "AVANT 20\n"
			+ "POSER\n"
			+ "AVANT 20"; 
	
	public Interpreteur(int xCanvas,int yCanvas){
		crayon = new Crayon(0, 0);
		this.c = new Canvas(xCanvas,yCanvas);
		
		this.gc = c.getGraphicsContext2D();
	}
	
	public Canvas getCanvas(String programme){
		
		String[] code = programme.split("\n");
		
		
		
		for (int i = 0; i < code.length; i++) {
			if(isMoveCommand(code[i])){
				move(code[i]);
			}else{
				crayon.updateCrayon(code[i]);
			}
		}
		
		return c;
	}
	
	
	private void move(String commande) {
		String test = commande.split(" ")[0];
		Coordonne temp = crayon.getCoord();
		
		if(test.equals("AVANT")){
			
			crayon.getNewCoordForward(Integer.valueOf(commande.split(" ")[1]));
			gc.setFill(crayon.getCouleur());
			gc.setLineWidth(crayon.getWidth());
			if(crayon.isEcrit()){
				gc.strokeLine(temp.getX(), temp.getY(), crayon.getX(), crayon.getY());
			}
		}
		if(test.equals("ALLERA")){
			gc.setFill(crayon.getCouleur());
			gc.setLineWidth(crayon.getWidth());
			if(crayon.isEcrit()){
				gc.strokeLine(temp.getX(), temp.getY(), Integer.valueOf(commande.split(" ")[1].split(",")[0]), Integer.valueOf(commande.split(" ")[1].split(",")[1]));
			}
		}
		
	}

	private boolean isMoveCommand(String string) {
		string = string.split(" ")[0];
		if(string.equals("AVANT") || string.equals("ALLERA")){
			return true;
		}
		return false;
	}

	
	
	
	public static void main(String[]args){
		Interpreteur i = new Interpreteur(200, 200);
		Test.start(i.getCanvas(Interpreteur.CODE));
	}
}
