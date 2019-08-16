/*
123     -> " one hundred twenty three", should trim().
*/
public class Solution {
    public String numberToWords(int num) {
        String[] thousands = {"", " Thousand", " Million", " Billion"};
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num > 0){
            if(num % 1000 != 0){
                sb.insert(0, convertToWords(num % 1000) + thousands[i]);
            }
            i++;    // 1000 -> "One" should be "One Thousand"
            num /= 1000;
        }
        
        return sb.length() == 0 ? "Zero" : sb.toString().trim();
    }
    
    private String convertToWords(int num){
        String[] digit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String[] ten = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] multiTen = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        
        StringBuilder sb = new StringBuilder();
        if(num >= 100){
            sb.append(digit[num / 100]).append(" Hundred");
            num %= 100;
        }
        if(num >= 20){
            sb.append(multiTen[num/10]);
            num %= 10;
            sb.append(digit[num]);
        }else if(num <10){
            sb.append(digit[num]);
        }else{
            // 10 <= num < 20
            num %= 10;
            sb.append(ten[num]);
        }
        
        return sb.length() == 0 ? "" : sb.toString();
    }
    
    // Follow-up: Reversed Input
    /*
    https://leetcode.com/problems/integer-to-english-words/discuss/216295/Follow-up-on-this-question
    */
}
