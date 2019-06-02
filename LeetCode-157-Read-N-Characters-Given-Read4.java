/*
Use read4() to implement read(), return the actual number read.
Becareful, it's possible that the actual number of elements in buf is < n

https://leetcode.com/discuss/85767/java-easy-version-to-understand

*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // 1.
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
//     public int read(char[] buf, int n) {
//         if(n <= 0) return 0;
        
//         char[] tmp = new char[4];
//         int j = 0;
        
//         while(true){
//             int readCount = read4(tmp); //put data from read4 into tmp
            
//             // copy date from temp to buf
//             for(int i = 0; i < readCount && j < n; j++, i++){
//                 buf[j] = tmp[i];
//             }
            
//             // readCount < 4 means file is all read. j==n means we have already get all we need from file.
//             if(readCount < 4 || j == n){
//                 break;
//             }
//         }
        
//         return j;
//     }
    
    // 2.
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        
        int total = 0;
        boolean eof = false;
        while(!eof && total < n) {
            char[] buf4 = new char[4];
            int count = read4(buf4);
            count = Math.min(count, n - total);
            
            for (int k = 0; k < count; k++) {
                buf[total++] = buf4[k];
            }
            
            eof = count < 4;
            // buf4 = new char[4]; // not necessary
        }
        
        return total;
    }
}
