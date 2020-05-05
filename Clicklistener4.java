import java.awt.event.*;
import javax.swing.*;

public class Clicklistener4 implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
        JFrame plateau_de_jeu=new JFrame("Dames chinoises");
		plateau_de_jeu.add(new Plateau(4));
        plateau_de_jeu.setSize(600,600);
		plateau_de_jeu.setLocationRelativeTo(null);
		plateau_de_jeu.setVisible(true);

	}
}


