package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import interpretation.Interpreteur;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Menu extends Application {
	private  Interpreteur i;
	private  Canvas c2;
	private HBox root;
	@Override
	public void start(Stage stage) throws Exception {
		this.root = new HBox();
		TextArea ta=new TextArea();
		this.c2 = new Canvas(300,300);
		this.i=Interpreteur.getInstance();
		VBox vbox=new VBox();
		HBox hbox=new HBox();
		MenuBar mb=new MenuBar();
		javafx.scene.control.Menu file=new javafx.scene.control.Menu("fichier");
		MenuItem save=new MenuItem("Sauvegarder");
		MenuItem ouvrir=new MenuItem("Ouvrir");
		file.getItems().addAll(save,ouvrir);
		save.setOnAction(e->{
			FileChooser dialog = new FileChooser();
			dialog.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Texte","*.txt"));
			File file2 = dialog.showSaveDialog(null);
			if(file2.getName().contains(".")){
				int i=0;
				while(file2.getName().charAt(i)!='.')i++;
				file2=new File(file2.getName().substring(0, i) + ".txt");
			}
			if(!file2.getName().contains(".")){
				file2=new File(file2.getAbsolutePath() + ".txt");
			}
			try {
				FileWriter fw=new FileWriter(file2);
				fw.write(ta.getText());
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
                
			});
		ouvrir.setOnAction(e->{
			FileChooser dialog = new FileChooser();
			dialog.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("Texte","*.txt"));
			File file2 = dialog.showOpenDialog(null);
			String texte="";
			try {
				FileReader fr=new FileReader(file2);
				int c= fr.read();
				while(c!=-1){
					texte+=(char)c;
					c=fr.read();
				}
				fr.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			ta.setText(texte);
			
		});
		mb.getMenus().add(file);
		
		
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
		poser.setOnMouseClicked(e->ta.setText(ta.getText()+"POSER\n"));
		
		Button lever=new Button();
		Image flechelever=new Image("File:images/flechelever.png");
		lever.setGraphic(new ImageView(flechelever));
		lever.setPrefSize(50, 50);
		lever.setOnMouseClicked(e->ta.setText(ta.getText()+"LEVER\n"));

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
		vbox.getChildren().addAll(mb,hbox,ta,hbox2);

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

}
