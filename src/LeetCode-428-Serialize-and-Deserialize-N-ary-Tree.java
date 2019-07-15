/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/*

1,#3,3,#2,5,#0,6,#0,2,#0,4,#0
Utilization Rate: 6/23=25% 

Or we even could remove "#" to further decompress the string.
*/
// class Codec {

//     // Encodes a tree to a single string.
//     StringBuilder sb = new StringBuilder();
//     public String serialize(Node root) {
//         if (root == null) return "";
        
//         sb.append(",");
//         sb.append(root.val);
//         sb.append(",").append("#").append(root.children.size());
//         for (Node n : root.children) {
//             serialize(n);
//         }
//         return sb.toString().substring(1);
//     }
    
    

//     // Decodes your encoded data to tree.
//     public Node deserialize(String data) {
//         if (data == null || data.length() == 0) return null;
        
//         String[] arr = data.split(",");
//         Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<>());
//         int numChildren = Integer.parseInt(arr[1].substring(1));
//         int[] loc = new int[] {2};
//         deserialize(arr, loc, root, numChildren);
//         return root;
//     }
    
//     public void deserialize(String[] arr, int[] loc, Node parent, int numChildren) {
        
//         for (int i = 0; i < numChildren; i++) {
//             Node c = new Node(Integer.parseInt(arr[loc[0]]), new ArrayList<>());
//             parent.children.add(c);
//             loc[0]++;
//             int num = Integer.parseInt(arr[loc[0]].substring(1));
//             loc[0]++;
//             deserialize(arr, loc, c, num);
//         }
//     }
// }


// Remove "#" from number of Children.
class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    public String serialize(Node root) {
        if (root == null) return "";
        
        sb.append(",");
        sb.append(root.val);
        sb.append(",").append(root.children.size());
        for (Node n : root.children) {
            serialize(n);
        }
        return sb.toString().substring(1);
    }
    
    

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] arr = data.split(",");
        Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<>());
        int numChildren = Integer.parseInt(arr[1].substring(0));
        int[] loc = new int[] {2};
        deserialize(arr, loc, root, numChildren);
        return root;
    }
    
    public void deserialize(String[] arr, int[] loc, Node parent, int numChildren) {
        
        for (int i = 0; i < numChildren; i++) {
            Node c = new Node(Integer.parseInt(arr[loc[0]]), new ArrayList<>());
            parent.children.add(c);
            loc[0]++;
            int num = Integer.parseInt(arr[loc[0]].substring(0));
            loc[0]++;
            deserialize(arr, loc, c, num);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
