    package Traitement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Partie implements Serializable{
 
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActual;
    protected Map<Domains,ArrayList<Question>> listMapQuestion;

    public Partie(Joueur joueur1, Joueur joueur2){
 
        this.joueur1= joueur1;
        this.joueur2= joueur2;
        //Tirer un joueur Aleatoirement
        Random random = new Random();
        int joueurActu = random.nextInt(2);
        if(joueurActu == 0) this.joueurActual = joueur1;
        else this.joueurActual =joueur2;

              
        
    }


    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueurActual(Joueur joueurActual) {
        this.joueurActual = joueurActual;
    }

    public Joueur getJoueurActual() {
        return joueurActual;
    }

    public void setListMapQuestion(Map<Domains, ArrayList<Question>> listMapQuestion) {
        this.listMapQuestion = listMapQuestion;
    }
    public void changeTurn(){
        if(joueurActual == joueur1)
            joueurActual=joueur2;
        else
            joueurActual=joueur1;
    }
}

