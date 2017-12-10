package interpretation;

import commandes.Allera;
import commandes.Avant;
import commandes.Couleur;
import commandes.Droite;
import commandes.Epaisseur;
import commandes.Gauche;
import commandes.Lever;
import commandes.Poser;
import commandes.Repeter;
import commandes.Script;
import commandes.Tantque;

public interface VisiteurAST {

	void visiterCouleur(Couleur c);
	void visiterAllerA(Allera c);
	void visiterDroite(Droite c);
	void visiterEpaisseur(Epaisseur c);
	void visiterGauche(Gauche c);
	void visiterLever(Lever c);
	void visiterPoser(Poser c);
	void visiterScript(Script s);
	void visiterAvant(Avant c);
	void visiterRepeter(Repeter n);
	void visiterTantque(Tantque n);
	
	
}
