/**
 * Created by chen on 15/5/12.
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so
 * it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
 * You can call isBadVersion to help you determine which version is the first bad one. The details interface can be
 * found in the code's annotation part.
 * <p/>
 * Example:
 * Given n=5:
 * Call isBadVersion(3), get false;
 * Call isBadVersion(5), get true;
 * Call isBadVersion(4), get true;
 * Here we are 100% sure that the 4th version is the first bad version.
 * Note:
 * Please read the annotation in code area to get the correct way to call isBadVersion in different language. For
 * example, Java is VersionControl.isBadVersion(v)
 * <p/>
 * Challenge:
 * You should call isBadVersion as few as possible.
 * <p/>
 * Version Control Case:
 * public class VersionControl {
 * public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether
 * the kth code version is bad or not.
 */
public class LintCode_74_FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }

        int start = 1;
        int end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // search the left bound(the first bad version)
            if (!VersionControl.isBadVersion(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (VersionControl.isBadVersion(start)) {
            return start;
        } else if (VersionControl.isBadVersion(end)) {
            return end;
        }

        return -1;
    }

    private static class VersionControl {
        private static boolean isBadVersion(int v) {
            if (v == 5) {
                return true;
            }
            return false;
        }
    }
}
