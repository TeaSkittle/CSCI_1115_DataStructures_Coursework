// By: Travis Dowd
// Date: 9-24-2020 ( start date )
//
// TODO: Focus on marking a habit complete, then try and fix the delete function
//

package Final;

import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.file.*;

class Main {
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
	
	public static void getInput() throws IOException {
		Scanner input = new Scanner( System.in );
		System.out.print( "\n> " );
		String option = input.nextLine().trim().toLowerCase();
		switch( option ){
			case "help":
				System.out.println( "Available options:" );
				System.out.println( "List   - Show all active habits" );
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
				// mark a habit complete
				break;
			case "new":
				if( Files.notExists( Paths.get( "Habits/" ))){
					Files.createDirectories( Paths.get( "Habits/" ));
				} createHabit(); 
				break;
			case "delete":
				System.out.println( "------------------------------");
				System.out.println( "  WARNING: Still has issues" );
				System.out.println( "------------------------------");
				if( Files.notExists( Paths.get( "Habits/" ))){
					System.out.println( "No habits to delete..." );
				} deleteHabit();
				break;
			default:
				System.out.println( "Error: Unkown command..." );
		}
	}
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
}