package interpretation;

public class ParserArithmetique {
	
	// Début singleton
	private static ParserArithmetique instance = new ParserArithmetique();
	public static ParserArithmetique getInstance(){return ParserArithmetique.instance;}
	// Fin singleton
	
	public int parser(String expression){
		return Integer.valueOf(expression);
	}
	
	
}
