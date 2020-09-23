# Final Ideas

- Habit tracker
- To Do app
- The X effect
  - 7-weeks ( 49 days )
- View stats
  - View percentage of completed days
  - View number of days left ( out of 49 )
- Have suggested habits ( easy ones )
- Maybe some motivation or inspiration
- Make it fun, with jokes and a little attitude!

## Data Structures

- Can have each task as an array of 49 boolean values, all set to false by default
- Have each habit writen to a file when changed, and read upon opening app.
  - Would be easy if the is just 0s and 1s, or bool values
  - example: 
```Java	
boolean[] arr = new boolean[49]; 
// All are defaulted to false
```
- Have a map as the data structre to hold all the other habits, will be written and read from a file as well
- Key/Value will be equivalent to: Habit/File_Location
  - example:
```Java
Map<String, String> habits = new TreeMap<>();
``` 

