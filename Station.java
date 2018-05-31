/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars: 
    String _name;
    String _line; //could be number of letter, but as a String
    double _xcor;
    double _ycor;
    Station _next;
    Station _prev;
    boolean _terminus; //true if it is the endpoint of a train line
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
    public Station getNext(){
	return _next;
    }
    public Station getPrev(){
	return _prev;
    }
    //mutators
    public void setNext(Station next){
	_next = next;
    }
    public void setPrev(Station prev){
	_prev = prev;
    }
   
	
}
