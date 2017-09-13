package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Test extends Application{
	
	
	private static Canvas c;

	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();

		
		root.getChildren().add(c);
		Scene s = new Scene(root);
		stage.setScene(s);
		stage.show();
		
		
	}
	
	public static void start(Canvas c){
		Test.c  = c;
		Application.launch();
	}
}
