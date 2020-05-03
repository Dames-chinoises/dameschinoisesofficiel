import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;


public class Cases_du_plateau extends JPanel {
	
	private Couleur_du_case couleur;
	private boolean selectionnee;
	
	public Cases_du_plateau(Couleur_du_case couleur){		// on crée l'objet case du plateau
		this.couleur=couleur;
		setLayout(new GridLayout(1,0));		// on crée la case 
		switch (couleur) {
		case BLANC :				// on colorie la case créée en blanc
			setForeground(Color.WHITE);
			setBackground(new Color(220, 220, 220));
			break;
		case GRIS :				// on colorie la case créée en gris
			setForeground(Color.GRAY);
			setBackground(new Color(220, 220, 220));
			break;
		}
	}
	
	private void initialisationCouleur(){		// c'est une méthode qui nous permet d'initialiser les couleurs des cases du plateau en blanc ou gris
		switch (couleur) {
		case BLANC :
			setForeground(Color.WHITE);
			setBackground(new Color(220, 220, 220));
			break;
		case GRIS :
			setForeground(Color.GRAY);
			setBackground(new Color(220, 220, 220));
			break;
		}
	}
	
	public Couleur_du_case getCouleur() {  // méthode qui retourne la couleur d'une case du plateau
		return couleur;
	}
	
	

	public boolean isSelectionnee() {	// méthode qui permet de savoir si une case est sélectionnée par le joueur ou non
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {  // si selectionnee=true, la case est coloriée en bleue sinon on laisse la case dans sa couleur d'origine
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			initialisationCouleur();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){		// méthode qui rend le plateau plus "joli" à l'aide d'éléments graphiques
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
