package Interpretation;

import javafx.scene.canvas.Canvas;

public class Interpreteur {

	Canvas c;
	
	public Interpreteur(int xCanvas,int yCanvas){
		this.c = new Canvas(xCanvas,yCanvas);
	}
	
	public Canvas getCanvas(String programme){
		
		String[] code = programme.split("\n");
		
		
		
		for (int i = 0; i < code.length; i++) {
			if(isMoveCommand(code[i])){
				
			}else{
				
			}
		}
		
		return c;
	}
	
	
	private boolean isMoveCommand(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateCanvas(String LigneCommande){
		
	}
	
	
	
	/*public static void main(String[]args){
		System.out.println("Salut");
		Canvas c = new Canvas(200,200);
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.strokeLine(0, 200, 200, 200);
		gc.line
		Test.start(c);
	}*/
}
