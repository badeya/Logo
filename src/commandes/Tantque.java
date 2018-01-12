package commandes;

import arbre.Node;
import interpretation.Crayon;

/**
 * 
 * Noeud Tantque
 *
 */

public class Tantque implements Node{

	String expression;
	Script s;
	
	/**
	 * Constructeur du noeud Tantque
	 * 
	 * @param expression
	 * @param s
	 */
	
	public Tantque(String expression, Script s) {
		this.expression = expression;
		this.s  = s;
	}
	
	/**
	 * 
	 * @return une expression
	 */
	
	public String getExpression(){return this.expression;}
	
	/**
	 * 
	 * @return un script
	 */
	public Script getScript(){return this.s;}
	
	@Override
	public void accept(Crayon cr) {cr.visiterTantque(this);}

}
