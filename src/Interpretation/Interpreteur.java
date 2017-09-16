package Interpretation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Test;

public class Interpreteur {

	Canvas c;
	GraphicsContext gc;
	Crayon crayon;
	
	//final String code = "AVANCE 20\nLEVER\nAVANCE 20\nPOSER"; 
	
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
				
			}
		}
		
		return c;
	}
	
	
	private void move(String commande) {
		String test = commande.split(" ")[0];
		if(test.equals("AVANCER")){
			Coordonne temp = crayon.getCoord();
			crayon.getNewCoordForward(Integer.valueOf(commande.split(" ")[1]));
			gc.setFill(crayon.getCouleur());
			gc.setLineWidth(10);
			gc.strokeLine(temp.getX(), temp.getY(), crayon.getX(), crayon.getY());
		}
		
	}

	private boolean isMoveCommand(String string) {
		string = string.split(" ")[0];
		if(string.equals("AVANCER")){
			return true;
		}
		return false;
	}

	public void updateCanvas(String LigneCommande){
		
	}
	
	
	
	public static void main(String[]args){
		Interpreteur i = new Interpreteur(200, 200);
		Test.start(i.getCanvas("AVANCER 20"));
	}
}
