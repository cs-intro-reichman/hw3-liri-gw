/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(preProcess("William Shakespeare") + " " + preProcess("I am a weakish speller"));
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1N = preProcess(str1).toLowerCase();
		String str2S = preProcess(str2).toLowerCase();
		if(str1N.length() != str2S.length()) { return false; }
		char[]str2N = str2S.toCharArray();
		for(int i = 0; i < str1N.length(); i++) {
			boolean flag = false;
			for(int j = 0; j < str2N.length; j++) {
				if(str1N.charAt(i) == str2N[j]) {
					flag  = true;
					str2N[j] = '?';
					break;
				}
			}
			if(!flag) {
					return flag;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		StringBuilder newStr = new StringBuilder(); 
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != '!' && str.charAt(i) != '?' && str.charAt(i) != '.' && str.charAt(i) != ',' && str.charAt(i) != ' ') {
				newStr.append(str.charAt(i));
			}
		}
		return newStr.toString();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		StringBuilder inputStr = new StringBuilder();
		inputStr.append(str);
		StringBuilder returnStr = new StringBuilder();
		int rand = -1;
		for(int i = 0; i < str.length(); i++) {
			rand = (int)(Math.random()*(inputStr.length()-1));
			returnStr.append(inputStr.charAt(rand));
			inputStr.deleteCharAt(rand);
		}
		String returnStr2 = returnStr.toString();
		return returnStr2;
	}
}
