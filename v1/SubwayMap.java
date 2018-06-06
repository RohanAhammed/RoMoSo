
import cs1.Keyboard;//used for user input
public class SubwayMap{

    public static void main(String[] args){
      Driver map = new Driver();
	System.out.println("Welcome to the interactive SubwayMap, a program that tells you the fastest route between 2 MTA train stations");
	System.out.println("What subway line is your departing station on?");
	System.out.println("Enter one of the following subway lines: 1 2 3 4 5 6 7 A B C D E F G J L M N Q R W Z");
	SubwayLine depLine = map.search(Keyboard.readString());
  System.out.println(depLine);
	System.out.println("Enter your departure station: ");
	Station depStation = depLine.search(Keyboard.readString());
	//code to find depStation object
	//String deptLine = Keyboard.readString();//might be unnecessary
	System.out.println("What subway line is your destination station on?");
	System.out.println("Enter one of the following subway lines: 1 2 3 4 5 6 7 A B C D E F G J L M N Q R W Z");
	SubwayLine destLine = map.search(Keyboard.readString());
	System.out.println("Enter your destination station: ");
	Station destStation = destLine.search(Keyboard.readString());
      	//code to find destStation object
	System.out.println("Finding the shortest route . . .");
  System.out.println(map.findShortestPath(depStation, destStation, 0));
    }
}//end of public class
