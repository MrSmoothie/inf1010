import java.util.*;
class Rute{
    private int tegn;
    private int x;
    private int y;
    private int antTegn;
    private ArrayList<Integer> solution = new ArrayList<Integer>();
    private Boks boks;
    private Rad rad;
    private Kolonne kolonne;

    Rute(int tegnIn,int xKordi, int yKordi, int str){
        this.tegn = tegnIn;
        this.x = xKordi;
        this.y =yKordi;
        this.antTegn = str;
    }

    public int getTegn(){
        return tegn;
    }

    public int[] finnAlleMuligeTegn(){
        for(int i = 1; i<antTegn+1;i++){
            if(!boks.inneholder(i) && !rad.inneholder(i) && !kolonne.inneholder(i)){
                solution.add(i);
            }
        }

        int[] temp = new int[solution.size()];
        for (int i=0; i < temp.length; i++)
        {
            temp[i] = solution.get(i).intValue();
        }
        return temp;
    }

    public void addKolonne(Kolonne input){
        this.kolonne = input;
    }

    public void addRad(Rad input){
        this.rad = input;
    }

    public void addBoks(Boks input){
        this.boks = input;
    }

    public void fyllUtDenneRuteOgResten(){
      int[] temp = finnAlleMuligeTegn();
      for(int i = 0; i<temp.length;i++){

      }
    }

}
