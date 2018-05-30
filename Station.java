/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars: 
    String name;
    String line; //could be number of letter, but as a String
    double xcor;
    double ycor;
    boolean terminus; //true if it is the endpoint of a train line
    int borough; /*boroughs: 
		   1: Brooklyn
		   2: Bronx
		   3: Manhattan
		   4: Queens
		   (Staten Island not included)*/

    //accessors: 
    public String getName(){
	return name;
    }
    public String getLine(){
	return line;
    }
    public boolean isTerminus(){
	return terminus;
    }
}