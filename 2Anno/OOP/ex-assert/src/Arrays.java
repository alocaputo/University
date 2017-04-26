
public class Arrays {
	/** The mission of this class is to provide a number of
	* standalone procedures that can be useful for manipulating
	* arrays of ints.
	**/
	/** search x in a **/
		public static int search (int [] a, int x) throws NotFoundException {
			
			assert (a!=null) : "a is not expected to be null";
			
			boolean found = false;
			int i=0;
			while(i<a.length && !found){
				if(a[i]==x){
					found = true;
				}
				i++;
			}
			if (found)
				return i;
			else
				 throw new NotFoundException(x);	
		}
	/** search x in a, when a is sorted increasingly 
	 *  REQUIRE a to be an array of integers sorted increasingly
	 *  @param x is the integer to find
	 * @throws NotFoundException 
	 * @throws NotSortedException 
	 **/
		public static int searchSorted(int [] a, int x) throws NotFoundException, NotSortedException{
			
			assert (a!=null) : "a is not expected to be null";
			
			for(int i=0;i<a.length-1;i++){
				if(a[i]>a[i+1]){
					throw new NotSortedException();
				}
			}
			
			int p = 0;
			int q = a.length-1;
			while(p<=q){
				int r = p + (q-p)/2;
				if(a[r] > x){
					p = r+1;
				}else if(a[r] < x){
					q = r -1;
				}else{
					return r;
				}
			}
			throw new NotFoundException(x);
		}


		public static void main(String[] args) {
			int[] arr1 = {1,5,9,4,8};
			//int[] arr1 = null;
			int[] arr2 = {1,2,3,80,9,32,33,85,100};
			try{
			System.out.println(search(arr1,92));
			}catch(NotFoundException e){
			}
			try{
				System.out.println(searchSorted(arr1,51));
			}catch(NotFoundException e){
				//arr1.sort;
			}catch(NotSortedException e){
				
			}

		}

	}