package erreur;

public class ErreurCommandesAllerA implements Erreur{


	@Override
	public void afficherErreur() {
		System.err.println("ERREUR : La commande ALLERA s'utilise comme ceci : ALLERA x,y");
		
	}
}
