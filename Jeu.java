import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.border.EmptyBorder;

public class Jeu{
    
    public static void main(String[] arg){
		//On cree une JFrame pour choisir le nombre de joueurs
		JFrame plateau_de_jeu = new JFrame("Dames chinoises");
		JPanel menu = new JPanel();
		JLabel nb = new JLabel("Veuillez choisir le nombre de joueurs: ");
		JPanel menu1 = new JPanel();
		menu1.setBorder(new EmptyBorder(new Insets(20, 120, 10, 20)));
		BoxLayout boxlayout = new BoxLayout(menu1,BoxLayout.Y_AXIS);
		//On cree des JButtons pour pouvoir jouer en fonction de nombre de joueurs
		JButton nb2 = new JButton("2");
		JButton nb3 = new JButton("3");
		JButton nb4 = new JButton("4");
		JButton nb6 = new JButton("6");
		menu.add(nb);
		menu1.setLayout(boxlayout);
		menu1.add(nb2);
		menu1.add(Box.createRigidArea(new Dimension(0, 10))); //Faire un peu d'espace entre les JButtons
		menu1.add(nb3);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu1.add(nb4);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu1.add(nb6);
		//Chaque JButton peut creer une nouvelle JFrame pour pouvoir jouer en fonction de nombre de joueurs
		nb2.addActionListener(new Clicklistener2()); 
		nb3.addActionListener(new Clicklistener3());
		nb4.addActionListener(new Clicklistener4());
		nb6.addActionListener(new Clicklistener6());
		plateau_de_jeu.add(menu,BorderLayout.NORTH);
		plateau_de_jeu.add(menu1);
		plateau_de_jeu.setSize(300,260);
		plateau_de_jeu.setLocationRelativeTo(null);
		plateau_de_jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plateau_de_jeu.setVisible(true);
	}

}
