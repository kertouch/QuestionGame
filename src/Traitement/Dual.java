package Traitement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Dual extends Partie implements Serializable{
    private int scor1;
    private int scor2;
    private int numQuestion1;
    private int numQuestion2;
    private int numCase;


    public Dual(Joueur joueur1, Joueur joueur2,int numCase){
        super(joueur1,joueur2);
        scor1 = 0;
        scor2 = 0;
        numQuestion1 = 1;
        numQuestion2 = 1;
        this.numCase = numCase;

    }

    public int getNumCase() {
        return numCase;
    }
    

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }
    public void incrScor1() {
        this.scor1++;
    }

    public void incrScor2() {
        this.scor2++;
    }

    public int getScor1() {
        return scor1;
    }

    public int getScor2() {
        return scor2;
    }

    public void incrNumQuestion1() {
        this.numQuestion1++;
    }

    public int getNumQuestion1() {
        return numQuestion1;
    }

    public void incrNumQuestion2() {
        this.numQuestion2++;
    }

    public int getNumQuestion2() {
        return numQuestion2;
    }

    public ArrayList<Question> questionsDualPlayer(Joueur joueur) {
        ArrayList<Question> listQuestion = new ArrayList<Question>();
        ArrayList<Domains> d = joueur.getDomainePredilection();
        Iterator it = d.iterator();
      //  System.out.println(this.listMapQuestion.isEmpty());
        while (it.hasNext()) listQuestion.addAll(this.listMapQuestion.get(it.next()));
        return listQuestion;

    }

    public Question randomQuestionSelector(ArrayList<Question> listQuestion){
        Random random = new Random();
        int index = random.nextInt(listQuestion.size());
        return listQuestion.get(index);
    }

    public boolean joueurGagnant(){
        if ((getScor1() == getScor2())&&(getScor1() == 3))
            return false;
        else{
            if (getScor1() > getScor2())return true;
            else return false;
        }
    }


    public boolean endDuel(){
        return (((getScor1()- getScor2()>=2)||(getScor2()-getScor1()>=2)&&(numQuestion1>2))&&(numQuestion2>2)||((numQuestion1>3)&&(numQuestion2>3)));
    }


    public Question questionDual(Joueur joueur){
           return randomQuestionSelector(questionsDualPlayer(joueur)) ;
        }
    public void responsQuestion(Joueur joueur,Question question,String response){
        if (response.equals(question.answer)){
            if (joueur == getJoueur1()) 
                incrScor1();  
            else 
                incrScor2();    
        }
        if (joueur == getJoueur1()) {
          
                incrNumQuestion1();
                setJoueurActual(getJoueur2());
            }else {
                
                incrNumQuestion2();
               setJoueurActual(getJoueur1());
    }

}


}