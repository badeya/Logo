
package main;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * 
 * Main de l'interpreteur Bogo
 */

public class Main extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {
	
		Menu menu = new Menu();
		menu.start(stage);
	}
	
	public static void main(String[] args){
		Application.launch();
	}
}
