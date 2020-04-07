import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;


public class Cases_du_plateau extends JPanel {
	
	private Couleur_du_pion couleur;
	private boolean selectionnee;
	
	public Cases_du_plateau(Couleur_du_pion couleur){
		setLayout(new GridLayout(1,0));
		this.couleur=couleur;
		initialisationCouleur();
	}
	
	private void initialisationCouleur(){
		switch(couleur){
		case BLANC :
			setBackground(Color.WHITE);
			setForeground(new Color(200, 200, 200));
			
			break;
		case NOIR :
			setBackground(Color.BLACK);
			setForeground(new Color(20, 20, 20));
			break;
			
		case GRIS :
			setBackground(new Color(200, 200, 200));
			setForeground(new Color(20, 20, 20));
			break;
			
		case VERT :
			setBackground(Color.GREEN);
			setForeground(new Color(20, 20, 20));
			break;
		
		case BLEU :
			setBackground(Color.BLUE);
			setForeground(new Color(20, 20, 20));
			break;
		
		case ROUGE :
			setBackground(Color.RED);
			setForeground(new Color(20, 20, 20));
			break;
		
		case JAUNE :
			setBackground(Color.YELLOW);
			setForeground(new Color(20, 20, 20));
			break;
			
		case ORANGE :
			setBackground(Color.ORANGE);
			setForeground(new Color(20, 20, 20));
			break;
		}
	}
	
	public Couleur_du_pion getCouleur() {
		return couleur;
	}
	
	

	public boolean isSelectionnee() {
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {  // si selectionnee=true, case coloriée en bleue sinon on laisse la case dans sa couleur d'origine
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
	public void paintComponent(Graphics g){
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
