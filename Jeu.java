import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.UIManager;



public class Jeu {

	
	public static void main(String[] args) {
		
		JFrame plateau_de_jeu = new JFrame();
		plateau_de_jeu.setSize(600, 600);
		plateau_de_jeu.setLocationRelativeTo(null);
		plateau_de_jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plateau_de_jeu.add(new Plateau(19));
		plateau_de_jeu.setVisible(true);

	}

}
