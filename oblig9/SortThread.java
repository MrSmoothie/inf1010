/**
*
* @author Sindrech
*
* inf1010
* Oblig9
*
**/


import java.util.Arrays;
public class SortThread extends Thread{
	private String[] array;
	private String[] array1;
	private Sort m;


	SortThread(String[] array, String[] array1, Sort m){
		this.array=array;
		this.array1=array1;
		this.m=m;
	}

	public void run(){

		//sorteringen array.sort()
		Arrays.sort(array);
		Arrays.sort(array1);

		System.out.println("----------------------");
		for(String y : array){
			System.out.println(y);
		}
		for(String x : array1){
			System.out.println(x);
		}
		System.out.println("----------------------");
		/*for(int i=0; i<array.length;i++){
			if(array[i] != null){
			System.out.println(array[i]);

			}
		} */
		int c=0; //temp counter


		String[] temp = new String[array.length + array1.length];

		//if(array[0] == null){return;}
		//her må du ha sorterte arrrays, legger sorterer de sammen
		int i=0, k=0;
		while(i<array.length && k<array1.length){
			boolean tempA1 = false;
			boolean tempA = false;
			if(array[i].compareTo(array1[k]) <= 0){
				temp[c]=array[i];
				tempA = true;
			}
			if(array1[k].compareTo(array[i]) <= 0){
				temp[c]=array1[k];
				tempA1 = true;
			}
			if(tempA1 == true){
				k++;
			}
			if(tempA == true){
				i++;
			}
			c++;
		}while(i<array.length){
			if(array[i].compareTo(array1[k]) <= 0){
				temp[c]=array[i];
				i++;
			}
			c++;
		}while(k<array1.length){
			if(array1[k].compareTo(array[i-1]) <= 0){
				temp[c]=array1[k];
				k++;
			}
			c++;
		}
		m.nyListe(temp);
	}



}
