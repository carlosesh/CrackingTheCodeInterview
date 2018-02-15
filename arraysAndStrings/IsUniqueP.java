package arraysAndStrings;

public class IsUniqueP {

	public boolean isUnique(String str) 
	{
		/*One solution is to create an array of boolean values, where the flag at index i indicates
		 * whether character i in the alphabet is contained in the string, the second time you see
		 * this character you can immediately return false
		 * 
		 * We can also immediately return false if the string length exceeds the number of unique 
		 * characters in the alphabet. After all, you can't form a string of 280 unique characters
		 * out of a 128 character alphabet
		 * 
		 * NOTE: It's also okay to assume 256 characters, this would be the case in extended ASCII. You
		 * should clarify your assumptions with your interviewer.*/
		
		
		//ASCII
		if(str.length()>128)
			return false;
		
		boolean[] char_set= new boolean[128];
		for(int i=0; i<str.length(); i++) 
		{
			int val = str.charAt(i);
			if(char_set[val])//already found this character in string
				return false;
		}
					
		return true;
		
		/*Time complexity for this code is O(n), where n is the length of the string.
		 *The space complexity is O(1). You could also argue the time complexity is O(1),
		 *since the for loop will never iterate through more than 128 characters.
		 *If you didn't want to assume the character set is fixed, you could express 
		 *the complexity as O(c) space and O(min(c, n)) or O(c) time, where c is the size of the
		 *character set*/
	}

}