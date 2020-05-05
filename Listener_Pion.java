import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Listener_Pion implements MouseListener { // cette classe permet au joueur d'intéragir avec les pions du plateau
	
	private Plateau plateau;
	private Pion pion;
	
	public Listener_Pion(Pion pion, Plateau plateau){ // on crée l'objet écouteur pour les pions
		this.plateau=plateau;
		this.pion=pion;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) { // cette méthode permet, lorsque le joueur clique sur un pion qu'il veut déplacer, d'afficher toutes les possibilités de déplacements qui s'offrent à lui
		plateau.afficherPossibilites(pion); // les cases du plateau où le pion peut aller s'illuminent
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
