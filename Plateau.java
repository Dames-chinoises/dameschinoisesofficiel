

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;



public class Plateau extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
	int taille=19;
	Couleur_du_pion couleur;
	private Cases_du_plateau caseActive;

	private boolean tourNoir;
	private boolean case_valide;
	

	public Plateau(int taille){
		setLayout(new GridLayout(taille,taille));
		for(int i=0; i<taille; i++){	// dans cette boucle, on va colorier les cases du plateau
			for(int j=0; j<taille; j++){
				
				if ((j%2!=0 && i%2!=0) || (i%2==0 && j%2==0) || (i>=13) || (j<=6 && i<=2) || (j>=12 && i<=2) || (i<=12 && i>=10 && j<=6) || (j>=12 && i<=12 && i>=10) || ( j==0 && i>=4 && i<=8) || ( j==18 && i>=4 && i<=8) || (j==1 && i<=7 && i>=5) || (j==17 && i<=7 && i>=5) || (j==7 && i==12) || (j==7 && i==0) || (j==11 && i==0) || (j==11 && i==12)){
					ajouterCase(Couleur_du_pion.GRIS);
				}
					else{
						
						if((j==9 && i==0) || (j==8 && i==1) || (j==10 && i==1) || (j==7 && i==2) || (j==9 && i==2) || (j==11 && i==2)){
							ajouterCase(Couleur_du_pion.BLANC);
							getCase(i,j).add(creerPion(Couleur_du_pion.VERT, true));
						}
						else{
							
							if((j==0 && i==3) || (j==2 && i==3) || (j==4 && i==3) || (j==1 && i==4) || (j==3 && i==4) || (j==2 && i==5)){
								ajouterCase(Couleur_du_pion.BLANC);
								getCase(i,j).add(creerPion(Couleur_du_pion.NOIR, true));
							}
							else{
						
								if((j==14 && i==3) || (j==16 && i==3) || (j==18 && i==3) || (j==15 && i==4) || (j==17 && i==4) || (j==16 && i==5)){
									ajouterCase(Couleur_du_pion.BLANC);
									getCase(i,j).add(creerPion(Couleur_du_pion.ORANGE, true));
								}
								else{
					
									if((j==16 && i==7) || (j==15 && i==8) || (j==17 && i==8) || (j==14 && i==9) || (j==16 && i==9) || (j==18 && i==9)){
										ajouterCase(Couleur_du_pion.BLANC);
										getCase(i,j).add(creerPion(Couleur_du_pion.BLEU, true));
									}
									else{
					
										if((j==11 && i==10) || (j==9 && i==10) || (j==7 && i==10) || (j==8 && i==11) || (j==10 && i==11) || (j==9 && i==12)){
											ajouterCase(Couleur_du_pion.BLANC);
											getCase(i,j).add(creerPion(Couleur_du_pion.ROUGE, true));
										}
										else{
					
											if((j==2 && i==7) || (j==3 && i==8) || (j==1 && i==8) || (j==0 && i==9) || (j==2 && i==9) || (j==4 && i==9)){
												ajouterCase(Couleur_du_pion.BLANC);
												getCase(i,j).add(creerPion(Couleur_du_pion.JAUNE, true));
												}
											else{
												ajouterCase(Couleur_du_pion.BLANC);
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
	
	
	
	
	
	private void ajouterCase(Couleur_du_pion couleur){
		Cases_du_plateau case_voulue = new Cases_du_plateau(couleur);
		case_voulue.addMouseListener(new Listener_Cases_du_plateau(case_voulue, this));
		add(case_voulue);
	}

	private Pion creerPion(Couleur_du_pion couleur, boolean monte){
		Pion pion = new Pion(couleur);
		pion.addMouseListener(new Listener_pion(pion, this));
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

	public void selectionnerCases(int i, int j, Couleur_du_pion couleur){
		Pion pion = (Pion)(getCase(i, j).getComponent(0));
		if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0 ){ //si la case en haut à gauche existe et qu'il n'y a pas de pions
				getCase(i-1, j-1).setSelectionnee(true); // on colorie la case pour montrer qu'on peut la selectionner
			}
			else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0 ){ //si dans la case en haut à gauche il y a un pion d'une autre couleur et pas de pion dans celle placée après ce pion dans la diagonale (pour manger un pion placé en haut à gauche)
				getCase(i-2, j-2).setSelectionnee(true);
			}
			if(i-1>=0 && j+1<taille && getCase(i-1, j+1).getComponentCount()==0){ //si la case en haut à droite existe et qu'il n'y a pas de pions
				getCase(i-1, j+1).setSelectionnee(true);
			}
			else if(i-2>=0 && j+2<taille && getCase(i-2, j+2).getComponentCount()==0 ){ // pour sauter un pion adverse placé en haut à droite du pion
				getCase(i-2, j+2).setSelectionnee(true);
			}
		
		
			if(i+1<taille && j+1<taille && getCase(i+1, j+1).getComponentCount()==0){ //si la case en bas à droite existe et qu'il n'y a pas de pions
				getCase(i+1, j+1).setSelectionnee(true);
			}
			else if(i+2<taille && j+2<taille && getCase(i+2, j+2).getComponentCount()==0 ){ // pour sauter un pion adverse placé dans la case en bas à droite
				getCase(i+2, j+2).setSelectionnee(true);
			}
			if(i+1<taille && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){ //si la case en bas à gauche existe et qu'il n'y a pas de pions
				getCase(i+1, j-1).setSelectionnee(true);
			}
			else if(i+2<taille && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0 ){ // pour sauter un pion adverse placé en bas à gauche du pion
				getCase(i+2, j-2).setSelectionnee(true);
			}
	}

	public void deplacer(Cases_du_plateau case_voulue){
		case_voulue.add(caseActive.getComponent(0));
		for(int k=0; k<taille*taille; k++){
			getCase(k).setSelectionnee(false);
		}
		if(Math.abs(getLigne(case_voulue)-getLigne(caseActive))==2){ // si on doit sauter un pion pour aller dans la case voulue
			int i = (getLigne(case_voulue)+getLigne(caseActive))/2;	// on obtient le j du pion qui va être sauté
			int j = (getColonne(case_voulue)+getColonne(caseActive))/2; // on obtient le j du pion qui va être sauté
			getCase(i, j).removeAll();	// enlève le pion de la case
			getCase(i, j).validate();	// La méthode validate() permet de demander la validation des données d'un Javabean (je sais pas trop ce que c'est...)
			getCase(i, j).repaint();	// met à jour le panel 
		}
		tourNoir=!tourNoir; // une fois le pion déplacé, c'est au tour de l'autre joueur
		caseActive.removeAll(); // on enlève le pion de sa case précédente
		caseActive.repaint();	// met à jour le panel 
		caseActive=null;		// on enlève la valeur qu'il y avait dans case active
		case_voulue.repaint();
		
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
