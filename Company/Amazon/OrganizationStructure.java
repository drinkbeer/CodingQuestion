/*
// Given a flat file CSV, which denotes an Organization Structure as so:
//   employee_id, first_name, last_name, reports_to
//   mfly, Marty, McFly, jblogs
//   jblogs, Joe, Blogs, rboss
//   nmuller, Nicolas, Muller, jblogs
//   rboss, Robert, Boss,
//   trice, Travis, Rice, rboss.

// Print out a result of directs as such:
// 1. Robert Boss (rboss)
//     2. Joe Blogs (jblogs)
//         3. Nicolas Muller (nmuller)
//         3. Marty McFly (mfly)
//     2. Travice Rice (trice)

HashMap + DFS
*/
import java.util.*;
class OrganizationStructure{

    private static final String DATA = "mfly, Marty, McFly, jblogs\n" + 
                                    "jblogs, Joe, Blogs, rboss\n" + 
                                    "nmuller, Nicolas, Muller, jblogs\n" + 
                                    "rboss, Robert, Boss,\n" + 
                                    "trice, Travis, Rice, rboss\n";

    public static void main(String[] args){
        Map<String, Node> map = new HashMap<String, Node>();

        //scan lines and create nodes
        for(String line : DATA.split("\\n")){
            String[] split = line.split(",");
            String id = split[0].trim();
            String fName = split[1].trim();
            String lName = split[2].trim();
            Node temp = new Node(id, fName, lName);
            map.put(id, temp);
        }

        //connect nodes
        Node root = null;
        for(String line : DATA.split("\\n")){
            String[] split = line.split(",");
            String id = split[0].trim();
            if(split.length == 4){
                String reportTo = split[3].trim();
                map.get(id).reportTo = map.get(reportTo);
                map.get(reportTo).desc.add(map.get(id));
            }else{
                root = map.get(id);
            }
        }

        // DFS and print
        DFS(root, 0);
    }

    private static void DFS(Node root, int level){
        if(root == null) return;
        System.out.println(
            new String(new char[level * 3]).replace("\0", " ") + 
            String.format("%d. %s %s (%s)", level + 1, root.fName, root.lName, root.id)
        );

        for(Node child : root.desc){
            DFS(child, level + 1);
        }
    }

    private static class Node{
        public String id;
        public String fName;
        public String lName;
        public Node reportTo;
        public List<Node> desc;

        public Node(String id, String fName, String lName){
            this.id = id;
            this.fName = fName;
            this.lName = lName;
            reportTo = null;
            desc = new ArrayList<Node>();
        }
    }
}