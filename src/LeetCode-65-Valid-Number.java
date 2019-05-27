/*
https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
https://discuss.leetcode.com/topic/2973/java-solution-with-one-line

Test Cases:
    test(1, "123", true);
    test(2, " 123 ", true);
    test(3, "0", true);
    test(4, "0123", true);  //Cannot agree
    test(5, "00", true);  //Cannot agree
    test(6, "-10", true);
    test(7, "-0", true);
    test(8, "123.5", true);
    test(9, "123.000000", true);
    test(10, "-500.777", true);
    test(11, "0.0000001", true);
    test(12, "0.00000", true);
    test(13, "0.", true);  //Cannot be more disagree!!!
    test(14, "00.5", true);  //Strongly cannot agree
    test(15, "123e1", true);
    test(16, "1.23e10", true);
    test(17, "0.5e-10", true);
    test(18, "1.0e4.5", false);
    test(19, "0.5e04", true);
    test(20, "12 3", false);
    test(21, "1a3", false);
    test(22, "", false);
    test(23, "     ", false);
    test(24, null, false);
    test(25, ".1", true); //Ok, if you say so
    test(26, ".", false);
    test(27, "2e0", true);  //Really?!
    test(28, "+.8", true);  
    test(29, " 005047e+6", true);  //Damn = =|||
    
We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the end it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

Not a good problem as it didn't describe clearly the definition of Number.
*/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        
        for(int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterE = true;
            }else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen){
                    return false;
                }
                pointSeen = true;
            }else if(s.charAt(i) == 'e'){
                if(eSeen || !numberSeen){
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }
}
