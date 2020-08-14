/*
Author: Travis Dowd
Date: 8-13-2020

Description: Chapter 23, exercise 3

Good overview of quicksort, for future reference:
https://www.reddit.com/r/explainlikeimfive/comments/lb7w1/eli5_how_in_the_hell_does_quicksort_work/

*/

package Exercise23_03;

import java.util.Comparator;
import java.util.*;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }
    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  // Quick sort with comparable
  public static <E extends Comparable<E>> void qSort ( E[] list, int a, int b ) {
    if ( a < b ) {
      int i = a;
      int j = b;
      E x = list[( i + j ) / 2 ];
      while ( i <= j ) {
        while ( list[ i ].compareTo( x ) < 0 ) i++;
        while ( x.compareTo( list[ j ]) < 0  ) j--;
        if ( i <= j ) {
          E tmp = list[ i ];
          list[ i ] = list[ j ];
          list[ j ] = tmp;
          i++;
          j--;
        }
      } qSort( list, a, j );
    qSort( list, i, b );
    }
  }
  // Call the qSort & qSortCmp methods, needed extra arguements to make recursive
  // Also this way the two methods below are the ones actually being called in main
  public static <E extends Comparable<E>> void quickSort ( E[] list ) {
    qSort( list, 0, list.length -1 );
  }
  public static <E> void quickSort ( E[] list, Comparator<? super E> comparator ) {
    qSortCmp( list, comparator, 0, list.length - 1 );
  }
  // Quick sort with comparator
  // same as qSort above, execpt the while loops compare differently
  public static <E> void qSortCmp ( E[] list, Comparator<E> cmp, int a, int b ) {
    if ( a < b ) {
      int i = a;
      int j = b;
      E x = list[( i + j ) / 2 ];
      while ( i <= j ) {
        // Comparator comes into play here
        while ( cmp.compare( list[ i ], x ) < 0 ) i++;
        while ( cmp.compare( x, list[ j ] ) < 0 ) j--;
        if ( i <= j ){
          E tmp = list[ i ];
          list[ i ] = list[ j ];
          list[ j ] = tmp;
          i++;
          j--;
        }
      } qSortCmp( list, cmp, a, j );
    qSortCmp( list, cmp, i, b );
    }   
  }
}