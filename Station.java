/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars:
    String _stationId;
    String _name;
    String _line; //could be number of letter, but as a String
    double _xcor;
    double _ycor;
    String _borough; /*boroughs: 
		       Bx
		       M
		       Q
		       Bk
		       (Staten Island not included)*/
    String _transfers; //indicates which other subway lines include this Station

    //constructor
    public Station(String id, String name, String borough, String line, String xcor, String ycor, String transfers){
	_stationId = id;
	_name = name;
	_line = line;
	_transfers = transfers;
	_xcor = Double.parseDouble(xcor);
	_ycor = Double.parseDouble(ycor);
	_borough = borough;
    }
    //accessors: 
    public String getName(){
	return _name;
    }
    public String getLine(){
	return _line;
    }
    public String getTransfers(){
	return _transfers;
    }
    public static void main (String[] args){

    }
	
}
