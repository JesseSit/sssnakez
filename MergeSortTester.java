//Sssnakez: James Smith, Dasha Shafrina, Jesse Sit
//APCS2 pd3
//HW07 -- What Does the Data Say?
//2017-02-13

/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlog(n))

  Mean execution times for dataset of size n:
  Batch size: 100000
  Maximum Random Number: 100000
  n=1       time: 5.2E-8 seconds
  n=10      time: 8.4E-6 seconds
  n=100     time: 9.8454E-5 seconds
  ...
  n=100000  time: .013439039 seconds

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/

    //generates an int array of length 'size' with random numbers within the range 0-maxNum
    public static int[] generateArray(int size, int maxNum){
	int[] retArr = new int[size];
	for (int i = 0; i< size;i++){
	    retArr[i] = (int)(Math.random()*maxNum);
	}
	return retArr;
    }

    //Return the execution time of the sorting algorithm in nano seconds
    public static long runTest(int size, int maxNum){
	long startTime = System.nanoTime();
	MergeSortJames.sort(generateArray(size, maxNum));
	long endTime   = System.nanoTime();
	return endTime - startTime;
    }

    //returns the average execution time of the sorting algorithm over numTests iterations
    public static double averageTestTime(int numTests, int size, int maxNum){
	long totalTime = 0;
	for(int i = 0; i < numTests; i++){
	    totalTime += runTest(size, maxNum);
	}
	return (totalTime/(long)numTests)*0.000000001;
    }

    
    public static void main( String[] args ){
	int numTests = 100000;
	int maxNum = 100000;
	int size;
	System.out.println("Tests of a merge sort algorithm at different sizes. Execution time is in seconds.\n Number of tests performed: " + numTests + "\n Maximum Number: " + maxNum);
	//for n=1 ---------------------------------------
	size = 1;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=10 --------------------------------------
	size = 10;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=100 -------------------------------------
	size = 100;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=100000 -------------------------------------
	size = 100000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
    }//end main

}//end class
