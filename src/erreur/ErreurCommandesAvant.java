package erreur;

public class ErreurCommandesAvant implements Erreur{


	@Override
	public void afficherErreur() {
		System.out.println("ERREUE : La commande AVANT ne prend que des nombres en paramétre");
		
	}
}
