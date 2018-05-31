/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars: 
    String _name;
    String _line; //could be number of letter, but as a String
    double _xcor;
    double _ycor;
    boolean _terminus; //true if it is the endpoint of a train line
    int _borough; /*boroughs: 
		   1: Brooklyn
		   2: Bronx
		   3: Manhattan
		   4: Queens
		   (Staten Island not included)*/
    //constructor
    public Station(String name, String line, double xcor, double ycor, boolean terminus, int borough){
	_name = name;
	_line = line;
	_xcor = xcor;
	_ycor = ycor;
	_terminus = terminus;
	_borough = borough;
    }
    //accessors: 
    public String getName(){
	return _name;
    }
    public String getLine(){
	return _line;
    }
    public boolean isTerminus(){
	return _terminus;
    }
   
	
}
