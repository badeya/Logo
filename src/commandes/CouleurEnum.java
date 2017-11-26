package commandes;

import javafx.scene.paint.Color;

public enum CouleurEnum {

	ROUGE(Color.RED,"ROUGE"),
	BLEU(Color.BLUE,"BLEU"),
	BLANC(Color.WHITE,"BLANC"),
	GRIS(Color.GREY,"GRIS"),
	VERT(Color.GREEN,"VERT"),
	ORANGE(Color.ORANGE,"ORANGE"),
	JAUNE(Color.YELLOW,"JAUNE"),
	ROSE(Color.PINK,"ROSE"),
	VIOLET(Color.VIOLET,"VIOLET"),
	MARRON(Color.MAROON,"MARRON");
	
	
	
	Color c;
	String name;
	
	CouleurEnum(Color c, String name){
		this.c = c;
		this.name = name;
	}

	public Color getColor() {
		return c;
	}

	public String getName() {
		return name;
	}
	
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
			
		default:
			return Color.BLACK;
			
		}
	}
	
	
}
