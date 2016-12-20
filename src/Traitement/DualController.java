/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Traitement;

import Exceptions.GameExceptions;
import Exceptions.SaisieException;
import Traitement.Dual;
import Traitement.Joueur;
import Traitement.NiveauDiffeculte;
import Traitement.Question;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author karimNasri
 */
public class DualController implements Initializable,Serializable{
    @FXML
    private Label player1;
    @FXML
    private Label scor1;
    @FXML
    private Label player2;
    @FXML
    private Label scor2;
    @FXML
    private AnchorPane questionPan;
    @FXML
    private Label question;
    @FXML
    private ToggleGroup sugg;
    private Question q;
    private ArrayList<Question> questionsJ1;
    private ArrayList<Question> questionsJ2;
    private Dual dual;
    @FXML
    private Button start;
    @FXML
    public Label joueurActu;
    @FXML
    private VBox Vbox;
    private Joueur joueur;
    private Label numQ;
    @FXML
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    
    String winner;
    @FXML
    private AnchorPane child;
    
    private Partie2Controller p2c;
    @FXML
    private ChoiceBox<String> niveau;
        
    private String level;
    @FXML
    private AnchorPane levels;
    @FXML
    private TextField reponse;
    
              
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        questionPan.setVisible(false);
        // TODO
       reponse.setVisible(false);
       rb1.setVisible(false);
         niveau.setItems(FXCollections.observableArrayList("Facile", "Moyen", "Difficile"));
     
    }    

    @FXML
    private void saveAnswer(MouseEvent event) {
        String answer = "";
        try{
 if ((reponse.getText().trim().isEmpty() || (reponse.getText() == null)) && (sugg.getSelectedToggle() == null)) throw new SaisieException();
       switch(level){
           case "Facile":
               answer = (String)sugg.getSelectedToggle().getUserData();
                      
               break;
           case "Moyen" :
               answer = (String)sugg.getSelectedToggle().getUserData();
               break;
           case "Difficile":
               answer = reponse.getText();
               reponse.setVisible(true);
       
       }
      
       dual.responsQuestion(joueur,q, answer);
       
       if(joueur == dual.getJoueur1()){
           q = dual.randomQuestionSelector(questionsJ2);
           scor1.setText(String.valueOf(dual.getScor1()));
           
       }else{
          q = dual.randomQuestionSelector(questionsJ2);
          scor2.setText(String.valueOf(dual.getScor2()));
       }
       if(!(dual.endDuel()))
       {
         joueur = dual.getJoueurActual();
        
        joueurActu.setText(joueur.getNom());  
        question.setText(q.getQuestion());
          switch (level){
                case "Moyen":
                   
                  
                    String[] s = q.displaySuggestions(NiveauDiffeculte.Medium);
                
                    //rb1 = new RadioButton(s[0]);
                    rb1.setText(s[0]);
                    rb1.setUserData(s[0]);
                    rb1.setToggleGroup(sugg);
                    
                   // rb2 = new RadioButton(s[1]);
                    rb2.setText(s[1]);
                    rb2.setUserData(s[1]);
                    rb2.setToggleGroup(sugg);
                    
                   // rb3 = new RadioButton(s[2]);
                    rb3.setText(s[2]);
                    rb3.setUserData(s[2]);
                    rb3.setToggleGroup(sugg);
                    
                  //  rb4 = new RadioButton(s[3]);
                    rb4.setText(s[3]);
                    rb4.setUserData(s[3]);
                    rb4.setToggleGroup(sugg);
                    
//                    Vbox.getChildren().add(rb4);
  //                  Vbox.getChildren().add(rb3);
    //                Vbox.getChildren().add(rb2);
      //              Vbox.getChildren().add(rb1);
                    
                    break;
                case "Facile":
                 //   niveau = NiveauDiffeculte.Easy;
                    s = q.displaySuggestions(NiveauDiffeculte.Easy);
                 //   rb1 = new RadioButton(s[0]);
                    rb1.setText(s[0]);
                    rb1.setUserData(s[0]);
                    rb1.setToggleGroup(sugg);
                    
                 //   rb2 = new RadioButton(s[1]);
                    rb2.setText(s[1]);
                    rb2.setUserData(s[1]);
                    rb2.setToggleGroup(sugg);
                    rb3.setVisible(false);
                    rb4.setVisible(false);
                    Vbox.getChildren().add(rb2);
                    Vbox.getChildren().add(rb1);
                    break;
                case "Difficle":
                 //   niveau = NiveauDiffeculte.Hard;
                    reponse.setVisible(true);
                    break;
            }
       
       }else{
         
           p2c.setDualEnCour(false);
           GameExceptions ge = new GameExceptions();
               if(this.getDual().getJoueur1() == p2c.getPartie().getJoueur1()){
                   //Challenger a gagner
                   if(this.getDual().joueurGagnant()){
                    p2c.getPartie().setPosition1(this.getDual().getNumCase());
                    p2c.getPartie().setPas1(0);
                    p2c.setPosition1(this.getDual().getNumCase());
                    p2c.setLabelPlayer1(""+this.getDual().getNumCase());
                    p2c.setPas1("0");
                    ge.alert("Bravo "+this.getDual().getJoueur1().getNom()+"");
               } else{
                 //Challenger a perdu
                p2c.getPartie().changeTurn();
                p2c.setThePlayer(p2c.getPartie().getJoueurActual().getNom());
                ge.alert("Domage "+this.getDual().getJoueur1().getNom()+" vous avez perdu");
                  
               }
       }else{
                    if(this.getDual().joueurGagnant()){

                        p2c.getPartie().setPosition2(this.getDual().getNumCase());
                        p2c.getPartie().setPas2(0);
                        p2c.setPosition2(this.getDual().getNumCase());
                        p2c.setLabelPlayer2(""+this.getDual().getNumCase());
                        p2c.setPas2("0");
                        ge.alert("Bravo "+this.getDual().getJoueur1().getNom()+"");
                   } else{
                    ge.alert("Domage "+this.getDual().getJoueur1().getNom()+" vous avez perdu");
                    p2c.getPartie().changeTurn();
                    p2c.setThePlayer(p2c.getPartie().getJoueurActual().getNom());
                   // p2c.setPas1("0");
                   }
               
               }
           
           ((Node)(event.getSource())).getScene().getWindow().hide();
           
           
       }
        
        }catch(SaisieException s){}
    }
    
    public void setQuestionsJ1(ArrayList<Question> q){
    this.questionsJ1= q;
    }
    public void setQuestionsJ2(ArrayList<Question> q){
    this.questionsJ2= q;
    }
    public ArrayList<Question> getQuestionsJ1(){
    return this.questionsJ1;
    }
    public ArrayList<Question> getQuestionsJ2(){
    return this.questionsJ2;
    }

    public void setDual(Dual dual) {
        this.dual = dual;
    }

    public Dual getDual() {
        return dual;
    }
   @FXML
    private void start(ActionEvent event) {
    
     try {
          //  if(niveau.getSelectedToggle().== null) throw new SaisieException();
         questionPan.setVisible(true);
         level = niveau.getValue();
        
       
        questionsJ1 = dual.questionsDualPlayer(dual.getJoueur2());
        questionsJ2 = dual.questionsDualPlayer(dual.getJoueur2());
        joueur = dual.getJoueur1();
        player1.setText(joueur.getNom());
        player2.setText(dual.getJoueur2().getNom());
        q = dual.randomQuestionSelector(questionsJ1);
        question.setText(q.getQuestion());
        scor1.setText("0");
        scor2.setText("0");
//        numQ.setText("1");
           
           
           start.setVisible(false);
           levels.setVisible(false);
            
            
          
         
          
            switch (level){
                case "Moyen":
                   
                    if(false)throw new SaisieException();
                    String[] s = q.displaySuggestions(NiveauDiffeculte.Medium);
                
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
                 //   niveau = NiveauDiffeculte.Easy;
                    s = q.displaySuggestions(NiveauDiffeculte.Easy);
                    rb1 = new RadioButton(s[0]);
                    rb1.setUserData(s[0]);
                    rb1.setToggleGroup(sugg);
                    
                    rb2 = new RadioButton(s[1]);
                    rb2.setUserData(s[1]);
                    rb2.setToggleGroup(sugg);
                    rb3.setVisible(false);
                    rb4.setVisible(false);
                    Vbox.getChildren().add(rb2);
                    Vbox.getChildren().add(rb1);
                    break;
                case "Difficile":
                   
                    reponse.setVisible(true);
                    break;
            }
        } catch (SaisieException ex) {
           // Logger.getLogger(Partie2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    private void start1(ActionEvent event) {
        questionPan.setVisible(true);
        
       
        questionsJ1 = dual.questionsDualPlayer(dual.getJoueur2());
        questionsJ2 = dual.questionsDualPlayer(dual.getJoueur2());
        joueur = dual.getJoueur1();
        player1.setText(joueur.getNom());
        player2.setText(dual.getJoueur2().getNom());
        q = dual.randomQuestionSelector(questionsJ1);
        question.setText(q.getQuestion());
        scor1.setText("0");
        scor2.setText("0");
//        numQ.setText("1");
        
         String[] s = q.displaySuggestions(NiveauDiffeculte.Medium);
            //   RadioButton rb1 = new RadioButton(s[0]);
                rb1.setText(s[0]);
                rb1.setUserData(s[0]);
                rb1.setToggleGroup(sugg);

                
                rb2.setText(s[1]);
                rb2.setUserData(s[1]);
                rb2.setToggleGroup(sugg);

          //      RadioButton rb3 = new RadioButton(s[2]);
                rb3.setUserData(s[2]);
                rb3.setText(s[2]);
                rb3.setToggleGroup(sugg);

           //     RadioButton rb4 = new RadioButton(s[3]);
                rb4.setUserData(s[3]);
                rb4.setText(s[3]);
                rb4.setToggleGroup(sugg);

             
        
        
    }

    public String getWinner() {
        return winner;
    }

    public void setP2c(Partie2Controller p2c) {
        this.p2c = p2c;
    }

   
    
    
  
    
    
}
