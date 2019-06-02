/*
https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49601/What-is-the-difference-between-call-once-and-call-multiple-times


Think that you have 4 chars "a, b, c, d" in the file, and you want to call your function twice like this:

read(buf, 1); // should return 'a'
read(buf, 3); // should return 'b, c, d'
All the 4 chars will be consumed in the first call. So the tricky part of this question is how can you preserve the remaining 'b, c, d' to the second call.


https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/188293/Google-follow-up-question.-Speed-up-the-copy.

Follow Up:

If there is enough space in "buf", we could try to optimize read4 method to copy the file contents directly to "buf" by providing a pointer of "buf". But this requires optimization of buf4 method.

*/


/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    
    // 1.
//     char[] temp = new char[4];
//     int i = 0;  // pointer in temp
    
//     int readCount = 0;
    
//     public int read(char[] buf, int n) {
//         int j = 0;  // pointer in buf
        
//         if(n <= 0) return 0;
        
//         while(true){
//             if(i == 0) readCount = read4(temp);
            
//             // copy data from temp to buf
//             while(i < readCount && j < n){
//                 buf[j++] = temp[i++];
//             }
            
//             // if char in temp is used up, set i to 0
//             if(i == readCount) i = 0;
            
//             // readCount<4 means file is all read, j==n means we get all we need from file
//             if(readCount < 4 || j == n) break;
//         }
        
//         return j;
//     }
    
    
    // 2.
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int bufCount = 0;           // the count of chars in buf4
    private int bufPointer = 0;         // the pointer in buf4
    private char[] buf4 = new char[4];
    
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (bufPointer == 0) bufCount = read4(buf4);
            while (total < n && bufPointer < bufCount) buf[total++] = buf4[bufPointer++];
            
            if (bufCount < 4) break;   // there is nothing more to read in read4 method, we reached EOF
            if (bufPointer == bufCount) bufPointer = 0;  // reset the bufPointer 
        }
        return total;
    }
}
