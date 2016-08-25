/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Integer.parseInt(String)
Character.getNumericValue(char)

1.DFS


2.BFS
https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue
*/
public class Solution {
    // 1.DFS
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        List<Character> list = new ArrayList<Character>();
        DFS(digits, map, result, list);
        return result;
    }

    private void DFS(String digits, HashMap<Integer, String> map, List<String> result, List<Character> list){
        //end condition
        if(digits.length() == 0){
            StringBuilder sb = new StringBuilder();
            for(Character ch : list){
                sb.append(ch);
            }
            result.add(sb.toString());
            return;
        }

        String str = map.get(Character.getNumericValue(digits.charAt(0)));
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            list.add(ch);
            DFS(digits.substring(1), map, result, list);
            list.remove(list.size() - 1);
        }
    }
}