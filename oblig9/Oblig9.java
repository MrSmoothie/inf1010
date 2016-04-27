/**
*
* @author Sindrech
*
* inf1010
* Oblig9
*
**/

import java.util.concurrent.CountDownLatch;
import java.io.File;

class Oblig9{
	public static void main(String[] args) throws Exception{
		CountDownLatch start =null;
		Sort sort = new Sort();
		try{
			int antTraader = Integer.parseInt(args[0]);
			File fil = new File(args[1]);
			File fil1 = new File(args[2]);
			System.out.println("13");

			sort.lesInn(fil, antTraader);
			start = new CountDownLatch(antTraader);

		} catch (Exception e){
			System.out.println("wrong args");
			System.out.println("aalala");
			e.printStackTrace();
			System.exit(0);

		}

		System.out.println("THIS");

    //starter programmet
		sort.threadStart();

    //slutter programmet
		try{
			start.await();
		}catch(InterruptedException e){
			e.printStackTrace(); 
		} 
		


	}
}