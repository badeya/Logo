package interpretation;

import java.util.ArrayList;

import commandes.Avant;
import commandes.Droite;
import commandes.Lever;
import commandes.Poser;
import commandes.Repeter;
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
	//private String currentLine;
	//private BufferedReader rd;
	//private StringTokenizer code;

	public Interpreteur(int xCanvas,int yCanvas){
		new JFXPanel();
		crayon = Crayon.getInstance();
		this.c = new Canvas(xCanvas,yCanvas);
		this.gc = c.getGraphicsContext2D();
	}
	
	public GraphicsContext getGc() {return gc;}
	
	public double getHeighCanvas(){return this.c.getHeight();}
	
	public double getWidthCanvas(){return this.c.getWidth();}
	
	public Crayon getCrayon() {return crayon;}
	
	
	public Canvas getCanvas(String programme){
		/*Script p = new Script(new ArrayList<>());
		p.getList().add(new Avant(30));
		p.getList().add(new Droite(90));
		p.getList().add(new Avant(30));
		p.getList().add(new Lever());
		p.getList().add(new Avant(30));
		p.getList().add(new Poser());
		
		Repeter r = new Repeter(2, p);*/
		String prog = "SCRIPT\n"
				+ "AVANT 20\n"
				+ "AVANT 30\n"
				+ "script\n"
				+ "avant 40\n"
				+ "fin\n"
				+ "avant 50\n"
				+ "fin";
		Tokenizer t = new Tokenizer(prog);
		Parser p = new Parser(t);
		//Script s = p.analyser();
		//System.out.println(s);
		//s.accept(this.crayon);
		
		return this.c;
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
	


	public void clear(){
		this.c = new Canvas(c.getWidth(),c.getHeight());
		this.gc = c.getGraphicsContext2D();
		this.crayon=new Crayon(0, 0);
	}
	*/

}
