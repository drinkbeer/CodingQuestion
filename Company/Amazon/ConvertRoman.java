/*
Symbol  Value
I   1
V   5
X   10
L   50
C   100
D   500
M   1,000

Combination Value
IV      4
IX      9
XL      40
XC      90
CD      400
CM      900


Letter can duplicate, but cannot duplicate more than 3 letters. CCC -> 300


Test Case
II --> 2
CCC --> 300
MI --> 1001

MCM --> 1900

If num is larger than 3000? No

*/
import java.util.*;
class Solution {
    public static String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
         while(num >= values[i]){
             num -= values[i];
             sb.append(symbols[i]);
         }
        }
        return sb.toString();
    }
    public static void main(String[] args){
     System.out.println("2: " + intToRoman(2));
     System.out.println("4: " + intToRoman(4));
     System.out.println("1900: " + intToRoman(1900));
     
     System.out.println("MCM: " + romanToInt("MCM"));
     System.out.println("space: " + romanToInt(""));
     System.out.println("III: " + romanToInt("III"));
    }
    
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        if(s == null || s.length() == 0) return 0;
        
        int len = s.length();
        
        int result = map.get(s.charAt(len - 1));
        for(int i = len - 2; i >= 0; i--){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
                result += map.get(s.charAt(i));
            }else{
                result -= map.get(s.charAt(i)); // CM -> 900
            }
        }
        return result;
    }
    
    
}