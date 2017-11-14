package commandes;

import java.util.ArrayList;

import arbre.Node;
import erreur.ErreurCommandesAllerA;
import interpretation.Coordonne;
import interpretation.Interpreteur;


public class Allera implements Commandes,Node{
	
	int x;
	int y;
	
	public Allera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	@Override
	public void execute(Integer... a){
		x = a[0];
		y = a[1];
		Interpreteur i = Interpreteur.getInstance();
		try {
			
			int newx = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[0]);
			int newy = Integer.valueOf(i.getCurrentLine().split(" ")[1].split(",")[1]);
			
			/*if(i.getCrayon().isEcrit()){
				i.getGc().strokeLine(i.getCrayon().getX(), i.getCrayon().getY(), newx, newy);
			}*/

            Coordonne c = check(newx,newy);
            i.getCrayon().setX(c.getX());
            i.getCrayon().setY(c.getY());
			
		} catch (Exception e) {
			new ErreurCommandesAllerA().afficherErreur();
		}
		
	}

    private Coordonne check(double newx, double newy){
        if (newx > 375){
            newx=375;
        }
        if (newx < 0){
            newx = 0;
        }
        if (newy > 375){
            newy = 375;
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
	}
	
	





}
