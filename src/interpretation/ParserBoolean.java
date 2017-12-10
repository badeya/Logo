package interpretation;

public class ParserBoolean {

	public static boolean parser(String expr){
		
		if(expr.equals("estlever")){
			return !Interpreteur.getInstance().getCrayon().ecrit();
		}else if(expr.equals("estposer")){
			return Interpreteur.getInstance().getCrayon().ecrit();
		}
		
		System.out.println("Erreur condition boolean");
		Interpreteur.getInstance().setErreur(true);
		return false;
	}
	
}
