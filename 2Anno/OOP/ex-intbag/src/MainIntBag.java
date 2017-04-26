
public class MainIntBag {

	public static void main(String[] args) {
		IntSet is = new IntSet();
		is.insert(1);
		is.insert(2);
		is.insert(3);
		is.insert(2);
		

		int[] elts = {2,1,2,3};
		IntSet is2 = new IntSet(elts);
		
		boolean x = is.sameValues(is2);
		System.out.println(x);

	}

}
