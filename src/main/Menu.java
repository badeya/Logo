package main;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

import interpretation.Interpreteur;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * classe contenant l'interface graphique de l'application
 *
 */
public class Menu extends Application implements Observer{
	public static final int taille = 500;

	private  Interpreteur i;
	private  Canvas c2;
	private ControlleurMenu controlleur = new ControlleurMenu(); 
	HBox hbox2=new HBox();
	
	
	public Menu() {
		i = Interpreteur.getInstance();
		i.addObserver(this);
	}
	
	@SuppressWarnings("static-access")
	public void start(Stage stage) throws Exception {
		this.c2 = new Canvas(Menu.taille-20,Menu.taille-20);
		TextArea ta=new TextArea("SCRIPT\n"+
					"\tALLERA 200 200\n"+
					"\tSOIT DISTANCE = 50\n"+
					"\tSOIT ANGLE = 90\n"+
					"\tSOIT NBRDETOUR = 4\n"+
					"\tREPETER $NBRDETOUR\n"+
					"\tSCRIPT\n"+
					"\t\tAVANT $DISTANCE\n"+
					"\t\tDROITE $ANGLE\n"+
					"\tFIN\n"+
					"\tALLERA 10 10\n"+
					"\tSI POSX < 11\n" +
					"\tALORS SCRIPT\n" +
					"\t\tAVANT 50\n" +
					"\tFIN\n"+
					"\tSINON SCRIPT\n"+
					"\t\tDROITE 90\n"+
					"\t\tAVANT 20\n"+
					"\tFIN\n"+
					"\tBEZIER 400 0 , 400 400\n"+
					"\n"+
					"\tDROITE 180\n"+
					"\tTANTQUE POSX > 50\n"+
					"\tSCRIPT\n"+
					"\t\tAVANT 100\n"+
					"\t\tDROITE 90\n"+
					"\t\tAVANT 10\n"+
					"\t\tGAUCHE 90\n"+
					"\tFIN\n"+
					"FIN");
		/*		TextArea ta=new TextArea("SCRIPT\n" +
				"ALLERA 50 50 DROITE 90\n" + 
				"AVANT 200 GAUCHE 90 AVANT 75\n" + 
				"ALLERA 150 50 AVANT 75\n" + 
				"DROITE 90 AVANT 200\n" + 
				"DROITE 90 AVANT 75\n" + 
				"DROITE 90 AVANT 200\n" + 
				"ALLERA 275 50 DROITE 90 AVANT 75\n" + 
				"ALLERA 275 50 DROITE 90 AVANT 200\n" + 
				"GAUCHE 90 AVANT 75\n" + 
				"GAUCHE 90 AVANT 100\n" + 
				"GAUCHE 90 AVANT 50\n" + 
				"ALLERA 400 50 DROITE 90 DROITE 90 AVANT 75\n" + 
				"DROITE 90 AVANT 200\n" + 
				"DROITE 90 AVANT 75\n" + 
				"DROITE 90 AVANT 200\n" + 
				"FIN");*/
		ta.setPrefHeight(270);
		VBox vbox1=new VBox();
		VBox vbox2=new VBox();
		HBox hbox3=new HBox();
		HBox hbox4=new HBox();
		HBox hbox5=new HBox();
		MenuBar mb=new MenuBar();
		javafx.scene.control.Menu file=new javafx.scene.control.Menu("file");
		MenuItem saveimage=new MenuItem("Save image");
		MenuItem savecode=new MenuItem("Save code");
		MenuItem importer=new MenuItem("Import");
		MenuItem close=new MenuItem("Close");
		close.setOnAction(e->{System.exit(0);});
		file.getItems().addAll(importer,saveimage,savecode,close);
		mb.getMenus().add(file);
		//Label commandes=new Label("Commandes");
		ComboBox<String> choixCouleur=new ComboBox<String>();
		Slider epaisseur=new Slider(1,10,5);
		GridPane gp=new GridPane();
		Button avant=new Button();	
		Image flecheavant=new Image("File:images/flecheavant.png");
		Button gauche=new Button();
		Image flechegauche=new Image("File:images/flechegauche.png");
		Button droite=new Button();
		Image flechedroite=new Image("File:images/flechedroite.png");
		Button poser=new Button();
		Image flecheposer=new Image("File:images/flecheposer.png");
		Button lever=new Button();
		Image flechelever=new Image("File:images/flechelever.png");
		Button clear=new Button("clear");
		Button submit=new Button("submit");
		Button quit=new Button("quit");
		Button ApplyEpaisseur=new Button("Apply");
		epaisseur.setPrefWidth(300);
		Label nbEpaisseur=new Label(" 1      2      3      4       5       6       7       8       9       10");
		Label NomEpaisseur=new Label("Epaisseur");
		
		avant.setGraphic(new ImageView(flecheavant));
		avant.setOnMouseClicked(e->ta.setText(ta.getText()+"AVANT 20 "));
		gauche.setGraphic(new ImageView(flechegauche));
		gauche.setOnMouseClicked(e->ta.setText(ta.getText()+"GAUCHE 90 "));
		droite.setGraphic(new ImageView(flechedroite));
		droite.setOnMouseClicked(e->ta.setText(ta.getText()+"DROITE 90 "));
		poser.setGraphic(new ImageView(flecheposer));
		poser.setOnMouseClicked(e->ta.setText(ta.getText()+"POSER "));
		lever.setGraphic(new ImageView(flechelever));
		lever.setOnMouseClicked(e->ta.setText(ta.getText()+"LEVER "));
		clear.setOnMouseClicked(e->{
			Interpreteur.getInstance().setErreur(false);
			controlleur.updateCanvas("script fin ");
			ta.setText("");
			LoadInfo(hbox5);
		});
		submit.setOnMouseClicked(e->{
			Interpreteur.getInstance().setErreur(false);
			ta.setText(ta.getText().toUpperCase());
			controlleur.updateCanvas(ta.getText());
			LoadInfo(hbox5);
		});	
		
		saveimage.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image", "*.png"));
          
            File file3 = fileChooser.showSaveDialog(stage);
            
            if(file3 != null){
                try {
                    WritableImage writableImage = new WritableImage((int) c2.getWidth(), (int) c2.getHeight());
                    c2.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file3);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
		});

