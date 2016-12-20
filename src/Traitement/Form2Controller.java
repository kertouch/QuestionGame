/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Traitement;

import Exceptions.NameException;
import Exceptions.NameNoneExist;
import Exceptions.PartieExistException;
import Exceptions.PartieNonExistException;
import Exceptions.SaisieException;
import Exceptions.SavePlayer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author karimNasri
 */
public class Form2Controller implements Initializable {
    @FXML
    private TextField nomPlayer1;
    private ChoiceBox<String> domainChoice3Player1;
    private ChoiceBox<String> domainChoice2Player1;
    private ChoiceBox<String> domainChoice1Player1;
    @FXML
    private TextField nomPlayer2;
    private ChoiceBox<String> domainChoice2Player2;
    private ChoiceBox<String> domainChoice1Player2;
    private ChoiceBox<String> domainChoice3Player2;
    @FXML
    private Label choixJoueur1;
    @FXML
    private AnchorPane infoPlayer1;
    @FXML
    private Button changeDomain1;
    @FXML
    private AnchorPane choixDomains1;
    @FXML
    private Button savePlayer1;
    @FXML
    private Label choixJoueur2;
    @FXML
    private AnchorPane infoPlayer2;
    @FXML
    private Button changeDomain2;
    private VBox choixDomains2;
    @FXML
    private Button savePlayer2;
    @FXML
    private Button newPlayer1;
    @FXML
    private Button oldPlayer1;
    @FXML
    private Button oldPlayer2;
    @FXML
    private Button newPlayer2;
    private Label player1Choix1;
    private Label player1Choix2;
    private Label player1Choix3;
    private Label player2Choix3;
    private Label player2Choix2;
    private Label player2Choix1;
    
    private HashMap<String,HashMap<String,PartieNormal>> listPartie;
    private TreeSet<Joueur> listJoueur;
    
    private int newJ1;
    private int newJ2;
    @FXML
    private AnchorPane choixDomain1;
    @FXML
    private CheckBox cinema1;
    @FXML
    private CheckBox sport1;
    @FXML
    private CheckBox cg1;
    @FXML
    private CheckBox hist1;
    @FXML
    private CheckBox geo1;
    @FXML
    private CheckBox musique1;
    @FXML
    private CheckBox science1;
    @FXML
    private AnchorPane choixDomain2;
    @FXML
    private CheckBox science2;
    @FXML
    private CheckBox musique2;
    @FXML
    private CheckBox geo2;
    @FXML
    private CheckBox Hist2;
    @FXML
    private CheckBox cg2;
    @FXML
    private CheckBox sport2;
    @FXML
    private CheckBox cinema2;
    
    private Boolean modifyDomain1;
    private Boolean modifyDomain2;
    private ObservableSet<CheckBox> selectedCheckBoxes1 = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes1 = FXCollections.observableSet();
    private ObservableSet<CheckBox> selectedCheckBoxes2 = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes2 = FXCollections.observableSet();
    
     private final int maxNumSelected =  3; 
    
     private int i1;
     private int i2;
     private Joueur j1;
     private Joueur j2;
    @FXML
    private Button save;
    private boolean save1;
    private boolean save2;
    private boolean load;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        infoPlayer1.setVisible(false);
        infoPlayer2.setVisible(false);
        load=false;
        save.setDisable(true);
    
        ///INitalisation des choix vers de domain
       
        unselectedCheckBoxes1.add(cg1);
        unselectedCheckBoxes1.add(sport1);
        unselectedCheckBoxes1.add(cinema1);
         unselectedCheckBoxes1.add(hist1);
        unselectedCheckBoxes1.add(musique1);
        unselectedCheckBoxes1.add(geo1);
        unselectedCheckBoxes1.add(science1);
        
