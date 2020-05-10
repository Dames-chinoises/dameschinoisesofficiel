import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.border.EmptyBorder;

public class Jeu extends JFrame{
    
    public Jeu(){
		//On cree une JFrame pour choisir le nombre de joueurs
		JLabel nb = new JLabel("Veuillez choisir le nombre de joueurs: ");
		JLabel mode = new JLabel("Veuillez choisir le mode de jeu: ");
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		BoxLayout boxlayout1 = new BoxLayout(menu1, BoxLayout.Y_AXIS);
		BoxLayout boxlayout2 = new BoxLayout(menu2, BoxLayout.Y_AXIS);
		menu1.setLayout(boxlayout1);
		menu1.setBorder(new EmptyBorder(new Insets(0, 20, 0, 0))); 
		menu2.setLayout(boxlayout2);
		menu2.setBorder(new EmptyBorder(new Insets(0, 0, 0, 20)));
		//On cree des JRadiosButtons pour pouvoir jouer en fonction de nombre de joueurs et du mode de jeu
		JRadioButton nb2 = new JRadioButton("2");
		JRadioButton nb3 = new JRadioButton("3");
		JRadioButton nb4 = new JRadioButton("4");
		JRadioButton nb6 = new JRadioButton("6");
		ButtonGroup group1= new ButtonGroup();
		group1.add(nb2);
		group1.add(nb3);
		group1.add(nb4);
		group1.add(nb6);
		ButtonGroup group2= new ButtonGroup();
		JRadioButton modefacile = new JRadioButton("Facile");
		JRadioButton modedifficile = new JRadioButton("Difficile");
		group2.add(modefacile);
		group2.add(modedifficile);
		menu1.add(nb);
		menu1.add(Box.createRigidArea(new Dimension(0, 10))); //On ajoute un peu d'espace entre les JRadioButton
		menu1.add(nb2);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu1.add(nb3);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu1.add(nb4);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu1.add(nb6);
		menu1.add(Box.createRigidArea(new Dimension(0, 10)));
		menu2.add(mode);
		menu2.add(Box.createRigidArea(new Dimension(0, 10)));
		menu2.add(modefacile);
		menu2.add(Box.createRigidArea(new Dimension(0, 10)));
		menu2.add(modedifficile);
		menu2.add(Box.createRigidArea(new Dimension(0, 20)));
		//Le JButton modejeubutton cree une nouvelle JFrame pour pouvoir jouer en fonction de nombre de joueurs et le mode de jeu soit on affiche les movements possibles en bleu ou non
		JButton modejeubutton=new JButton("Set");
		menu2.add(modejeubutton);
		modejeubutton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			boolean modejeu=true;
			JFrame plateau_de_jeu=new JFrame("Dames chinoises"); //On cree le JFrame pour ajouter le jeu
			if(modefacile.isSelected()){
				modejeu=true;
				if(nb2.isSelected()){
					Plateau plateau = new Plateau(2,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb3.isSelected()){
					Plateau plateau = new Plateau(3,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb4.isSelected()){
					Plateau plateau = new Plateau(4,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb6.isSelected()){
					Plateau plateau = new Plateau(6,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);	
				}
			}else if(modedifficile.isSelected()){
				modejeu=false;
				if(nb2.isSelected()){
					Plateau plateau = new Plateau(2,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb3.isSelected()){
					Plateau plateau = new Plateau(3,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb4.isSelected()){
					Plateau plateau = new Plateau(4,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);
				}else if(nb6.isSelected()){
					Plateau plateau = new Plateau(6,modejeu);	//Creation du jeu
					plateau_de_jeu.add(plateau,BorderLayout.CENTER);
					JLabel tourj = plateau.getTourActuel(); //JLabel pour obtenir le tour actuel
					JPanel paneltours=new JPanel();
					paneltours.add(tourj);
					plateau_de_jeu.add(paneltours,BorderLayout.NORTH);	
				}
			}
			plateau_de_jeu.setSize(800,800);
			plateau_de_jeu.setLocationRelativeTo(null);
			plateau_de_jeu.setVisible(true);
			 
		}
	});
		
		add(menu1,BorderLayout.WEST);
		add(menu2,BorderLayout.EAST);
	
}
	
	public static void main(String[] arg){
		Jeu plateau_de_jeu = new Jeu();
		plateau_de_jeu.setTitle("Dames chinoises");
		plateau_de_jeu.setSize(500,210);
		plateau_de_jeu.setLocationRelativeTo(null);
		plateau_de_jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plateau_de_jeu.setVisible(true);
	}

}
	


	

