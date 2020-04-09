import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Listener_Pion implements MouseListener {
	
	private Plateau plateau;
	private Pion pion;
	
	public Listener_Pion(Pion pion, Plateau plateau){
		this.plateau=plateau;
		this.pion=pion;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		plateau.afficherPossibilites(pion);
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}
