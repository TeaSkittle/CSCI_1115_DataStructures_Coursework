// By: Travis Dowd
// Date: 9-24-2020 ( start date )

package Final;

import java.util.*;
import java.text.*;
import java.io.*;

class Main {
	public static void main( String[] args ) {
		//
		// DEBUGGING
		//
		// create blank habit object to start with
		Habit blank = new Habit();
		//
		// Structure of program:
		// - Welcome Screen
		// - List currently active habits
		// - Prompt user for input
		// - input will be either:
		//		1. Mark a habit completed today
		//		2. Create a new Habit
		//		3. Delete a current habit
		//		4. View More habit stats
		//
		System.out.println( "   66-Days   " );
		System.out.println( "-------------" );
		System.out.println( "Active Habits:");
		try { blank.readMap(); } 
		catch( FileNotFoundException ex ){
			System.out.println( "No habits yet..." );
		} System.out.println( "\nType 'Help' to view options..." );
		while( true ){ getInput(); }	
	}
	
	public static void getInput() {
		Scanner input = new Scanner( System.in );
		System.out.print( "\n> " );
		String option = input.nextLine().trim().toLowerCase();
		switch( option ){
			case "help":
				System.out.println( "Available options:" );
				System.out.println( "Done   - Mark a habit as completed for today" );
				System.out.println( "New    - Create a new habit" );
				System.out.println( "Delete - Remove habit ( Warning! Permanetely deletes the habit! )" );
				System.out.println( "Exit   - Close out of 66 Days, don't forget those habits!" );
				break;
			case "exit":
				System.exit( 0 );
				break;
			case "done":
				// mark a habit complete
				break;
			case "new":
				// create a new habit
				break;
			case "delete":
				// remove a habit
				break;
			default:
				System.out.println( "Error: Unkown command..." );
		}
	}
	
}