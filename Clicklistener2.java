import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Clicklistener2 implements ActionListener{ //ActionListener du bouton pour creer une nouvelle JFrame qui aura le jeu pour 2 joueurs
	
	public void actionPerformed(ActionEvent e) {
        JFrame plateau_de_jeu=new JFrame("Dames chinoises"); 
        Plateau plateau = new Plateau(2);
		plateau_de_jeu.add(new Plateau(2)); 
        plateau_de_jeu.setSize(800,800);
		plateau_de_jeu.setLocationRelativeTo(null);
		plateau_de_jeu.setVisible(true);
		
	}
}



