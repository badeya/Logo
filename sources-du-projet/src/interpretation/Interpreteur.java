package interpretation;

import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Interpreteur {
	
	// Singleton
	private static final Interpreteur INSTANCE = new Interpreteur(300, 300);
	public static Interpreteur getInstance(){ return Interpreteur.INSTANCE; }
	// Fin du singleton
	
	private Canvas c;
	private GraphicsContext gc;
	private Crayon crayon;
	private String currentLine;

	public Interpreteur(int xCanvas,int yCanvas){
	    //ne pas retirer le jfx panel
		new JFXPanel();
		crayon = new Crayon(0, 1);
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}


	
	public void setParam(int height,int width){
		this.c = new Canvas(width, height);
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
		try{
			CommandeFactory.getInstance().getCommande(this.currentLine.split(" ")[0]).updateCrayon(this);
		}catch (Exception e) {
			System.out.println("[Message debug] Pas de commande donner en paramétre (Normal dans le cas d'un clear)");
		}
		
	}
	
	public double getHeighCanvas(){
		return this.c.getHeight();
	}
	public double getWidthCanvas(){
		return this.c.getWidth();
	}

	public void clear(){
		this.c = new Canvas(c.getWidth(),c.getHeight());
		this.gc = c.getGraphicsContext2D();
		this.crayon=new Crayon(0, 0);
	}
	
	public GraphicsContext getGc() {
		return gc;
	}

}
