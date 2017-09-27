package erreur;

public class ErreurCommandesAllerA implements Erreur{

    public ErreurCommandesAllerA(){
    }

    public static void errSyntaxe(){
        System.err.println("ERREUR : La commande ALLERA s'utilise comme ceci : ALLERA x,y");
    }
}
