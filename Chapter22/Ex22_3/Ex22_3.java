/*
Author: Travis Dowd
Date: 8-10-2020
Chapter 22, exercise 3

Due to the nested for loop, this program has a quadratic growth rate: T(n) = O(n^2)
*/

import java.util.*;

class Ex23_3 {
	public static void main ( String[] args ) {
		Scanner input = new Scanner( System.in );
		System.out.printf( "Enter a string s1: " );
		String s1 = input.nextLine();
		System.out.printf( "Enter a string s2: ");
		String s2 = input.nextLine();
		// Convert Strings to char array to avoid indexOf
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		System.out.printf( "Matched at index %d", match( c1, c2 ));
	}
	// Limits:
	// Don’t use the indexOf method in the String class
	// Your algorithm needs to be at least O(n) time
	public static int match ( char[] c1, char[] c2 ) {
		int index = 0;
		for ( int i = 0; i < c1.length; i++ ) {
			if ( c1[ i ] == c2[ 0 ] ) {
				index = i;
				for ( int j = i; j < c2.length; j++ ) {
					if ( c1[ j ] == c2[ j ] ){
						index = i;
					}
				}
			}
		}
		return index;
	}
}