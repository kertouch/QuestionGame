/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Traitement;

import Exceptions.DualEnCourException;
import Exceptions.GameExceptions;
import Exceptions.QuestionEnCour;
import Exceptions.ReponseException;
import Exceptions.SaisieException;
import Exceptions.lockedCaseException;
import Exceptions.turnException;
import Traitement.Case;
import Traitement.Domains;
import Traitement.Dual;
import Traitement.Joueur;
import Traitement.NiveauDiffeculte;
import Traitement.PartieNormal;
import static Traitement.PartieNormal.randomEnum;
import Traitement.Question;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Pair;



/**
 * FXML Controller class
 *
 * @author karimNasri
 */
public class Partie2Controller implements Initializable,Serializable {
    
    private DualController dc;
    @FXML
    private Label player2;
    @FXML
    private Button b118;
    @FXML
    private Button b17;
    @FXML
    private Button b214;
    @FXML
    private Button b111;
    @FXML
    private Button b27;
    @FXML
    private Button b22;
    @FXML
    private Button a10;
    @FXML
    private Button b12;
    @FXML
    private Button a18;
    @FXML
    private Button b218;
    @FXML
    private Button b14;
    @FXML
    private Button a14;
    @FXML
    private Button a5;
    @FXML
    private Button a20;
    @FXML
    private Button b25;
    @FXML
    private Button b29;
    @FXML
    private Button a13;
    @FXML
    private Button a4;
    @FXML
    private Button b114;
    @FXML
    private Button b117;
    @FXML
    private Button b120;
    @FXML
    private Button b217;
    @FXML
    private Button a6;
    @FXML
    private Button b23;
    @FXML
    private Button b213;
    @FXML
    private Button b18;
    @FXML
    private Button a16;
    @FXML
    private Button b212;
    @FXML
    private Button b115;
    @FXML
    private Button b112;
    @FXML
    private Button b121;
    @FXML
    private Button a8;
    @FXML
    private Button b21;
    @FXML
    private Button a12;
    @FXML
    private Button b16;
    @FXML
    private Button b110;
    @FXML
    private Button a2;
    @FXML
    private Button a9;
    @FXML
    private Button b24;
    @FXML
    private Button a7;
    @FXML
    private Button b26;
    @FXML
    private Button b216;
    @FXML
    private Button b15;
    @FXML
    private Button a21;
    @FXML
    private Button b210;
    @FXML
    private Button b211;
    @FXML
    private Button b113;
    @FXML
    private Button b119; 
    @FXML
    private Button b13;
    @FXML
    private Button a15;
    @FXML
    private Button b28;
    @FXML
    private Button a19;
    @FXML
    private Button a17;
    @FXML
    private Button b116;
    @FXML
    private Button b215;
    @FXML
    private Button b221;
    @FXML
    private Button b219;
    @FXML
    private Button b19;
    @FXML
    private Button a1;
    @FXML
    private Button a11;
    @FXML
    private Button b220;
    @FXML
    private Button a3;
    @FXML
    private Button b11;
    @FXML
    private Label player1;
    @FXML
    private ProgressIndicator progressPlayer1;
    @FXML
    private Label pas1;
    @FXML
    private Label pos1;
    @FXML
    private ProgressIndicator progressPlayer2;
    @FXML
    private Label pas2;
    @FXML
    private Label pos2;
    @FXML
    private Label thePlayer;
    @FXML
    private AnchorPane questionPan;
    @FXML
    private ChoiceBox<String> level;
    @FXML
    private Button okLevel;
    @FXML
    private Label levelChoice;
    @FXML
    private AnchorPane questionResponsePan1;
    @FXML
    private AnchorPane questionResponse2;
    @FXML
    private Button submitResponse;
    @FXML
    private VBox Vbox;
    @FXML
    private RadioButton useless;
    @FXML
    private ToggleGroup sugg;
    @FXML
    private TextField response;
    
    private Button[] listbutton;
    private Map<Domains, ArrayList<Question>> listQuestion;
    private HashMap<String,HashMap<String,PartieNormal>> listPartie;
    private TreeSet<Joueur> listJoueur;
    private int position1 ;
    private int position2 ;  
    private boolean allowClick ;
    private PartieNormal partie;
    private Question ActuelQuestion;
    private NiveauDiffeculte niveau;
    @FXML
    private Label question;
    @FXML
    private AnchorPane start;
    @FXML
    private Label player11;
    @FXML
    private Label player21;
    
