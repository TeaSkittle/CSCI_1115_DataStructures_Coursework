// (c) Travis Dowd
// (d) 8-3-2020
//
// Chapter 21, exercise 7

package Ex21_7;

import java.util.*;

public class Exercise21_07 {
	public static void main( String[] args ) {
		String text = "Good morning. Have a good class. Have a good visit. Have fun!";
		// Create HashMap
		Map<String, Integer> map = new HashMap<>();
		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();		
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		// ------------------------
		//   Sort key/pair values
		// ------------------------
		ArrayList<WordOccurance> list = new ArrayList<WordOccurance>();
		map.forEach(( k, v ) -> { list.add( new WordOccurance( k, v )); });
		Collections.sort( list );
		for( WordOccurance k : list ){
			System.out.println( k.getWord() + "\t" + k.getCount() );
		}
	}
}