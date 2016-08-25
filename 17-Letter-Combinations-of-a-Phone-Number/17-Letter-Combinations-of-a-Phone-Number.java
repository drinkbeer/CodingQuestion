/*
Integer.parseInt(String)
Character.getNumericValue(char)

1.DFS


2.BFS
https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue

*/
public class Solution {
    // 1.DFS (easy but slow)
    // public List<String> letterCombinations(String digits) {
    //     List<String> result = new ArrayList<String>();
    //     if(digits == null || digits.length() == 0) return result;

    //     HashMap<Integer, String> map = new HashMap<Integer, String>();
    //     map.put(2, "abc");
    //     map.put(3, "def");
    //     map.put(4, "ghi");
    //     map.put(5, "jkl");
    //     map.put(6, "mno");
    //     map.put(7, "pqrs");
    //     map.put(8, "tuv");
    //     map.put(9, "wxyz");
    //     map.put(0, "");

    //     List<Character> list = new ArrayList<Character>();
    //     DFS(digits, map, result, list);
    //     return result;
    // }

    // private void DFS(String digits, HashMap<Integer, String> map, List<String> result, List<Character> list){
    //     //end condition
    //     if(digits.length() == 0){
    //         StringBuilder sb = new StringBuilder();
    //         for(Character ch : list){
    //             sb.append(ch);
    //         }
    //         result.add(sb.toString());
    //         return;
    //     }

    //     String str = map.get(Character.getNumericValue(digits.charAt(0)));
    //     for(int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         list.add(ch);
    //         DFS(digits.substring(1), map, result, list);
    //         list.remove(list.size() - 1);
    //     }
    // }
    // 2.BFS(not finish)
    // public List<String> letterCombinations(String digits) {
    //     List<String> result = new ArrayList<String>();
    //     if(digits == null || digits.length() == 0) return result;
        
    //     HashMap<Integer, String> map = new HashMap<Integer, String>();
    //     map.put(2, "abc");
    //     map.put(3, "def");
    //     map.put(4, "ghi");
    //     map.put(5, "jkl");
    //     map.put(6, "mno");
    //     map.put(7, "pqrs");
    //     map.put(8, "tuv");
    //     map.put(9, "wxyz");
    //     map.put(0, "");
        
        
        
    //     for(int i = 0; i < digits.length(); i++){
            
    //     }
    // }
    
    // 3.add string to result circle by circle
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        result.add("");     //must initialize, as we add string to result circle by circle
        
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            String str = map[Character.getNumericValue(digits.charAt(i))];
            while(result.get(0).length() == i){
                //this means string in result has not reached to the length as digits, can continue add 
                String curr = result.remove(0);
                for(char ch : str.toCharArray()){
                    result.add(curr + ch);
                }
            }
        }
        return result;
    }
}