         unselectedCheckBoxes2.add(cg2);
        unselectedCheckBoxes2.add(sport2);
        unselectedCheckBoxes2.add(cinema2);
         unselectedCheckBoxes2.add(Hist2);
        unselectedCheckBoxes2.add(musique2);
        unselectedCheckBoxes2.add(geo2);
        unselectedCheckBoxes2.add(science2);
        choixDomain1.setVisible(false);
        choixDomain2.setVisible(false);
        ////////////
//    
        newJ1 =0;
        newJ2 =0;
        modifyDomain1 =false;
        modifyDomain2 = false;
        save1=false;
        save2=false;
        
    }    

    @FXML
    private void newPlayer1(MouseEvent event) {
       //  initializListJoueur();
        newPlayer1.setVisible(false);
        oldPlayer1.setVisible(false);
        choixJoueur1.setText("Nouveau");
         changeDomain1.setVisible(false);
         choixDomain1.setVisible(true);
         infoPlayer1.setVisible(true);
         newJ1 = 1;
         savePlayer1.setDisable(true);
         
         
    }

    @FXML
    private void oldPlayer1(MouseEvent event) {
        
        newPlayer1.setVisible(false);
        oldPlayer1.setVisible(false);
        choixJoueur1.setText("Ancien");
         changeDomain1.setVisible(true);
         choixDomain1.setVisible(false);
         infoPlayer1.setVisible(true);
         newJ1 = 0;
    }

    @FXML
    private void newPlayer2(MouseEvent event) {
        newPlayer2.setVisible(false);
        oldPlayer2.setVisible(false);
        choixJoueur2.setText("Nouveau");
         changeDomain2.setVisible(false);
         choixDomain2.setVisible(true);
         infoPlayer2.setVisible(true);
         newJ2 = 1;
         savePlayer2.setDisable(true);
    }

    @FXML
    private void oldPlayer2(MouseEvent event) {
        newPlayer2.setVisible(false);
        oldPlayer2.setVisible(false);
        choixJoueur2.setText("Ancien");
         changeDomain2.setVisible(true);
         choixDomain2.setVisible(false);
         infoPlayer2.setVisible(true);
         newJ2 = 0;
         
    }

    @FXML
    private void save(MouseEvent event) throws IOException, PartieNonExistException {
        try {
            // creatFile("E:\\listJoueur.dat");
            CheckBox cb1;
            CheckBox cb2;
            ArrayList<Domains> lD1=new ArrayList<>();;
            ArrayList<Domains> lD2=new ArrayList<>();;
            if(!save1)throw new SavePlayer(nomPlayer1.getText()+" ");
            if(!save2)throw new SavePlayer(nomPlayer2.getText()+" ");
            if(modifyDomain1|| newJ1 == 1 ){
                Iterator it = selectedCheckBoxes1.iterator();
              
                cb1 = new CheckBox();
                while(it.hasNext()){
                    cb1 =(CheckBox) it.next();
                    lD1.add(extractDomain(cb1.getText()));
                }
                j1.setDomainePredilection(lD1);
            };
            if((modifyDomain2)|| newJ2 == 1){
                Iterator it = selectedCheckBoxes2.iterator();
              
                cb2 = new CheckBox();
                while(it.hasNext()){
                    cb2 =(CheckBox) it.next();
                    lD2.add(extractDomain(cb2.getText()));
                }
                j2.setDomainePredilection(lD2);
                
            };
            PartieNormal pn;
            saveJoueur(listJoueur,"SavedFiles/listJoueur.dat");
            try{
            if((listPartie.containsKey(j1.getNom()) && listPartie.containsKey(j2.getNom())&& listPartie.get(j1.getNom()).containsKey(j2.getNom())&&listPartie.get(j2.getNom()).containsKey(j1.getNom())))throw new PartieNonExistException();
           
                
            }catch(PartieNonExistException p){
            }finally{
                
                
                 if((listPartie.containsKey(j1.getNom()) && listPartie.containsKey(j2.getNom())&& listPartie.get(j1.getNom()).containsKey(j2.getNom())&&listPartie.get(j2.getNom()).containsKey(j1.getNom()))){
                   pn = listPartie.get(j1.getNom()).get(j2.getNom());
                    }else{
                     pn = new PartieNormal(j1,j2, 21,"donnees.txt");
                    }
                    if(modifyDomain1 )
                         pn.getJoueur1().setDomainePredilection(lD1);
                     if(modifyDomain2 )
                        pn.getJoueur2().setDomainePredilection(lD2);
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/ElementGraphic/partie2.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("the Y game");
                        stage.setMinHeight(800);
                        stage.setMinWidth(1300);
                        stage.setX(0);
                        stage.setY(0);
                        stage.setFullScreen(true);
                        stage.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Partie2Controller controller = (Partie2Controller)loader.getController();
                        controller.setPartie(pn);
                        controller.setListPartie(listPartie);
                        controller.setListJoueur(listJoueur);
            }
            /*
            if((newJ1 == 1 )&&(newJ2 == 1)||(newJ1 == 1 )&&(newJ2 == 0) ||(newJ1 == 0 )&&(newJ2 == 1)&&(!load)){
                PartieNormal pn = new PartieNormal(j1,j2, 21,"donnees.txt");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/ElementGraphic/partie2.fxml"));
                Parent root = (Parent) loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("the Y game");
                stage.setMinHeight(800);
                 stage.setMinWidth(1300);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Partie2Controller controller = (Partie2Controller)loader.getController();
                controller.setPartie(pn);
                controller.setListPartie(listPartie);
                controller.setListJoueur(listJoueur);
            }else{
                if(newJ1 == 0 && newJ2 == 0){
                    try {
                        
                        if(!(listPartie.containsKey(j1.getNom()) && listPartie.containsKey(j2.getNom())&& listPartie.get(j1.getNom()).containsKey(j2.getNom())&&listPartie.get(j2.getNom()).containsKey(j1.getNom())))throw new PartieExistException();
                        PartieNormal pn = listPartie.get(j1.getNom()).get(j2.getNom());
                       if(modifyDomain1 )
                           pn.getJoueur1().setDomainePredilection(lD1);
                        if(modifyDomain2 )
                        pn.getJoueur2().setDomainePredilection(lD2);
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/ElementGraphic/partie2.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("the Y game");
                        stage.setMinHeight(800);
                        stage.setMinWidth(1300);
                        stage.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Partie2Controller controller = (Partie2Controller)loader.getController();
                        controller.setPartie(pn);
                        controller.setListPartie(listPartie);
                        controller.setListJoueur(listJoueur);
                        
                    } catch (PartieExistException e) {
                    }
                    
                    
                }
            }
                    */
        } catch (SavePlayer ex) {
            
        }
        
        
    }

    @FXML
    private void savePlayer1(MouseEvent event) {
        try{
            if(nomPlayer1.getText().trim().isEmpty() || (nomPlayer1.getText() == null))throw new SaisieException();
            save1=true;
        switch(newJ1){
            case 1:
                
                if(nameExist(listJoueur,nomPlayer1.getText().toLowerCase() ))throw new NameException();
                ArrayList<Domains> d = new ArrayList<Domains>();
                for(CheckBox cb: selectedCheckBoxes1)
                 d.add(extractDomain(cb.getText()));
               
                Joueur j = new Joueur(nomPlayer1.getText().toLowerCase(), d);
                j1 =  j;
                listJoueur.add(j1);
            
                
                break;
            case 0:
                 if(!nameExist(listJoueur,nomPlayer1.getText().toLowerCase() ))throw new NameNoneExist();
                        boolean exist=false;
                    Iterator it = listJoueur.iterator();
                    Joueur j1=new Joueur("", null);
               while((it.hasNext())&&!(j1.getNom().toLowerCase().equals(nomPlayer1.getText().toLowerCase())))
               {
                    
                  j1 = (Joueur)it.next();
                  if(j1.getNom().toLowerCase().equals(nomPlayer1.getText().toLowerCase()))exist = true;
            
               }    
                if (exist) {
                    this.j1 = j1; 
                    System.out.println(this.j1.getNom());
                    
                }
               
                break;
        }
        }catch(SaisieException se){
        }catch(NameException ne){
        }catch(NameNoneExist nne){
        }
        if(!savePlayer1.isDisabled()&& !savePlayer2.isDisabled())
        save.setDisable(false);
    }


    @FXML
    private void savePlayer2(MouseEvent event)  {
        try{
             if(nomPlayer2.getText().trim().isEmpty() || (nomPlayer2.getText() == null))throw new SaisieException();
            save2=true;
        switch(newJ2){
            case 1:
                 if(nameExist(listJoueur,nomPlayer2.getText().toLowerCase() ))throw new NameException();
                 ArrayList<Domains> d = new ArrayList<Domains>();
                for(CheckBox cb: selectedCheckBoxes2)
                 d.add(extractDomain(cb.getText()));
                
                Joueur j = new Joueur(nomPlayer2.getText(), d);
               
                j2 = j;
                 listJoueur.add(j2);
                 
                break;
            case 0:
                if(!nameExist(listJoueur,nomPlayer2.getText().toLowerCase() ))throw new NameNoneExist();
                     boolean exist=false;
                    Iterator it = listJoueur.iterator();
                    Joueur j2 = new Joueur("", null);
               while((it.hasNext())&&!(j2.getNom().toLowerCase().equals(nomPlayer2.getText().toLowerCase())))
               {
                 
                  j2 = (Joueur)it.next();
                  if(j2.getNom().toLowerCase().equals(nomPlayer2.getText().toLowerCase()))exist = true;
               }  
                
               if (exist) {
                    this.j2 = j2; 
                    System.out.println(this.j2.getNom());
                    
                }
                break;
        }
        }catch(SaisieException es){
            
        }catch(NameException e){
            
        }catch(NameNoneExist nne){
        }
        
        if(!savePlayer1.isDisabled()&& !savePlayer2.isDisabled())
        save.setDisable(false);
    }

    @FXML
    private void changeDomains1(MouseEvent event) {
        choixDomain1.setVisible(true);
         changeDomain1.setVisible(false);
         savePlayer1.setDisable(true);
         modifyDomain1 = true;
    }

   

    @FXML
    private void changeDomains2(MouseEvent event) {
        choixDomain2.setVisible(true);
        changeDomain2.setVisible(false);
        savePlayer2.setDisable(true);
         modifyDomain2 = true;
    }

    public void setListPartie(HashMap<String, HashMap<String, PartieNormal>> listPartie) {
        this.listPartie = listPartie;
    }



    public TreeSet<Joueur> getListJoueur() {
        return listJoueur;
    }

    public HashMap<String, HashMap<String, PartieNormal>> getListPartie() {
        return listPartie;
    }

   

    

   

   

    @FXML
    private void checked1(ActionEvent event) {
        CheckBox checkBox =(CheckBox)event.getSource();
       
         if (checkBox.isSelected()) {
             
            selectedCheckBoxes1.add(checkBox);
            unselectedCheckBoxes1.remove(checkBox);
            i1++;
            
        } else {
               
            unselectedCheckBoxes1.add(checkBox);
            selectedCheckBoxes1.remove(checkBox);
            i1--;
        }
         
     
          
            if (i1 >= 3) {
              
                unselectedCheckBoxes1.forEach(cb -> cb.setDisable(true));
                
                savePlayer1.setDisable(false);
            } else {
                unselectedCheckBoxes1.forEach(cb -> cb.setDisable(false));
                savePlayer1.setDisable(true);
            }
    


    }

    @FXML
    private void checked2(ActionEvent event) {
        CheckBox checkBox =(CheckBox)event.getSource();
         if (checkBox.isSelected()) {
            selectedCheckBoxes2.add(checkBox);
            unselectedCheckBoxes2.remove(checkBox);
            i2++;
        } else {
            unselectedCheckBoxes2.add(checkBox);
            selectedCheckBoxes2.remove(checkBox);
            i2--;
        }
          

        
            if (i2 >= maxNumSelected) {
                
                unselectedCheckBoxes2.forEach(cb -> cb.setDisable(true));
                savePlayer2.setDisable(false);
            } else {
                unselectedCheckBoxes2.forEach(cb -> cb.setDisable(false));
               savePlayer2.setDisable(true);
            }
     
          
    }
    
    public Domains extractDomain(String domain){
        Domains domains = Domains.cinema;
          switch (domain) {
              case  "Science":
                       domains = Domains.science;
                       break;
                   case "Cinéma":
                      domains = Domains.cinema;
                       break;
                   case "Géographie":
                      domains = Domains.geographie;
                       break;
                   case "Sport":
                       domains= Domains.sport;
                       break;
                   case "Musique":
                       domains = Domains.musique;
                       break;
                   case "Histoire":
                      domains =Domains.histoire;
                       break;
                   case "Culture général":
                       domains = Domains.culture_generale;
               }
return domains;
       }

    void setListJoueur(TreeSet<Joueur> listJoueur) {
     this.listJoueur= listJoueur;//To change body of generated methods, choose Tools | Templates.
    }

    public void setLoad(boolean load) {
        this.load = load;
    }
   
    
 public void savePartie() throws IOException{
    ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream("SavedFiles/listPartie.dat", true);
         oos = new ObjectOutputStream(fout);
         
        oos.writeObject(listPartie);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(oos  != null){
            oos.close();
        } 
}
    }
 public void saveJoueur(TreeSet<Joueur> listJoueur,String chemin) throws IOException{
    ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    
    try{
         fout = new FileOutputStream(chemin, false);
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


 

   private boolean nameExist(TreeSet<Joueur> hM, String name){
        boolean exist = false;
        Iterator it = hM.iterator();
        Joueur j=new Joueur("", null);
            while(it.hasNext()&& !exist){
               j = (Joueur)it.next();
                System.out.println(j.getNom());
                if(name.equals(j.getNom()))exist = true;
            }
        return exist;
}
    public void initializListJoueur(){
    this.listJoueur = new TreeSet<Joueur>();
    }

    @FXML
    private void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();    
    }
    
}
