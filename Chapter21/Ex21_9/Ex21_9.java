// (c) Travis Dowd
// (d) 8-3-2020
//
// Chapter 21, exercise 9

import java.util.*;

public class Ex21_9 {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
      map.put( "Alabama", "Montgomery" );
      map.put( "Alaska", "Juneau" );
      map.put( "Arizona", "Phoenix" );
      map.put( "Arkansas", "Little Rock" );
      map.put( "California", "Sacramento" );
      map.put( "Colorado", "Denver" );
      map.put( "Connecticut", "Hartford" );
      map.put( "Delaware", "Dover" );
      map.put( "Florida", "Tallahassee" );
      map.put( "Georgia", "Atlanta" );
      map.put( "Hawaii", "Honolulu" );
      map.put( "Idaho", "Boise" );
      map.put( "Illinois", "Springfield" );
      map.put( "Indiana", "Indianapolis" );
      map.put( "Iowa", "Des Moines" );
      map.put( "Kansas", "Topeka" );
      map.put( "Kentucky", "Frankfort" );
      map.put( "Louisiana", "Baton Rouge" );
      map.put( "Maine", "Augusta" );
      map.put( "Maryland", "Annapolis" );
      map.put( "Massachusettes", "Boston" );
      map.put( "Michigan", "Lansing" );
      map.put( "Minnesota", "Saint Paul" );
      map.put( "Mississippi", "Jackson" );
      map.put( "Missouri", "Jefferson City" );
      map.put( "Montana", "Helena" );
      map.put( "Nebraska", "Lincoln" );
      map.put( "Nevada", "Carson City" );
      map.put( "New Hampshire", "Concord" );
      map.put( "New Jersey", "Trenton" );
      map.put( "New York", "Albany" );
      map.put( "New Mexico", "Santa Fe" );
      map.put( "North Carolina", "Raleigh" );
      map.put( "North Dakota", "Bismarck" );
      map.put( "Ohio", "Columbus" );
      map.put( "Oklahoma", "Oklahoma City" );
      map.put( "Oregon", "Salem" );
      map.put( "Pennsylvania", "Harrisburg" );
      map.put( "Rhode Island", "Providence" );
      map.put( "South Carolina", "Columbia" );
      map.put( "South Dakota", "Pierre" );
      map.put( "Tennessee", "Nashville" );
      map.put( "Texas", "Austin" );
      map.put( "Utah", "Salt Lake City" );
      map.put( "Vermont", "Montpelier" );
      map.put( "Virginia", "Richmond" );
      map.put( "Washington", "Olympia" );
      map.put( "West Virginia", "Charleston" );
      map.put( "Wisconsin", "Madison" );
      map.put( "Wyoming", "Cheyenne" );

    Scanner input = new Scanner( System.in );
    while( true ){
      System.out.print( "State: ");
      String state = input.nextLine();
        if( map.containsKey( state )){
          System.out.println( "Capitol: " + map.get( state ) + "\n" );
      }
    }
  }
}
