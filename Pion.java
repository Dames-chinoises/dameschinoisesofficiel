import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;


public class Pion extends JPanel {

	private static final long serialVersionUID = 1436178861615738480L;

	private Couleur_du_pion couleur;
	


	public Pion(Couleur_du_pion couleur) { // on crée l'objet Pion
		
		this.couleur = couleur;
		setOpaque(false);
		switch (couleur) {	// on colorie le pion en noir ou vert ou bleu ou rouge ou jaune ou rose en fonction de la couleur voulue
		case NOIR :
			setForeground(new Color(1, 1, 1));
			setBackground(new Color(100, 100, 100));
			break;
		
		case VERT :
			setForeground(Color.GREEN);
			setBackground(new Color(20, 20, 20));
			break;
		
		case BLEU :
			setForeground(Color.BLUE);
			setBackground(new Color(20, 20, 20));
			break;
		
		case ROUGE :
			setForeground(Color.RED);
			setBackground(new Color(20, 20, 20));
			break;
		
		case JAUNE :
			setForeground(Color.YELLOW);
			setBackground(new Color(20, 20, 20));
			break;
			
		case ROSE :
			setForeground(Color.PINK);
			setBackground(new Color(20, 20, 20));
			break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){ 	// cette méthode permet de donner un visuel agréable au component Pion grâce à des éléments graphiques
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
		g.fillOval(5, 5, getWidth()-10, getHeight()-10);

	}

	public Couleur_du_pion getCouleur() {  // cette méthode retourne la couleur du pion 
		return couleur;
	}

	

}
