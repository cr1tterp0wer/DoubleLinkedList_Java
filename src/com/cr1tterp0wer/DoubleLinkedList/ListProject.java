package com.cr1tterp0wer.DoubleLinkedList;

public class ListProject {
	
	public static void main( String[] args) {

		DoubleLinkedList<String> names = new DoubleLinkedList<String>();
		names.append("Satan");
		names.append("Lucifer");
		names.append("Azmodius");
		names.append("Satanas");
		names.prepend("Azmodon");
		names.insertAfter(names.getTail(), "Diabolo");
		names.delete("Lucifer");
		names.delete("Diabolo");
		names.delete("Satan");

		names.printList();
	}
}
