/*
LeetCode: https://leetcode.com/problems/rotate-image/
LintCode: http://www.lintcode.com/problem/rotate-image/
JiuZhang: http://www.jiuzhang.com/solutions/rotate-image/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-rotate-image-java/

Analysis:
Easy problem. Can draw the array in paper, and calculate.

https://shmilyaw-hotmail-com.iteye.com/blog/2292710

它的变化过程是将它的每一行都变成了列的方式。比如说第１行转换后变成了第三列，第二行变成了第二列，第三行变成了第一列。因为问题中的要求，只能使用常量范围的额外空间，所以不能简单的新建一个矩阵再拷贝过去。如果能这么做的话那就太简单了， 我们按照前面的转换一行行的拷过去就可以了。

现在牵涉到旋转这个矩阵的时候，我们该怎么做呢？我们先来看第一行的元素(0, 0)位置的元素旋转后到了(0, 2)的位置，(0, 1)的则到了(1, 2)的位置，(0, 2)到了(2, 2)的位置。下一行的元素呢？(1, 0) -> (0, 1) (1, 1) -> (1, 1)  (1, 2) -> (2, 1)。假设矩阵的长度为n的话，我们会发现对应于原来矩阵里的元素matrix[i][j]在旋转后的位置变为matrix[j][n - 1 - i]。

这样，我们就找到了这里变化的一个规律。但是因为这里是通过替换的方式进行位置调整，所以还有一些细节需要处理。比如说，我们确定了一个元素的位置之后，它替换的原来这个元素也要继续去替换它的下一个元素。按照前面的规律同样，它也要继续这么替换直到最后一个元素覆盖了最开始我们拿来替换的元素。这里就相当于旋转了一个圈。实际上由于我们每次这么调整就需要最多４个元素，这里只需要按照这个步骤遍历调整４次就可以了。

对于这个调整的过程，我们有必要细化一下。假定在节点matrix[i][j]，那么首先我们要将我们当前要替换的那个节点的值保存一下，因为它在下一次要用到。所以我们将matrix[j][n - i - 1]赋值给一个元素p。然后将原来matrix[i][j]的值设置到这个位置。这样我们得到的这个(j, n - i - 1)又将作为下一个交换元素的起始点，继续下一个过程...　所以我们需要将新的位置索引i = j, j = n - i - 1。

还有一个问题就是我们遍历的时候，取值的范围该怎么定？是遍历所有的元素吗？很显然不是。因为我们一个元素要这么旋转调整４次。我们实际调整的范围如下图：



从上图可以看到，我们在两条斜线范围内的一行经过４次调整正好就覆盖了一个圈。所以我们取值只需要覆盖1/4个矩阵的那个三角部分就可以了。

*/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1 || matrix.length != matrix[0].length) return;
        
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++){
            for(int j = 0; j < (len + 1) / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
