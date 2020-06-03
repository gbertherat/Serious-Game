package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Factory;
import v1.Defi;
import v1.Question;

public class RepondreDefi {
	private GUI myGui;
	private JFrame frame;
	private static int nbPress = 0;

	public RepondreDefi(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int id) {
		if(GUI.idSession != 0) {
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(1024,20)));
			
			Defi defiSel = myGui.getDefi(id);
			Question question = defiSel.getQuestion();
		
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			
			JLabel titre = Factory.addLabel("Défi accepté", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// TITRE QUESTION //
			JPanel titreQuestionPanel = Factory.addPanel();
			titreQuestionPanel.setMaximumSize(new Dimension(460, 20));
			titreQuestionPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel titreQuestion = Factory.addLabel("Titre: ", 14, true);
			titreQuestionPanel.add(titreQuestion);
			panel.add(titreQuestionPanel);
			panel.add(Box.createRigidArea(new Dimension(500,5)));
			
			JPanel fieldTitrePanel = Factory.addPanel();
			fieldTitrePanel.setMaximumSize(new Dimension(460, 30));
			fieldTitrePanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JTextField fieldTitre = Factory.addField(120, 30, false);
			fieldTitre.setText(question.getTitre());
			fieldTitrePanel.add(fieldTitre);
			panel.add(fieldTitrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// CATEGORIE //
			JPanel doublePanel = Factory.addPanel();
			doublePanel.setMaximumSize(new Dimension(460, 30));
			doublePanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel categorieLabel = Factory.addLabel("Catégorie:", 14, true);
			categorieLabel.setMaximumSize(new Dimension(290, 30));
			doublePanel.add(categorieLabel);
			
			JLabel pointsLabel = Factory.addLabel("Points: 3", 15, true);
			doublePanel.add(pointsLabel);
			panel.add(doublePanel);
			
			JPanel boxPanel = Factory.addPanel();
			boxPanel.setMaximumSize(new Dimension(460, 30));
			boxPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JComboBox<String> categorieBox = Factory.addBox(myGui.categories, 200, 30);
			categorieBox.setSelectedItem(question.getCategorie());
			boxPanel.add(categorieBox);
			
			boxPanel.add(Box.createRigidArea(new Dimension(102, 20)));
			
			JSpinner pointsInput = Factory.addSpiner(40, 30, 1, 10, 3);
			pointsInput.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					pointsLabel.setText("Points: " + String.valueOf(pointsInput.getValue()));
				}
			});
			boxPanel.add(pointsInput);
			panel.add(boxPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// CONTENU //
			JPanel contenuPanel = Factory.addPanel();
			contenuPanel.setMaximumSize(new Dimension(460, 30));
			contenuPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JLabel contenuLabel = Factory.addLabel("Contenu:", 14, true);
			contenuPanel.add(contenuLabel);
			panel.add(contenuPanel);
			
			JTextArea contenuField = Factory.addTextArea(440, 80, false);
			contenuField.setText(question.getContenu());
			JScrollPane scrollPanel = Factory.addScroll(contenuField, 440, 80);
			panel.add(scrollPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// REPONSE //
			JPanel reponsePanel = Factory.addPanel();
			reponsePanel.setMaximumSize(new Dimension(460, 30));
			reponsePanel.add(Box.createRigidArea(new Dimension( 10, 20)));
			
			JLabel reponseLabel = Factory.addLabel("Réponse:", 14, true);
			reponsePanel.add(reponseLabel);
			panel.add(reponsePanel);
			
			JTextArea reponseField = Factory.addTextArea(440, 80, true);
			JScrollPane reponseScroll = Factory.addScroll(reponseField, 440, 80);
			panel.add(reponseScroll);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// EXPEDITEUR & DESTINATAIRE //
			JPanel byPanel = Factory.addPanel();
			byPanel.setMaximumSize(new Dimension(460, 30));
			byPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel byLabel = Factory.addLabel("Expéditeur:", 14, true);
			byLabel.setMaximumSize(new Dimension(230, 30));
			byPanel.add(byLabel);
			panel.add(byPanel);
			
			JPanel boxesPanel = Factory.addPanel();
			boxesPanel.setMaximumSize(new Dimension(460, 30));
			boxesPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel expediteurLabel = Factory.addLabel(defiSel.getExpediteur().getUsername(), 15, false);
			boxesPanel.add(expediteurLabel);
			panel.add(boxesPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// BOUTONS : VALIDER & SUPPRIMER //
			JPanel buttonsPanel = Factory.addPanel();
			buttonsPanel.setMaximumSize(new Dimension(460, 50));
			buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JLabel messageLabel = Factory.addLabel("", 12, true);
			messageLabel.setForeground(Color.red);
			
			JButton validButton = Factory.addButton("Valider!", 90, 30);
			JButton delButton = Factory.addButton("Abandonner", 110, 30);
			delButton.setForeground(Color.red);
			buttonsPanel.add(validButton);
			buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			buttonsPanel.add(delButton);
			buttonsPanel.add(Box.createRigidArea(new Dimension(5, 10)));
			buttonsPanel.add(messageLabel);
			panel.add(buttonsPanel);

			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// BOUTON : RETOUR //
			panel.add(Box.createVerticalGlue());
			JPanel retourPanel = Factory.addPanel();
			JButton back = Factory.addButton("Retour", 100, 40);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					panel.repaint();
					new AccepterDefi(myGui, frame).repaint(1);
				}
			});
			retourPanel.add(back);
			retourPanel.add(Box.createHorizontalGlue());
			panel.add(retourPanel);
			
			panel.repaint();
		}
	}
}
