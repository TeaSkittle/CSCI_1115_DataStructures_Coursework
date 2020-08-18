// By: Travis Dowd
// 8-18-2020

import java.util.*;

public class Exercise24_05 {
	public static void main( String[] args ) {
		GenericQueue<String> q = new GenericQueue<>();
		System.out.println( "Starting queue: " );
		q.enqueue( "Hello" );
		q.enqueue( "world" );
		System.out.println( q );
		
		System.out.println( "\nAfter enqueue: " );
		q.enqueue( "have" );
		q.enqueue( "more" );
		q.enqueue( "strings" );
		System.out.println( q );
		
		System.out.println( "\nAfter dequeue: " );
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println( q );
	}
}