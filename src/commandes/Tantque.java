package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Tantque implements Node{

	String expression;
	Script s;
	
	public Tantque(String expression, Script s) {
		this.expression = expression;
		this.s  = s;
	}
	
	public String getExpression(){return this.expression;}
	public Script getScript(){return this.s;}
	
	@Override
	public void accept(Crayon cr) {cr.visiterTantque(this);}

}
