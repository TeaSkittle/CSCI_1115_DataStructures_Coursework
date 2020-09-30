// By: Travis Dowd
// Date: 9-24-2020

package Final;

import java.util.*;
import java.io.*;
import java.awt.print.*;
import java.text.*;
import javax.swing.plaf.*;

class Habit {
	private Date date = Calendar.getInstance().getTime();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	private String strDate = dateFormat.format(date);
	private String name;
	private HashMap<String, String> map = new HashMap<String, String>();
	private String mapFile = "HabitMap";
	private int[] array;
	
	/* Getters, not being used, made them in case needed
	public Date getDate(){ return this.date; }
	public String getName(){ return this.name; }
	public int[] getArray(){ return this.array; }
	*/
	
	public Habit(){}
	public Habit( String name ){
		this.array = new int[ 66 ]; // defaulted with 0's
		this.name = name;
		map.put( this.name, strDate );
	}
	
	public void writeHabit(){
		try {
			BufferedWriter outputWriter = new BufferedWriter( new FileWriter( "Habits/" + name ));
			outputWriter.write( Arrays.toString( array ));	
			outputWriter.flush();
			outputWriter.close();
			writeMap();
		} catch ( IOException ex ){
			ex.printStackTrace();
		}
	}
	public void removeHabit() {
		File file = new File( "Habits/" + name );
		if( file.delete() ){
			map.remove( name );
			System.out.println( "Habit removed" );
		} else {
			System.out.println( "Failed to remove habit" );
		}
	}
	/* not being used
	public int[] readHabit(){
		try {
			Scanner s = new Scanner( new File( "Habits/" + name ));
			array = new int[ s.nextInt() ];
			for( int i = 0; i < array.length; i++ ){
				array[ i ] = s.nextInt();
			}
		} catch( IOException ex ){
			ex.printStackTrace();
		} return array;
	}
	*/
	// use serialize
	// https://www.tutorialspoint.com/java/java_serialization.htm
	// https://www.javacodeexamples.com/write-hashmap-to-text-file-in-java-example/2353
	// https://beginnersbook.com/2014/01/how-to-append-to-a-file-in-java/
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
}