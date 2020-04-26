import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.util.LinkedList;

import javax.swing.JPanel;


public class Plateau extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
	int taille=19;
	Couleur_du_pion couleur;
	private Cases_du_plateau caseActive;

	private boolean tourNoir;
	private boolean case_valide;
	private boolean dejaSaute;
	private LinkedList<Coordonees> mouvementsPossibles = new LinkedList<>();


	private LinkedList <Coordonees> triangleVert = new LinkedList <>();
	private LinkedList <Coordonees> triangleRouge = new LinkedList <>();

	private LinkedList <Coordonees> triangleNoire = new LinkedList <>();
	private LinkedList <Coordonees> triangleBleu = new LinkedList <>();

	private LinkedList <Coordonees> triangleRose = new LinkedList <>();
	private LinkedList <Coordonees> triangleJaune = new LinkedList <>();
	

	public Plateau(int taille){
		setLayout(new GridLayout(taille,taille));
		ajouterCoordonees();
		for(int i=0; i<taille; i++){	// dans cette boucle, on va colorier les cases du plateau
			for(int j=0; j<taille; j++){
				
				if ((j%2!=0 && i%2!=0) || (i%2==0 && j%2==0) || (i>=13) || (j<=6 && i<=2) || (j>=12 && i<=2) || (i<=12 && i>=10 && j<=6) || (j>=12 && i<=12 && i>=10) || ( j==0 && i>=4 && i<=8) || ( j==18 && i>=4 && i<=8) || (j==1 && i<=7 && i>=5) || (j==17 && i<=7 && i>=5) || (j==7 && i==12) || (j==7 && i==0) || (j==11 && i==0) || (j==11 && i==12)){
					ajouterCase(Couleur_du_case.GRIS);
				}
					else{
						
						if((j==9 && i==0) || (j==8 && i==1) || (j==10 && i==1) || (j==7 && i==2) || (j==9 && i==2) || (j==11 && i==2)){
							ajouterCase(Couleur_du_case.BLANC);
							getCase(i,j).add(creerPion(Couleur_du_pion.VERT, true));
						}
						else{
							
							if((j==0 && i==3) || (j==2 && i==3) || (j==4 && i==3) || (j==1 && i==4) || (j==3 && i==4) || (j==2 && i==5)){
								ajouterCase(Couleur_du_case.BLANC);
								getCase(i,j).add(creerPion(Couleur_du_pion.NOIR, true));
							}
							else{
						
								if((j==14 && i==3) || (j==16 && i==3) || (j==18 && i==3) || (j==15 && i==4) || (j==17 && i==4) || (j==16 && i==5)){
									ajouterCase(Couleur_du_case.BLANC);
									getCase(i,j).add(creerPion(Couleur_du_pion.ROSE, true));
								}
								else{
					
									if((j==16 && i==7) || (j==15 && i==8) || (j==17 && i==8) || (j==14 && i==9) || (j==16 && i==9) || (j==18 && i==9)){
										ajouterCase(Couleur_du_case.BLANC);
										getCase(i,j).add(creerPion(Couleur_du_pion.BLEU, true));
									}
									else{
					
										if((j==11 && i==10) || (j==9 && i==10) || (j==7 && i==10) || (j==8 && i==11) || (j==10 && i==11) || (j==9 && i==12)){
											ajouterCase(Couleur_du_case.BLANC);
											getCase(i,j).add(creerPion(Couleur_du_pion.ROUGE, true));
										}
										else{
					
											if((j==2 && i==7) || (j==3 && i==8) || (j==1 && i==8) || (j==0 && i==9) || (j==2 && i==9) || (j==4 && i==9)){
												ajouterCase(Couleur_du_case.BLANC);
												getCase(i,j).add(creerPion(Couleur_du_pion.JAUNE, true));
												}
											else{
												ajouterCase(Couleur_du_case.BLANC);
											}
										}
									}
								}
							}
						}
					}
			
		
	
				
			}
		}
	
		
		
		
		
	}



	private void ajouterCase(Couleur_du_case couleur){
		Cases_du_plateau case_voulue = new Cases_du_plateau(couleur);
		case_voulue.addMouseListener(new Listener_Cases_du_plateau(case_voulue, this));
		add(case_voulue);
	}

	private Pion creerPion(Couleur_du_pion couleur, boolean monte){
		Pion pion = new Pion(couleur);
		pion.addMouseListener(new Listener_Pion(pion, this));
		return pion;
	}


	public Cases_du_plateau getCase(int i, int j){
		return (Cases_du_plateau) getComponent(j+i*taille);
	}

	public Cases_du_plateau getCase(int i){
		return (Cases_du_plateau) getComponent(i);
	}


	public void afficherPossibilites(Pion p){
		if((p.getCouleur().equals(Couleur_du_pion.VERT) && tourNoir) || (p.getCouleur().equals(Couleur_du_pion.ROUGE) && !tourNoir)){ // si le pion selectionné est noir et que c'est au tour du noir de jouer (ou l'inverse)
			int i=0;
			int j=0;
			for(int k=0; k<taille*taille; k++){  // le nombre k représente le nombre totale de cases du plateau
				getCase(k).setSelectionnee(false); // on laisse la case k dans sa couleur normale
				if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){ // si il y a un pion dans la case k et si ce pion est bien le pion p
					caseActive=getCase(k); // la case dans laquelle il y a le pion qu'on a sélectionné et dont on cherche les endroits où il peut aller
					i=k/taille; // donne la position i du pion sur le plateau
					j=k%taille; // donne la position j du pion sur le plateau

				}
			}
			selectionnerCases(i, j, p.getCouleur());  // on colorie les cases dans lesquelles le pion p peut potentiellement aller 
		}
	}

	//Methode qui selection les cases ou il est possible se deplacer a partir de la liste mouvements possibles
	public void selectionnerCases(int i, int j, Couleur_du_pion couleur){
		Pion pion = (Pion)(getCase(i, j).getComponent(0));
		getMouvementsPossibles(i,j);
		ajouterSauts();
		mouvementsPossibles.forEach(c-> getCase(c.getI(),c.getJ()).setSelectionnee(true));
		mouvementsPossibles=new LinkedList<>();
	}

	public void deplacer(Cases_du_plateau case_voulue){
		case_voulue.add(caseActive.getComponent(0));		//on met le pion de la case active sur la case voulue
		for(int k=0; k<taille*taille; k++){ 		// reinitialise selectionner_cases
			getCase(k).setSelectionnee(false);
		}
		if(Math.abs(getLigne(case_voulue)-getLigne(caseActive))==2){ // si on doit sauter un pion pour aller dans la case voulue
			int i = (getLigne(case_voulue)+getLigne(caseActive))/2;	// on obtient le j du pion qui va être sauté
			int j = (getColonne(case_voulue)+getColonne(caseActive))/2; // on obtient le j du pion qui va être sauté
			getCase(i, j).removeAll();	// enlève le pion de la case
			getCase(i, j).validate();	// La méthode validate() permet de demander la validation des données d'un Javabean (je sais pas trop ce que c'est...)
			getCase(i, j).repaint();	// met à jour le panel
		}
		if(finDeJeu() == false) {
			tourNoir = !tourNoir; // une fois le pion déplacé, c'est au tour de l'autre joueur
		} else {
			System.out.println("finDeJeu");
		}
		caseActive.removeAll(); // on enlève le pion de sa case précédente
		caseActive.repaint();	// met à jour le panel 
		caseActive=null;		// on enlève la valeur qu'il y avait dans case active
		case_voulue.repaint();
		
	}

	public void ajouterCoordonees (){ //Methode qui ajoute les cases avec coordonnes  dans chaque linkedlist
		//ajoute les pions dans le triangle vert
		triangleVert.add(new Coordonees(0,9));
		triangleVert.add(new Coordonees(1,8));
		triangleVert.add(new Coordonees(1,10));
		triangleVert.add(new Coordonees(2,7));
		triangleVert.add(new Coordonees(2,9));
		triangleVert.add(new Coordonees(2,11));


		//ajoute les pion dans le traingle rouge
		triangleRouge.add(new Coordonees(10,7));
		triangleRouge.add(new Coordonees(10,9));
		triangleRouge.add(new Coordonees(10,11));
		triangleRouge.add(new Coordonees(11,8));
		triangleRouge.add(new Coordonees(11,10));
		triangleRouge.add(new Coordonees(12,9));


		// ajoute les pions dans le triangle noir
		triangleNoire.add(new Coordonees(3,0));
		triangleNoire.add(new Coordonees(3,2));
		triangleNoire.add(new Coordonees(3,4));
		triangleNoire.add(new Coordonees(4,1));
		triangleNoire.add(new Coordonees(4,3));
		triangleNoire.add(new Coordonees(5,2));


		// ajoute les pions dans le triangle jaune
		triangleJaune.add(new Coordonees(7,2));
		triangleJaune.add(new Coordonees(8,1));
		triangleJaune.add(new Coordonees(8,3));
		triangleJaune.add(new Coordonees(9,0));
		triangleJaune.add(new Coordonees(9,2));
		triangleJaune.add(new Coordonees(9,4));


		// ajoute les pions dans le triangle rose
		triangleRose.add(new Coordonees(3,18));
		triangleRose.add(new Coordonees(3,16));
		triangleRose.add(new Coordonees(3,14));
		triangleRose.add(new Coordonees(4,17));
		triangleRose.add(new Coordonees(4,15));
		triangleRose.add(new Coordonees(5,16));


		// ajoute les pions dans le triangle bleu
		triangleBleu.add(new Coordonees(7,16));
		triangleBleu.add(new Coordonees(8,17));
		triangleBleu.add(new Coordonees(8,15));
		triangleBleu.add(new Coordonees(9,18));
		triangleBleu.add(new Coordonees(9,16));
		triangleBleu.add(new Coordonees(9,14));
	}


	public boolean finDeJeu() {
		boolean finiVert = true;
		boolean finiRouge = true;
		boolean finiNoir = true;
		boolean finiBleu = true;
		boolean finiJaune = true;
		boolean finiRose = true;

		for (Coordonees c :triangleVert) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiVert = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.ROUGE) {
				finiVert = false;
				break;
			}
		}
		for (Coordonees c :triangleRouge) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiRouge = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.VERT) {
				finiRouge = false;
				break;
			}
		}
		for (Coordonees c :triangleNoire) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiNoir = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.BLEU) {
				finiNoir = false;
				break;
			}
		}
		for (Coordonees c :triangleBleu) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiBleu = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.NOIR) {
				finiBleu = false;
				break;
			}
		}
		for (Coordonees c :triangleJaune) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiJaune = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.ROSE) {
				finiJaune = false;
				break;
			}
		}
		for (Coordonees c :triangleRose) {
			if ((getCase(c.getI(),c.getJ()).getComponentCount() == 0)){
				finiRose = false;
				break;
			} else if(((Pion)(getCase(c.getI(),c.getJ()).getComponent(0))).getCouleur()!=Couleur_du_pion.JAUNE) {
				finiRose = false;
				break;
			}
		}

		if(finiBleu == true || finiNoir == true || finiJaune == true || finiRose== true || finiRouge== true || finiVert == true) {
			return true;
		}else{
			return false;
		}
	}
	private int getLigne(Cases_du_plateau case_voulue){
		int res=0;
		for(int i=0; i<taille*taille; i+=2){
			if(getCase(i).equals(case_voulue)){
				res=i/taille;
			}
		}
		return res;
	}

	//Methode qui ajoute les premirs mouvements possibles dans la liste Mouvements Possibles
	private void getMouvementsPossibles(int i, int j){
		//DIRECTION 0 - HAUT DROITE
		if( i-1>=0 && j+1<=18 && getCase(i-1, j+1).getCouleur()==Couleur_du_case.BLANC  && getCase(i-1,j+1).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i-1,j+1))){
			mouvementsPossibles.add(new Coordonees(i-1,j+1));
		}
		else if( i-1>=0 && j+1<=18 && getCase(i-1, j+1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i-1,j+1).getComponentCount()!=0){
			if(i-2>=0 && j+2<=18 && getCase(i-2, j+2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i-2,j+2).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i-2,j+2))) {
				Coordonees aAjouter = new Coordonees(i-2,j+2);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}
		//DIRECTION 1 -  BAS DROITE
		if(i+1>=0 && j+1<=18 && getCase(i+1, j+1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i+1,j+1).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i+1,j+1))){
			mouvementsPossibles.add(new Coordonees(i+1,j+1));
		}
		else if( i+1>=0 && j+1<=18 && getCase(i+1, j+1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i+1,j+1).getComponentCount()!=0){
			if(i+2>=0 && j+2<=18 && getCase(i+2, j+2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i+2,j+2).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i+2,j+2))) {
				Coordonees aAjouter = new Coordonees(i+2,j+2);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}
		// DIRECTION 2 - DROITE
		if( i>=0 && j+2<=18 && getCase(i, j+2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j+2).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i,j+2))){
			mouvementsPossibles.add(new Coordonees(i,j+2));
		}
		else if( i>=0 && j+2<=18 && getCase(i, j+2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j+2).getComponentCount()!=0){
			if(i>=0 && j+4<=18 && getCase(i, j+4).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j+4).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i,j+4))) {
				Coordonees aAjouter = new Coordonees(i,j+4);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}
		// DIRECTION 3 - GAUCHE
		if(i>=0 && j-2>=0 && getCase(i, j-2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j-2).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i,j-2))){
			mouvementsPossibles.add(new Coordonees(i,j-2));
		}
		else if(i>=0 && j-2>=0 && getCase(i, j-2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j-2).getComponentCount()!=0){
			if(i>=0 && j-4<=18 && getCase(i, j-4).getCouleur()==Couleur_du_case.BLANC &&  getCase(i,j-4).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i,j-4))) {
				Coordonees aAjouter = new Coordonees(i,j-4);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}
		//DIRECTION 4 -  BAS GAUCHE
		if( i+1>=0 && j-1>=0 &&  getCase(i+1, j-1).getCouleur()==Couleur_du_case.BLANC && getCase(i+1,j-1).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i+1,j-1))){
			mouvementsPossibles.add(new Coordonees(i+1,j-1));
		}
		else if( i+1>=0 && j-1>=0 && getCase(i+1, j-1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i+1,j-1).getComponentCount()!=0){
			if(i+2>=0 && j-2<=18 && getCase(i+2, j-2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i+2,j-2).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i+2,j-2))) {
				Coordonees aAjouter = new Coordonees(i+2,j-2);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}
		//DIRECTION 5 - HAUT GAUCHE
		if( i-1>=0 && j-1>=0 && getCase(i-1, j-1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i-1,j-1).getComponentCount()==0&& !mouvementsPossibles.contains(new Coordonees(i-1,j-1))){
			mouvementsPossibles.add(new Coordonees(i-1,j-1));
		}
		else if( i-1>=0 && j-1>=0 && getCase(i-1, j-1).getCouleur()==Couleur_du_case.BLANC &&  getCase(i-1,j-1).getComponentCount()!=0){
			if(i-2>=0 && j-2<=18 && getCase(i-2, j-2).getCouleur()==Couleur_du_case.BLANC &&  getCase(i-2,j-2).getComponentCount()==0 && !mouvementsPossibles.contains(new Coordonees(i-2,j-2))) {
				Coordonees aAjouter = new Coordonees(i-2,j-2);
				aAjouter.dejaSaute=true;
				mouvementsPossibles.add(aAjouter);
			}
		}

	}

	//Methode qui ajoute les mouvements supplementaires au caus oú il est possible de sauter en plus
	private void ajouterSautsPossibles(Coordonees c){
		if(c.dejaSaute) {
			int i = c.getI();
			int j = c.getJ();
			//DIRECTION 0 - HAUT DROITE
			if (i - 1 >= 0 && j + 1 <= 18 && getCase(i - 1, j + 1).getCouleur() == Couleur_du_case.BLANC && getCase(i - 1, j + 1).getComponentCount() != 0 ) {
				if (i - 2 >= 0 && j + 2 <= 18 && getCase(i - 2, j + 2).getCouleur() == Couleur_du_case.BLANC && getCase(i - 2, j + 2).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i - 2, j + 2))) {
					Coordonees aAjouter = new Coordonees(i-2,j+2);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
			//DIRECTION 1 -  BAS DROITE
			if (i + 1 >= 0 && j + 1 <= 18 && getCase(i + 1, j + 1).getCouleur() == Couleur_du_case.BLANC && getCase(i + 1, j + 1).getComponentCount() != 0) {
				if (i + 2 >= 0 && j + 2 <= 18 && getCase(i + 2, j + 2).getCouleur() == Couleur_du_case.BLANC && getCase(i + 2, j + 2).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i + 2, j + 2))) {
					Coordonees aAjouter = new Coordonees(i+2,j+2);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
			// DIRECTION 2 - DROITE
			if (i >= 0 && j + 2 <= 18 && getCase(i, j + 2).getCouleur() == Couleur_du_case.BLANC && getCase(i, j + 2).getComponentCount() != 0) {
				if (i >= 0 && j + 4 <= 18 && getCase(i, j + 4).getCouleur() == Couleur_du_case.BLANC && getCase(i, j + 4).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i, j + 4))) {
					Coordonees aAjouter = new Coordonees(i,j+4);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
			// DIRECTION 3 - GAUCHE
			if (i >= 0 && j - 2 >= 0 && getCase(i, j - 2).getCouleur() == Couleur_du_case.BLANC && getCase(i, j - 2).getComponentCount() != 0) {
				if (i >= 0 && j - 4 <= 18 && getCase(i, j - 4).getCouleur() == Couleur_du_case.BLANC && getCase(i, j - 4).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i, j - 4))) {
					Coordonees aAjouter = new Coordonees(i,j-4);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
			//DIRECTION 4 -  BAS GAUCHE
			if (i + 1 >= 0 && j - 1 >= 0 && getCase(i + 1, j - 1).getCouleur() == Couleur_du_case.BLANC && getCase(i + 1, j - 1).getComponentCount() != 0) {
				if (i + 2 >= 0 && j - 2 <= 18 && getCase(i + 2, j - 2).getCouleur() == Couleur_du_case.BLANC && getCase(i + 2, j - 2).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i + 2, j - 2))) {
					Coordonees aAjouter = new Coordonees(i+2,j-2);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
			//DIRECTION 5 - HAUT GAUCHE
			if (i - 1 >= 0 && j - 1 >= 0 && getCase(i - 1, j - 1).getCouleur() == Couleur_du_case.BLANC && getCase(i - 1, j - 1).getComponentCount() != 0) {
				if (i - 2 >= 0 && j - 2 <= 18 && getCase(i - 2, j - 2).getCouleur() == Couleur_du_case.BLANC && getCase(i - 2, j - 2).getComponentCount() == 0 && !mouvementsPossibles.contains(new Coordonees(i - 2, j - 2))) {
					Coordonees aAjouter = new Coordonees(i-2,j-2);
					aAjouter.dejaSaute=true;
					mouvementsPossibles.add(aAjouter);
				}
			}
		}

	}

	//Methode qui ajoute les sautes supplementaires possibles dans la liste mouvements possibles
	private void ajouterSauts(){
		int size = 0;
		while (mouvementsPossibles.size()!=size){
			size=mouvementsPossibles.size();
			for(int a=0; a<mouvementsPossibles.size();a++){
				Coordonees c = mouvementsPossibles.get(a);
				ajouterSautsPossibles(c);
			}

		}
	}


	private int getColonne(Cases_du_plateau case_voulue){
		int res=0;
		for(int i=0; i<taille*taille; i+=2){
			if(getCase(i).equals(case_voulue)){
				res=i%taille;
			}
		}
		return res;
	}
}

// pour jouer à 6 joueurs, il faut remplacer tourNoir ( qui est boolean donc prend que 2 valeurs) par une autre variable qui peut prendre 6 valeurs
