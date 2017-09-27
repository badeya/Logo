package erreur;

public class ErreurCommandesAvant implements Erreur{

    public ErreurCommandesAvant(){
    }

    public static void errSyntaxe(){
        System.err.println("ERREUR : La commande AVANT ne prend que des nombres en parametre");
    }
}
