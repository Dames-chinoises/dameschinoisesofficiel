import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Listener_Cases_du_plateau implements MouseListener{
	
	private Cases_du_plateau case_voulue;
	private Plateau plateau;

	
	public Listener_Cases_du_plateau(Cases_du_plateau case_voulue, Plateau plateau) {
		super();
		this.case_voulue = case_voulue;
		this.plateau = plateau;
	}


	public void mouseClicked(MouseEvent arg0) {
	
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		if(case_voulue.isSelectionnee()){
			plateau.deplacer(case_voulue);
		}
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	

}
