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
	
	public Cases_du_plateau(Couleur_du_case couleur){
		setLayout(new GridLayout(1,0));
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
	
	private void initialisationCouleur(){
		switch(couleur){
		case BLANC :
			setBackground(Color.WHITE);
			setForeground(new Color(200, 200, 200));
			
			break;
			
		case GRIS :
			setBackground(Color.GRAY);
			setForeground(new Color(200, 200, 200));
			break;
		}
	}
	
	public Couleur_du_case getCouleur() {
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
