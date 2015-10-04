/**
 * Created by chen on 15/4/1.
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures.
 * <p/>
 * Tips:
 * 1.Use a boolean array to mark if this char is unique or not.
 * 2.Use a binary digit to mark if this char is unique or not.
 * <p/>
 * Notes:
 * 1. Array.length -> String.length()
 * 2. ASCII has 128 chars? why use 256
 * <p/>
 * Time complexity: 1.O(N) 2.O(N)   - N refers to the length of String
 * Space complexity: 1.O(1) 2.O(1)
 */
public class CC150_1_1_2{
	
	private static boolean unique1(String str){
		if(str == null || str.length() == 0 || str.length() > 256)return false;
		
		boolean[] mark = new boolean[256];
		
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(mark[val]) return false;
			else
				mark[val] = true;
		}
		return true;
	}
	
	private static boolean unique2(String str){
		if(str == null || str.length() == 0 || str.length() > 256) return false;
		
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if((checker & 1 << val) > 0) return false;
			else
				checker |= 1 << val;
		}
		return true;
	}
	
	public static void main(String[] args){
		String[] strs = {"qwertyuiop", "qazwsxeadc"};
		
		for(int i = 0; i < strs.length; i++){
			System.out.println("String: " + unique1(strs[i]) + " - " + unique2(strs[i]));
		}
	}

}