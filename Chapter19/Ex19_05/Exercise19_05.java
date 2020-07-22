/*
Author: Travis Dowd
Date: 7-22-2020

Description: Chapter 19, exercise 5
 */
public class Exercise19_05 {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
    
    String[] words = {"red", "green", "blue"};
    System.out.println(max(words));
    
    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
    System.out.println(max(circles));
  }
  // -------
  //   Max
  // -------
  // Find max value of list
  public static <E extends Comparable<E>> E max( E[] list ){
    E currentMin;
    int currentMinIndex; 
    // Sort list
    for ( int i = 1; i < list.length; i++ ){
      currentMin = list[ i ];
      currentMinIndex = i;
      for ( int j = i + 1; j < list.length; j++ ){
        if ( currentMin.compareTo( list[ j ] ) > 0 ){
          currentMin = list[ j ];
          currentMinIndex = j;
        }
      } if ( currentMinIndex != i ){
        list[ currentMinIndex ] = list[ i ];
        list[ i ] = currentMin;
      }
    } // return max value of list
    E index = list[ 0 ];
    for( E item : list ){
      index = item;
    } return index;
  }
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }
}
