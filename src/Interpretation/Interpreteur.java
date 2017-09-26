package Interpretation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Test;

public class Interpreteur {

	Canvas c;
	GraphicsContext gc;
	Crayon crayon;
	
	final static String CODE = ""
			+ "\nEPAISSEUR 2"
			+ "\nLEVER"
			+ "\nAVANT 100"
			+ "\nPOSER"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nCOULEUR ROUGE"
			+"\nALLERA 56,90"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20";
	
	
	public Interpreteur(int xCanvas,int yCanvas){
		crayon = new Crayon(0, 1);
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
			gc.setStroke(crayon.getCouleur());
			gc.setLineWidth(crayon.getWidth());
			if(crayon.isEcrit()){
				gc.strokeLine(temp.getX(), temp.getY(), crayon.getX(), crayon.getY());
			}
		}
		if(test.equals("ALLERA")){
			double tempX = temp.getX();
			double tempY = temp.getY();
			gc.setFill(crayon.getCouleur());
			gc.setStroke(crayon.getCouleur());
			gc.setLineWidth(crayon.getWidth());
			crayon.setX(Integer.valueOf(commande.split(" ")[1].split(",")[0]));
			crayon.setY(Integer.valueOf(commande.split(" ")[1].split(",")[1]));
			if(crayon.isEcrit()){
				System.out.println(temp);
				System.out.println(crayon.getCoord());
				gc.strokeLine(tempX, tempY, crayon.getX(),crayon.getY());
				System.out.println("debug");
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
	
	public void clear(){
		this.c = new Canvas(c.getWidth(),c.getHeight());
		this.gc = c.getGraphicsContext2D();
	}

	
	
	
	public static void main(String[]args){
		Interpreteur i = new Interpreteur(200, 200);
		Test.start(i.getCanvas(Interpreteur.CODE));
	}
}
