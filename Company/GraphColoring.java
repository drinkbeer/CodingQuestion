class GraphColoring{
    static int n = 0;
    
    public static void main(String[] args){
        int[][] x = new int[][]{  
                    {1,1,1,1,0,0},  
                    {1,1,1,1,1,0},  
                    {1,1,1,1,0,0},  
                    {1,1,1,1,1,0},  
                    {0,1,0,1,1,1},  
                    {0,0,0,0,1,1}};
        // color. 0 is first color, 1 is second...
        int c = 0;
        // color plan.
        int[] k = new int[x.length];
        
        setColor(x, 0, c, k);
    }
    
    /*
    Color the ith node
    */
    public static void setColor(int[][] x, int i, int c, int[] k){
        boolean fc = false; // is current color # enough?
        
        if(i < x.length){
            for(int t = 0; t <= c; t++){
                // check if t could be colored to current i pos.
                if(checkColor(x, i, t, k)){
                    fc = true;
                    k[i] = t;
                    setColor(x, i + 1, c, k);   //color next i+1 pos
                }
            }
            
            if(!fc){
                c++;
                k[i] = c;
                i++;
                setColor(x, i, c, k);
            }
        }else{
            //print color plan
            n++;
            System.out.println("Plan" + n + ": ");
            for(int j = 0; j < k.length; j++){
                System.out.println(k[j] + ", ");
            }
            System.out.println();
        }
    }
    
    private static boolean checkColor(int[][] x, int i, int t, int[] k){
        // j < i not j < x[i].length, because we color from front to end
        for(int j = 0; j < i; j++){
            if(x[i][j] == 1 && k[j] == t) return false;
        }
        return true;
    }
}