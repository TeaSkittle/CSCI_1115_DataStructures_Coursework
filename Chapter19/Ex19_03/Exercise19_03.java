/*
Author: Travis Dowd 
Date: 7-20-2020

Description: Chapter 19, exercise 3. Remove duplicates from ArrayList
 */

import java.util.ArrayList;

public class Exercise19_03  {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  public static <E> ArrayList<E> removeDuplicates( ArrayList<E> list ){
    ArrayList<E> newList = new ArrayList<E>();
    for( E number : list ){
      if( !newList.contains( number )){ newList.add( number );}
    } return newList;
  }
}