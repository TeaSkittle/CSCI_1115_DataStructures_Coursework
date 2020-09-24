// By: Travis Dowd
// Date: 9-24-2020

package Final;

import java.util.*;
import java.io.*;
import java.awt.print.*;
import java.text.*;

class Habit {
	private Date date = Calendar.getInstance().getTime();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
	private String strDate = dateFormat.format(date);
	private String name;
	private String filename = "Habits/" + name;
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
		map.put( name, strDate );
	}
	
	public void writeHabit(){
		try {
			BufferedWriter outputWriter = new BufferedWriter( new FileWriter( filename ));
			outputWriter.write( Arrays.toString( array ));	
			outputWriter.flush();
			outputWriter.close();
		} catch ( IOException ex ){
			ex.printStackTrace();
		}
	}
	// Change from void to int[]
	public int[] readHabit(){
		try {
			Scanner s = new Scanner( new File( filename ));
			array = new int[ s.nextInt() ];
			for( int i = 0; i < array.length; i++ ){
				array[ i ] = s.nextInt();
			}
		} catch( IOException ex ){
			ex.printStackTrace();
		} return array;
	}
	// use serialize
	// https://www.tutorialspoint.com/java/java_serialization.htm
	// https://www.javacodeexamples.com/write-hashmap-to-text-file-in-java-example/2353
	public void writeMap(){
		try {
			BufferedWriter bf = new BufferedWriter( new FileWriter( mapFile ));
			for( Map.Entry<String, String> entry : map.entrySet() ){
				bf.write( entry.getKey() + ":" + entry.getValue() );
				bf.newLine();
			} bf.flush();
			bf.close();
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
}