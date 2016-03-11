package recursion;

/**
 * Use recursion to check whether or not a given String is a palindrome
 * @author Kevin McBain
 *
 */
public class Palindrome {

	public static void main(String args[])
	{
		System.out.println(isPalindrome("madam"));
		System.out.println(isPalindrome("Palindrome"));
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("abcd"));
		System.out.println(isPalindrome("cba"));
		
	}
	
	public static boolean isPalindrome(String str)
	{
		if(str.length() == 0 || str.length() == 1)
		{
			return true;
		}
		if(str.charAt(0) != str.charAt(str.length() - 1))
		{
			return false;
		}
		return isPalindrome(str.substring(1, str.length() - 1));
	}
}
