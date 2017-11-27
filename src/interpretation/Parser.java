package interpretation;

import java.util.ArrayList;
import java.util.Stack;

import arbre.Node;
import commandes.Repeter;
import commandes.Script;

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
		}else{// TODO
			System.out.println("Paser methode analyser() l24 : TODO"+":"+this.teteLect);
		}
		return null;
	}
	
	private ArrayList<Node> Commande(){
		ArrayList<Node> res = new ArrayList<Node>();
		if(isCommande(this.teteLect.split(" ")[0])){	
			res.add(CommandeFactory.getInstance().getCommande(this.teteLect));
			System.out.println("@@@"+res);
			this.Consommer(this.teteLect);
			res.addAll(Commande());
		}else if(this.teteLect.equals("fin")){return res;}
		else if (this.teteLect.split(" ")[0].equals("repeter")) {
			String tmp = this.teteLect;
			this.Consommer(this.teteLect);
			res.add(new Repeter(tmp,Script()));
			res.addAll(Commande());
		}else if (this.teteLect.split(" ")[0].equals("si")) {
			this.Consommer(this.teteLect);
			this.Consommer("alors");
			res.add(Script());
			this.Consommer("sinon");
			res.add(Script());
			res.addAll(Commande());
		}else{// TODO	
			System.out.println("Paser methode Commande() l45 : TODO : "+this.teteLect);
			return null;
		}
		return res;
	}
	
	private void Consommer(String type) {
		if(this.teteLect.equals(type)){
			s.push(type);
			this.teteLect = this.lecteur.nextLine();
		}else{// TODO
			System.out.println("Paser methode consommer() l56 : TODO :"+this.teteLect+":"+type);
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
				+ "repeter 2\n"
				+ "script\n"
				+ "avant 40\n"
				+ "fin\n"
				+ "avant 50\n"
				+ "avant 60\n"
				+ "fin";
		Tokenizer t = new Tokenizer(prog);
		Parser p = new Parser(t);
		Script s = (Script)p.analyser();
		System.out.println(p.s);
		System.out.println("scriptList : "+s.getList().toString());
	}
}
