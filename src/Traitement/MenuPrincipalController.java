/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Traitement;

import Traitement.Joueur;
import Traitement.PartieNormal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karimNasri
 */
public class MenuPrincipalController implements Initializable {
    @FXML
    private Button newGame;
    @FXML
    private Button bestScor;
    @FXML
    private Button quit;
    private Label label;
    
    private HashMap<String,HashMap<String,PartieNormal>> listPartie;
    private TreeSet<Joueur> listJoueur;
    private PartieNormal partie;
     TextField pass;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     
       
    }    

    @FXML
    private void newGame(MouseEvent event) throws IOException {
     try {
        loadJoueur();
        loadPartie();
       } catch (IOException ex) {
          Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
  
        FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/form2.fxml"));
        Parent root = (Parent) loader.load();
        Form2Controller fc  = (Form2Controller)loader.getController();
       
        fc.setListJoueur(listJoueur);
        fc.setListPartie(listPartie);
        
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene); 
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.show(); 
        ////
       
        
         
        
            
                
    }

    public TreeSet<Joueur> getListJoueur() {
        return listJoueur;
    }

    public HashMap<String, HashMap<String, PartieNormal>> getListPartie() {
        return listPartie;
    }
    
    
    
    
    private void submit(ActionEvent event) {
        String labels = pass.getText();
        label.setText(labels);
    }

 public void loadPartie() throws IOException{
     
     ObjectInputStream objectinputstream = null;
try {
    FileInputStream streamIn = new FileInputStream("SavedFiles/listPartie.dat");
    objectinputstream = new ObjectInputStream(streamIn);
   listPartie = (HashMap<String,HashMap<String,PartieNormal>>) objectinputstream.readObject();
    
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if(objectinputstream != null){
        objectinputstream .close();
    } 
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

   
    private void saveJoueur() throws IOException {
       ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream("SavedFiles/listJoueur.dat", true);
         oos = new ObjectOutputStream(fout);
         
        oos.writeObject(listJoueur);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(oos  != null){
            oos.close();
        } 
}   
    
}

    public void setListJoueur(TreeSet<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }

    
public void initialiazListePartie(String url) throws IOException{
 ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream(url, true);
         oos = new ObjectOutputStream(fout);
         HashMap<String,HashMap<String,PartieNormal>> lJ= new HashMap<String,HashMap<String,PartieNormal>>();
         oos.writeObject(lJ);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(oos  != null){
            oos.close();
        } 
}   
}
public void initialiazListeJoueur(String url) throws IOException{
 ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream(url, true);
         oos = new ObjectOutputStream(fout);
        SortedSet<Joueur> lJ = new TreeSet<>();
         oos.writeObject(lJ);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(oos  != null){
            oos.close();
        } 
}   
}

    @FXML
    private void initializeTout(MouseEvent event) throws IOException {
        initialiazListeJoueur("SavedFiles/ListJoueur.dat");
        initialiazListePartie("SavedFiles/ListPartie.dat");
    }

    @FXML
    private void bestScor(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/Classement.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene); 
        stage.show();
    }

    @FXML
    private void loadJeu(MouseEvent event) throws IOException {
         try {
        loadJoueur();
        loadPartie();
       } catch (IOException ex) {
          Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
  
        FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/formLoad.fxml"));
        Parent root = (Parent) loader.load();
        FormLoadController fc  = (FormLoadController)loader.getController();
       
        fc.setListJoueur(listJoueur);
        fc.setListPartie(listPartie);
        
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene); 
        stage.show(); 
        ////
       
        
         
        
        
    }

    @FXML
    private void close(ActionEvent event) {
          Platform.exit();
    }
 
}
 