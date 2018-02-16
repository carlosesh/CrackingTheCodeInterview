package arraysAndStrings;

public class CheckPermutation 
{
	/*Like in many questions, we should confirm some details with our interviewer.
	 * We should understand if the permutation comparison is case sensitive.
	 * That is: is God a permutation of dog? Additionally, we should ask if whitespace
	 * is significant. So, "god     " is different from "dog".
	 * 
	 * Observe first that strings of different lengths cannot be permutations of each other.
	 * There are two easy ways to solve this problem, both of which use this optimization.*/
	
	/*Solution #1: Sort the strings
	 * If two strings are permutations, then we know they have the same characters, but in 
	 * different orders. Therefore, sorting the strings will put the characters from two
	 * permutations in the same order. We just need to compare the sorted version of the strings*/
	
	String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	boolean permutation1(String s, String t) {
		if(s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}
	
	/*Though this algorithm is not as optimal in some sensed, it may be preferable in one sense:
	 * It's clean, simple and easy to understand. In a practical sense, this may very well be a superior
	 * way to implement the problem.
	 * 
	 * However if efficiency is very important, we can implement it a different way*/
	
	/*Solution #2: Check if the two string have identical character counts.
	 * We can also use definition of a permutation -- two words with the same character counts --
	 * to implement this algorithm. We simply iterate through this code, count how many times each character appears
	 * Then, afterwards, we compare the two arrays*/
	
	boolean permutation2(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		int[] letters = new int[128]; // Assumption
		
		char[] s_array = s.toCharArray();
		for(char c : s_array) {// count number of each char in s
			letters[c]++;
		}
		
		for(int i=0; i<t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if(letters[c]<0)
				return false;
		}
		
		return true;
	}
	
	/*Note the assumption on line 48. In your interview, you should always check with your interviewer about the size
	 * of the character set. We assumed that the character set was ASCII*/

}
