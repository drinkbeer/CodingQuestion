/*
 * Complete the function below.
 */
    private static String replace(String str, char ch, int i){
        char[]  chars = str.toCharArray();
        chars[i] = ch;
        return String.valueOf(chars);
    }
    static int friendCircles(String[] friends) {
        if(friends == null || friends.length == 0 || friends[0].length() == 0) return 0;
        int m = friends.length;
        int n = friends[0].length();
        int count = 0;
        
        for(int i = 0; i < m; i++){
            String str = friends[i];
            
            if(str.charAt(i) == 'Y'){
                count++;
                for(int j = i; j < n; j++){
                    if(str.charAt(j) == 'Y'){
                        for(int k = 0; k < m; k++){
                            replace(friends[k], 'N', j);
                        }
                    }
                }
            }
            
            
            
        }
        return count;
    }

