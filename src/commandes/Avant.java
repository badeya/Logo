package commandes;

import arbre.Node;
import interpretation.Crayon;

public class Avant implements Node{
	
	int distance;
	
	public Avant(int distance){
		this.distance = distance;
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

	private Coordonne check(double newx, double newy,Interpreteur i){
        if (newx > i.getWidthCanvas()){
            newx=i.getWidthCanvas();
        }
        if (newx < 0){
            newx = 0;
        }
        if (newy > i.getHeighCanvas()){
            newy = i.getHeighCanvas();
        }
        if (newy < 0){
            newy = 0;
        }
        return new Coordonne(newx,newy);
    }

	@Override
	public ArrayList<Node> getChildren() {
		ArrayList<Node> res = new ArrayList<Node>();
		res.add(this);
		return res;
	}*/

}
