[![pipeline status](https://git-iut.univ-lille1.fr/tanguy.depommier/ProjetMode2017-K4/badges/master/pipeline.svg)](https://git-iut.univ-lille1.fr/tanguy.depommier/ProjetMode2017-K4/commits/master)


@author Thibaut Depommier
@author Valentin Lucas
@author Belembert Melvin
@author Badey Arthur

Adresse git: https://git-iut.univ-lille1.fr/tanguy.depommier/ProjetMode2017-K4.git

Ce qui � �t� fait :
- L'interpretateur de language LOGO
- L'interface graphique 
- implemantation des boutons
- Controle sortie de canvas
-Courbe de bézier
-Parseur Boolean et arithmetique
-Noeud Si, Tanque, Repeter
-Variable
-modele mcv
-Sauvegarder/Charger 


Ce qu'il reste � faire : 

Pour la r�partitions des t�ches :
- Thibaut s'est occuper de l'Interpr�teur de language LOGO et des commandes.
- Melvin du parser arithmétique et des tests.
- Valentin et Arthur de l'interface graphique et de l'impl�mentation des boutons.


****************************************************************

Liste des fonctionalitées : 

-Importer script
-Sauvegarder le tracer
-Sauvegarder le script
-choix de la couleur 
-choix de l'épaisseur
-variable
-Courbe de Bézier
-Conditions 
-Boucles
-gestion des calculs 

****************************************************************
Script montrant les fonctionalitées du projet : 

SCRIPT
	ALLERA 200 200
	SOIT DISTANCE = 50
	SOIT ANGLE = 90
	SOIT NBRDETOUR = 4
	REPETER $NBRDETOUR
	SCRIPT
		AVANT $DISTANCE
		DROITE $ANGLE
	FIN
	ALLERA 10 10
	SI POSX < 11
	ALORS SCRIPT
		AVANT 50
	FIN
	SINON SCRIPT
		DROITE 90
		AVANT 20
	FIN
	BEZIER 400 0 , 400 400
	DROITE 180
	TANTQUE POSX > 50
	SCRIPT
		AVANT 100
		DROITE 90
		AVANT 10
		GAUCHE 90
	FIN
FIN

****************************************************************
Exemple autres de scripts : 

SCRIPT
EPAISSEUR 1
ALLERA 150 150
REPETER 10+8
SCRIPT
DROITE 40/2
REPETER 18
SCRIPT
DROITE 2*10
COULEUR ROUGE
AVANT 5
COULEUR JAUNE
AVANT 5
COULEUR VERT
AVANT 5
COULEUR BLEU
AVANT 5
FIN
FIN
FIN


----------------------------------------------------------------

SCRIPT
LEVER
ALLERA 50  50
POSER
EPAISSEUR 5
COULEUR BLEU
AVANT 50
DROITE 90
COULEUR VERT
AVANT 50
DROITE 90
COULEUR ROUGE
AVANT 50
DROITE 90
COULEUR JAUNE
AVANT 50
FIN

------------------------------------------------------------------

SCRIPT
ALLERA 75 75
REPETER 5
SCRIPT
EPAISSEUR 2
AVANT 40
EPAISSEUR 1
AVANT 20
EPAISSEUR 2
AVANT 40
DROITE 216
FIN
FIN

------------------------------------------------------------------

SCRIPT
	ALLERA 200 200
	SOIT DISTANCE = 50
	SOIT ANGLE = 90
	SOIT NBRDETOUR = 4
	REPETER $NBRDETOUR
	SCRIPT
		AVANT $DISTANCE
		DROITE $ANGLE
	FIN
	ALLERA 10 10
	SI ESTPOSER
	ALORS SCRIPT
		AVANT 50
	FIN
	SINON SCRIPT
		DROITE 90
		AVANT 20
	FIN
	BEZIER 400 0 , 400 400
FIN

------------------------------------------------------------------


SCRIPT
LEVER
ALLERA 100  100
EPAISSEUR 2
COULEUR ORANGE
POSER
REPETER 10
SCRIPT
  AVANT 10
  DROITE 10
FIN
TANTQUE POSY > 100
SCRIPT
  AVANT 10
  DROITE 10
FIN
SI POSX > 100
ALORS
  SCRIPT
    COULEUR ROUGE
  FIN
SINON
  SCRIPT
    COULEUR BLEU
  FIN
GAUCHE 90
EPAISSEUR 5
AVANT 50
FIN


****************************************************************




