package com.cr1tterp0wer.DoubleLinkedList;

public class DoubleLinkedList<T> {


	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	DoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public Node<T> getHead(){
		return this.head;
	}

	public Node<T> getTail(){
		return this.tail;
	}
	
	public void append( T data ) {
		Node<T> newborn = new Node<T>( data );

		if( this.head == null ) {
			this.head = newborn;
			this.tail = newborn;
		}else {
			this.tail.next = newborn;
			newborn.prev = this.tail;
			this.tail = newborn;
		}
		size++;
	}
	
	public void prepend( T data ) {
	  Node<T> newborn = new Node<T>( data );
	  
	  if( this.head == null ) {
		  this.head = newborn;
		  this.tail = newborn;
	  }else {
		  this.head.prev = newborn;
		  newborn.next = this.head;
		  this.head = newborn;
	  }
	  size++;
	}
	
	public void insertAfter( Node<T> n, T d ) {
		
		Node<T> newborn = new Node<T>( d );

		if( this.head == null )
			return;
		
		Node<T> found = search( n.data );

		if( found != null ) {
			if( found == this.tail ) {
				this.append( d );
			}else {
				newborn.next = found.next;
				newborn.prev = found;
				found.next.prev = newborn;
				found.next = newborn;
			    size++;
			}
		}
	}
	
	public void delete( T d ) {
		Node<T> found = this.search( d );

		if( found != null ) {
			if( found == this.tail ) {
				this.tail = found.prev;
				found.prev.next = null;
				found.prev = null;
			}else if( found == this.head ) {
			    this.head = found.next;
			    this.head.prev = null;
			    found.next = null;
			}else {
				found.prev.next = found.next;
				found.next.prev = found.prev;
			}
			size--;
		}
	}
	
	public Node<T> search( T d ) {
		Node<T> current = this.head;
		while( current != null ) {
			if( current.data == d )
				return current;
			current = current.next;
		}

		return null;
	}
	
	public void printList() {
		Node<T> current = this.head;
		while( current != null ) {
			System.out.println( current.data );
			current = current.next;
		}
	}
	
	public int getSize() { return size; }
	
	//Private node class
	private class Node<T>{
		
        Node<T> next;
		Node<T> prev;
		T data;

		Node(){
		  next = null;
		  prev = null;
		  data = null;
		}

		Node( T d ){
			this.data = d;
			next = null;
			prev = null;
		}
	}
}