		savecode.setOnAction(e->{
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


		importer.setOnAction(e->{
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
		
		ApplyEpaisseur.setOnAction(e->{
			ta.setText(ta.getText()+"EPAISSEUR "+(int)epaisseur.getValue()+"\n");
		});
		
		quit.setOnMouseClicked(e->System.exit(0));


		choixCouleur.getItems().addAll("ROUGE","BLEU","BLANC","GRIS","VERT","ORANGE","JAUNE","ROSE","VIOLET","MARRON");
		choixCouleur.setOnAction(e->{
			ta.setText(ta.getText()+"COULEUR "+choixCouleur.getValue()+"\n");
		});
		choixCouleur.setPromptText("Colors");
		
		submit.setPadding(new Insets(20));
		clear.setPadding(new Insets(20));
		quit.setPadding(new Insets(20));
		
		hbox4.setMargin(submit, new Insets(1,1,1,280));
		
		
		
		gp.getChildren().addAll(avant,gauche,droite,lever,poser,choixCouleur);
		gp.setAlignment(Pos.CENTER);
		hbox3.getChildren().addAll(NomEpaisseur,epaisseur,ApplyEpaisseur);
		hbox4.getChildren().addAll(clear,quit,submit);
		hbox4.setAlignment(Pos.CENTER);

		vbox2.getChildren().addAll(nbEpaisseur,hbox3,gp,ta,hbox4,hbox5);
		

		//vbox2.getChildren().addAll(choixCouleur,nbEpaisseur,hbox3,gp,ta,hbox4,hbox5);
		
		hbox2.getChildren().addAll(vbox2,c2);
		vbox1.getChildren().addAll(mb,hbox2);
		
		vbox2.setMargin(nbEpaisseur, new Insets(1,1,1,70));
		
		hbox3.setMargin(epaisseur, new Insets(1,1,1,15));
		hbox3.setMargin(ApplyEpaisseur, new Insets(1,1,1,15));
		
		choixCouleur.setPadding(new Insets(17,17,17,5));
		gp.setMargin(choixCouleur, new Insets(1,1,1,-50));
		gp.setMargin(avant, new Insets(1,1,1,50));
		
		gp.setRowIndex(avant, 0);
		gp.setColumnIndex(avant, 0);
		gp.setRowIndex(gauche, 0);
		gp.setColumnIndex(gauche, 1);
		gp.setRowIndex(droite, 0);
		gp.setColumnIndex(droite, 2);
		gp.setRowIndex(lever, 0);
		gp.setColumnIndex(lever, 3);
		gp.setRowIndex(poser, 0);
		gp.setColumnIndex(poser, 4);
			 
		LoadInfo(hbox5);
		
		Scene s = new Scene(vbox1,500+Menu.taille,20+Menu.taille);
		stage.setTitle("Logo");
		stage.setScene(s);
		stage.show();
		stage.setResizable(false);

		

	}
	
	public void LoadInfo(HBox hbox) {
		hbox.getChildren().clear();
		String nomCouleur="";
		Label posx=new Label("PosX : "+(int)i.getCrayon().getPosX());
		Label posy=new Label(" PosY : "+(int)i.getCrayon().getPosY());
		Label epaisseur=new Label(" Epaisseur : "+i.getCrayon().getWidth());
		switch(i.getCrayon().getCouleur().toString()) 
		{
		case "0xff0000ff":
			nomCouleur="ROUGE";
			break;
		case "0x0000ffff":
			nomCouleur="BLEU";
			break;
		case "0xffffffff":
			nomCouleur="BLANC";
			break;
		case "0x808080ff":
			nomCouleur="GRIS";
			break;
		case "0x008000ff":
			nomCouleur="VERT";
			break;
		case "0xffa500ff":
			nomCouleur="ORANGE";
			break;
		case "0xffff00ff":
			nomCouleur="JAUNE";
			break;
		case "0xffc0cbff":
			nomCouleur="ROSE";
			break;
		case "0xee82eeff":
			nomCouleur="VIOLET";
			break;
		case "0x800000ff":
			nomCouleur="MARRON";
			break;
		case "0x000000ff":
			nomCouleur="NOIR";
			break;
		}
		Label couleur=new Label(" Couleur : "+nomCouleur);
		
		hbox.getChildren().addAll(posx,posy,epaisseur,couleur);
		
	}
	
	private void updateCanvas(){
		Node temp = c2;
		c2=i.getCanvas();
		hbox2.getChildren().remove(temp);
		hbox2.getChildren().add(c2);
		if(this.i.haveErreur()){
			Alert a = new Alert(AlertType.ERROR,i.getMessageErreur());
			a.show();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		updateCanvas();
	}

}
