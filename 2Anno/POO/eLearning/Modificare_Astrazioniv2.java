
public class InsertionSort {

    static int[] arr1 = {10,34,2,56,7,67,88,42};
    static boolean asc = true; //Ascending order = True
    							//Descending order = False

    public static void main(String a[]){
        doSorting(arr1);				//Sorts the array using Insertion Sort
        if(asc){
        printAsc(arr1);					//Print the sorted array
        }else{
        printDesc(arr1);				//Prints the sorted array in reverse
        }}

	/**
	 * MODIFY the array a so the values are ordered, increasing
	 * @param a an array of integers to be sorted
	 */
	public static void doSorting(int[] a) {
		for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    swap(a,j);
                }
            }
        }
	}
	
	/**
	 * print on the console all the values of an array
	 * @param a an array of integers to be printed on console
	 */
	public static void printAsc(int[] a) {
		for(int i:a){
		System.out.print(i);
		System.out.print(", ");
	}}
	
	/**
	 * print on the console all the values of an array from the end to the start
	 * @param a an array of integers to be printed on console in reverse
	 */
	public static void printDesc(int[] a) {
		for(int i=a.length-1;i>=0;i--){
		System.out.print(a[i]);
		System.out.print(", ");
	}}
	
	/**
	 * swap a[j] with a[j-1]; MODIFY the array a
	 * @param a an array of integers, REQUIRE to have 2 or more elements
	 * @param j an index of the array, REQUIRE to be a valid index and > 0
	 */
	private static void swap(int[] a, int j) {
		int temp;
		temp = a[j];
		a[j] = a[j-1];
		a[j-1] = temp;
	}
}
