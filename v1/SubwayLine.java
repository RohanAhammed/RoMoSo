/***
    class SubwayLine simulates an entire subway line.
***/
import cs1.Keyboard;
import java.util.LinkedList;

public class SubwayLine{

    //instance vars:
    Station _head;
    Station _tail;
    int size = 0;


    //constructor:
    public SubwayLine(){
	_head = null;
	_tail = null;
    }//end constructor

    public void add(Station x) {
	if (_head == null){
	    _head = x;
	    _tail = x;
	}
	else{
	    _tail.setNext(x);
	    x.setBefore(_tail);
	    _tail = x;
	}
	size ++;
    }

    public Station get(int index){
	if (index >= size || index < 0){
	    System.out.println("Try Again!");
	    return null;
	}
	else {
	    Station temp = _head;
	    int ctr = 0;
	    while (ctr < index){
		temp = temp.getNext();
		ctr += 1;
	    }
	    return temp;
	}
    }

    public Station search(int id){
	Station temp = _head;
	Station retval = null;
	while (temp != null){
	    if (temp.getID() == id){
		retval = temp;
		break;
	    }
	    temp = temp.getNext();
	}
	return retval;
    }

    public String toString(){
	String retStr = "";
	int counter = 0;
	Station _temp = _head;
	while (_temp != null){
	    retStr += "|- " + counter + " -> " + _temp.getName();
	    retStr += "\n";
	    _temp = _temp.getNext();
	    counter++;
	}
	return retStr;
    }

    //methods:
}
