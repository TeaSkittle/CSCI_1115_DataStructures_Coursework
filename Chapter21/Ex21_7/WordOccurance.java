// (c) Travis Dowd
// (d) 8-3-2020
//
// Chapter 21, exercise 7

package Ex21_7;

class WordOccurance implements Comparable<WordOccurance> {
	String word;
	int count;
	WordOccurance( String word, int count ){
		this.word = word;
		this.count = count;
	}
	public int getCount(){
		return this.count;
	}
	public String getWord(){
		return this.word;
	}
	@Override
	public int compareTo( WordOccurance o ){
		if( count == o.count ){
			return 0;
		} else if( count > o.count ){
			return 1;
		} else {
			return -1;
		}
	}
}