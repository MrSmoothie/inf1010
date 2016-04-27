class Rute{
    private char tegn;
    private int x;
    private int y;


    Rute(char tegnIn,int xKordi, int yKordi){
        this.tegn = tegnIn;
        this.x = xKordi;
        this.y =yKordi;
    }

    public char getTegn(){
      return tegn;
    }
}
