class Solution {
    /*
    https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
    */
    private class StrItem {
        int num;
        StringBuilder sb = new StringBuilder();
        
        public StrItem(int num) {
            this.num = num;
        } 
    }
    
    public String decodeString(String s) {
        if (s == null || s.length() <= 1) return s;
        
        Stack<StrItem> stack = new Stack<>();
        int len = s.length(), num = 0;
        stack.push(new StrItem(1));     // initialize the stack with a StrItem with 1
        for (int i = 0; i < len; i++) {
            switch(s.charAt(i)) {
                case '0': case '1': case '2': case '3': case '4':
                case '5': case '6': case '7': case '8': case '9':
                    num = 10 * num + s.charAt(i) - '0';
                    break;
                case '[':
                    // means we finished reading numbers
                    StrItem numSI = new StrItem(num);
                    stack.push(numSI);
                    num = 0;        // we have to set the num to be 0
                    break;
                case ']':
                    // means we finished reading one string
                    StrItem si = stack.pop();
                    String str = si.sb.toString();
                    int n = si.num;
                    for (int j = 0; j < n; j++) {
                        stack.peek().sb.append(str);
                    }
                    break;
                default:
                    stack.peek().sb.append(s.charAt(i));
            }
        }
        return stack.pop().sb.toString();
    }
}
