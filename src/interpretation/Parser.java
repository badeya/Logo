package interpretation;

import java.util.Stack;
import commandes.Script;

public class Parser {

	private Tokenizer lecteur;
	private String teteLect;
	
	private Stack<String> s = new Stack<String>();
	
	
	public Parser(Tokenizer lecteur){
		this.lecteur = lecteur;
	}
	
	public void analyser(){
		this.teteLect = this.lecteur.nextLine();
		Script();

	}
	
	private void Script() {
		if(teteLect.equals("script")){
			this.Consommer("script");
			this.Commande();
			this.Consommer("fin");
		}else{
			// TODO
			System.out.println("Paser methode analyser() l24 : TODO");
		}
	}
	
	private void Commande(){
		if(isCommande(this.teteLect.split(" ")[0])){
			this.Consommer(this.teteLect);
			Commande();
		}else if(this.teteLect.equals("fin")) return;
		else if (this.teteLect.equals("repeter")) {
			this.Consommer("repeter");
			Script();
			Commande();
		}else{
			// TODO
			System.out.println("Paser methode Commande() l45 : TODO : "+this.teteLect);
		}
	}
	
	private void Consommer(String type) {
		if(this.teteLect.equals(type)){
			s.push(type);
			this.teteLect = this.lecteur.nextLine();
		}else{
			System.out.println("Paser methode consommer() l56 : TODO :"+this.teteLect+":"+type);
			// TODO
		}
	}
	
	private boolean isCommande(String s) {
		String[] commande = {"allera","avant","couleur","droite","epaisseur","lever","poser"};
		for (String cmd : commande) {
			if(s.equals(cmd)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String prog = "SCRIPT\n"
				+ "AVANT 20\n"
				+ "AVANT 30\n"
				+ "repeter\n"
				+ "script\n"
				+ "avant 40\n"
				+ "fin\n"
				+ "avant 50\n"
				+ "avant 60\n"
				+ "fin";
		Tokenizer t = new Tokenizer(prog);
		Parser p = new Parser(t);
		p.analyser();
		System.out.println(p.s);
	}
}
