class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;
            
            sb.insert(0, (v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;
        }
        
        if (carry != 0) sb.insert(0, carry);
        return sb.toString();
    }
}
