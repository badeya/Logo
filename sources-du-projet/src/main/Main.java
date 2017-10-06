package main;



import interpretation.Interpreteur;
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
	private  Interpreteur i;
	private  Canvas c2;
	private HBox root;

	@Override
	public void start(Stage stage) throws Exception {
		this.root = new HBox();
		TextArea ta=new TextArea();
		this.c2 = new Canvas(300,300);
		this.i=new Interpreteur((int) c2.getWidth(),(int) c2.getHeight());
		VBox vbox=new VBox();
		HBox hbox=new HBox();
		hbox.setPadding(new Insets(5));
		vbox.setPadding(new Insets(5));
		Button avant=new Button();	
		Image flecheavant=new Image("File:sources-du-projet/images/flecheavant.png");
		avant.setPrefSize(50, 50);
		avant.setGraphic(new ImageView(flecheavant));
		avant.setOnMouseClicked(e->ta.setText(ta.getText()+"AVANT 20\n"));
		
		Button gauche=new Button();
		Image flechegauche=new Image("File:sources-du-projet/images/flechegauche.png");
		gauche.setGraphic(new ImageView(flechegauche));
		gauche.setPrefSize(50, 50);
		gauche.setOnMouseClicked(e->ta.setText(ta.getText()+"GAUCHE 90\n"));

		
		Button droite=new Button();
		Image flechedroite=new Image("File:sources-du-projet/images/flechedroite.png");
		droite.setGraphic(new ImageView(flechedroite));
		droite.setOnMouseClicked(e->ta.setText(ta.getText()+"DROITE 90\n"));

		droite.setPrefSize(50, 50);
		Button poser=new Button();
		Image flecheposer=new Image("File:sources-du-projet/images/flecheposer.png");
		poser.setGraphic(new ImageView(flecheposer));
		poser.setPrefSize(50, 50);
		
		Button lever=new Button();
		Image flechelever=new Image("File:sources-du-projet/images/flechelever.png");
		lever.setGraphic(new ImageView(flechelever));
		lever.setPrefSize(50, 50);
		
		HBox hbox2=new HBox();
		Button clear=new Button("clear");
		clear.setPrefSize(75, 50);
		clear.setOnMouseClicked(e->{
			updateCanvas("");
			ta.setText("");
		});
		Button submit=new Button("submit");
		submit.setPrefSize(75, 50);
		submit.setOnMouseClicked(e->{
			ta.setText(ta.getText().toUpperCase());
			updateCanvas(ta.getText());

		});			

		Button quit=new Button("quit");
		quit.setPrefSize(75, 50);
		quit.setOnMouseClicked(e->System.exit(0));
		root.setPadding(new Insets(3));
		root.getChildren().addAll(vbox,c2);
		hbox.getChildren().addAll(avant,gauche,droite,poser,lever);
		hbox2.getChildren().addAll(clear,submit,quit);
		vbox.getChildren().addAll(hbox,ta,hbox2);

		
		Scene s = new Scene(root,800,300);
		stage.setScene(s);
		stage.show();
		stage.setResizable(false);
		
	}
	
	private void updateCanvas(String s){
		Canvas temp = c2;
		c2=i.getCanvas(s);
		root.getChildren().remove(temp);
		root.getChildren().add(c2);	
	}
	
	public static void main(String[] args){
		Application.launch();
	}
}