    private String winner;
    @FXML
    private AnchorPane child;
    @FXML
    private Label x;
    
    private boolean dualEnCour;
    private boolean questionEnCour;
    @FXML
    private Label d21;
    @FXML
    private Label d31;
    @FXML
    private Label d11;
    @FXML
    private Label d12;
    @FXML
    private Label d32;
    @FXML
    private Label d22;
    @FXML
    private Label domain;
   
    /**
     * Initializes the controller class.
     */
    
       public void initialize(URL url, ResourceBundle rb) {
        listbutton = new Button[100];
        dualEnCour = false;
        questionEnCour= false;
        /////Initialisation des button pour le joueur1
        listbutton[0] = b21;
        listbutton[1] = b22;
        listbutton[2] = b23;
        listbutton[3] = b24;
        listbutton[4] = b25;
        listbutton[5] = b26;
        listbutton[6] = b27;
        listbutton[7] = b28;
        listbutton[8] = b29;
        listbutton[9] = b210;
        listbutton[10] = b211;
        listbutton[11] = b212;
        listbutton[12] = b213;
        listbutton[13] = b214;
        listbutton[14] = b215;
        listbutton[15] = b216;
        listbutton[16] = b217;
        listbutton[17] = b218;
        listbutton[18] = b219;
        listbutton[19] = b220;
        listbutton[20] = b221;

     /////Initialisation des button pour le joueur2
        
        
        listbutton[21] = b11;
        listbutton[22] = b12;
        listbutton[23] = b13;
        listbutton[24] = b14;
        listbutton[25] = b15;
        listbutton[26] = b16;
        listbutton[27] = b17;
        listbutton[28] = b18;
        listbutton[29] = b19;
        listbutton[30] = b110;
        listbutton[31] = b111;
        listbutton[32] = b112;
        listbutton[33] = b113;
        listbutton[34] = b114;
        listbutton[35] = b115;
        listbutton[36] = b116;
        listbutton[37] = b117;
        listbutton[38] = b118;
        listbutton[39] = b119;
        listbutton[40] = b120;
        listbutton[41] = b121;
       
        listbutton[42] = a1;
        listbutton[43] = a2;
        listbutton[44] = a3;
        listbutton[45] = a4;
        listbutton[46] = a5;
        listbutton[47] = a6;
        listbutton[48] = a7;
        listbutton[49] = a8;
        listbutton[50] = a9;
        listbutton[51] = a10;
        listbutton[52] = a11;
        listbutton[53] = a12;
        listbutton[54] = a13;
        listbutton[55] = a14;
        listbutton[56] = a15;
        listbutton[57] = a16;
        listbutton[58] = a17;
        listbutton[59] = a18;
        listbutton[60] = a19;
        listbutton[61] = a20;
        listbutton[62] = a21;
     //La liste de question qui va etre modifier
        //Initialisation 
        
        
        
        questionPan.setVisible(false);
        levelChoice.setVisible(false);
        questionResponsePan1.setVisible(false);
        questionResponse2.setVisible(false);
        useless.setVisible(false);
        level.setItems(FXCollections.observableArrayList("Facile", "Moyen", "Difficile"));
        response.setVisible(false);
        
        
      
        allowClick = true;
        progressPlayer1.setProgress((double)1/42);
        progressPlayer2.setProgress((double)1/42);
        
         
         
       
    }

    @FXML
    private void questionGenerator1(MouseEvent event) {
        
        try{
            if(questionEnCour)throw new QuestionEnCour();
        if (partie.getJoueurActual() != partie.getJoueur2()) throw new turnException();
            
            Button src = (Button) event.getSource();
            int i = Integer.parseInt(src.getText()) - 1;
      
            Case[] l2 = partie.getListCase2();
            if (l2[i].isLockPlayer1()) throw new lockedCaseException();
                position2 = i+1;
                partie.setPosition2(position2);
                pos2.setText(""+position2);
             //   for(int j = i-1; j>0; j--)
               //  listbutton[j-1].setDisable(true);
                
                questionPan.setVisible(true);
                partie.setListMapQuestion(l2[i].randomQuestion(partie.getListMapQuestion()));
               domain.setText(l2[i].getDomaine().toString());
                setActuelQuestion(l2[i].getQuestion());
                question.setText(ActuelQuestion.getQuestion());
                questionEnCour = true;
       }catch(QuestionEnCour q){
       }catch(turnException e){
           
       }catch(lockedCaseException e2){
           
       }
         
       
    }

