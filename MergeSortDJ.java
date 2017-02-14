/*
  Team Just Dance: Dasha Shifrina, Jesse Sit
  APCS pd3
  HW#06: Step 1: Split, Step 2: ?, Step 3: Sorted!
  2017-2-11
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  First, the unsorted array is split in half until there's only one element in each of 
  resulting arrays. So given an array with 4 elements, those 4 get split into two arrays
  with 2 elements each, and each of those length 2 arrays get split into two arrays with
  1 element each. In that case, there are four 1 element arrays. This guarantees sortedness
  in each of the one element arrays. Now, each of those one element arrays are merged with 
  the other one element array with which they were originally split, and the forming array
  is merged with the other same-length array with which it was originally split, until 
  there is one sorted array that is the length of the original unsorted array.x
  ======================================*/

public class MergeSort {

    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int indexA = 0;
	int indexB = 0;
	int[] merged = new int[a.length + b.length];
	for (int x = 0; x < a.length + b.length; x++){
	    if(indexA == a.length){
		merged[x] = b[indexB];
		indexB += 1;
	    }
	    else if(indexB == b.length){
		merged[x] = a[indexA];
		indexA += 1;
	    }
	    else if(a[indexA] > b[indexB]){
		merged[x] = b[indexB];
		indexB += 1;
	    }
	    else{
		merged[x] = a[indexA];
		indexA += 1;
	    }
	}
	return merged;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length < 2){
	    return arr;
	}
	else {
	    int[] arrFirst = new int[arr.length/2];
	    int[] arrSecond = new int[arr.length - arr.length/2];
	    for(int i = 0; i < arr.length/2; i++){
		arrFirst[i] = arr[i];
	    }
	    for(int i = arrSecond.length; i< arr.length; i++){
		arrSecond[i - arrSecond.length] = arr[i];
	    }
	    return merge(sort(arrFirst), sort(arrSecond));
	}
	//	printArray(arrFirst);
	//	printArray(arrSecond);

	    
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort

