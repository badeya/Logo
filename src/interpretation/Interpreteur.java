package interpretation;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.StringTokenizer;

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
	private BufferedReader rd;
	private StringTokenizer code;

	public Interpreteur(int xCanvas,int yCanvas){
		new JFXPanel();
		crayon = Crayon.getInstance();
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}
	
	public GraphicsContext getGc() {
		return gc;
	}


	
	/*public void setParam(int height,int width){
		this.c = new Canvas(width, height);
		this.gc = c.getGraphicsContext2D();
	}
	
	public Canvas getCanvas(String programme){
		code = new StringTokenizer(programme);
		this.clear();
        while(code.hasMoreElements()){
            this.currentLine = code.nextToken("\n");
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
			StringTokenizer strr = new StringTokenizer(currentLine);
			String sttt = strr.nextToken();
			if(CommandeFactory.getInstance().doesNeedInt(sttt)){
				if(strr.countTokens() == 1){
					CommandeFactory.getInstance().getCommande(sttt).execute(Integer.parseInt(strr.nextToken()));
				}
				if(strr.countTokens() == 2){
					CommandeFactory.getInstance().getCommande(sttt).execute(Integer.parseInt(strr.nextToken()),Integer.parseInt(strr.nextToken()));
				}
			}else{
				CommandeFactory.getInstance().getCommande(sttt).execute();
			}
		}catch (Exception e) {
			e.printStackTrace();
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
	*/

}
