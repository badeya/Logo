package interpretation;

import commandes.Script;
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
	private boolean erreur = false;

	public Interpreteur(int xCanvas,int yCanvas){
		new JFXPanel();
		crayon = Crayon.getInstance();
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}
	
	public boolean haveErreur(){return this.erreur;}
	
	public void setErreur(boolean erreur){this.erreur = erreur;}
	
	public GraphicsContext getGc() {return gc;}
	
	public double getHeighCanvas(){return this.c.getHeight();}
	
	public double getWidthCanvas(){return this.c.getWidth();}
	
	public Crayon getCrayon() {return crayon;}
	
	
	public Canvas getCanvas(String programme){
		this.crayon.reset();
		this.c = new Canvas(c.getWidth(), c.getHeight());
		this.gc = c.getGraphicsContext2D();
		Tokenizer t = new Tokenizer(programme);
		Parser p = new Parser(t);
		Script s = (Script)p.analyser();
		s.accept(this.crayon);
		System.out.println(c);
		return this.c;
	}
}