    @FXML
    private void questionGenerator2(MouseEvent event) {
        
       try{
           if(questionEnCour)throw new QuestionEnCour();
        if (partie.getJoueurActual() != partie.getJoueur1()) throw new turnException();
            
            Button src = (Button) event.getSource();
            int i = Integer.parseInt(src.getText()) - 1;
           //
            Case[] l1 = partie.getListCase1();
            
            if (l1[i].isLockPlayer1()) throw new lockedCaseException();
                 position1 = i+1;
                 partie.setPosition1(position1);
           
                 
                pos1.setText(""+position1);
                questionPan.setVisible(true);
                domain.setText(l1[i].getDomaine().toString());
                partie.setListMapQuestion(l1[i].randomQuestion(partie.getListMapQuestion()));
                partie.listCase1[i].setQuestion(l1[i].getQuestion());
                setActuelQuestion(l1[i].getQuestion());
                question.setText(ActuelQuestion.getQuestion());
                questionEnCour = true;
       }catch(QuestionEnCour rs){
       }catch(turnException e){
           
       }catch(lockedCaseException e2){
           
       }

            
      
      
        
            

    }

    public void setPartie(PartieNormal p) {
        partie = p;
    }

  

    private String colorFinder(Domains domain) {
        String color = new String("-fx-base: #100000;-fx-background-radius:50%");

        switch (domain) {
            case science:
                color = "-fx-base: #1e90ff;-fx-background-radius:50%";
                break;
            case histoire:
                color = "-fx-base: #000000;-fx-background-radius:50%";
                break;
            case geographie:
                color = "-fx-base: #ca1fff;-fx-background-radius:50%";
                break;
            case sport:
                color = "-fx-base: #b4babf;-fx-background-radius:50%";

                break;
            case musique:
                color = "-fx-base: #2fff1f;-fx-background-radius:50%";
                break;
            case cinema:
                color = "-fx-base: #ff1f1f;-fx-background-radius:50%";
                break;
            case culture_generale:
                color = "-fx-base: #e8ff1f;-fx-background-radius:50%";
        }
        return color;
    }

    @FXML
    private void start(MouseEvent event) {
      
        
        //initialisation 
        pos1.setText((String.valueOf(partie.getPosition1())));
        pos2.setText((String.valueOf(partie.getPosition2())));;
        pas1.setText((String.valueOf(partie.getPas1())));
        pas2.setText((String.valueOf(partie.getPas2())));
        progressPlayer1.setProgress((double)partie.getPosition1()/42);
        progressPlayer2.setProgress((double)partie.getPosition2()/42);
        position1 = partie.getPosition1();
        position2 = partie.getPosition2();
       //  listPartie = new HashMap<>();
        Case[] cases2 = partie.getListCase1();
        Case[] cases1 = partie.getListCase2();
       cases1[19].setLockPlayer1(false);
        
        player1.setText(partie.getJoueur1().getNom());
        player2.setText(partie.getJoueur2().getNom());
        player11.setText(partie.getJoueur1().getNom());
        player21.setText(partie.getJoueur2().getNom());
        listQuestion = partie.getListMapQuestion();
        thePlayer.setText(partie.getJoueurActual().getNom());
        
        d11.setText(partie.getJoueur1().getDomainePredilection().get(0).toString());
        d21.setText(partie.getJoueur1().getDomainePredilection().get(1).toString());
        d31.setText(partie.getJoueur1().getDomainePredilection().get(2).toString());
         d12.setText(partie.getJoueur2().getDomainePredilection().get(0).toString());
        d22.setText(partie.getJoueur2().getDomainePredilection().get(1).toString());
        d32.setText(partie.getJoueur2().getDomainePredilection().get(2).toString());
        //s();
        
        for (int i = 0; i < 42; i++) {
            if (i < 21) {
                listbutton[i].setStyle(colorFinder(cases1[i].getDomaine()));
            }
            else {
                listbutton[i].setStyle(colorFinder(cases2[i - 21].getDomaine()));
            }
           
            }
       
        
        if(partie.getJoueurActual()== partie.getJoueur2()){
            
            for(int j = position2-2; j >=0; j--){
                listbutton[j].setDisable(true);
      
            }
            for(int j = 20; j< 42;j++){
                listbutton[j].setDisable(true);
            }
        }else{
            for(int j = position1+19; j > 21;j--){
                listbutton[j].setDisable(true);
            }
            
            for(int j = 0;j < 21;j++){
                 listbutton[j].setDisable(true);
            }
        } 
        
    }

