package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		Canvas c2=new Canvas();
		c2.setWidth(375);
		c2.setHeight(375);
		VBox vbox=new VBox();
		HBox hbox=new HBox();
		hbox.setPadding(new Insets(5));
		vbox.setPadding(new Insets(5));
		Button avant=new Button();
		avant.setPrefSize(50, 50);
		Button arriere=new Button();
		arriere.setPrefSize(50, 50);
		Button gauche=new Button();
		gauche.setPrefSize(50, 50);
		Button droite=new Button();
		droite.setPrefSize(50, 50);
		Button poser=new Button();
		poser.setPrefSize(50, 50);
		Button lever=new Button();
		lever.setPrefSize(50, 50);
		TextArea tf=new TextArea();
		HBox hbox2=new HBox();
		Button clear=new Button("clear");
		clear.setPrefSize(50, 50);
		Button submit=new Button("submit");
		submit.setPrefSize(50, 50);
		Button quit=new Button("quit");
		quit.setPrefSize(50, 50);
		root.getChildren().addAll(c2,vbox);
		hbox.getChildren().addAll(avant,arriere,gauche,droite,poser,lever);
		hbox2.getChildren().addAll(clear,submit,quit);
		vbox.getChildren().addAll(hbox,tf,hbox2);

		
		Scene s = new Scene(root,750,275);
		stage.setScene(s);
		stage.show();
		
		
	}
	
	public static void main(String[] args){
		Application.launch();
	}
}
