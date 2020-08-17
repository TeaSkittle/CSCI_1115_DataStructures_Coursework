// By: Travis Dowd
// Date: 8-31-2020
//
// Chapter 27, exercise 11

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Exercise27_11 {
  public static void main(String[] args) {
    Set<String> set = new HashSet<String>(); 
    set.add("Smith");
    set.add("Anderson");
    set.add("Lewis");
    set.add("Cook"); 
    set.add("Smith");
  
    ArrayList<String> list = setToList(set);
    System.out.println(list);
  }
  
  // Second "Smith" not added in set or arraylist
  public static <E> ArrayList<E> setToList(Set<E> s) {
    ArrayList<E> list = new ArrayList<>();  // Create ArrayList
    for ( E e : s ) {                       // foreach loop for generic set
      list.add( e );                        // add e to ArrayList
    } return list;                          // return ArrayList
  }
}