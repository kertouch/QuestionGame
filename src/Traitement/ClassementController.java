/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Traitement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


 /**
 * FXML Controller class
 *
 * @author karimNasri
 */
public class ClassementController implements Initializable {
private TreeSet<Joueur> listJoueur;
   
    @FXML
    private VBox names;
    @FXML
    private VBox scors;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   try {
   //TODO
        loadJoueur();
   } catch (IOException ex) {
       Logger.getLogger(ClassementController.class.getName()).log(Level.SEVERE, null, ex);
   }
    
    
    classement();
    
    
    }    

    public void setListJoueur(TreeSet<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }

    public TreeSet<Joueur> getListJoueur() {
        return listJoueur;
    }
    
    public void classement(){
        int i = 0;
        Iterator it = listJoueur.iterator();
        while((it.hasNext()&&(i<10))){
         Joueur j = (Joueur)it.next();
         Label lbName = new Label(j.getNom());
         Label lbScor = new Label(""+j.getScore());
         names.getChildren().add(lbName);
         scors.getChildren().add(lbScor);
         i++;
        }
    
    }
    
    public void loadJoueur() throws IOException{
     
     ObjectInputStream objectinputstream = null;
try {
    FileInputStream streamIn = new FileInputStream("SavedFiles/listJoueur.dat");
   
    objectinputstream = new ObjectInputStream(streamIn);
     
    listJoueur = (TreeSet<Joueur>) objectinputstream.readObject();
   
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if(objectinputstream != null){
        objectinputstream .close();
    } 
}
    
}
}
