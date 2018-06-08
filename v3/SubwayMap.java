/***
Class SubwayMap is in fact the Driver class for Transfer Reccommendations
***/
import cs1.Keyboard;//used for user input
public class SubwayMap{

    public static void main(String[] args){
	Driver map = new Driver();
	System.out.println("Welcome to the interactive SubwayMap, a program that tells you the fastest route between 2 MTA train stations");
	System.out.println("What subway line is your departing station on?");
	System.out.println("Enter one of the following subway lines: \n1 2 3\t4 5 6\t7\tA C E\t B D F M \tN Q R W \tJ Z\tG\tL");

	//choose start line: 
	String userInp = Keyboard.readString();
        SubwayLine depLine = map.search(userInp);
        while (depLine == null){
            System.out.println("Please enter a valid Subway Line…");
            userInp = Keyboard.readString();
            depLine = map.search(userInp);
        }
        System.out.println("==========================\nYou have selected the " + userInp + " line");
        System.out.println(depLine);

	//choose start station:                                                                 
        System.out.println("Enter the number that corresponds to your departure station: ");
        int depStat = Keyboard.readInt();
        Station depStation = depLine.get(depStat);
        while (depStation == null){
            System.out.println("Please enter a valid station number…");
            depStat = Keyboard.readInt();
            depStation = depLine.get(depStat);
        }
        System.out.print("==========================\nYou have selected ");
        System.out.println(depStation);
	System.out.println("possible next stops:\n" + depStation.seeTransArr());

	System.out.println("What subway line is your destination station on?");
	System.out.println("Enter one of the following subway lines: \n1 2 3\t4 5 6\t7\tA C E\t B D F M \tN Q R W \tJ Z\tG\tL");

	//choose destination line:                                                              
        userInp = Keyboard.readString();
        SubwayLine destLine = map.search(userInp);
        while (destLine == null){
            System.out.println("Please enter a valid Subway Line…");
            userInp = Keyboard.readString();
            destLine = map.search(userInp);
        }
        System.out.println("==========================\nYou have selected the "+ userInp + " line");
        System.out.println(destLine);

	//choose destination station:                                                           
        System.out.println("Enter the number that corresponds to your destination station: ");
        int destStat = Keyboard.readInt();
        Station destStation = destLine.get(destStat);
        while (destStation == null){
            System.out.println("Please enter a valid station number…");
            destStat = Keyboard.readInt();
            destStation = depLine.get(depStat);
        }
        System.out.print("==========================\nYou have selected ");
        System.out.println(destStation);

	System.out.println("Finding the shortest route . . .");
	System.out.println("from "+ depStation.getName() + " to " + destStation.getName());
	map.SSShortDist(depStation, destStation);
	System.out.println(map.printPath(depStation, destStation));
	System.out.println("");
    }
}//end of public class
