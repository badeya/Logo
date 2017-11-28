package interpretation;

import java.util.Stack;

<<<<<<< HEAD
=======
import arbre.Node;
import commandes.Repeter;
import commandes.Script;
import commandes.Si;

>>>>>>> 439bc5c3b44e09108b55d38b4cf7bbdccbb6b23f
public class Parser {

	private Tokenizer lecteur;
	private String teteLect;
	
	private Stack<String> s = new Stack<String>();
	
	public Parser(Tokenizer lecteur){this.lecteur = lecteur;}
	
	public Node analyser(){
		this.teteLect = this.lecteur.nextLine();
		return Script();
	}
	
	private Script Script() {
		
		if(teteLect.equals("script")){
			this.Consommer("script");
			Script res = new Script(Commande());
			this.Consommer("fin");
			return res;
		}else{
			System.out.println("Paser methode analyser() l24 : TODO"+":"+this.teteLect);
			Interpreteur.getInstance().setErreur(true);
		}
		return null;
	}
	
	private ArrayList<Node> Commande(){
		ArrayList<Node> res = new ArrayList<Node>();
		if(isCommande(this.teteLect.split(" ")[0])){	
			res.add(CommandeFactory.getInstance().getCommande(this.teteLect));
			this.Consommer(this.teteLect);
			res.addAll(Commande());
		}else if(this.teteLect.equals("fin")){return res;}
		else if (this.teteLect.split(" ")[0].equals("repeter")) {
			String tmp = this.teteLect;
			this.Consommer(this.teteLect);
			res.add(new Repeter(tmp,Script()));
			res.addAll(Commande());
		}else if (this.teteLect.split(" ")[0].equals("si")) {
			String tmp = this.teteLect;
			this.Consommer(this.teteLect);
			this.Consommer("alors");
			Script tmp2 = Script();
			this.Consommer("sinon");
			res.add(new Si(tmp,tmp2,Script()));
			
			res.addAll(Commande());
		}else{
			System.out.println("Paser methode Commande() l45 : TODO : "+this.teteLect);
			Interpreteur.getInstance().setErreur(true);
			return null;
		}
		return res;
	}
	
	private void Consommer(String type) {
		if(this.teteLect.equals(type)){
			s.push(type);
			this.teteLect = this.lecteur.nextLine();
		}else{
			
			//System.out.println("Paser methode consommer() l56 : TODO :"+this.teteLect+":"+type);
			Interpreteur.getInstance().setErreur(true);
		}
	}
	
	private boolean isCommande(String s) {
		String[] commande = {"allera","avant","couleur","droite","epaisseur","lever","poser","gauche"};
		for (String cmd : commande) {
			if(s.equals(cmd)) return true;
		}
		return false;
	}
<<<<<<< HEAD

	public static void main(String[] args) {
		String prog = "SCRIPT\n"
				+ "AVANT 20 + 32r-yu\n"
				+ "AVANT 30\n"
				+ "repeter\n"
				+ "script\n"
				+ "avant 40\n"
				+ "fin\n"
				+ "avant 50\n"
				+ "avant 60\n"
				+ "si estlever\n"
				+ "alors\n"
				+ "script\n"
				+ "avant alors\n"
				+ "fin\n"
				+ "sinon\n"
				+ "script\n"
				+ "avant sinon\n"
				+ "fin\n"
				+ "fin";
		/*String prog = "Script\n"
				+"Avant 20\n"
				+"Script\n"
				+"Avant 20\n"
				+"fin\n"
				+"fin\n";*/
		Tokenizer t = new Tokenizer(prog);
		Parser p = new Parser(t);
		p.analyser();
		System.out.println(p.s);
	}
=======
>>>>>>> 439bc5c3b44e09108b55d38b4cf7bbdccbb6b23f
}
