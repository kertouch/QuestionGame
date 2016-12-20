package Traitement;
import java.io.Serializable;
import java.util.Random;

public class Question implements Serializable{
    protected String question;
    protected String answer;
    protected String[] suggestions;
    protected Domains domaine;
    public Question(String question ,String answer,String[] suggestions ,Domains domaine) {
        this.suggestions=suggestions.clone();
        this.answer=answer;
        this.question=question;
        this.domaine = domaine;
    }

    public boolean answerIsTrue(String playerAnswer){
        return playerAnswer.equals(answer);
    }
    public String[] displaySuggestions(NiveauDiffeculte niveauDiffeculte){
        String[] suggestions = new String[4];
        Random random = new Random();
        int indexMedium ;
        switch (niveauDiffeculte){
            case Hard:
                        suggestions[0] = " Taper la bonne reponse: ";
                break;
            case Medium:
                int indexEasy =random.nextInt(4);
                        suggestions[indexEasy]= answer;
                        int indexEasy1 = restrictionNumberRandom(4, indexEasy);
                        suggestions[indexEasy1] = this.suggestions[0];
                        int indexEasy2 = restriction2NumberRandom(4, indexEasy, indexEasy1);
                        suggestions[indexEasy2] = this.suggestions[1];
                        int indexEasy3 = restriction3NumberRandom(4, indexEasy, indexEasy1, indexEasy2);
                         suggestions[indexEasy3]= this.suggestions[2];
                
                        
                break;
            case Easy:
                        indexMedium = random.nextInt(2);
                        suggestions[indexMedium] = answer;
                        suggestions[restrictionNumberRandom(2,indexMedium)]= randomStringArray(this.suggestions);
                break;

        }
        return suggestions;
    }

    public String randomStringArray(String[] strings){
        Random random = new Random();
        int index = random.nextInt(strings.length);
        return strings[index];

    }

    public int restrictionNumberRandom(int randomListLengh, int restrictedNumber){
        Random random= new Random();
        int randomNumber = random.nextInt(randomListLengh);
        while (randomNumber == restrictedNumber){
            randomNumber = random.nextInt(randomListLengh);
        }
            return randomNumber;
    }
    public int restriction2NumberRandom(int randomListLengh, int restrictedNumber1,int restrictedNumber2){
        Random random= new Random();
        int randomNumber = random.nextInt(randomListLengh);
        while ((randomNumber == restrictedNumber1)||(randomNumber == restrictedNumber2)){
            randomNumber = random.nextInt(randomListLengh);
        }
        return randomNumber;
    }
    public int restriction3NumberRandom(int randomListLengh, int restrictedNumber1,int restrictedNumber2,int restrictedNumber3){
        Random random= new Random();
        int randomNumber = random.nextInt(randomListLengh);
        while ((randomNumber == restrictedNumber1)||(randomNumber == restrictedNumber3)||(randomNumber == restrictedNumber2)){
            randomNumber = random.nextInt(randomListLengh);
        }
        return randomNumber;
    }

    public Domains getDomaine() {
        return domaine;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getSuggestions() {
        return suggestions;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDomaine(Domains domaine) {
        this.domaine = domaine;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSuggestions(String[] suggestions) {
        this.suggestions = suggestions;
    }
    
    
    
}
