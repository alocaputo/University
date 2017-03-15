
public class SommaCumulativa {

	static void sums( int[] z){
		if (z == null || z.length == 0) {
			return;
		}
		for (int i = 1; i < z.length; i++){
			z[i] = z[i-1] + z[i];
		}
	}
	
	public static void main(String[] args) {
		int[] d = {2, 4, 6, 8};
		sums(d);
	}

}
