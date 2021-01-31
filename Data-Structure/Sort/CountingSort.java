package Sort;

/**
 * Counting sort is an algorithm that sorts the element by:
 * 1. Counting the frequency of each element. Put counting in a [0, max_value] sorted frequency array.
 * 2. Do incremental sum of the frequency array.
 * 3. The final position of a value is [frequency - 1].
 *
 * https://www.programiz.com/dsa/counting-sort
 *
 * Ave Time Complexity: O (N + K), N is number of elements, K is the range of elements (aka, max value - min value).
 * Space Complexity: O (max_value)
 */
public class CountingSort {
}
