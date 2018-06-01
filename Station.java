/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars: 
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
    //constructor
    public Station(String name, String borough, String line, double xcor, double ycor){
	_name = name;
	_line = line;
	_xcor = xcor;
	_ycor = ycor;
	_borough = borough;
    }
    //accessors: 
    public String getName(){
	return _name;
    }
    public String getLine(){
	return _line;
    }

    public static void main (String[] args){

	Station PBP = new Station("Pelham Bay Park", "Bx", "6", Double.parseDouble("40.852462"), Double.parseDouble("-73.828121"));   
	Station B = new Station("Buhre Av", "Bx", "6", Double.parseDouble("40.84681"), Double.parseDouble("-73.832569"));
	System.out.println(PBP.getName());
	System.out.println(PBP.getLine());

	
    }
	
}