    public void setActuelQuestion(Question ActuelQuestion) {
        this.ActuelQuestion = ActuelQuestion;
    }

    @FXML
    private void saveLevel(MouseEvent event)  {
        try {
            if(level.getValue() == null) throw new SaisieException();
            
            levelChoice.setVisible(true);
            levelChoice.setText(level.getValue());
            level.setVisible(false);
            okLevel.setVisible(false);
            questionResponsePan1.setVisible(true);
            questionResponse2.setVisible(true);
            
            RadioButton rb1;
            RadioButton rb2;
            RadioButton rb3;
            RadioButton rb4;
            okLevel.setVisible(false);
            level.setVisible(false);
            
            switch (level.getValue()) {
                case "Moyen":
                    String[] s = ActuelQuestion.displaySuggestions(NiveauDiffeculte.Medium);
                    niveau = NiveauDiffeculte.Medium;
                    rb1 = new RadioButton(s[0]);
                    rb1.setUserData(s[0]);
                    rb1.setToggleGroup(sugg);
                    
                    rb2 = new RadioButton(s[1]);
                    rb2.setUserData(s[1]);
                    rb2.setToggleGroup(sugg);
                    
                    rb3 = new RadioButton(s[2]);
                    rb3.setUserData(s[2]);
                    rb3.setToggleGroup(sugg);
                    
                    rb4 = new RadioButton(s[3]);
                    rb4.setUserData(s[3]);
                    rb4.setToggleGroup(sugg);
                    
                    Vbox.getChildren().add(rb4);
                    Vbox.getChildren().add(rb3);
                    Vbox.getChildren().add(rb2);
                    Vbox.getChildren().add(rb1);
                    
                    break;
                case "Facile":
                    niveau = NiveauDiffeculte.Easy;
                    s = ActuelQuestion.displaySuggestions(NiveauDiffeculte.Easy);
                    rb1 = new RadioButton(s[0]);
                    rb1.setUserData(s[0]);
                    rb1.setToggleGroup(sugg);
                    
                    rb2 = new RadioButton(s[1]);
                    rb2.setUserData(s[1]);
                    rb2.setToggleGroup(sugg);
                    
                    Vbox.getChildren().add(rb2);
                    Vbox.getChildren().add(rb1);
                    break;
                case "Difficile":
                    niveau = NiveauDiffeculte.Hard;
                    response.setVisible(true);
                    break;
            }
        } catch (SaisieException ex) {
           // Logger.getLogger(Partie2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  //  } 
    @FXML
    private void saveQuestion(MouseEvent event) throws IOException {
         setProgresseBar();
        allowClick = true;
        int pos;
        boolean answer = false;
        
        if(partie.getJoueurActual() == partie.getJoueur1()){
            pos = position1;
            }
            else{
            pos = position2;
            }
        try{
        if ((response.getText().trim().isEmpty() || (response.getText() == null)) && (sugg.getSelectedToggle() == null)) throw new SaisieException();
        
               
            level.setVisible(true);
            okLevel.setVisible(true);
            questionPan.setVisible(false);
            levelChoice.setVisible(false);
            questionResponsePan1.setVisible(false);
            questionResponse2.setVisible(false);
            
            response.setVisible(false);
            Vbox.getChildren().remove(0, Vbox.getChildren().size());
            switch(niveau){
                case Easy:
            answer =partie.nmbrPas(partie.getJoueurActual(), ActuelQuestion,(String)sugg.getSelectedToggle().getUserData(),niveau,pos);
               
                
                    break;
                case Medium:
            answer = partie.nmbrPas(partie.getJoueurActual(), ActuelQuestion,(String)sugg.getSelectedToggle().getUserData(),niveau,pos);
            
                    break;
                case Hard:
            answer =partie.nmbrPas(partie.getJoueurActual(), ActuelQuestion,response.getText(),niveau,pos);
          
                    break;
                    
            }
           
               
            if(partie.getJoueurActual() == partie.getJoueur1()){
                
                //Show position
              
                  for (int j = partie.getPosition2()-1; j >= 0; j--) {
                      
                    listbutton[j].setDisable(true);
                  }
                  
                for(int i2 = partie.getPosition2()-1; i2<63;i2++){
                    if(!(i2>20 && i2<42))
                    listbutton[i2].setDisable(false);
               
                }
                
                
                
                if(answer){
                ReponseException rp = new ReponseException("Bonne reponse");
                partie.setUnLockCase1();
                pas1.setText((String.valueOf(partie.getPas1())));
                position1 = partie.getPosition1();
                pos1.setText((String.valueOf(position1)));
                if(position1 == 42 ){
                     partie.getJoueur1().incrScor();
                   rp = new ReponseException("Le gagnant est: "+partie.getJoueur1().getNom()+".Votre nouvewu scor: " +partie.getJoueur1().getScore());
                    ((Node)child).getScene().getWindow().hide();  
                    listJoueur.remove(partie.getJoueur1());
                   listJoueur.add(partie.getJoueur1());
                 Joueur j2= partie.getJoueur2();
                 Joueur j1= partie.getJoueur1();
                 listPartie.get(j1.getNom()).remove(j2.getNom());
                 listPartie.get(j2.getNom()).remove(j1.getNom());
                   saveJoueur(listJoueur,"SavedFiles/listJoueur.dat");
                   savePartie();
                
               
                    
                }
                }else{
                     ReponseException rp = new ReponseException("Mauvaise reponse"); 
                     pas1.setText("0");
                     position1 = partie.getPosition1();
                }
                
            }
            else{ 
                //Show position
               
                for (int j = position1+19; j>20; j--) 
                {
                    listbutton[j].setDisable(true);
                }
                
                for(int i2 = position1+20; i2<63;i2++){
                    listbutton[i2].setDisable(false);
                }
                
                if(answer){
                ReponseException rp = new ReponseException("Bonne reponse");
                partie.setUnLockCase2();
                pas2.setText((String.valueOf(partie.getPas2())));
                position2 = partie.getPosition2();
                pos2.setText((String.valueOf(position2)));
                
                 if(position2 == 42 ){
                partie.getJoueur2().incrScor();
                rp = new ReponseException("Le gagnant est: "+partie.getJoueur2().getNom()+".Votre nouvewu scor: " +partie.getJoueur2().getScore()); 
                  listJoueur.remove(partie.getJoueur2());
                 listJoueur.add(partie.getJoueur2());
                 Joueur j2= partie.getJoueur2();
                 Joueur j1= partie.getJoueur1();
                 listPartie.get(j1.getNom()).remove(j2.getNom());
                 listPartie.get(j2.getNom()).remove(j1.getNom());
                  ((Node)child).getScene().getWindow().hide(); 
                     saveJoueur(listJoueur,"SavedFiles/listJoueur.dat");
                     savePartie();
                 }
                }else{
                ReponseException rp = new ReponseException("Mauvaise reponse"); 
                pas2.setText("0");
                position2 = partie.getPosition2();
                }
                
            }
            questionEnCour = false;
           
            
            partie.changeTurn();
            thePlayer.setText(partie.getJoueurActual().getNom());
            try{
            response.clear();
            sugg.getSelectedToggle().setSelected(false);
            }catch(NullPointerException n){
            }
        }catch(SaisieException e){
    
    }

    }

   private void setProgresseBar(){
      double i = (double)position1/42;
      double j = (double)position2/42;
       
    progressPlayer1.setProgress(i);
    progressPlayer2.setProgress(j);
    
    
}

    @FXML
    private void questionGenerator3(MouseEvent event) throws IOException {
       
        try{
         if(questionEnCour)throw new QuestionEnCour();
         if(dualEnCour)throw new DualEnCourException();
         Button src ;
        int i;
        src = (Button) event.getSource();
        i = Integer.parseInt(src.getText()) - 1;
        
        Random random = new Random();
        Case[] l1 = partie.getListCase1();
        Case[] l2 = partie.getListCase2();
        if (partie.getJoueurActual() == partie.getJoueur1()) {
            if(partie.getPas1() == 0 && position1 == i+1)
            {
                l1[i].setLockPlayer1(false);
                listbutton[i+21].setDisable(false);
            }
            
            
            if(l1[i].isLockPlayer1())throw new lockedCaseException();
            if((position2 != i+1)||!(l1[i].isLockPlayer2())){
            position1 = i+1;
            pos1.setText(""+position1);
            partie.setPosition1(position1);
            if (l1[i].isLockPlayer1()) throw new lockedCaseException();
                 
                l1[i].setDomaine(randomEnum(Domains.class,random));
                listbutton[i+21].setStyle(colorFinder(l1[i].getDomaine()));
                domain.setText(l1[i].getDomaine().toString());
                questionPan.setVisible(true);
                partie.setListMapQuestion(l1[i].randomQuestion(partie.getListMapQuestion()));
                setActuelQuestion(l1[i].getQuestion());
                question.setText(ActuelQuestion.getQuestion());
                questionEnCour = true;
            }else{///Lancement du dual
                
                startDual(i+1);
                dualEnCour = true;
                l1[i].setLockPlayer2(false);
                questionEnCour=false;
                
            }

           
        } else {
            questionEnCour = true;
            if(l2[i].isLockPlayer1())throw new lockedCaseException();
            
            if(partie.getPas2() == 0 && position2 == i+1){
                l2[i].setLockPlayer1(false);
                listbutton[i+21].setDisable(false);
            }
             if((position1 != i+1)||!(l2[i].isLockPlayer2())){
             position2 = i+1;
             pos2.setText(""+position2);
             partie.setPosition2(position2);
             
            if (l2[i].isLockPlayer1()) throw new lockedCaseException();
            
                l2[i].setDomaine(randomEnum(Domains.class,random));
                listbutton[i+21].setStyle(colorFinder(l2[i].getDomaine()));
                questionPan.setVisible(true);
                domain.setText(l2[i].getDomaine().toString());
                partie.setListMapQuestion(l2[i].randomQuestion(partie.getListMapQuestion()));
                setActuelQuestion(l2[i].getQuestion());
                question.setText(ActuelQuestion.getQuestion());
                
             }else{////lancement du dual
                 startDual(i+1);
                 dualEnCour = true;
                 l2[i].setLockPlayer2(false);
                  questionEnCour = false;
             }
      
       
    }
         
        }catch(QuestionEnCour q){
        }catch(lockedCaseException e){
            questionEnCour = false;
        }catch(DualEnCourException es){
            questionEnCour = false;
        }
}
    
    public Dual dual(Joueur challenger,int numCase){
        Dual dual;
        if(challenger == partie.getJoueur1()){
            dual = new Dual( challenger, partie.getJoueur2(),numCase);
            
        }else
            dual = new Dual( challenger, partie.getJoueur1(),numCase);
        
        return dual;
    }


   
    private void startDual(int numCase) throws IOException {
      ///    initializListParti();
        questionEnCour=false;
         Dual d = dual(partie.getJoueurActual(),numCase);
        FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/Dual.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene);  
        stage.setTitle("Dual");  
        stage.show();
        DualController controller = (DualController)loader.getController();
        dc = controller;
        d.setListMapQuestion(partie.getListMapQuestion());
        controller.setDual(d);
        controller.setP2c(this);
        
       
       
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
    

    private void thing(MouseEvent event) throws IOException  {
   
   
        HashMap<String,PartieNormal> jn;
      if(listPartie.containsKey(partie.getJoueur1().getNom())){
         jn = listPartie.get(partie.getJoueur1().getNom());
         jn.put(partie.getJoueur2().getNom(), partie);
      
      }
      else{
         jn = new HashMap<String,PartieNormal>();
         jn.put(partie.getJoueur2().getNom(), partie);
      }
      
      listPartie.put(partie.getJoueur1().getNom(),jn);
      
       if(listPartie.containsKey(partie.getJoueur2().getNom())){
         jn = listPartie.get(partie.getJoueur2().getNom());
         jn.put(partie.getJoueur1().getNom(), partie);
      
      }
      else{
         jn = new HashMap<String,PartieNormal>();
         jn.put(partie.getJoueur1().getNom(), partie);
      }
      listPartie.put(partie.getJoueur2().getNom(),jn);


      savePartie();
     
    
    }
    
       
 public void savePartie() throws IOException{
    ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream("SavedFiles/listPartie.dat", false);
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

    public void setListPartie(HashMap<String, HashMap<String, PartieNormal>> listPartie) {
        this.listPartie = listPartie;
    }

    public HashMap<String, HashMap<String, PartieNormal>> getListPartie() {
        return listPartie;
    }
 
 
 public void initializListParti(){
     this.listPartie = new HashMap<>();
 }

    public void setDualEnCour(boolean dualEnCour) {
        this.dualEnCour = dualEnCour;
    }

    public PartieNormal getPartie() {
        return partie;
    }

    
  public void setLabelPlayer1(  String s){
      pos1.setText(s);
  }
  public void setLabelPlayer2(  String s){
      pos2.setText(s);
  }
  public void setPas1(String s){
      pas1.setText(s);
  }
  public void setPas2(String s){
      pas2.setText(s);
  }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

    public void setThePlayer(String s) {
        this.thePlayer.setText(s);
    }

    public void setListJoueur(TreeSet<Joueur> listJoueur) {
        this.listJoueur = listJoueur;
    }

    public TreeSet<Joueur> getListJoueur() {
        return listJoueur;
    }

   

    @FXML
    private void classement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/Classement.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene); 
        stage.show();
        ClassementController cc=(ClassementController)loader.getController();
        cc.setListJoueur(listJoueur);
    }


    
  
    @FXML
    private void newGame(ActionEvent event) throws IOException {
         MenuPrincipalController mpc = new MenuPrincipalController();
       
     try {
        mpc.loadJoueur();
        mpc.loadPartie();
       } catch (IOException ex) {
          Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
        listJoueur = mpc.getListJoueur();
        
        FXMLLoader loader = new FXMLLoader();  
        loader.setLocation(getClass().getResource("/ElementGraphic/form2.fxml"));
        Parent root = (Parent) loader.load();
        Form2Controller fc  = (Form2Controller)loader.getController();
       
        fc.setListJoueur(mpc.getListJoueur());
        fc.setListPartie(mpc.getListPartie());
        
        Scene scene = new Scene(root);  
        Stage stage = new Stage();  
        stage.setScene(scene); 
        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.show(); 
        ////
        ((Node)child).getScene().getWindow().hide();
            
        
    }

    @FXML
    private void saveGame(ActionEvent event) throws IOException {
     
        ReponseException r= new ReponseException("Partie sauvgarder");
         HashMap<String,PartieNormal> jn;
      if(listPartie.containsKey(partie.getJoueur1().getNom())){
         jn = listPartie.get(partie.getJoueur1().getNom());
         jn.put(partie.getJoueur2().getNom(), partie);
      
      }
      else{
         jn = new HashMap<String,PartieNormal>();
         jn.put(partie.getJoueur2().getNom(), partie);
      }
      
      listPartie.put(partie.getJoueur1().getNom(),jn);
      
       if(listPartie.containsKey(partie.getJoueur2().getNom())){
         jn = listPartie.get(partie.getJoueur2().getNom());
         jn.put(partie.getJoueur1().getNom(), partie);
      
      }
      else{
         jn = new HashMap<String,PartieNormal>();
         jn.put(partie.getJoueur1().getNom(), partie);
      }
      listPartie.put(partie.getJoueur2().getNom(),jn);
      
      
    

      savePartie();
     
    
    } 

    @FXML
    private void close(ActionEvent event) {
        
       ((Node)child).getScene().getWindow().hide();       
        //Platform.exit();


       
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
}

  
    
 
    

