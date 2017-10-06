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
	
	
}
