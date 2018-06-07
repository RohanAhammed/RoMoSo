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
      Station _temp = _head;
      if (index >= size){
        System.out.println("Try Again!");
        return get(Keyboard.readInt());
      }
      for (int x = 0; x < index; x++){
        _temp = _temp.getNext();
      }
      return _temp;
    }

    public Station search(int id){
      Station _temp = _head;
      while (_temp.getID() != id){
        _temp = _temp.getNext();
      }
      return _temp;
    }

    public String toString(){
      String retStr = "";
      int counter = 0;
      Station _temp = _head;
      while (_temp != null){
        retStr += counter + ") " + _temp.getName();
        retStr += "\n";
        _temp = _temp.getNext();
        counter++;
      }
      return retStr;
    }


    //methods:
}
