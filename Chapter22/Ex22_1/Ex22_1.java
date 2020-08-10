/*
Author: Travis Dowd
Date: 8-10-2020
Chapter 22, exercise 1

Test string: abcabcdgabxy

Linear complexity, due to the fact that void max( String in ) only loops though
in once, and sequesntially compares unitl the loop is finished. So: T(n) = O(n)
*/

import java.util.*;

class Ex22_1 {
	public static void main ( String[] args ) {
		Scanner input = new Scanner( System.in );
		System.out.printf( "Enter a string: " );
		String entered = input.nextLine();
		max( entered );
	}
	public static void max ( String in ) {
		// Using LinkedList for easier access of elements
		LinkedList<Character> out = new LinkedList<>();
		LinkedList<Character> buffer = new LinkedList<>();
		for ( int i = 0; i < in.length(); i++ ) {
			// IF buffer is greater than 1
			// AND character in string at location i is
			// LESS THAN OR EQUAL TO the last element in buffer
			// AND buffer contains char in string 
			if ( buffer.size() > 1 && in.charAt( i ) <= buffer.getLast() && buffer.contains( in.charAt( i ))) {
				// IF above returns TRUE, clear the buffer
				buffer.clear();
			}
			// IF above returns FALSE, then add char to buffer
			buffer.add( in.charAt( i ));
			// IF both buffer is GREATER THAN out
			if ( buffer.size() > out.size()) {
				// Clear out
				// and copy all of buffer to out
				out.clear();
				out.addAll( buffer );
			}
		} 
		// Clear to free up the memory
		buffer.clear();
		// Fancy one-liner to print out list, treated similar to return statement
		out.forEach( System.out::print );
	}
}