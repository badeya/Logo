package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Allera implements Node {
	
	public int x;
	public int y;
	
	public Allera(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void accept(Crayon cr) {
		cr.visiterAllerA(this);
		
	}

}