package interpretation;

import java.util.ArrayList;
import java.util.Stack;

import arbre.Node;
import commandes.Repeter;
import commandes.Script;
import commandes.Si;

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
}
