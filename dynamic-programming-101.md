//参考 http://hawstein.com/posts/dp-novice-to-advanced.html
public class DynamicProgramming101 {
/*动态规划(此处的Programming)是规划的意思
 * 1.什么是动态规划
 * 动态规划是一种解决问题的思想。
 * 比方说你有一个很大的问题。但是你可以把它分成无数--或者许多个子问题， 
 * 模变小后的问题和原来的问题是同质的，除了规模变小，其它的都是一样的
 *
 *Example1:已知公交線路, 現從A到F地,求公交換乘方式
 *比方说你A》B》C》D》E》F 换乘了 每一次其实等于就是一个小问题
 *初始状态A求出先做B,然后到了B，在计算得出应该坐C，然后到了C得出应该坐D
 *最后求除了符合题目要求的步驟序列
 *
 *
 * ！！！ 当前子问题的解将由上一次子问题的解推出,你找到了上一个子问题的解
 * ！！！你就找到了本子问题的解。(想到loop和recursive了不是吗)
 * 
 * 动态规划算法通常基于一个递推公式及一个或多个初始状态。 然后一个个解决子问题，
 * 最终到子问题全部解决
 * 
 * Example2:如果我们有面值为1元、3元和5元的硬币若干枚，如何用|最少|的硬币凑够11元？
 *我用函数来表达吧比较清楚b(钱数)=硬币数
 * 最小的初始状态 ：0元-0个硬币  b(0)=0
 * 下一个状态：1元-1个（1元）硬币   b(1)=1
 * b(2)=2,但是你的思维方法不能是 拿了2个1元硬币
 * 而应该是：我拿了一个一元硬币 这是1种拿法,然后剩下1元成为了b(1)=1;
 * 所以3元时候b(3)=1+b(2)=3       //  拿了1元后递推回b(2)  拿了一个3元的递推会b(0)
 * 当然 另一种方法是直接拿个一个3元的所以b(3)=min{d(3-1)+1, d(3-3)+1}
 * 所以。本题的解法就是
 *              vj表示本次取的硬币的面值
 * d(i)=min{ d(i-vj)+1 }，其中i-vj >=0， 
 * 
 * 
 * 上面讨论了2个非常简单的例子。现在让我们来看看对于更复杂的问题， 如何找到状态之间的
 * 转移方式(即找到状态转移方程)。为此我们要引入一个新词叫递推关系来将状态联系起来(说的还是状态转移方程)
 * Example3:
 * 一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。 (讲DP基本都会讲到的一个问题LIS：longest increasing subsequence)
 * 正如上面我们讲的，面对这样一个问题，我们首先要定义一个“状态”来代表它的子问题， 并且找到它的解。注意，大部分情况下，
 * 某个状态只与它前面出现的状态有关， 而独立于后面的状态。
 * 假设数组是{5，3，4，8，6，7} //ps：最长升序子序列不一定要连续的，但是不能改变原数组的顺序，所以是3.4.6.7
 *前1个数的LIS长度d(1)=1(序列：5)
 *前2个数的LIS长度d(2)=1(序列：3；3前面没有比3小的)
 *前3个数的LIS长度d(3)=2(序列：3，4；4前面有个比它小的3，所以d(3)=d(2)+1)
 *                                                                  请注意这个max
 *前4个数的LIS长度d(4)=3(序列：3，4，8；8前面比它小的有3个数，所以 d(4)=max{d(1),d(2),d(3)}+1=3)
  
 *
 * 我觉得状态转移方程已经很明显了，如果我们已经求出了d(1)到d(i-1)， 那么d(i)可以用下面的状态转移方程得到：
 * d(i) = max{1, d(j)+1},其中j<i且A[j]<=A[i]--->j不大于A[i]的最大的一个数
 * 用大白话解释就是，想要求d(i)，就把i！！前面！！的各个子序列中， ！！最后一个数不大于A[i]的序列长度加1！！，然后取出最大的长度即为d(i)。 
 * 当然了，有可能i前面的各个子序列中最后一个数都大于A[i]，那么d(i)=1， 即它自身成为一个长度为1的子序列。
 * 所以由此可得
 * d(5)=d(3)+1=2+1=3 //离6最近但是比6小的是4--d(3)
 * d(6)=d(4)+1=3=4
 * 这个方法是O(N2)
 * 
 * 
public int maxSubSequence(int person[]){
	int[] d=new int[person.length];
	int maxSubLen=1;
	for(int i=1;i<person.length;i++){
		d[i]=1;
			for(int j=0;j<i;i++){
				if(person[j]<=person[i]&&(d[j]+1)>d[i]){
					d[i]=d[j]+1;}
			}
	if(d[i]>maxSubLen){maxSubLen=d[i]; }
	}

return maxSubLen;
}

 * 
 * 
 * 
 */  
//还有种nlogn的更巧妙解法 有兴趣可以google
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



https://www.1point3acres.com/bbs/thread-423857-1-1.html

