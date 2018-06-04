
import cs1.Keyboard;//used for user input
public class SubwayMap{
    public static void main(String[] args){
	System.out.println("Welcome to the interactive SubwayMap, a program that tells you the fastest route between 2 MTA train stations");
	System.out.println("What subway line is your departing station on?");
	System.out.println("Enter one of the following subway lines: 1 2 3 4 5 6 7 A B C D E F G J L M N Q R W Z");
	String depStation = Keyboard.readString();
	System.out.println("Enter your departure station: ");
	String depStation = Keyboard.readString();
	//code to find depStation object
	//String deptLine = Keyboard.readString();//might be unnecessary
	System.out.println("What subway line is your destination station on?");
	System.out.println("Enter one of the following subway lines: 1 2 3 4 5 6 7 A B C D E F G J L M N Q R W Z");
	String depStation = Keyboard.readString();
	System.out.println("Enter your destination station: ");
	String destStation = Keyboard.readString();
      	//code to find destStation object
	System.out.println("Finding the shortest route . . .");
    }
}//end of public class
