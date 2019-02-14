package Lab2_Cs272;

/**
 * In the previous lab, we use a fixed-length array to store all the authors for a book.
 * This approach has one disadvantage: when the author array is full, we cannot add more authors for the book.
 * In this lab, based on what we have learned in class, 
 * you are asked to design a data structure StringSet, which can be used to store all the authors of a book. 
 * You are required to design the data structure StringSet to store String values and support basic operations. 
 * This StringSet data structure should implement the functionality of a collection whose space can grow automatically. 
 * This collection data structure does NOT allow you to store the same String value multiple times. 
 * I.e., if the collection already contains a String value a, you cannot add another given String value a to the collection.
 * @author Tony Urbina
 * @since 2/3/19
 */

public class StringSet {
	/**
	 * Instance variables
	 */
	String StringSet_;
	int Capacity_;
	String [] MyArray;
	
	/**
	 * A no-argument constructor, which initializes a StringSet instance, 
	 * sets its capacity to 2, and creates an array to store 2 String instances. 
	 */
	public StringSet() {
	StringSet_ = "";
	Capacity_ = 2;
	MyArray = new String [2];
	}//No Argument Constructor
	
	/**
	 * The following constructor, which initializes a StringSet instance, 
	 * sets its capacity to the input parameter _capacity, and creates an array to store _capacity string values.
	 * @precondition 
	 * _Capacity must be Positive.
	 * @param _Capacity
	 * The initial capacity
	 */
	public StringSet(int _Capacity) {
	if(_Capacity < 0) {
		return;
	}//end if Precondition
	StringSet_ = "";
	Capacity_ = _Capacity;
	MyArray = new String [_Capacity];
	}//end Constructor
	
	/**
	 * A copy constructor, 
	 * which creates a new StringSet instance and copies the content of the given object to the new instance.
	 * @precondition 
	 * obj is not null and its an instanceof StringSet
	 * @param obj
	 * the object were going to copy
	 */
	public StringSet(Object obj) {
	if(obj != null) {
		if(obj instanceof StringSet) {
			StringSet ref = (StringSet)obj;
			StringSet_ = ref.StringSet_;
			Capacity_ = ref.Capacity_;
			MyArray = ref.MyArray;
		}//end if
	}//end if Precondition
	}//end Copy Constructor
	
	/**
	 * The following method which returns the actual number of elements in this collection.
	 * @return
	 * the size of however many elements there are in the array
	 */
	public int size() {
		int count=0;
		for(int i=0;i<Capacity();i++) {
			if(MyArray[i]!=null) {
				count++;
			}//end if
		}//end for
		return count;
	}//end size
	
	/**
	 * The following method which returns the capacity of this collection instance. 
	 * @return
	 * The length of the array
	 */
	public int Capacity() {
		return MyArray.length;
	}//end capacity
	
	/**
	 * A method which adds a given String value to the first available space of the string array in this StringSet instance. 
	 * When the collection space is sufficient to hold the new String, this String value can be directly added to the collection. 
	 * Otherwise, you need to double the space of the instance array by implementing a method ensureCapacity
	 * @precondition 
	 * a is not null
	 * @param a
	 * the string we are evaluating
	 */
	public void add(String a) {
		if(a == null) {
			return;
		}//end PreCondition
		if(size() == MyArray.length) {
			String [] BiggerArray = new String[(size() + 1)*2];
			System.arraycopy(MyArray, 0, BiggerArray, 0, size());
			MyArray = BiggerArray;
		}//end if
		MyArray[size()] = a;
		Capacity_++;
	}//end add
	
	
	/**
	 * A method to check whether this collection contains the input parameter. 
	 * @precondition 
	 * a is not null
	 * @param a
	 * the string we are evaluating
	 * @return 
	 * True if the collection contains input param, otherwise false
	 */
	public boolean conatins(String a) {
	if(a == null) {
		return false;
	}else{
		int answer = 0;
		for(int i = 0; i < Capacity_; i++) {
			if(a.equals(MyArray[i])) {
				answer++;
			}//end if
			if(answer >= 1) {
				return true;
			}//end if
		}//end for
	}//end else
	return false;
	}//end contains method
	
