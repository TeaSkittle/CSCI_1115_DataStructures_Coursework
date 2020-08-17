/* 
Author: Travis Dowd
Date: 8-31-2020

Given: "4.5"      Expected: 51451
Given: "Hello"    Expected: 69609650
*/

import java.lang.Math;

public class Exercise27_09 { 
  public static void main(String[] args) {
    String s = "4.5";
    System.out.println(hashCodeForString(s));
    s = "Hello";
    System.out.println(hashCodeForString(s));
  }
  
  public static int hashCodeForString( String s ) {
    final int b = 31;
    int hash = 0;
    char[] arr = s.toCharArray();
    for( int i = 0; i < s.length(); i++ ){
      hash = b * hash + s.charAt( i );
    } return hash;
  }
}