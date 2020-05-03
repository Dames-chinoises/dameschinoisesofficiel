import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Listener_Cases_du_plateau implements MouseListener{  // cette class permet au joueur d'intéragir avec les cases du plateau
	
	private Cases_du_plateau case_voulue;
	private Plateau plateau;

	
	public Listener_Cases_du_plateau(Cases_du_plateau case_voulue, Plateau plateau) {  //on crée l'objet Listener pour les cases du plateau
		super();
		this.case_voulue = case_voulue;		// la case voulue est la case sur laquelle le jeu à cliquer et où il veut déplacer son pion
		this.plateau = plateau;
	}


	public void mouseClicked(MouseEvent arg0) {
	
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {  // cette méthode permet, lorsque le joueur clique sur la case voulue, d'autoriser le déplacement du pion vers la case voulue
		if(case_voulue.isSelectionnee()){
			plateau.deplacer(case_voulue);
		}
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	

}
