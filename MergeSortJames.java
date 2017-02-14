//James Smith
//APCS2 pd3
//HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2017-02-11

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: Take in a list of any length. Perform recursive calls by splitting the list in half every time and calling the sorting on the split lists. The recursion terminates when the list is of length 1. Once everything can be evaluated, it takes the two sides and compares their values at the nonused indexes. The smaller element of the two lists goes into the final array. This repeats until all of the numbers are used in one of the lists. To compensate for an uneven division on an odd number list split, the remaining digits are just filled in one at a time.

  ======================================*/

public class MergeSortJames {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] mergedArr = new int[a.length + b.length];
	int leftSize = a.length;
	int rightSize = b.length;
	int og = 0;
	int left = 0;
	int right = 0;
	while (left < leftSize && right < rightSize){
	    if (a[left] <= b[right]){
		mergedArr[og] = a[left];
		og ++;
		left ++;
	    }
	    else{
		mergedArr[og] = b[right];
		og ++;
		right ++;
	    }
	}
	while (left < leftSize){
	    mergedArr[og] = a[left];
	    og++;
	    left++;
	}
	while (right < rightSize){
	    mergedArr[og] = b[right];
	    og++;
	    right++;
	}
	return mergedArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int midPoint;
	int left;
	int right;
	if (arr.length < 2){
	    return arr;
	}
	midPoint = arr.length/2;
	left = midPoint;
	right = arr.length - midPoint;
	int[] leftArr = new int[left];
	int[] rightArr = new int[right];
	for (int i=0;i<left;i++){
	    leftArr[i] = arr[i];
	}
	for (int k=left;k<arr.length;k++){
	    rightArr[k-left] = arr[k];
	}
	int[] leftArrSort = sort(leftArr);
	int[] rightArrSort = sort(rightArr);
	return merge(leftArrSort, rightArrSort);
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
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

