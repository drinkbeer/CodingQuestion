class Solution {
    /*
    https://www.youtube.com/watch?v=C75nVjzsT9g
    https://leetcode.com/problems/parse-lisp-expression/discuss/113902/A-Clean-Java-Solution
    
    First part: tokenize the expression
    parse()     - tokenize the expression (split the expressions)
    
    Second part: do the calculation
        1. add: just do calculation on tokens (with recursive eval)
        2. mult: just do calculation on tokens (w9th recursive eval)
        3. let: need to put new pair into map unti lthe last exp
    
    */
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }
    
    private int eval(String exp, Map<String, Integer> parent) {
        if (exp.charAt(0) != '(') {
            // just a number or a symbol
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return parent.get(exp);
        }
        
        // create a new scope, and add all the previous values to it
        Map<String, Integer> map = new HashMap<>();
        map.putAll(parent);
        /*
        exp.charAt(1) == 'm' ? 6 : 5
        This is the start index to trimming the expression:
        "(let " - 5 chars
        "(add " - 5 chars
        "(mult " - 6 chars
        */
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) {  // add
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(m")) {  // mult
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else {    // let
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            }
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }
    
    /*
    parse() - tokenizes an expression
    */
    private List<String> parse(String str) {
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') par++;
            if (c == ')') par--;
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) res.add(new String(sb));
        return res;
    }
}
