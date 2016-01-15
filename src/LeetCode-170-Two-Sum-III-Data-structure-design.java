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
// public class TwoSum {
//     List<Integer> list;
    
//     public TwoSum(){
//         list = new ArrayList<Integer>();
//     }

//     // Add the number to an internal data structure.
//  public void add(int number) {
//      list.add(number);
//  }

//     // Find if there exists any pair of numbers which sum is equal to the value.
//  public boolean find(int value) {
//      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//      for(int i = 0; i < list.size(); i++){
//          if(map.containsKey(list.get(i))){
//              return true;
//          }else{
//              map.put(value - list.get(i), i);
//          }
//      }
//      return false;
//  }
// }

public class TwoSum {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    
    public TwoSum(){
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        list.add(number);
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }else{
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++){
            int num1 = list.get(i);
            int num2 = value - num1;
            if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
        }
        
        return false;
    }
}
// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);