/***
class SubwayLine simulates an entire subway line.
***/

import java.util.LinkedList;

public class SubwayLine{

    //instance vars:
    String _line; //letter or number
    LinkedList<Station> _stops;

    //constructor: 
    public SubwayLine(String line){
	_line = line;
	_stops = new LinkedList<Station>();
    }//end constructor

    //methods:
    public void add(Station x){
	_stops.add(x);
    }
    
}
