/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulateur;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Rachid_2
 */
public class FrameCard extends javax.swing.JFrame {
   // private ImageIcon im;
    int nbLigne=0;
    int nbColonne=0;
    JLabel myLabel;
    //private Image mon_image;
         
    /**
     * Creates new form FrameCard
     */
    public FrameCard() {
        initComponents();
        char[][] matrice;
        String urlFromage, urlSabelette, urlPorte,urlHerbe, urlMur,urlVide;
        /*
        
        • * : un mur URL MUR
        • G : une zone d'herbe URL HERBE
        • ' ' : une zone de déplacement URL VIDE
        • D : les points d'apparition des personnages URL PORTE
        • A : les points d'arrivée des personnages. URL FROMAGE
        
        */
        urlFromage="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\fromage.png";
        urlSabelette="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\sabelette.png";
        urlPorte="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\porte.png";
        urlHerbe="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\herbe.png";
        urlMur="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\mur.png";
        urlVide="C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\img\\vide.png";
        
        matrice=myMatrice("C:\\Users\\Rachid_2\\Documents\\CoursESGI\\Master\\M1\\S1\\Semaine Thematique\\Projet\\map.txt");
        /*
        
        • * : un mur URL MUR
        • G : une zone d'herbe URL HERBE
        • ' ' : une zone de déplacement URL VIDE
        • D : les points d'apparition des personnages URL PORTE
        • A : les points d'arrivée des personnages. URL FROMAGE
        
        */
        char result;
        //remplissage du JPanel
       for(int countC=0;countC<nbColonne;countC++)
       {
           for(int countL=0;countL<nbLigne;countL++)
           {
              result= matrice[countL][countC];
              switch(result) {
                  //si la valeur est '*' on affiche un mur
                  //a la localisation x=index de la colonne*22
                                    //y= index de la ligne*222
                case ('*'):myLabel=new JLabel(new ImageIcon(urlMur));
                           myLabel.setSize(100,100);
                           myLabel.setLocation(countC*25, countL*25);
                   break;
                   //si la valeur est ' ' on affiche un l'image vide
                  //a la localisation x=index de la colonne*22
                                    //y= index de la ligne*222
                case (' '):myLabel=new JLabel(new ImageIcon(urlVide));
                            myLabel.setSize(100,100);
                            myLabel.setLocation(countC*25, countL*25);
                   break;
                    //si la valeur est 'G' on affiche de l'herbe
                  //a la localisation x=index de la colonne*22
                                    //y= index de la ligne*222
                case ('G'):myLabel=new JLabel(new ImageIcon(urlHerbe));
                           myLabel.setSize(100,100);
                           myLabel.setLocation(countC*25, countL*25);
                   break;
                    //si la valeur est 'A' on affiche un fromage
                  //a la localisation x=index de la colonne*22
                                    //y= index de la ligne*222
                case ('A'):myLabel=new JLabel(new ImageIcon(urlFromage));
                           myLabel.setSize(100,100);
                           myLabel.setLocation(countC*25, countL*25);
                   break;
                    //si la valeur est 'D' on affiche une porte
                  //a la localisation x=index de la colonne*22
                                    //y= index de la ligne*222
                case ('D'):myLabel=new JLabel(new ImageIcon(urlPorte));
                           myLabel.setSize(100,100);
                           myLabel.setLocation(countC*25, countL*25);
                   break;
    

                            }
              jpMyPanel.add(myLabel);
              
            }
       } 
    }
    
    public char [][] myMatrice(String url)
    {
        
                String chaine="";
		String fichier =url;
		char[][] matrice;
                String ligne="";
                String contenu="";
                
                int l=0;
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			while ((ligne=br.readLine())!=null){
                            //l++ afin de savoir combien de ligne on a
                            l++;
				//afin d'avoir tout le contenu du fichier texte
                                //dans une chaine de caractere
				chaine+=ligne;
                                //afin davoir la taille d'une ligne (donc de nb de colonne ds la matrice)
                                //grace a contenu.length();
                                contenu=ligne;
			}
			br.close(); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
              
                 matrice= new char[l][contenu.length()];
 
                 int li=0;
                 int colonne=0;
                 
                    //remplissage de la matrice
                     for(int count=0; count<chaine.length();count++)
                     {
                         //si on arrive a la fin d'une ligne on incremente la ligne
                        if(colonne==contenu.length())
                        {
                            li++;
                            //count+=colonne;
                           colonne=0;
                        }
                       
                        matrice[li][colonne]=chaine.charAt(count);
                        //incrementation de la colonne a chaque passage
                        colonne++;
                     }
                     
                     nbColonne=contenu.length();
                     nbLigne=l;
                     return matrice;
                     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpMyPanelLayout = new javax.swing.GroupLayout(jpMyPanel);
        jpMyPanel.setLayout(jpMyPanelLayout);
        jpMyPanelLayout.setHorizontalGroup(
            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jpMyPanelLayout.setVerticalGroup(
            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpMyPanel;
    // End of variables declaration//GEN-END:variables
}
