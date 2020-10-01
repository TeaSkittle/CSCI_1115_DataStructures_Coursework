/*
============================================================
By: Travis Dowd
Date: 9-24-2020
============================================================
*/

//
// TODO: Test done/mark with older habits
//


package Final;

import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.file.*;

class Final {
	/*
	===============================================================
	Main Section
		This section contains the main method and global variables.
	===============================================================
	*/
	private static Habit habits = new Habit();
	
	public static void main( String[] args ) {	
		System.out.println( "   66-Days   " );
		System.out.println( "-------------" );
		System.out.println( "\nType 'Help' to view options..." );
		while( true ){ 
			try { getInput(); } 
			catch( IOException ex ){ ex.printStackTrace(); }
		}	
	}
	/*
	===============================================================
	getInput() Method
		A void method utilizing a case-switch style of control flow
		to be the source of user interaction.
	===============================================================
	*/
	public static void getInput() throws IOException {
		Scanner input = new Scanner( System.in );
		System.out.print( "\n> " );
		String option = input.nextLine().trim().toLowerCase();
		switch( option ){
			case "help":
				System.out.println( "Available options:" );
				System.out.println( "List   - Show all active habits" );
				System.out.println( "View   - View progress on a habbit" );
				System.out.println( "Done   - Mark a habit as completed for today" );
				System.out.println( "New    - Create a new habit" );
				System.out.println( "Delete - Remove habit ( Warning! Permanetely deletes the habit! )" );
				System.out.println( "Exit   - Close out of 66 Days, don't forget those habits!" );
				break;
			case "list":
				System.out.println( "Active Habits:\n");
				habits.printMap();
				break;
			case "exit":
				System.exit( 0 );
				break;
			case "done":
				markHabit();
				break;
			case "view":
				viewHabit();
				break;
			case "new":
				if( Files.notExists( Paths.get( "Habits/" ))){
					Files.createDirectories( Paths.get( "Habits/" ));
				} createHabit(); 
				break;
			case "delete":
				if( Files.notExists( Paths.get( "Habits/" ))){
					System.out.println( "No habits to delete..." );
				} deleteHabit();
				break;
			default:
				System.out.println( "Error: Unkown command..." );
		}
	}
	/*
	================================================================
	Habit Methods
		These methods are used in the above getInput() method, these
		all essentially get additional user input and call a method
		from the Habit class.
	================================================================
	*/
	public static void createHabit(){
		Scanner in = new Scanner( System.in );
		System.out.print( "Habit name: " );
		String name = in.nextLine().trim().toLowerCase();
		Habit newHabit = new Habit( name );
		newHabit.writeHabit();
	}
	public static void deleteHabit(){
		Scanner in = new Scanner( System.in );
		System.out.print( "Habit name: " );
		String name = in.nextLine().trim().toLowerCase();
		Habit newHabit = new Habit( name );
		newHabit.removeHabit();
	}
	public static void viewHabit(){
		Scanner in = new Scanner( System.in );
		System.out.print( "Habit name: " );
		String name = in.nextLine().trim().toLowerCase();
		Habit newHabit = new Habit( name );
		newHabit.printHabit();
	}
	public static void markHabit(){
		Scanner in = new Scanner( System.in );
		System.out.print( "Habit name: " );
		String name = in.nextLine().trim().toLowerCase();
		Habit newHabit = new Habit( name );
		newHabit.changeHabit();
	}
}