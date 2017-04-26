
public class Palindrome {

	/* isPalindrome tell if a string in palindrome
	 * @param str1 the string to be checked, REQUIRE has to be not null
	 * @return true if is palindrome, false else
	 */

	public static boolean isPalindrome(String str1){
		StringBuilder sb = new StringBuilder(str1);
		sb.reverse();
		String str2 = sb.toString();
		return str1.equals(str2) ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(""));
	}

}
