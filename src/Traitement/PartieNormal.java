package Traitement;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class PartieNormal extends Partie implements Serializable{
    private Joueur joueur1;
    private int position1;
    private int pas1;
    protected Case[] listCase1;
    protected Case[] listCase2;
 
    private Joueur joueur2;
    private int position2;
    private int pas2;

  
   

    public PartieNormal(Joueur joueur1, Joueur joueur2,int nbrCase,String url){
        super( joueur1, joueur2);
        
        
        /// Initialisation pour le joueur 1
         setPas1(0);
        setJoueur1(joueur1);
        listCase1 = new Case[42];
        Random random =new Random();
       for (int j = 1; j < 43; j++) {
            listCase1[j-1] = new Case(randomEnum(Domains.class,random),j);
        }
        setPosition1(1);
        listCase1[0].setLockPlayer1(false);
        
        
        
        
        
        
        //////// Initialisation pour le joueur 2
        
        
        setPas2(0);
        setJoueur2(joueur2);
        listCase2 = new Case[42];
      //  Random random =new Random();
       for (int j = 1; j < 43; j++) {
            listCase2[j-1] =new Case(randomEnum(Domains.class,random),j);
        }
        setPosition2(1);
        listCase2[0].setLockPlayer1(false);
        
        
        
        
        
        
        
        
        
        
        
        
        /////////////////////////
     
        
        //Initialisation de la liste de questions

        ArrayList<Question> questions;
        listMapQuestion = new HashMap<Domains, ArrayList<Question>>();
        for (Domains s : Domains.values()){
            questions = new ArrayList<Question>();
            listMapQuestion.put(s, questions);
        }
        extractQuestionDomain(url);
      
    }

    public boolean nmbrPas(Joueur joueur,Question question,String reponse,NiveauDiffeculte niveauDiffeculte,int pos){
        int pas = 0;
        Boolean answer= false;
        if (question.answer.equals(reponse)){
            answer =true;
         // la reponse est juste on valid la postion du joueur;
             if(joueur == getJoueur1())
                 setPosition1(pos);
            else
                 setPosition2(pos);
            
            
            switch (niveauDiffeculte) {
                case Hard:
                    if (joueur.getDomainePredilection().contains(question.domaine))
                        pas= 4;
                    else pas = 5;
                    break;
                case Medium:
                    if (joueur.getDomainePredilection().contains(question.domaine))
                        pas =2;
                    else pas = 3;
                    break;
                case Easy:
                    if (joueur.getDomainePredilection().contains(question.domaine))
                        pas = 1;
                    else pas = 2;
                    break;
            }
        }

       if (joueur == this.getJoueur1()){
            
             setPas1(pas);

        }else {
            
            setPas2(pas);
        }
       return answer;
    }

    public boolean startDual(Case caseJoueur, Case caseDuChallenger){
        return caseDuChallenger == caseJoueur;

    }
    public Dual lanceDual(int numCase){
        Dual dual =new Dual(getJoueur1(),getJoueur2(),numCase);
        dual.setListMapQuestion(this.listMapQuestion);
        return dual ;
    }

  

    public ArrayList<String[]> extractAllQuestions(String str){
        ///Methode suprime les virgules ... les saut de lingne
        ///Elle stock chaque ligne dans un String[] se String[] a comme elements ["La question","La reponse","prop1","prop2","prop3']
        String[] lines = str.split("\n");
        ArrayList<String[]> lines2 = new ArrayList<String[]>();
        String[] strTransit ;

        for (String s : lines) {
            if (s.length()>10) {
                strTransit = s.split(";");
                strTransit[0] = strTransit[0].replace("<", "");
                strTransit[0] = strTransit[0].replace(">", "");
                lines2.add(strTransit);
            }
        }

        return lines2;
    }

    public Joueur createNewPlayer(String nom, ArrayList<Domains> domains){
        return new Joueur(nom,domains);

    }
    public PartieNormal lancementPartie(String nomJoueur1, ArrayList<Domains> domainsJoueur1,String nomJoueur2, ArrayList<Domains> domainsJoueur2,int nbrCase,String url){
        Joueur joueur1 = createNewPlayer(nomJoueur1,domainsJoueur1);
        Joueur joueur2 = createNewPlayer(nomJoueur2,domainsJoueur2);
        return new PartieNormal(joueur1,joueur2,nbrCase,url) ;

    }

   



   public void extractQuestionDomain(String fileName){
       /// Sauvgarde les questions dans l attribut listMapQuestions
        String str = loadFileString(fileName);
        ArrayList<String[]> lines = extractAllQuestions(str);

       Question question;
       String[] suggests = new String[3];

       for (String[] s : lines) {
       /// extrair les suggestions ds questios;
           suggests[0] = s[3];
           suggests[1] = s[4];
           suggests[2] = s[5];

           /// Pour eviter les accents on les supprime
           s[0]= s[0].toLowerCase().replace("�","e");
           s[0]= s[0].replace("è", "e");
           s[0]= s[0].replace(" ","_");

           ///Ranger les questios dans la map selon leur Domain;
               switch (Domains.valueOf(s[0])) {
                   case science:
                       question = new Question(s[1],s[2],suggests,Domains.science);
                       listMapQuestion.get(Domains.science).add(question);
                       break;
                   case histoire:
                       question = new Question(s[1],s[2],suggests,Domains.histoire);
                       listMapQuestion.get(Domains.histoire).add(question);
                       break;
                   case geographie:
                       question = new Question(s[1],s[2],suggests,Domains.geographie);
                       listMapQuestion.get(Domains.geographie).add(question);
                       break;
                   case sport:
                       question = new Question(s[1],s[2],suggests,Domains.sport);
                       listMapQuestion.get(Domains.sport).add(question);
                       break;
                   case musique:
                       question = new Question(s[1],s[2],suggests,Domains.musique);
                       listMapQuestion.get(Domains.musique).add(question);
                       break;
                   case cinema:
                       question = new Question(s[1],s[2],suggests,Domains.cinema);
                       listMapQuestion.get(Domains.cinema).add(question);
                       break;
                   case culture_generale:
                       question = new Question(s[1],s[2],suggests,Domains.culture_generale);
                       listMapQuestion.get(Domains.culture_generale).add(question);
               }

       }




    }


    public String  loadFileString(String fileName){

        /// Extrait les donnees du fichier et renvoi un String contentenat le tout
        File file = new File(fileName);
        FileReader fr;
        String str ="";
        try {
            fr = new FileReader(file);

            int i;
            while((i = fr.read()) != -1)
                str += (char)i;
           // System.out.println(str);
            fr.close();


        }catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
    
    
    
    ////seters and getters

    public Map<Domains, ArrayList<Question>> getListMapQuestion() {
        return listMapQuestion;
    }

    @Override
    public Joueur getJoueur1() {
        return super.getJoueur1(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur getJoueur2() {
        return super.getJoueur2(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur getJoueurActual() {
        return super.getJoueurActual(); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void setJoueur1(Joueur joueur1) {
        super.setJoueur1(joueur1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJoueur2(Joueur joueur2) {
        super.setJoueur2(joueur2); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJoueurActual(Joueur joueurActual) {
        super.setJoueurActual(joueurActual); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void setListMapQuestion(Map<Domains, ArrayList<Question>> listMapQuestion) {
        super.setListMapQuestion(listMapQuestion); //To change body of generated methods, choose Tools | Templates.
    }

 

    /////Method de troncon
  
    public void setListCase1(Case[] listCase) {
        this.listCase1 = listCase;
    }
    public void setListCase2(Case[] listCase) {
        this.listCase2 = listCase;
    }

    public void setPas1(int pas1) {
        this.pas1 = pas1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }
    
    
   
     public static <T extends Enum<?>> T randomEnum(Class<T> clazz,Random random){

        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
     
      public void setUnLockCase1() {
        for (int i = getPosition1(); i < getPosition1()+ getPas1(); i++) {
            if(i<42)
            listCase1[i].setLockPlayer1(false);
        }
        for(int j = getPosition1()-1; j >= 0;j--){
            listCase1[j].setLockPlayer1(true);
        }
                

    }
      public void setUnLockCase2() {
        for (int i = getPosition2(); i < getPosition2()+getPas2(); i++) {
            if(i<42)
            listCase2[i].setLockPlayer1(false);
        }
        for(int j = getPosition2()-1; j >= 0;j--){
            listCase2[j].setLockPlayer1(true);
        }
                

    }

    public void setPas2(int pas2) {
        this.pas2 = pas2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

   
     public Case[] getListCase1() {
        return listCase1;
    }
      public Case[] getListCase2() {
        return listCase2;
    }

    public int getPas1() {
        return pas1;
    }

    public int getPas2() {
        return pas2;
    }

    public int getPosition1() {
        return position1;
    }

    public int getPosition2() {
        return position2;
    }

 
    
 public void savePartie(PartieNormal pn) throws IOException{
    ObjectOutputStream oos = null;
    FileOutputStream fout = null;
    try{
         fout = new FileOutputStream("E:\\karimSer.txt", true);
         oos = new ObjectOutputStream(fout);
        // System.out.println(pn.getNomPartie());
        oos.writeObject(pn);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(oos  != null){
            oos.close();
        } 
}
    }
 
 public void loadPartie() throws IOException{
     
     ObjectInputStream objectinputstream = null;
try {
    FileInputStream streamIn = new FileInputStream("E:\\karimSer.txt");
    objectinputstream = new ObjectInputStream(streamIn);
    PartieNormal pn = (PartieNormal) objectinputstream.readObject();
    System.out.println(pn);
    
    System.out.println(pn.getJoueur2().getNom());
    System.out.println(pn.getJoueur1().getNom());
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if(objectinputstream != null){
        objectinputstream .close();
    } 
}



}

}