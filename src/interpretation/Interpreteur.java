package interpretation;

import commandes.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Interpreteur {

	private Canvas c;
	private GraphicsContext gc;
	private Crayon crayon;

	private String currentLine;



	/*final static String CODE = ""
			+ "\nAVANT 20"
			+ "\nAVANT 2000";*/


	/*private final static String CODE = ""
			+ "\nEPAISSEUR 2"
			+ "\nLEVER"
			+ "\nALLERA 75,75"
			+ "\nPOSER"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20"
			+ "\nDROITE 45"
			+ "\nAVANT 20";*/


	public Interpreteur(int xCanvas,int yCanvas){
	    //ne pas retirer le jfx panel
		new JFXPanel();
		crayon = new Crayon(0, 1);
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}

	public Canvas getCanvas(String programme){

		this.clear();
		String[] code = programme.split("\n");

        for (String aCode : code) {
            this.currentLine = aCode;
            execute();
        }

		return c;
	}


	public Crayon getCrayon() {
		return crayon;
	}

	public String getCurrentLine() {
		return currentLine;
	}

	private void execute() {

		switch(this.currentLine.split(" ")[0]){
		case "DROITE":
			new Droite().updateCrayon(this);
			break;
		case "GAUCHE":
			new Gauche().updateCrayon(this);
			break;
		case "LEVER":
			new Lever().updateCrayon(this);
			break;
		case "POSER":
			new Poser().updateCrayon(this);
			break;
		case "EPAISSEUR":
			new Epaisseur().updateCrayon(this);
			break;
		case "COULEUR":
			new Couleur().updateCrayon(this);
			break;
		case "AVANT":
			new Avant().updateCrayon(this);
			break;
		case "ALLERA":
			new Allera().updateCrayon(this);
			break;
		default:
			break;


		}

	}
	
	public double getHeighCanvas(){
		return this.c.getHeight();
	}
	public double getWidthCanvas(){
		return this.c.getWidth();
	}

	/*private void move(String commande) {
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
				gc.strokeLine(tempX, tempY, crayon.getX(),crayon.getY());
			}
		}

	}*/

	/*private boolean isMoveCommand(String string) {
		string = string.split(" ")[0];
		if(string.equals("AVANT") || string.equals("ALLERA")){
			return true;
		}
		return false;
	}*/

	public void clear(){
		this.c = new Canvas(c.getWidth(),c.getHeight());
		this.gc = c.getGraphicsContext2D();
		this.crayon=new Crayon(0, 0);
	}






	public GraphicsContext getGc() {
		return gc;
	}

}
