package Queue;

/*
A basic implementation of a doubly linked list
*/
public class DoublyLinkedList {
    private Node head;
    private int size;

    public class Node{
        public Object item;
        public Node prev = null;
        public Node next = null;

        public Node(){
            this.item = null;
        }

        public Node(Object item){
            this.item = item;
        }

        public String toString(){
            return this.item.toString();
        }
    }

    

    public DoublyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFront(Object item){
        Node addNode = new Node(item);
        addNode.next = this.head;
        if(this.head != null){
            this.head.prev = addNode;
        }
        this.head = addNode;
        addNode.prev = null;
        this.size += 1;
    }


    /*
    Insert node into a specific position in doubly linked list.
    For example:
    If list is [a, b, c], addMid(d, 2) will give [a, d, b, c]
    */
    public void addMid(Object item, int position){
        Node addNode = new Node(item);
        Node temp = this.head;
        for(int i = 1; i < position - 1; i++){
            temp = temp.next;
        }
        addNode.next = temp.next;
        if(addNode.next != null){
            addNode.next.prev = addNode;
        }
        temp.next = addNode;
        addNode.prev = temp;
        this.size += 1;
    }

    public void addEnd(Object item){
        Node addNode = new Node(item);
        if(size == 0){
            addFront(item);
        }else{
            //find the last node
            Node lastNode = this.head;
            for(int i = 0; i < this.size - 1; i++){
                lastNode = lastNode.next;
            }
            // create a new node
            Node newLastNode = new Node(item);
            lastNode.next = newLastNode;
            newLastNode.prev = lastNode;
            newLastNode.next = null;
            this.size += 1;
        }
    }

    public Node deleteFront(){
        try{
            this.head = this.head.next;
            this.size -= 1;
            return this.head;
        }catch(NullPointerException e){
            System.out.println("The list is empty");
            return null;
        }
    }

    public Node deleteEnd(){
        Node secondLastNode = this.head;
        for(int i = 0; i < this.size - 1; i++){
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
        this.size -= 1;
        return secondLastNode;
    }

    public void delete(Object item){
        if(contains(item) == false){
            System.out.println("The list doesn't contain the item");
        }else{
            boolean findOne = false;
            Node deleteNode = head;
            while(!findOne){
                if(deleteNode.item.equals(item)){
                    if(deleteNode.prev != null){
                        deleteNode.prev.next = deleteNode.next;
                    }else{
                        this.head = deleteNode.next;
                    }
                    if(deleteNode.next != null){
                        deleteNode.next.prev = deleteNode.prev;
                    }
                    findOne = true;
                    this.size -= 1;
                }
                //continue to find
                deleteNode = deleteNode.next;
            }
        }
    }

    public void deleteAll(Object item){
        if(!contains(item)){
            System.out.println("The list doesn't contain the item");
        }else{
            while(contains(item)){
                delete(item);
            }
        }
    }

    public boolean contains(Object item){
        Node checkNode = this.head;
        for(int i = 0; i < this.size; i++){
            if(checkNode.item.equals(item)){
                return true;
            }
            checkNode = checkNode.next;
        }
        return false;
    }

    public Node getFront(){
        return this.head;
    }

    public int getSize(){
        return this.size;
    }

    public String toString(){
        String s = "";
        if(this.size == 0){
            System.out.println("The list is empty");
        }else{
            Node currNode = this.head;
            for(int i = 0; i < this.size; i++){
                s += "[" + currNode.item.toString() + "]";
                currNode = currNode.next;
            }
        }
        // new line and indent
        s += "\n\t";
        // Add the values of the other fields to the string
        s += "The current size of the list is " + this.size + ".";
        return s;
    }
}
