package it.uniud.poo;

public class MyInsertionSort {
	static int[] arr1 = {10,34,2,56,7,67,88,42};
	public static void main(String a[]){
		doInsertionSort(arr1);
		print();
	}

/*doInsetionSort perform the Insertion sort for a given array
 * 
 */
	private static void doInsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(a[j] < a[j-1]){
					swap(a, j, j-1);
				}
			}
		}
	}
/*Given an array of integer this method swap the elements in position i and j
 * */
private static void swap(int[] a, int j, int i) {	
	int temp;
		temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}


		

	
	private static void print() {
		for(int i:arr1){
			System.out.format("%d, ",i);
		}
	}
}
