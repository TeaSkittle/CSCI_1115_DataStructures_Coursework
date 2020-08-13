/*
Author: Travis Dowd
Date: 8-13-2020

Description: Chapter 23, exercise 3


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
  //http://www.learntosolveit.com/java/GenericQuicksortComparable.html
  public static <E extends Comparable<E>> void qSort( E[] list, int a, int b ){
    if ( a < b ) {
      int i = a;
      int j = b;
      E x = list[( i + j ) / 2 ];
      while ( i <= j ) {
        while ( list[ i ].compareTo( x ) < 0 ) i++;
        while ( x.compareTo( list[ j ]) < 0  ) j--;
        if ( i <= j ){
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
  //http://www.learntosolveit.com/java/GenericQuickSort.html
  public static <E> void qSortCmp(E[] arr, Comparator<E> cmp, int a, int b) {
    
  }
  public static <E extends Comparable<E>> void quickSort( E[] list ){
    qSort( list, 0, list.length -1 );
  }

 public static <E> void quickSort(E[] list, Comparator<? super E> comparator ){
    qSortCmp( list, comparator, 0, list.length - 1 );
  }
}