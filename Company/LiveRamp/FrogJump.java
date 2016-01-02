/*
A small frog wants to get to the other side of a pond. The frog is initially located on 
one bank of the pond (position 0) and wants to get to the other bank (posisiton X).
The frog can jump any (integer) distance between 1 and D. If X > D then the frog 
cannot jump right across the pond. Luckily, there are leaves falling from a tree onto 
the surface of the pond, and the frog can jump onto and from the leaves.

You are given a zero-indexed array A consisting of N integers. This array represents 
falling leaves. Initially there are no leaves. A[K] represents the position where a leaf
will fall in second K.

The goal is to find the earliest time when the frog can get to the other side of the 
Pond. The frog can jump from and to positions 0 and X (the banks of the pond) and 
every position with a leaf.

For example, you are given integers X = 7, D = 3 and array A such that:

A[0] = 1;
A[1] = 3;
A[2] = 1;
A[3] = 4;
A[4] = 2;
A[5] = 5;

Initially, the frog cannot jump across the pond in a single jump. However, in second 3, 
after a leaf falls at position 4, it becomes possible for the frog to cross. This is the 
earliest moment when the frog can jump across the pond (by jumps of length 1, 3 and 3).

Write a function: 
        int solution(int A[], int N, int X, int D);
that, given a zero-indexed array A consisting of N integers, and integers X and D, returns
the earliest time when the frog can jump to the other side of the pond. If the frog can 
leap across the pond in just one jump, the function should return 0. If the frog can get 
to the other side of the pond just after the very first leaf falls, the function should 
also return 0. If the frog is never able to jump to the other side of the pond, the 
function should return -1.

Analysis:
Time Complexity: O(N)
Space Complexity: O(1)

Greedy.
Scan from 0s, to (N-1)s.
Initially, maximum position the frog could reach is D (not sure if there is leaf between position 0-D)
Each second, there is a leaf fall into pond. So we,
    1.See if frog could reach the leaf.
    2.If could, see if the max pos is smaller than curr leaf pos + D
    3.If smaller, means frog could jump longer from curr leaf. Now update max position
    4.Check is curr time's max position is longer than end of pond. If so, return curr time.

Free-Response:
We're excited that you're interested in a position here at LiveRamp. How did you hear about us and why are you interested in working at LiveRamp in particular? What about LiveRamp excites you? Please limit yourself to 1-2 paragraphs.
1.I love the LiveRamp culture. LiveRamp place happy work style in a topmost position. I can socialize with colleagues at the happy hours, I can build some cool projects in HackWeek, I will never go hungry as LiveRamp provides me with lots of food, etc.
2.I love to work in small team. Working in a small team can ensure I can focus on my part of work at a highest degree, and my potentiality can be mostly used.
*/
class FrogJump {

    private static int frogJump(int arr[], int X, int D){
        if(arr == null || arr.length == 0) return -1;
        if(X <= D) return 0;

        int maxCouldReach = D;     // time phase

        for(int time = 0; time < arr.length; time++){
            if(maxCouldReach >= arr[time]){
                // means could reach the leaf in curr time
                if(maxCouldReach < arr[time] + D){
                    maxCouldReach = arr[time] + D;
                    if(maxCouldReach >= X) return time;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,3,1,4,2,5};
        int X = 7;      // the end of pond
        int D = 3;      // the longest step frog can jump in one step
        System.out.println(frogJump(arr, X, D));
    }
}