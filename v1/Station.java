/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars:
    int _id;
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
    Station before;
    Station next;

    //constructor
    public Station(String id, String name, String borough, String line, String xcor, String ycor, String transfers){
	_id = Integer.parseInt(id);
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
    public String toString(){
	return _line + ": " + _name;
    }
    public int getID(){
	return _id;
    }
    //other methods
    public boolean canTransfer(Station x){
	return _id == x.getID();
    }

    public void setBefore (Station x){
      before = x;
    }
    public void setNext (Station x){
      next = x;
    }
    public Station getNext(){
      return next;
    }
    public Station getBefore(){
      return before;
    }

    public static void main (String[] args){
      /*
	Driver SubwayMap = new Driver();
	for (Station i: SubwayMap.g){
	    System.out.println(i);
	    System.out.println(i.getID());
	    //if transfers contains f:
	    if (i.getTransfers().indexOf("F") >= 0){
		//iterate through F line
		for (Station x: SubwayMap.f){
		    //if the two ID's match:
		    if (i.canTransfer(x)){
			System.out.print("Transfer to: ");
			System.out.println(x);
			//break, because there is at most on ID match
			break;
		    }
		}
	    }
	    System.out.println(i.getTransfers());
	    System.out.println("++++++++++++++++++");
	}
  */
    }

}
