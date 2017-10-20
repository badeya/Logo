package main;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	

	@Override
	public void start(Stage stage) throws Exception {

		Menu menu=new Menu();
		menu.start(stage);
	}
		
	
	public static void main(String[] args){
		Application.launch();
	}
}
