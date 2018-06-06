/***
class SubwayLine simulates an entire subway line.
***/

import java.util.LinkedList;

public class SubwayLine{

    //instance vars:
    String _line; //letter or number
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
    }

    public Station search(String name){
      Station _temp = _head;
      while (!_temp.getName().equals(name)){
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
      Station _temp = _head;
      while (_temp != null){
        retStr += _temp.getName();
        retStr += "\n";
        _temp = _temp.getNext();
      }
      return retStr;
    }


    //methods:
}
