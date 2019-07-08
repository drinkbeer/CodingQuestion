class Solution {
    // 1. Using One Set to record all substring seen before
//     public List<String> findRepeatedDnaSequences(String s) {
//         if (s == null || s.length() < 10) return new ArrayList<>();
        
//         HashSet<String> record = new HashSet<>();
//         HashSet<String> res = new HashSet<>();
        
//         int start = 0, end = 9, n = s.length();
//         while (end < n) {
//             String str = s.substring(start, end + 1);
//             if (record.contains(str)) {
//                 res.add(str);
//             } else {
//                 record.add(str);
//             }
            
//             start++;
//             end++;
//         }
        
//         return new ArrayList<>(res);
//     }
    
    // 2.Encode the substring to be interger
    /*
    https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-%2B-bits-manipulation)
    Time O(KN)  - K is 10 here
    */
//     public List<String> findRepeatedDnaSequences(String s) {
//         if (s == null || s.length() < 10) return new ArrayList<>();
        
//         HashSet<Integer> record = new HashSet<>();
//         HashSet<String> res = new HashSet<>();
        
//         int[] map = new int[26];
//         // map['A' - 'A'] = 0;      // 00
//         map['C' - 'A'] = 1;         // 01
//         map['G' - 'A'] = 2;         // 10
//         map['T' - 'A'] = 3;         // 11
        
//         int start = 0, end = 9, n = s.length();
//         while (end < n) {
//             String str = s.substring(start, end + 1);
            
//             int v = 0;
//             for (char c : str.toCharArray()) {
//                 v <<= 2;
//                 v |= map[c - 'A'];
//             }
            
//             if (record.contains(v)) {
//                 res.add(str);
//             } else {
//                 record.add(v);
//             }
            
//             start++;
//             end++;
//         }
        
//         return new ArrayList<>(res);
//     }
    
    /*
    https://leetcode.com/problems/repeated-dna-sequences/discuss/53867/Clean-Java-solution-(hashmap-%2B-bits-manipulation)
    
    This is a great solution, and the enhancement in the comments is awesome!
It'd be really awesome if there are some comments describing the solution though.

So just if someone like me just walked in and might be struggling a bit with understanding what they both did,
1. For the solution in the post
The whole idea is to transform the DNA string to numbers (so it'll be quicker for comparison), and this is actually easy since we know for a fact that the sequence only consists of 4 letters (all upper case) 'A', 'C', 'G' and 'T'.

If we want to map this to binary, we'd need (log 4 = 2)
00 -> 'A'
01 -> 'C'
10 -> 'G'
11 -> 'T'

so we create an array to save these values

char[] map = new char[26];
//map['A' - 'A'] = 0;
map['C' - 'A'] = 1;
map['G' - 'A'] = 2;
map['T' - 'A'] = 3;
Now to transform the sequences.
We want to compare every 10 letters to the rest of the sequence, so what we'll do here is:

Transform 10 letters
Try to add them to a set (if the sequence already exists in the set, it will return false)
Try to add them to a second set (If we managed to add it to the set, then this is only the second time we found that sequence, otherwise, it means that we already found it twice, and we don't need to add it to the output list)
Add the sequence to the output list only if we couldn't add the sequence to the first set, and we successfully added it to the second set
So, let's transform the sequence:
First of all, we need 20 bits (10 letters * 2 bits for representing each letter)
So we start with a variable V = 0.
Then for each letter we shift V to the left by 2 bits and OR it with the letter representation
so for sequence "CG" for example:
v = 0

v <<= 2
v = 00

v |= map[s.charAt(j) - 'A'];
So map[s.charAt(j) - 'A'] = 0 = 01
v |= 01 = 01

Nex Character "G":
v = 01

v <<= 2
v = 0100

v |= map[s.charAt(j) - 'A'];
So map[s.charAt(j) - 'A'] = 0 = 10
v |= 0100 = 0110

and so on for the 10 chars.

Then as mentioned above, add that sequence to 2 sets, and if the sequence was:

Added to set1 (Then don't do anything, and notice here that we're depending on the condition short circuiting, so it won't continue to execute the addition to the second set since we're using && and the first condition was true and we're using not, so it will be false) - then - we do nothing.
Not added to set1 and added to set 2 - then - that means that we saw that exact number before, so we add it to the output list.
Not added to set and Not added to set 2 - then - that means that we saw that number before Twice, so do nothing.
2. For the enhancement in the comments by LIYUANZHE01
Notice in the original solution that everytime, we go to the next character we translate the whole string.
In other words, for the sequence "AAAAAAAAAG"
We translate the sequence "AAAAAAAAAA"
then the next loop we move one character to the right, and translate "AAAAAAAAAG"
Notice here that we did the work twice to translate all the "A" letter, as we did that as part of the previous translation for the "AAAAAAAAAA"
So the enhancement would be not to do this, so the solution would become O(N) where N is the number of characters in the sequence s.

To do so, we simply shift the last value to the left twice, to get rid of the first character (Move it outside the 20 bits we're interested in then clear all bits after the first 20)

So let's check the code:

for(int i = 0; i < 10; i++){  // first value
    	val = val << 2;
    	val = val | map[s.charAt(i) - 'A'];
}
words1.add(val);
This is exactly what we did before, but we do it separately for the very first value, and the reason we did this outside the loop is that the loop won't be doing that anymore.
Instead, the next loop would do the enhancement we said before, so let's check the next loop:

for(int i = 1; i < s.length() - 9; i++){ 
    	val &= ~(3 << 18);
    	val = val << 2;
    	val = val | map[s.charAt(i+9) - 'A'];
        if(!words1.add(val) && words2.add(val)){
        	res.add(s.substring(i, i + 10));
        }
}
Notice the first thing here is that we're not clearing val as we did before, but what we do instead is that we clear out the first 2 bits of the 20 bits as follows:

val &= ~(3 << 18);
So 3<<18 = 11 and put 18 zeros in front of it = 11000000000000000000
Then invert all these bits:
~(3<<18) = ~(11000000000000000000) = 00111111111111111111
When you & that with the previous value, the first 18 bits will remain as they are, and only the last 2 bits will be zeros
then we shift that to the left to get 2 zeros to the right, and remove the last 2 zeros out of the way
Then we or the result with the next character in the sequence.
Then we continue with the same logic as the original algorithm.

    Time O(N)
    */
    public List<String> findRepeatedDnaSequences(String s) {
    	if(s.length() < 11) return new ArrayList<>();
        Set<Integer> words1 = new HashSet<>();
        Set<Integer> words2 = new HashSet<>();
        List<String> res = new ArrayList<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int val = 0;
        
        for(int i = 0; i < 10; i++){  // first value
    		val = val << 2;
    		val = val | map[s.charAt(i) - 'A'];
		}
		words1.add(val);

        for(int i = 1; i < s.length() - 9; i++){ 
    		val &= ~(3 << 18);
    		val = val << 2;
    		val = val | map[s.charAt(i+9) - 'A'];
        	if(!words1.add(val) && words2.add(val)){
        		res.add(s.substring(i, i + 10));
        	}
        }
        return res;
    }
}
