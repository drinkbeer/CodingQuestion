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

*/
class FrogJump {

    public int solution(int A[], int N, int X, int D){

    }
}