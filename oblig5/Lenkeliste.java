class Lenkeliste<E extends Comparable<E>>{
	Node first;
	int antall=0;
	//lager Node klassem
	private class Node{
		Node next;
		E thing;
		public Node(E e){
			thing=e;
		}
	}
	//sjekker om Listen er tom
	public boolean tom(){
		return (antall == 0);
	}
	//Legger til en ny node forran i listen LiFo
	public void leggTil(E e){
		Node temp = new Node(e);
		temp.next=first;
		first=temp;
		antall++;
	}
	//Fjerner Det Objektet med minst "E thing"
	public E fjernMinste(){
		if (tom()){
			return null;
		}
		E minste = first.thing;
		Node temp = first;
		Node remove = null;
		//while lokke for a finne den minste
		while(temp.next != null){
			if(temp.next.thing.compareTo(minste) < 0){
				minste = temp.next.thing;
				remove = temp;
			}
			temp = temp.next;
		}
		antall--;
		//fjerner den minste

		if(minste != first.thing){
		//	temp=remove.next;
			remove.next = remove.next.next;

		}else{
			first = first.next;
		}
		return minste;
	}

	public boolean inneholder(E e){
		Node temp=first;
		while(temp != null){
			if(temp.thing.compareTo(e) ==0){
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
}
