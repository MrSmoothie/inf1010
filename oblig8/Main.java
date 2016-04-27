import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
  char[] allowedChars = {'+','-','.','|', '@', '#', '&'};
  char[] splitters = {'+','-','|'};
  Brett boardOne;
  public void lesInnFil(String input){
    int yStr = 0;
    int str = 0;
    try{
      File f = new File(input);
      if(f.exists() && !f.isDirectory()) {
        Scanner reader = new Scanner(f);
        while(reader.hasNextLine()){
          int xStr = 0;
          char[] temp = reader.nextLine().toCharArray();
          if(temp.length != 1){
            if(temp[0] != '-'){
            for(int i = 0; i<temp.length; i++){
              if(yStr < str && xStr < str){
              if ((temp[i] >= 'a' && temp[i] <= 'z') || (temp[i] >= 'A' && temp[i] <= 'Z') || new String(allowedChars).indexOf(temp[i]) != -1 || temp[i] >= '0' && temp[i] <= '9'){
                if(new String(splitters).indexOf(temp[i]) == -1){
                  if(temp[i] != '.'){
                    boardOne.legTilRute(temp[i],xStr,yStr);
                  }
                  xStr++;
                }
              }else{
                throw new BrokenSyntax();
              }
            }else{
              throw new CharException();
            }
            }
              yStr++;
            }
          }else{
            int y = Character.getNumericValue(temp[0]);
            int x = Integer.parseInt(reader.nextLine());
            str = x*y;
            if(str != 64){
            boardOne = new Brett(y, x);
            }else{
                throw new BoardException();
            }
          }
        }
      }else{
        throw new NumberException();
      }

    }catch(FileNotFoundException err){
      err.getMessage();
    }catch(BrokenSyntax err){
      err.printError();
    }catch(NumberException err){
      err.printError();
    }catch(CharException err){
      err.printError();
    } catch(BoardException err){
      err.printError();
    }
  }

  private class BrokenSyntax extends Exception{
    public void printError(){
      System.out.println("ukjent syntaks paa filen, sjekk at alle tegn er riktige");
    }
  }

  private class NumberException extends Exception{
    public void printError(){
      System.out.println("Et av tallene er utenfor lovlig intervall");
    }
  }

  private class CharException extends Exception{
    public void printError(){
      System.out.println("Antall tegn stemmer ikke");
    }
  }

  private class BoardException extends Exception{
    public void printError(){
      System.out.println("For stort brett");
    }
  }

  public Brett getBrett(){
    return boardOne;
  }
}
