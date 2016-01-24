/*
给定一个class FileNode, FileNode有两种类型分别是folder还有file, 如果是file的话它提供一个接口来输出其里面的data(并不需要实现），如果是folder,那么有一个函数listChildren返回list<FileNode>提供folder里面包含的其他file跟folder....题目要实现的是给定一个FileNode, 然后把里面包含的所有file data给输出.....因为题目一开始有点绕，花了点时间理解。

最开始写了个简单的recursion, 小哥问recursion版本会有什么优劣势，follow up是让我写个不用recursion的，然后我写了个bfs版本。。再一个follow up是用iterative来写recursion的版本。。。
*/
class PrintFile{
    private Class FileNode{
        int value;
        boolean isFolder;

        public FileNode(int value, boolean isFolder){
            this.value = value;
            this.isFolder = isFolder;
        }

        public List<FileNode> listChildren(){
            return null;
        }
    }

    //DFS
    public void printFile(FileNode node){
        List<FileNode> list = node.listChildren();

        while(list.next != null){
            FileNode curr = list.next;
            
            if(curr.isFolder){
                printFile(curr);
            }else{
                System.out.print(curr.value + " ");
            }
        }
    }

    public void printFile(FileNode node){
        Stack<FileNode> stack = new Stack<FileNode>();
        stack.push(node);

        while(!stack.isEmpty()){
            FileNode curr = stack.pop();
            if(curr.isFolder){
                List<FileNode> list = curr.listChildren();
                stack.addAll(list);
            }else{
                System.out.print(curr.value + " ");
            }
        }
    }

    //Print all file name in this directory (Preorder traversal of)
    private void listAll(int depth){
        printName(depth);   //Print the name of the object
        if(isDirectory()){
            //for each file c in this directory (for each child)
            c.listAll(depth + 1);
        }
    }

    public void listAll(){
        listAll(0);
    }
}