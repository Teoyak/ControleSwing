package javaapplication25;

import static java.awt.Color.BLACK;
import static java.awt.Color.GREEN;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.Border;

public class Convertisseur extends JFrame
{
    /// Le convertisseur est basé sur l'exercice 5 du TP3 -> factoriel
    /// Quelques menus ajustements ont étés effectués
    
    public Convertisseur (String name)
    {
	setTitle(name);
        construc();       
    }
    
    private void construc() // Construc general
    {
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(false);
	setContentPane(Contenu());        
                
        this.setVisible(true);
    }
	
    Container Contenu()
    {    
        //Placement
        getContentPane().setLayout(new FlowLayout());
        
        //Espace disponible
	JTextField textNum = new JTextField(5);
        getContentPane().add(textNum);
        textNum.setText("0");
        
        //Bouton pour calculer
	JButton calcul = new JButton();
        calcul.setText("Conversion");
        getContentPane().add(calcul);
        
        //Emplacement résultat
        JTextField boiteResultat = new JTextField();
        getContentPane().add(boiteResultat);
        boiteResultat.setText(" Résultat ");
	boiteResultat.setEditable(false);
	boiteResultat.setBackground(GREEN);
        Border bordure = BorderFactory.createLineBorder(BLACK, 1);
	boiteResultat.setBorder(bordure);
        
        //Action du bouton
	calcul.addActionListener(new ActionListener() 
	{
            public void actionPerformed(ActionEvent e)
            {
                String name;
                int n = -1;

                name = textNum.getText();
                n = Integer.parseInt(name); // Passer de String à Int

                //Le nombre est-il dans le bonne tranche ?
                if (n > -273)
                {
                    int resultatInt = n*9/5+32;
                    String resultatString = String.valueOf(resultatInt); // Passer de Int à String
                    
                    boiteResultat.setText(" " + resultatString + " °F"); // Mise à jour du résultat
                    calcul.setText(name + " °C"); //Mise à jour du bouton
                }

                else // Message d'erreur
                    JOptionPane.showMessageDialog(null, "La temperature ne peut pas etre inferieure au zero absolut.", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            }
	});
        return getContentPane();
    }
    
}