	/**
	 * A method to remove from the collection the String which has the same value as the given parameter. 
	 * @precondition 
	 * a is not null
	 * @param a
	 * The String we are evaluating
	 * @return 
	 * True if the value is able to be removed, false otherwise
	 */
	public boolean remove(String a) {
		if(a == null) {
			return false;
		}//end Precondition
		int	index; 
		for	(index=0;	(index	<	Capacity_ )	&&	(!a.equals(MyArray[index])); index++);
		if	(index	==	Capacity_) 
			return	false; 
		else{
			Capacity_--; 
			MyArray[index]	=	MyArray[index + 1];
			MyArray[index + 1] = null;
			return	true; 
			}//end else
	}//end remove method
	
	/**
	 * The following method which guarantees the capacity of the collection. 
	 * If this collection's capacity is smaller than the input parameter, 
	 * this method sets the capacity to minimumCapacity and enlarges the array to hold minimumCapacity Strings; 
	 * Otherwise, this collection is left unchanged
	 * @precondition 
	 * minimumCapacity is positive
	 * @param minimumCapacity
	 * The minimumCapacity of the array
	 */
	private void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity < 0) {
			return;
		}//end precondition
		String [] BigArray;
		if(size() < minimumCapacity) {
			BigArray = new String [minimumCapacity];
			System.arraycopy(MyArray, 0, BigArray, 0, size());
			MyArray = BigArray;
		}//end if
	}//end ensureCapacity
	
	/**
	 * A method which adds one String value to this StringSet instance such that the values in the string array are ordered ascending. 
	 * When the collection space is sufficient to hold the new String, this String value can be directly added to the collection. 
	 * Otherwise, you need to double the space of the instance array by implementing a method ensureCapacity. 
	 * @precondition 
	 * a is not null
	 * @param a
	 * The String we are evaluating
	 */
	public void addOrder(String a) {
		if(a == null) {
			return;
		}//end if
        //Sorting the strings
        for (int i = 0; i < size(); i++) {
            for (int j = i + 1; j < size(); j++) { 
                if (MyArray[i].compareTo(MyArray[j])>0){
                    a = MyArray[i];
                    MyArray[i] = MyArray[j];
                    MyArray[j] = a;
                }//end for
            }//end for
        }//end for
	}//end addOrder
	
	public static void main(String[] args) {
		
		StringSet A = new StringSet();
		
		System.out.println("The Capacity of the original array is: " + A.Capacity());
		System.out.println();
		
		A.add("T");
		A.add("A");
		A.add("B");
		

		System.out.println("The Capacity of the New StringSet array is: " + A.Capacity());
		System.out.println("The Size of The new StringSet is: "+A.size());
		System.out.println();
		System.out.println("The \"TAB\" were added on to the string array");
		
		for(int i = 0; i < A.size(); i++) {
			System.out.println(A.MyArray[i]);	
		}//end for
		
		System.out.println();
		System.out.println("The Sorted string Array of \"TAB\"");
		A.addOrder("TAB");
		
		for(int i = 0; i < A.size(); i++) {
			System.out.print(A.MyArray[i]);	
		}//end for
		
		System.out.println();
		
		A.ensureCapacity(10);
		
		System.out.println();
		System.out.println("The New Capacity Within esureCapacity(10) is: "+A.Capacity());
		System.out.println();
		
		StringSet B = new StringSet(5);
		
		B.add("C");
		B.add("A");
		B.add("T");

		System.out.println("The Capacity of The new StringSet is: "+B.Capacity());
		System.out.println("The Size of The new StringSet is: "+B.size());
		
		for(int i = 0; i < B.size(); i++) {
		System.out.println(B.MyArray[i]);
		}//end for
		
		System.out.println("Will Be Removed from \"CAT\"? "+B.remove("A"));
		
		for(int i = 0; i < B.size(); i++) {
		System.out.println(B.MyArray[i]);
		}//end for
		
		System.out.println();
		System.out.println("This is using copy constructor so, it will be a direct copy from StringSet B to C after removing \"A\"");
		StringSet C = new StringSet(B);
		
		for(int i = 0; i < C.size(); i++) {
			System.out.println(C.MyArray[i]);
		}//end for
	}//end main
}//end class
