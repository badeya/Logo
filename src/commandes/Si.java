package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Si implements Node {

	String cmd;
	boolean conditionVrai;
	Script alors;
	Script sinon;
	
	public Si(String cmd,Script alors,Script sinon){
		conditionVrai = evaluer(cmd);
		this.alors = alors;
		this.sinon = sinon;
	}
	
	@Override
	public void accept(Crayon cr) {
		alors.accept(cr);

	}
	
	private boolean evaluer(String s){
		if(s.split(" ")[1].equals("estlever")){
			return !Interpreteur.getInstance().getCrayon().ecrit();
		}else if(s.split(" ")[1].equals("estposer")){
			System.out.println(Interpreteur.getInstance().getCrayon().ecrit());
			return Interpreteur.getInstance().getCrayon().ecrit();
		}
		System.out.println("Erreu condition du if");
		Interpreteur.getInstance().setErreur(true);
		return false;
	}

}
