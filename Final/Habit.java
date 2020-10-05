/*
============================================================
By: Travis Dowd
Date: 9-24-2020
============================================================
*/

package Final;

import java.util.*;
import java.io.*;
import java.awt.print.*;
import java.text.*;
import javax.swing.plaf.*;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

class Habit {
	/*
	============================================================
	Class Basics
		This section contains varaible declarations, contructors
		and other general Java requirements for a Class file.
	============================================================
	*/
	private Date date = Calendar.getInstance().getTime();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	private String strDate = dateFormat.format(date);
	private String name;
	private HashMap<String, String> map = new HashMap<String, String>();
	private String mapFile = "HabitMap";
	private int[] array;
	
	/* Getters, not being used
	public Date getDate(){ return this.date; }
	public String getName(){ return this.name; }
	public int[] getArray(){ return this.array; }
	public HashMap<String, String> getMap(){ return this.map ;}
	*/
	
	public Habit(){}
	public Habit( String name ){
		this.array = new int[ 66 ]; // defaulted with 0's
		this.name = name;
		map.put( this.name, strDate );
	}
	/*
	===========================================================
	Array Methods
		This secion contains the methods affecting the arrays
		and file operations of each habit
	===========================================================
	*/
	public void writeHabit(){
		try {
			FileWriter writer = new FileWriter( "Habits/" + name );
			for ( int i = 0; i < array.length; i++ ){
				writer.write( array[ i ] + " " );
			}
			writer.close();
			writeMap();
		} catch( IOException ex ){
			ex.printStackTrace();
		}
	}
	public void removeHabit() {
		File file = new File( "Habits/" + name );
		if( file.delete() ){
			System.out.println( "Habit removed" );
			try {
				Map<String, String> mapFileContents = new HashMap<String, String>();
				mapFileContents = readMap();
				mapFileContents.remove( name );
				File mFile = new File( mapFile );
				FileWriter fw = new FileWriter( mFile, false );
				BufferedWriter bw = new BufferedWriter( fw );
				PrintWriter pw = new PrintWriter( bw );
				for( Map.Entry<String, String> entry : mapFileContents.entrySet() ){
					pw.println( entry.getKey() + ":" + entry.getValue() );
				} pw.flush();
				pw.close();
			} catch( IOException ex ){
				ex.printStackTrace();
			}
		} else {
			System.out.println( "Failed to remove habit" );
		}
	}
	public int[] readHabit() throws FileNotFoundException {
		try {
			Scanner s = new Scanner( new File( "Habits/" + name ));
			for( int i = 0; i < array.length; i++ ){
				array[ i ] = s.nextInt();
			}
		} catch( IOException ex ){
			ex.printStackTrace();
		} return array;
	}
	public void printHabit(){
		int[] fileArray;
		try {
			fileArray = readHabit();
			System.out.print( "Started on: " );
			printDate();
			System.out.println( "\t\tWeek" );
			int week = 1;
			for( int i = 0; i < fileArray.length; i++ ){
				if( i % 7 == 0  && i >= 7 ){ 
					System.out.print( "\t" + week +"\n" );
					week++;
				} System.out.print( fileArray[ i ] + " " );
				if( i == 65 ){
					System.out.print( "\t\t10" );
				}			
			} System.out.print( "\n" );
		} catch( FileNotFoundException ex ){
			ex.printStackTrace();
		}
	}
	// This is for the changeHabit method, returns the difference of two Dates
	// https://stackoverflow.com/questions/20165564/calculating-days-between-two-dates-with-java
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	// https://stackoverflow.com/questions/10118327/addition-and-subtraction-of-dates-in-java
	public void changeHabit(){
		int[] fileArray;
		Date startDate;
		String currentDate = dateFormat.format( date );
		Map<String, String> mapFileContents = new HashMap<String, String>();
		try {
			// get start date from map
			mapFileContents = readMap(); 
			String habitStr = mapFileContents.get( name );
			startDate = new SimpleDateFormat( "yyyy-MM-dd" ).parse( habitStr );
			// Get today's date
			//Date today = dateFormat.parse( habitStr );
			Date today = new Date();
			today.setHours(0); 
			today.setMinutes(0); 
			today.setSeconds(0);
			Calendar cal = GregorianCalendar.getInstance();
			// Do math operations on date
			cal.setTime( startDate );
			long days = getDifferenceDays( startDate, today );
			cal.add( GregorianCalendar.DATE, (int)days );
			// 
			// Testing
			//
			//System.out.println( "result: " + dateFormat.format( cal.getTime() ));
			//System.out.println( "days: " + days );
			// change array, after tested futher
			fileArray = readHabit();
			// Overwrite habit file with new array
			try {
				FileWriter writer = new FileWriter( "Habits/" + name );
				for ( int i = 0; i < fileArray.length; i++ ){
					if ( i != days ){
						writer.write( fileArray[ i ] + " " );
					} else {
						writer.write( "1 " );
					}
				} writer.close();
			} catch( IOException ex ){
				ex.printStackTrace();
			}
		} catch( FileNotFoundException ex ){
			ex.printStackTrace();
		} catch( ParseException e ){
			e.printStackTrace();
		}
	}
	/*
	===========================================================
	Map Methods
		This sectios contains the methods affecting the hashmap
		storage of the habits.
	===========================================================
	*/
	public void writeMap(){
		try {
			File file = new File( mapFile );
			if( !file.exists() ){
				file.createNewFile();
			} FileWriter fw = new FileWriter( file, true );
			BufferedWriter bw = new BufferedWriter( fw );
			PrintWriter pw = new PrintWriter( bw );
			for( Map.Entry<String, String> entry : map.entrySet() ){
				pw.println( entry.getKey() + ":" + entry.getValue() );
			} pw.flush();
			pw.close();
		} catch( IOException ex ){
			ex.printStackTrace();
		}
	}
	public Map<String, String> readMap() throws FileNotFoundException {
		Map<String, String> mapFileContents = new HashMap<String, String>();
		try {
			BufferedReader bf = new BufferedReader( new FileReader( mapFile ));
			String line = null;
			while(( line = bf.readLine()) != null ){
				String[] parts = line.split(":");
				String habitName = parts[0].trim();
				String habitDate = parts[1].trim();
				if( !habitName.equals("") && !habitDate.equals("") ){
					mapFileContents.put( habitName, habitDate );
				}
			} bf.close();
		} catch( IOException ex ){
			System.out.println( "No habits yet..." );
		} return mapFileContents;
	}	
	public void printMap() {
		Map<String, String> mapFileContents = new HashMap<String, String>();
		try { 
			mapFileContents = readMap(); 
		}  catch( FileNotFoundException ex ){ 
			ex.printStackTrace(); 
		} for( Map.Entry<String, String> entry : mapFileContents.entrySet() ) {
			System.out.println( entry.getKey() + "\t\t" + entry.getValue().toString() );
		} 
	}
	public void printDate(){
		Date habitDate;
		Map<String, String> mapFileContents = new HashMap<String, String>();
		try { 
			mapFileContents = readMap(); 
			String habitStr = mapFileContents.get( name );
			habitDate = new SimpleDateFormat( "yyyy-MM-dd" ).parse( habitStr );
			System.out.println( habitDate );
			System.out.print( "\n" );
		}  catch( FileNotFoundException ex ){ 
			ex.printStackTrace(); 
		} catch( ParseException e ){
			e.printStackTrace();
		}
	}
}