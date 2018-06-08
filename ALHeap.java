/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

    //instance vars
    private ArrayList<Station> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {
	_heap = new ArrayList<Station>();      
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString() 
    {
	//simple version:
	//return _heap.toString(); 

	//prettier version:
	String lvlOrdTrav = "heap size " + _heap.size() + "\n";

	if ( _heap.size() == 0 ) return lvlOrdTrav;

	int h = 1; //init height to 1
	for( int i = 0; i < _heap.size(); i++ ) {
	    lvlOrdTrav += i + ":" + _heap.get(i) + " ";
	    if ( i >= Math.pow(2,h) - 2 ) {
		lvlOrdTrav += "\n";
		h++;
	    }
	}
	return lvlOrdTrav;
    }//O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() { return _heap.isEmpty(); } //O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Station peekMin()
    { 
	if ( _heap.size() < 1 )
	    return null;
	else
	    return _heap.get(0); 
    } //O(1)


    /*****************************************************
     * add(Station) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Station addVal )
    { 

	//Add value as last node, to maintain balance, completeness of tree
	_heap.add( addVal );

	int addValPos = _heap.size() - 1;
	int parentPos;

	while( addValPos > 0 ) { //potentially swap until reach root

	    //pinpoint parent
	    parentPos = (addValPos-1) / 2;

	    if ( addVal.compareTo(_heap.get(parentPos)) < 0 ) {//addVal < parent
		swap( addValPos, parentPos );
		addValPos = parentPos;
	    }
	    else 
		break;
	}
    } //O(logn)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Station removeMin()
    { 
	if ( _heap.size() == 0 ) 
	    return null;

	//store root value for return at end of fxn
	Station retVal = peekMin();

	//store val about to be swapped into root
	Station foo = _heap.get( _heap.size() - 1);

	//swap last (rightmost, deepest) leaf with root
	swap( 0, _heap.size() - 1 );

	//lop off last leaf
	_heap.remove( _heap.size() - 1);

	// walk the now-out-of-place root node down the tree...
	int pos = 0;
	int minChildPos;

	while( pos < _heap.size() ) {

	    //choose child w/ min value, or check for child
	    minChildPos = minChildPos(pos);

	    //if no children, then i've walked far enough
	    if ( minChildPos == -1 ) 
		break;
	    //if i am less than my least child, then i've walked far enough
	    else if ( foo.compareTo( _heap.get(minChildPos) ) <= 0 ) 
		break;
	    //if i am > least child, swap with that child
	    else {
		swap( pos, minChildPos );
		pos = minChildPos;
	    }
	}
	//return removed value
	return retVal;
    }//O(logn)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    { 
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= _heap.size() || lc >= _heap.size() )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= _heap.size() )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( _heap.get(lc).compareTo(_heap.get(rc)) < 0 )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)

  
    private Station minOf( Station a, Station b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }

    //remake a heap, if it is not:
    public void minheapify(int index){
	for (int i = index; i < _heap.size(); i ++ ){
	    int addedIndex = i;
	    int parentIndex = (addedIndex + (index - 1)) / 2;
	    while (parentIndex >= index && _heap.get(parentIndex).compareTo(_heap.get(addedIndex)) > 0){
		swap(addedIndex, parentIndex);
		addedIndex = parentIndex;
		parentIndex = addedIndex / 2;
	    }
	}
    }


    //main method for testing
    public static void main( String[] args )
    {
	ALHeap pile = new ALHeap();

	pile.add(new Station("293", "Van Cortlandt Park - 242 St", "Bx", "1", "40.889248", "-73.898583", "1"));
	//System.out.println(pile);
	pile.add(new Station("294", "238 St", "Bx", "1", "40.884667", "-73.90087", "1"));
	//System.out.println(pile);
	pile.add(new Station("295", "231 St", "Bx", "1", "40.878856", "-73.904834", "1"));
	pile.add(new Station("296", "Marble Hill - 225 St", "M", "1", "40.874561", "-73.909831", "1"));
	System.out.println(pile);
	
	

    }//end main()

}//end class ALHeap