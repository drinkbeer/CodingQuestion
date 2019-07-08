/*
LeetCode:  https://leetcode.com/problems/two-sum-iii-data-structure-design/
LintCode:  not find
JiuZhang:  not find
ProgramCreek:  http://www.programcreek.com/2014/03/two-sum-iii-data-structure-design-java/
Analysis: 
1.
put: Time O(1)
find: Time O(n)
2.
put: Time O(1)
find: Time O(n)
*/

// Using one HashMap + one List
// class TwoSum {

//     List<Integer> list;
//     /** Initialize your data structure here. */
//     public TwoSum() {
//         list = new ArrayList<>();
//     }
    
//     /** Add the number to an internal data structure.. */
//     public void add(int number) {
//         list.add(number);
//     }
    
//     /** Find if there exists any pair of numbers which sum is equal to the value. */
//     public boolean find(int value) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int val : list) {
//             map.put(val, map.getOrDefault(val, 0) + 1);
            
//             if (map.containsKey(value - val)) {
//                 if (val == value - val) {
//                     if (map.get(val) > 1) return true;
//                 } else {
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }


// Using One HashMap. Best solution
class TwoSum {

    HashMap<Integer, Integer> map;
    int max;
    int min;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        min = Math.min(min, number);
        max = Math.max(max, number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value < min * 2 || value > max * 2) return false;
        
        for (int i : map.keySet()) {
            int val2= value - i;
            if (map.containsKey(val2) && (i != val2 || map.get(i) > 1)) {
                return true;
            }
        }
        
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
