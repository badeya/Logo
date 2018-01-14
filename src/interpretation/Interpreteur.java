package interpretation;

import java.util.HashMap;
import java.util.Observable;

import commandes.Script;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.Menu;


public class Interpreteur extends Observable{
	
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
	
	
	/**
	 * Constructeur de l'interpreteur
	 * 
	 * @param xCanvas position x du canvas
	 * @param yCanvas position y du canvas
	 */
	public Interpreteur(int xCanvas,int yCanvas){
		new JFXPanel();
		crayon = Crayon.getInstance();
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}
	
	/**
	 * 
	 * @return une variable
	 */
	
	public HashMap<String, Integer> getVariables(){return this.variables;}
	
	/**
	 * 
	 * @return une erreur
	 */
	public boolean haveErreur(){return this.erreur;}
	
	/**
	 * 
	 * @param erreur
	 */
	public void setErreur(boolean erreur){this.erreur = erreur;}
	
	/**
	 * 
	 * @return une erreur sous la forme d'une chaine de caractère
	 */
	public String getMessageErreur() {return this.messageErreur;}
	
	/**
	 * mise à jour du message d'erreur
	 * 
	 * @param message
	 */
	public void setMessageErreur(String message) {this.messageErreur = message;}
	/**
	 * 
	 * @return un contecte graphipe
	 */
	public GraphicsContext getGc() {return gc;}
	
	/**
	 * 
	 * @return le hauteur du canvas
	 */
	public double getHeighCanvas(){return this.c.getHeight();}
	
	/**
	 * 
	 * @return la largeur du canvas 
	 */
	public double getWidthCanvas(){return this.c.getWidth();}
	
	/**
	 * 
	 * @return une instance du crayon
	 */
	public Crayon getCrayon() {return crayon;}
	
	/**
	 * permet de réinitialiser le crayon
	 */
	private void reset(){
		this.crayon.reset();
		this.c = new Canvas(c.getWidth(), c.getHeight());
		this.gc = c.getGraphicsContext2D();
	}
	
	/**
	 * Permet de retourner un canvas à partir d'un programme
	 * 
	 * @param programme
	 * @return
	 */
	public void updateCanvas(String programme) {
		System.out.println("interpreteur 1");
		reset();
		Tokenizer t = new Tokenizer(programme);
		Parser p = new Parser(t);
		Script s = (Script)p.analyser();
		
		if(!Interpreteur.getInstance().haveErreur()) s.accept(this.crayon);
		else reset();
		System.out.println("interpreteur 2");
		//this.notifyObservers();
		System.out.println(this.countObservers());
		this.setChanged();
		this.notifyObservers("update canvas");
		
		
	}
	
	/**
	 * 
	 * @return un canvas
	 */
	
	public Canvas getCanvas(){ return this.c;}
	
	
}
