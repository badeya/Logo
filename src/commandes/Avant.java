package commandes;

import arbre.Node;
import interpretation.Crayon;
import interpretation.Interpreteur;

public class Avant implements Node{
	
	int distance;
	
	public Avant(String cmd){
		try {
			this.distance = Integer.valueOf(cmd.split(" ")[1]);
		} catch (Exception e) {
			Interpreteur.getInstance().setErreur(true);
		}
	}
	
	public int getDistance(){return this.distance;}

	@Override
	public void accept(Crayon cr) {
		cr.visiterAvant(this);
	}
	
	

	/*@Override
	public void execute(Integer... a) {
		distance = a[0];
		Interpreteur i = Interpreteur.getInstance();
		try {
			
			double orientation = i.getCrayon().getOrientation();
			Coordonne coord = i.getCrayon().getCoord();
			
			
			double angle = 2.0 * Math.PI * (orientation/360);
			
			double newx = Math.cos(angle) * distance + coord.getX();
			double newy =  Math.sin(angle) * distance + coord.getY();
			
			if(i.getCrayon().isEcrit()){
				i.getGc().setStroke(i.getCrayon().getCouleur());
				i.getGc().strokeLine(coord.getX(), coord.getY(), newx, newy);
			}
            Coordonne c = check(newx,newy,i);
			i.getCrayon().setX(c.getX());
			i.getCrayon().setY(c.getY());
			
		} catch (Exception e) {
			
			new ErreurCommandesAvant().afficherErreur();
		  }
		
	}

	

	@Override
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		res.add(this);
		return res;
	}*/

}
