
/**
 * @author Alessandro Locaputo
 *
 */
public class MyInsertionSort {

    static int[] arr1 = {10,34,2,56,7,67,88,42};
    static boolean asc = true; //Ascending order = True
                               //Descending order = False

    public static void main(String a[]){
            	if(asc){				
            		sortAscending(arr1);
            		}else{
            		sortDescending(arr1);
            	}
         printOut(arr1);
    }

	/**
	 * print on the console all the values of an array
	 * @param a an array of integers to be printed on console
	 */
	public static void printOut(int[] a) {
		for(int i:a){
			System.out.print(i);
			System.out.print(", ");
			}
	}

	/**
	 * MODIFY the array a so the values are sorted in descending order
	 * @param a an array of integers to be sorted
	 */
	private static void sortDescending(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(a[j] > a[j-1]){
					swap(a,j);
			}
	}}}

	/**
	 * MODIFY the array a so the values are sorted in ascending order
	 * @param a an array of integers to be sorted
	 */
	private static void sortAscending(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(a[j] < a[j-1]){
					swap(a,j);
			}
	}}}

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
