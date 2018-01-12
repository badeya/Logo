package commandes;

import interpretation.Interpreteur;
import javafx.scene.paint.Color;

/**
 *  Couleurs qui peuvent etres utiliser
 */

public enum CouleurEnum {
	/**
     * couleur rouge
     */
	ROUGE(Color.RED,"ROUGE"),
	/**
     * couleur bleu
     */
	BLEU(Color.BLUE,"BLEU"),
	/**
     * couleur blanc
     */
	BLANC(Color.WHITE,"BLANC"),
	/**
     * couleur gris
     */
	GRIS(Color.GREY,"GRIS"),
	/**
     * couleur vert
     */
	VERT(Color.GREEN,"VERT"),
	/**
     * couleur orange
     */
	ORANGE(Color.ORANGE,"ORANGE"),
	/**
     * couleur jaune
     */
	JAUNE(Color.YELLOW,"JAUNE"),
	/**
     * couleur rose
     */
	ROSE(Color.PINK,"ROSE"),
	/**
     * Red violet
     */
	VIOLET(Color.VIOLET,"VIOLET"),
	/**
     * couleur marron
     */
	MARRON(Color.MAROON,"MARRON"),
	/**
     * couleur noir
     */
	NOIR(Color.BLACK,"NOIR");
	
	
	
	Color c;
	String name;
	
	
	/**
	 * @param  c couleur du crayon
	   @param  name 
	 */

	CouleurEnum(Color c, String name){
		this.c = c;
		this.name = name;
	}
	
	
	/**
     * Retourne la couleur.
     * 
     * @return Une instance de Color.
     */
	public Color getColor() {
		return c;
	}

	/**
     * Retourne le nom de la couleur.
     * 
     * @return Une instance du nom de la couleur.
     */
	public String getName() {
		return name;
	}
	/**
     * Retourne le nom de la couleur en minuscule.
     * 
     * @param nom
     * @return Une instance du nom de la couleur en minuscule.
     */
	public static Color getColor(String nom){
		nom = nom.toLowerCase();
		switch (nom) {
		case "jaune":
			return CouleurEnum.JAUNE.getColor();
			
		case "rouge":
			return CouleurEnum.ROUGE.getColor();
			
		case "bleu":
			return CouleurEnum.BLEU.getColor();
			
		case "blanc":
			return CouleurEnum.BLANC.getColor();
			
		case "gris":
			return CouleurEnum.GRIS.getColor();
			
		case "vert":
			return CouleurEnum.VERT.getColor();
			
		case "orange":
			return CouleurEnum.ORANGE.getColor();
			
		case "rose":
			return CouleurEnum.ROSE.getColor();
			
		case "violet":
			return CouleurEnum.VIOLET.getColor();
			
		case "marron":
			return CouleurEnum.MARRON.getColor();
		
		case "noir":
			return CouleurEnum.NOIR.getColor();
			
		default:
			Interpreteur.getInstance().setErreur(true);
			System.out.println("Mauvaise couleur");
			return Color.BLACK;
			
		}
	}
	
	
}
