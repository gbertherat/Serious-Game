package v1;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La classe GUI permet la création de l'interface utilisateur, elle contient aussi le main()
 * @author Guillaume
 */
public class GUI{	
	// MAIN //
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Serious-Game by Bertherat Guillaume");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		
		main.add(Box.createRigidArea(new Dimension(500,30)));
		
		JPanel titrePanel = new JPanel();
		titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
		JLabel titre = new JLabel("Serious-Game");
		titre.setFont(new Font("Arial", Font.BOLD, 21));
		titrePanel.add(titre);
		main.add(titrePanel);
		
		main.add(Box.createRigidArea(new Dimension(500,80)));
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		JButton seConnecter = new JButton("Se connecter");
		seConnecter.setMinimumSize(new Dimension(150,50));
		seConnecter.setMaximumSize(new Dimension(150,50));
		seConnecter.setPreferredSize(new Dimension(150,50));
		buttonPanel1.add(seConnecter);
		main.add(buttonPanel1);
		
		frame.getContentPane().add(main);
		frame.setVisible(true);
		
	}
}
