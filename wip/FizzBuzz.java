// By: Travis Dowd
// Date: 8-28-2020
//
// Recurisve fizzbuzz, using ternary operators. See notes.md

class FizzBuzz {
	public static void main( String[] args ){
		fizzBuzz( 0, 100 );
	}
	public static String fizzBuzz( int start, int end ){
		final String result =
			start % 3 == 0 ? start % 5 == 0 ? "FizzBuzz"
			: "Fizz" 
			: start % 5 == 0 ? "Buzz" 
			: String.valueOf( start );
		if ( start < end ) {
			System.out.println( fizzBuzz( start + 1, end )); // recursive call and print to stdout
		} else { ; } // Do nothing, pass the else condition
		return result; // Always return the result
	}	
}