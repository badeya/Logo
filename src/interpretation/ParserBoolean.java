package interpretation;

public class ParserBoolean {

	private static int expr1;
	private static int expr2;
	private static String operande;
	
	
	public static boolean parser(String expr){
		
		ParserArithmetique p = new ParserArithmetique();
		String[] expression = expr.split(" ");
		
		if(isPrimitive(expression[0])){expr1 = getPrimitive(expression[0]);}
		else{ expr1 = p.calc(expression[0]); }
		
		if(!isOperande(expression[1])){ Interpreteur.getInstance().setErreur(true);
			Interpreteur.getInstance().setMessageErreur("Erreur dans la condition : \""+expr+"\" \noperande \""+expression[1]+"\" inconnu");
			operande = "==";
		}else{
			operande = expression[1];
		}
		
		if(isPrimitive(expression[2])){expr2 = getPrimitive(expression[2]);}
		else{ expr2 = p.parser(expression[2]); }
				
		return evaluer();
	}
	
	private static boolean evaluer() {
		System.out.println(expr2+operande+expr1);
		switch(operande){
		case "<":
			return expr1<expr2;
		case ">":
			return expr1>expr2;
		case "<=":
			return expr1<=expr2;
		case ">=":
			return expr1>=expr2;
		case "==":
			return expr1==expr2;
		case "!=":
			return expr1!=expr2;
		}
		return false;
	}

	private static boolean isOperande(String string) {
		String[] operande = {"<",">",">=","<=","==","!="};
		for (int i = 0; i < operande.length; i++) {
			if(string.equals(operande[i])) return true;
		}
		return false;
	}

	private static int getPrimitive(String s) {
		if(s.equals("posx")){
			return (int) Interpreteur.getInstance().getCrayon().getPosX();
		}
		if(s.equals("posy")) return (int) Interpreteur.getInstance().getCrayon().getPosY();
		return 0;
	}

	private static boolean isPrimitive(String s){
		if(s.equals("posx")||s.equals("posy")) return true;
		return false;
	}
	
}
