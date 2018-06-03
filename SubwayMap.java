
import cs1.Keyboard;//used for user input
public class SubwayMap{
    public static void main(String[] args){
	System.out.println("Welcome to the interactive SubwayMap, a program that tells you the fastest route between 2 MTA train stations");
	System.out.println("Enter your departure station: ");
	String depStation = Keyboard.readString();
	System.out.println("Enter your destination station: ");
	String destStation = Keyboard.readString();
	System.out.println("Finding the shortest route . . .");
    }
}//end of public class
