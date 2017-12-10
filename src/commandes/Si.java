package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.ParserBoolean;

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
		if(conditionVrai) alors.accept(cr);
		else sinon.accept(cr);
	}
	
	private boolean evaluer(String s){
		return ParserBoolean.parser(s);
		
		/*if(s.equals("estlever")){
			return !Interpreteur.getInstance().getCrayon().ecrit();
		}else if(s.equals("estposer")){
			return Interpreteur.getInstance().getCrayon().ecrit();
		}
		System.out.println("Erreur condition du if");
		Interpreteur.getInstance().setErreur(true);
		return false;*/
	}

}
