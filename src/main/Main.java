package main;

import Interpretation.Interpreteur;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	static Interpreteur i = new Interpreteur(375, 375);
	static Canvas c2 = i.getCanvas("");

	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		TextArea ta=new TextArea();
		Interpreteur interpreteur=new Interpreteur((int) c2.getWidth(),(int) c2.getHeight());
		VBox vbox=new VBox();
		HBox hbox=new HBox();
		hbox.setPadding(new Insets(5));
		vbox.setPadding(new Insets(5));
		Button avant=new Button();	
		Image flecheavant=new Image("File:images/flecheavant.png");
		avant.setPrefSize(50, 50);
		avant.setGraphic(new ImageView(flecheavant));
		avant.setOnMouseClicked(e->ta.setText(ta.getText()+"AVANT 20\n"));
		
		Button gauche=new Button();
		Image flechegauche=new Image("File:images/flechegauche.png");
		gauche.setGraphic(new ImageView(flechegauche));
		gauche.setPrefSize(50, 50);
		gauche.setOnMouseClicked(e->ta.setText(ta.getText()+"GAUCHE 90\n"));

		
		Button droite=new Button();
		Image flechedroite=new Image("File:images/flechedroite.png");
		droite.setGraphic(new ImageView(flechedroite));
		droite.setOnMouseClicked(e->ta.setText(ta.getText()+"DROITE 90\n"));

		droite.setPrefSize(50, 50);
		Button poser=new Button();
		Image flecheposer=new Image("File:images/flecheposer.png");
		poser.setGraphic(new ImageView(flecheposer));
		poser.setPrefSize(50, 50);
		
		Button lever=new Button();
		Image flechelever=new Image("File:images/flechelever.png");
		lever.setGraphic(new ImageView(flechelever));
		lever.setPrefSize(50, 50);
		
		HBox hbox2=new HBox();
		Button clear=new Button("clear");
		clear.setPrefSize(75, 50);
		clear.setOnMouseClicked(e->{
			interpreteur.clear();
			ta.setText("");
		});
		Button submit=new Button("submit");
		submit.setPrefSize(75, 50);
		submit.setOnMouseClicked(e->{
			Canvas temp = c2;
			c2=interpreteur.getCanvas(ta.getText());
			root.getChildren().remove(temp);
			root.getChildren().add(c2);				
			interpreteur.clear();
			ta.setText("");

		});			

		Button quit=new Button("quit");
		quit.setPrefSize(75, 50);
		quit.setOnMouseClicked(e->stage.close());
		root.getChildren().addAll(vbox,c2);
		hbox.getChildren().addAll(avant,gauche,droite,poser,lever);
		hbox2.getChildren().addAll(clear,submit,quit);
		vbox.getChildren().addAll(hbox,ta,hbox2);

		
		Scene s = new Scene(root,800,300);
		stage.setScene(s);
		stage.show();
		
		
	}
	
	public static void main(String[] args){
		Application.launch();
	}
}
