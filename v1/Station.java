/***
Class Station simulates a singular train station
***/

public class Station{

    //instance vars:
    private int _id;
    private String _name;
    private String _line; //could be number of letter, but as a String
    private double _xcor;
    private double _ycor;
    private String _borough; /*boroughs:
		       Bx
		       M
		       Q
		       Bk
		       (Staten Island not included)*/
    private String _transfers; //indicates which other subway lines include this Station
    private Station[][] _transferPointers;
    private Station before;
    private Station next;

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

    public double getX(){
      return _xcor;
    }
    public double getY(){
      return _ycor;
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
    public String getTransArr(){
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
    public Station[][] getTransArray(){
      return _transferPointers;
    }



}
