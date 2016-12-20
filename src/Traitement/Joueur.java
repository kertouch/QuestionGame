package Traitement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;

public class Joueur implements Serializable,Comparable<Joueur>{
    private String nom;
    private ArrayList<Domains> domainePredilection;
    private int score;

    public Joueur(String nom, ArrayList<Domains> domainePredilection){
        score = 0;
        this.domainePredilection = domainePredilection;
        this.nom = nom;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void incrScor(){
    this.score++;
     }
    

    public void setDomainePredilection(Domains domainePredilection) {
        this.domainePredilection.add(domainePredilection);

    }

    public void removeDomainePredilection(Domains dominePredilection) {
        this.domainePredilection.remove(dominePredilection) ;
    }

    public ArrayList<Domains> getDomainePredilection() {
        return domainePredilection;
    }

   
    // red�finiton de equals pour un objet de type joueur
    @Override
    public boolean equals(Object obj) {
        Joueur j = (Joueur)obj;
        return this.getNom().equals(j.getNom()); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDomainePredilection(ArrayList<Domains> domainePredilection) {
        this.domainePredilection = domainePredilection;
    }
    
  

    public boolean isContained(SortedSet<Joueur> joueurs){
        for (Joueur joueur:
             joueurs) {
            if (this.equals(joueur)) return true;
        }
        return false;
    }

    @Override
    public int compareTo(Joueur o) {
       if (this.getScore()> o.getScore()){
            return -1;
        }else return 1;
            
    }


   


   

  /* @Override
    public int compareTo(Object o) {
        if (o instanceof Joueur){
            return (score!= ((Joueur)o).getScore() )?((Integer)score).compareTo(((Joueur)o).getScore()) : nom.toLowerCase().compareTo(((Joueur)o).getNom().toLowerCase());
        }else return false; 
    }*/


    /**
     *
     * @param o
     * @return
     */
   
    

   
}
