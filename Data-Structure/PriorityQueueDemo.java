/*
output 

1,2,3,5,10, 
----------------------------- 
9,8,2,1,



http://my.oschina.net/leejun2005/blog/135085

*/
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
 
public class PriorityQueueDemo {
 
    public static void main(String[] args) {
        Queue<Integer> qi = new PriorityQueue<Integer>();
 
        qi.add(5);
        qi.add(2);
        qi.add(1);
        qi.add(10);
        qi.add(3);
 
        while (!qi.isEmpty()) {
            System.out.print(qi.poll() + ",");
        }
        System.out.println();
        System.out.println("-----------------------------");
        
        // <span></span><span>自定义的比较器，可以让我们自由定义比较的顺序</span> 
        Comparator<Integer> cmp = new Comparator<Integer>() { 
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
        q2.add(2);
        q2.add(8);
        q2.add(9);
        q2.add(1);
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + ",");
        }
 
    }
 
}