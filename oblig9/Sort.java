/**
*
* @author Sindrech
*
* inf1010
* Oblig9
*
**/

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.concurrent.CountDownLatch;

class Sort{
	private ArrayList<String[]> arrays = new ArrayList<>();
	private ArrayList<String[]> sortert = new ArrayList<>();
	private CountDownLatch start;

	public void lesInn(File fil, int antTraader) throws Exception{
		System.out.println("7");

		Scanner in = new Scanner(fil);
		int antOrd = in.nextInt();
		//nullstille leseren
		in.nextLine();
		//oprette array med dokument fil
		String array[]= new String[antOrd];
		System.out.println("90");


		try{
			for(int i=0;i<antOrd;i++){
				array[i]=in.nextLine();
				System.out.println("1");

			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Prob array out of bound Exception");
		}

		int sortLength = antOrd/antTraader; //+-1

		//hvis ferre enn 1
		if(sortLength*antTraader < antOrd){
			sortLength++;
		}
		System.out.println(sortLength);

		String[] temp;
		int counter=0;
		//hvis 1 traad?
		for(int i=0; i<antTraader;i++){
			//oppretter ant trader
			temp = new String[sortLength];
			for(int k=0; k<sortLength;k++){
			//oppretter arrays og legger inn i arraylist
				if(counter < antOrd){
					temp[k]=array[counter];
					counter++;
				}else{break;}
			}
			arrays.add(temp);
		}


		//threads.add(new SortThread());
		//threads.start();
	}

	public void skrivUt(){

	}

	public synchronized void threadStart(){
		for(int i=0; i<arrays.size(); i++){
			if(arrays.get(i+1) != null){
				System.out.println(arrays.size());
				System.out.println(arrays.get(i) + "||" + arrays.get(i+1));
				new SortThread(arrays.get(i), arrays.get(i+1), this).start();
				arrays.remove(i);
				arrays.remove(i+1);
				i = 0;
			}else{sortert.add(arrays.get(i));}
			System.out.println(i + "||" + arrays.size());
		}

	}
	public synchronized void threadHandler(){
    //oppretter og lager traader
		for(int i=0; i<sortert.size();i++){
			if(arrays.get(i+1) != null){
				new SortThread(sortert.get(i), sortert.get(i+1), this).start();
				sortert.remove(i);
				sortert.remove(i+1);
			}
		}
	}
	public synchronized void nyListe(String[] ny){
		//arraylist som lagrer alle lister og sender med 2 nye lister til en traad
		sortert.add(ny);
		if(sortert.size()>=2){
			threadHandler();
		}
	}
}
