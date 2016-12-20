package Traitement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Case implements Serializable{
    private Domains domaine;
    private Question question;
    private boolean lockPlayer1;
    private boolean lockPlayer2;
    private int numCase;
    public Case(Domains domaine,int numCase){
        this.domaine = domaine;
        this.numCase = numCase;
        this.lockPlayer1 = true;
        this.lockPlayer2 = true;
    }

    public Map randomQuestion(Map<Domains,ArrayList<Question>> listQuestion) {
     // Elle tire une question au hazard de la liste de question
     // Puis elle renvoi une map sans cette question qui sera suprimme pour qu'elle ne soit pas reutiliser
        Random random= new Random();
        ArrayList listQuestionDomain = listQuestion.get(this.domaine);
        System.out.println(listQuestionDomain.size());
        int index = random.nextInt(listQuestionDomain.size());
        question = (Question)listQuestionDomain.get(index);
        listQuestion.get(this.domaine).remove(question);
        return listQuestion;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }


    public void setDomaine(Domains domaine) {
        this.domaine = domaine;
    }

    public void setNbrCase(int nbrCase) {
        this.numCase = nbrCase;
    }

    public Domains getDomaine() {
        return domaine;
    }

    public int getNbrCase() {
        return numCase;
    }

    public void setLockPlayer1(boolean lockPlayer1) {
        this.lockPlayer1 = lockPlayer1;
    }

    public boolean isLockPlayer1() {
        return lockPlayer1;
    }

    public void setLockPlayer2(boolean lockPlayer2) {
        this.lockPlayer2 = lockPlayer2;
    }

    public boolean isLockPlayer2() {
        return lockPlayer2;
    }
}

