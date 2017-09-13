package Interpretation;

import javafx.scene.canvas.Canvas;

public class Interpreteur {

	
	
	public Canvas getCanvas(String programme){
		Canvas res = new Canvas(200,200);
		String[] code = programme.split("\n");
		
		for (int i = 0; i < code.length; i++) {
				
		}
		
		
		return res;
	}
	
	
	
	
	
	
	/*public static void main(String[]args){
		System.out.println("Salut");
		Canvas c = new Canvas(200,200);
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.strokeLine(0, 200, 200, 200);
		Test.start(c);
	}*/
}
