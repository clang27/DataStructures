import java.util.*;
/*
	With help from Carnegie Mellon University CS Department

	Created By: Collin Lang
	August 14th, 2017
	For: Cement my knowledge of Linked-Lists through Java and pulling my code onto GitHub
	Used: Ubuntu 64-bit Linux OS in VMWare, gedit, and JDK7

	What I learned from this:
		The AnyType Object
		How to instatiate objects with <> DataTypes attached to them
*/

public class LinkedList<AnyType> implements Iterable<AnyType>{
	public static void main(String[] args){
		LinkedList<String> list = new LinkedList <String>();
		list.addFirst("Hello");
		list.addLast("World");
		System.out.println(list);
		System.out.println("Size: " + list.size());
	}
/*---------------------------------------------------------------------*/
	private static class Node<AnyType>{
		private AnyType data;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> next){
			this.data = data;
			this.next = next;
		}
	}
/*---------------------------------------------------------------------*/
	private class LinkedListIterator implements Iterator<AnyType>{
		private Node<AnyType> next;

		public LinkedListIterator(){
			next = head;
		}

		public boolean hasNext(){
			return next != null;
		}

		public AnyType next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			AnyType res = next.data;
			next = next.next;
			return res;
		}

		public void remove() { 
			throw new UnsupportedOperationException(); 
		}
	}
/*---------------------------------------------------------------------*/
	private Node<AnyType> head;
	public LinkedList(){
	   head = null;
	}
	public boolean isEmpty() {
	   return head == null;
	}

	public void addFirst(AnyType data) {
	   head = new Node<AnyType>(data, head);
	}

	public AnyType getFirst()  {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	public AnyType removeFirst()  {
		AnyType temp = getFirst();
		head = head.next;
		return temp;
	}
	public void addLast(AnyType data) {
	   if(this.isEmpty())
		 addFirst(data);
	   else{
		Node<AnyType> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}

		temp.next = new Node<AnyType>(data, null);
	   }
	}
	public int size(){
		int size = 0;
		if(!this.isEmpty()){
			Node<AnyType> temp = head;
			while(temp != null){
				temp = temp.next;
				size++;
			}
		}
		return size;
	}
	public AnyType getLast() {
		if(this.isEmpty()) {	
			throw new NoSuchElementException();
		}

		Node<AnyType> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}

	      return temp.data;
	   }

	   public void clear(){
	      head = null;
	   }

	   public boolean contains(AnyType x) {
		for(AnyType temp : this){
			if(temp.equals(x)){
				return true;
			}
		}

		return false;
	   }
	   public AnyType get(int pos){
		if (head == null) {
			throw new IndexOutOfBoundsException();
		}

		Node<AnyType> temp = head;
		for (int k = 0; k < pos; k++){
			temp = temp.next;
		}

		if (temp == null) {
			throw new IndexOutOfBoundsException();
		}

		return temp.data;
	   }
	   public String toString(){
		StringBuffer result = new StringBuffer();
		for(Object x : this)
		      	result.append(x + " ");

		return result.toString();
	   }
	   public void insertAfter(AnyType key, AnyType toInsert){
		Node<AnyType> temp = head;

		while(temp != null && !temp.data.equals(key)){
			temp = temp.next;
		}

		if(temp != null){
			temp.next = new Node<AnyType>(toInsert, temp.next);
		}
	   }
	   public void insertBefore(AnyType key, AnyType toInsert){
		if(head != null){	
			if(head.data.equals(key)){
				addFirst(toInsert);
	      		}
			else{
				Node<AnyType> prev = null;
				Node<AnyType> cur = head;

				while(cur != null && !cur.data.equals(key)){
					prev = cur;
					cur = cur.next;
				}
				if(cur != null){
					prev.next = new Node<AnyType>(toInsert, cur);
				}
			}
		}
	   }
	   public void remove(AnyType key){
		if(head != null){	
			if(head.data.equals(key)){
				head = head.next;
	      		}
			else{
				Node<AnyType> cur  = head;
				Node<AnyType> prev = null;

				while(cur != null && !cur.data.equals(key) ){
					prev = cur;
					cur = cur.next;
				}

				if(cur == null)
					throw new RuntimeException("Node is Null");
				prev.next = cur.next;
			}
		}
	   }
	   public Iterator<AnyType> iterator(){
		return new LinkedListIterator();
	   }
}
