/*
Author: Travis Dowd
Date: 7-31-2020

Description: Chapter 20, exercise 21
*/
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  // Selction sort
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
    for( int i = 0; i < list.length - 1; i++ ){
      int min = i;                                               // Curent smallest element in list
      for( int j = i + 1; j < list.length; j++ )                 // Nested loop, tompare list[i] and list[j]
        if( comparator.compare( list[ i ], list[ j ] ) == 1 ){   // if a > b
          min = j;                                               // Set new current smallest element
        }                                                        //
        E temp = list[ min ];                                    // New E object for storing min
        list[ min ] = list [ i ];                                // Swap min 
        list[ i ] = temp;                                        // and temp
    }
  }
}