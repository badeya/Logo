package interpretation;

import java.util.Stack;

public class Parser {

	private Tokenizer lecteur;
	private String teteLect;
	
	private Stack<String> s = new Stack<String>();
	
	
	public Parser(Tokenizer lecteur){
		this.lecteur = lecteur;
	}
	
	public void analyser(){
		
		this.teteLect = lecteur.nextLine();
		this.Script();
	}
	
	private void Script(){
		if(teteLect.equals("eof")) return;
		if(teteLect.equals("script")){
			Consommer("script");
			Commande();
		}else if (teteLect.equals("fin")) {
			Consommer("fin");
			Commande();
		}else{
			System.out.println("Paser méthode Script() l32 : TODO");
			// TODO new EXCEPTION
		}
	}

	private void Consommer(String type) {
		if(this.teteLect.equals(type)){
			s.push(type);
			this.teteLect = this.lecteur.nextLine();
		}else{
			System.out.println("Paser methode consommer() l38 : TODO");
			// TODO
		}
	}

	private void Commande() {
		if(this.teteLect.split(" ")[0].equals("repeter")){
			Repeter();
		}else if(isCommande(this.teteLect.split(" ")[0])){
			Consommer(this.teteLect);
			Commande();
		}else if (this.teteLect.equals("fin")||this.teteLect.equals("script")) {
			Script();
		}else if(this.teteLect.equals("eof") && s.peek().equals("fin")){
			return;
		}
		else{
			System.out.println("Paser methode Commande() l61 : TODO :"+this.teteLect);
			// TODO
		}
		
	}

	private void Repeter() {
		this.teteLect = this.lecteur.nextLine();
		if(this.teteLect.equals("fin")){
			Consommer("fin");
		}else if(this.teteLect.equals("script")){
			Consommer("script");
			Repeter();
		}else if(isCommande(this.teteLect.split(" ")[0])){
			Consommer(this.teteLect);
			Repeter();	
		}else{
			System.out.println("Paser methode Repeter() l78 : TODO");
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
				+ "script"
				+ "avant 40\n"
				+ "fin\n"
				+ "avant 50\n"
				+ "fin";
		Tokenizer t = new Tokenizer(prog);
		Parser p = new Parser(t);
		p.analyser();
		System.out.println(p.s);
	}
	
}
