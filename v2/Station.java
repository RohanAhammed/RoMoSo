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
    Station[][] _transferPointers;
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
	_transferPointers = new Station[22][2];
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
    public Station[][] getTransArr(){
	return _transferPointers;
    }

    //other methods
    public void setTransfPointers(Station[][] array){
	_transferPointers = array;
    }
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
    public String seeTransArr(){
	String retStr = "";
	for (Station[] i: _transferPointers){
	    for (Station x: i){
		retStr += x;
		retStr += " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }



}
