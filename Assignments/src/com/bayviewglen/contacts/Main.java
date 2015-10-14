package com.bayviewglen.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable{

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Shelf shelf = readShelf();
		boolean loop = true, correctInput = true;
		while(loop){
		shelf.displayAll();
		int choice = 0;
		while(correctInput){
		System.out.println("What would you like to do? (Choose Number)");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" 1. Create a Book \n 2. Delete a Book\n 3. Open a Book\n 4. Close");
		try{
			choice = Integer.parseInt(input.nextLine());
			correctInput = false;
		}catch(NumberFormatException e){
			System.out.println("Please enter a number!\n");
		}
		}
		correctInput = true;
		
		if(choice == 1){
			System.out.println("What is the name?");
			String temp = input.nextLine();
			shelf.newAdressBook(temp);
		}else if (choice == 2){
			System.out.println("What is the name?");
			String temp = input.nextLine();
			shelf.deleteAdressBook(temp);			
		}else if(choice == 3){
			System.out.println("What is the name?");
			String temp = input.nextLine();
			shelf.openBook(temp);	
		}else if(choice == 4){
			
			loop = false;
			
		}else{
			
			System.out.println("Invalid Entry");
			
		}
	}
		
		saveShelf(shelf);
		
	}
	
	private static Shelf readShelf() throws FileNotFoundException {
		Shelf deserializedShelf = null;
		try {
            FileInputStream fileIn = new FileInputStream("data/saveFile.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedShelf = (Shelf) in.readObject();
            in.close();
            fileIn.close();
            return deserializedShelf;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
		return deserializedShelf;
		
	}
	
	private static void saveShelf(Shelf Shelf) {

		try {
			FileOutputStream fileOut = new FileOutputStream("data/saveFile.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Shelf);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

}
