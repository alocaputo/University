
public class NotFoundException extends Exception {

	public NotFoundException(int x){
		System.err.println("Unable to find " + x);
	}
}
