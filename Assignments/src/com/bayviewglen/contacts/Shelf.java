package com.bayviewglen.contacts;

import java.io.Serializable;
import java.util.ArrayList;

public class Shelf implements Serializable{

	private ArrayList<AdressBook> shelf;

	public Shelf() {
		
		shelf = new ArrayList<AdressBook>();
		
	}
	
	public void newAdressBook(String name){
		
		AdressBook book = new AdressBook(name);
		shelf.add(book);
		
	}
	
	public void deleteAdressBook(String name){
		
		for(int i = 0; i < shelf.size(); i++){
				
			if(shelf.get(i).getName().equals(name)){
				
				shelf.remove(i);
				
			}else if(i == shelf.size() - 1){
				System.out.println("No such book exists.");
			}
		}
			
	}	
	
	public void openBook (String name){
		
		for(int i = 0; i < shelf.size(); i++){
				
			if(shelf.get(i).getName().equals(name)){
				
				shelf.get(i).interfaceMethod();
				
			}else if(i == shelf.size() - 1){
				System.out.println("No such book exists.");
			}
		}
			
	}	
	
	
	public void displayAll(){
			
		System.out.println("Books:");
		System.out.println("______________________");
		
		for(int i = 0; i < shelf.size(); i++){
			System.out.println("|" + shelf.get(i).getName());
			System.out.println("______________________");
		}
		
	}
	
	
}
