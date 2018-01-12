package interpretation;

import java.util.ArrayList;
import java.util.Collection;

import arbre.Node;
import commandes.*;

public class Parser {

	private Tokenizer lecteur;
	private String teteLect;
	private ParserArithmetique parserArithmetique;

	/**
	 * 
	 * @param lecteur
	 */
	public Parser(Tokenizer lecteur){
		this.lecteur = lecteur;
		this.parserArithmetique = ParserArithmetique.getInstance();
	}
	/**
	 * 
	 * @return
	 */
	public Tokenizer getLecteur() {return this.lecteur;}
	/**
	 * 
	 * @return
	 */
	public Node analyser(){
		this.teteLect = this.lecteur.nextLine();
		return Script();
	}
	/**
	 * 
	 * @return
	 */
	private Script Script() {
		
		if(this.teteLect.equals("script")){
			this.Consommer("script");
			Script res = new Script(Commande());
			this.Consommer("fin");
			return res;
		}else{
			System.out.println("Paser methode analyser() l24 : TODO"+":"+this.teteLect+"t");
			Interpreteur.getInstance().setErreur(true);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	private ArrayList<Node> Commande(){
		ArrayList<Node> res = new ArrayList<Node>();
		if(this.teteLect.equals("fin")){return res;}
		else if(this.teteLect.equals("script"))   { res.add(Script()); }
		else if(this.teteLect.equals("avant"))    { res.addAll(Avant()); }
		else if(this.teteLect.equals("droite"))   { res.addAll(Droite()); }
		else if(this.teteLect.equals("gauche"))   { res.addAll(Gauche()); }
		else if(this.teteLect.equals("epaisseur")){ res.addAll(Epaisseur()); }
		else if(this.teteLect.equals("lever"))    { res.addAll(Lever()); }
		else if(this.teteLect.equals("poser"))    { res.addAll(Poser()); }
		else if(this.teteLect.equals("repeter"))  { res.addAll(repeter());}
		else if(this.teteLect.equals("allera"))   { res.addAll(allera());}
		else if(this.teteLect.equals("couleur"))  { res.addAll(couleur());}
		else if(this.teteLect.equals("si"))       { res.addAll(si());}
		else if(this.teteLect.equals("tantque"))  { res.addAll(tantque());}
		//else if(this.teteLect.equals("var"))      { res.addAll(var()); }
		else if(this.teteLect.equals("soit"))     { res.addAll(soit()); }
		else if(this.teteLect.equals("bezier"))     { res.addAll(bezier()); }
		
		else{
			System.out.println("Paser methode Commande() l45 : TODO : "+this.teteLect);
			Interpreteur.getInstance().setErreur(true);
			return null;
		}
		return res;
	}

	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> bezier() {
		// TODO
		ArrayList<Node> res = new ArrayList<>();
		this.Consommer("bezier");
		int x1 = this.parserArithmetique.parser(this.teteLect);
		this.teteLect = this.lecteur.nextLine();
		int y1 = this.parserArithmetique.parser(this.teteLect);
		this.teteLect = this.lecteur.nextLine();
		Consommer(",");
		int x2 = this.parserArithmetique.parser(this.teteLect);
		this.teteLect = this.lecteur.nextLine();
		int y2 = this.parserArithmetique.parser(this.teteLect);
		this.teteLect = this.lecteur.nextLine();
		res.add(new Bezier(x1, y1, x2, y2));
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> tantque() {
		ArrayList<Node> res = new ArrayList<>();
		this.Consommer("tantque");
		String condition = this.teteLect;
		this.teteLect = this.lecteur.nextLine();
		res.add(new Tantque(condition, Script()));
		res.addAll(Commande());
		return res;
	}
	
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> si() {
		ArrayList<Node> res = new ArrayList<>();
		this.Consommer("si");
		String condition = this.teteLect;
		this.teteLect = this.lecteur.nextLine();
		this.Consommer("alors");
		Script scriptalors = Script();
		this.Consommer("sinon");
		res.add(new Si(condition,scriptalors,Script()));
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> couleur() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("couleur");
		res.add(new Couleur(CouleurEnum.getColor(this.teteLect)));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> allera() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("allera");
		int x = this.parserArithmetique.parser(this.teteLect);
		this.teteLect = this.lecteur.nextLine();
		int y = this.parserArithmetique.parser(this.teteLect);
		res.add(new Allera(x,y));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> Poser() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("poser");
		res.add(new Poser());
		res.addAll(Commande());
		return res;
	}
	
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> Lever() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("lever");
		res.add(new Lever());
		res.addAll(Commande());
		return res;
	}
		/**
		 * 
		 * @return
		 */
		private Collection<? extends Node> Epaisseur(){
		ArrayList<Node> res = new ArrayList<>();
		Consommer("epaisseur");
		res.add(new Epaisseur(this.parserArithmetique.parser(this.teteLect)));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> Droite(){
		ArrayList<Node> res = new ArrayList<>();
		Consommer("droite");
		res.add(new Droite(this.parserArithmetique.parser(this.teteLect)));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> Gauche(){
		ArrayList<Node> res = new ArrayList<>();
		Consommer("gauche");
		res.add(new Gauche(this.parserArithmetique.parser(this.teteLect)));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> Avant(){
		ArrayList<Node> res = new ArrayList<>();
		Consommer("avant");
		res.add(new Avant(this.parserArithmetique.parser(this.teteLect)));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	/**
	 * 
	 * @return
	 */
	private Collection<? extends Node> repeter() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("repeter");
		String tmp = teteLect;
		this.teteLect = this.lecteur.nextLine();
		res.add(new Repeter(this.parserArithmetique.parser(tmp),Script()));
		res.addAll(Commande());
		return res;
	}
	
	// Partie qui s'occupe des variables 

	/**
	 * 
	 * @return une variable
	 */
	private Collection<? extends Node> soit() {
		ArrayList<Node> res = new ArrayList<>();
		Consommer("soit");
		String nom = this.teteLect;
		this.teteLect = this.lecteur.nextLine();
		Consommer("=");
		Interpreteur.getInstance().getVariables().put(nom, ParserArithmetique.getInstance().parser(this.teteLect));
		this.teteLect = this.lecteur.nextLine();
		res.addAll(Commande());
		return res;
	}
	
	// Fin de partie qui s'occupe des variables

	/**
	 * 
	 * @param type
	 */
	private void Consommer(String type) {
		if(this.teteLect.equals(type)){
			this.teteLect = this.lecteur.nextLine();
		}else{
			//TODO
			System.out.println("Paser methode consommer() l217 : to do :"+this.teteLect+":"+type);
			Interpreteur.getInstance().setErreur(true);
		}
	}
		
}
