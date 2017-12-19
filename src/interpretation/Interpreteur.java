package interpretation;

import java.util.HashMap;

import commandes.Script;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Menu;


public class Interpreteur {
	
	// Singleton
	private static final Interpreteur INSTANCE = new Interpreteur(Menu.taille, Menu.taille);
	public static Interpreteur getInstance(){ return Interpreteur.INSTANCE; }
	// Fin du singleton
	
	
	private HashMap<String, Integer> variables = new HashMap<>();
	private Canvas c;
	private GraphicsContext gc;
	private Crayon crayon;
	private boolean erreur = false;
	private String messageErreur;

	public Interpreteur(int xCanvas,int yCanvas){
		new JFXPanel();
		crayon = Crayon.getInstance();
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}
	
	public HashMap<String, Integer> getVariables(){return this.variables;}
	
	public boolean haveErreur(){return this.erreur;}
	
	public void setErreur(boolean erreur){this.erreur = erreur;}
	
	public String getMessageErreur() {return this.messageErreur;}
	
	public void setMessageErreur(String message) {this.messageErreur = message;}
	
	public GraphicsContext getGc() {return gc;}
	
	public double getHeighCanvas(){return this.c.getHeight();}
	
	public double getWidthCanvas(){return this.c.getWidth();}
	
	public Crayon getCrayon() {return crayon;}
	
	private void reset(){
		this.crayon.reset();
		this.c = new Canvas(c.getWidth(), c.getHeight());
		this.gc = c.getGraphicsContext2D();
	}
	
	public Canvas getCanvas(String programme){
		reset();
		Tokenizer t = new Tokenizer(programme);
		Parser p = new Parser(t);
		Script s = (Script)p.analyser();
		
		if(!Interpreteur.getInstance().haveErreur()) s.accept(this.crayon);
		else reset();
		
		// SYSOUT DE DEBUG #########
		//System.out.println(this.));
		System.out.println(Interpreteur.getInstance().getVariables());
		// FIN SYSOUT DE DEBUG ######
		return this.c;
	}
}
