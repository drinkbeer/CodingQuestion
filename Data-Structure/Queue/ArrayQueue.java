package Queue;

/*
A basic implementation of a queue using an array
http://math.hws.edu/javanotes/c9/s3.html
http://eddmann.com/posts/implementing-a-queue-in-java-using-arrays-and-linked-lists/

*/
public class ArrayQueue{
    private Object[] array;     // store data in array
    private int front;
    private int rear;           //
    private int maxSize;

    public ArrayQueue(){
        this.array = new Object[4];
        this.front = 0;
        this.rear = 0;
        this.maxSize = 4;
    }

    public ArrayQueue(int capacity){
        this.maxSize = capacity;
        this.array = new Object[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(Object item){
        if(isFull() == true){
            System.out.println("The queue is full");
        }else{
            this.array[this.rear] = item;
            this.rear = (this.rear + 1) % this.maxSize;     // Use mod to make full use of available space
        }
    }

    public Object dequeue(){
        if(isEmpty() == true){
            System.out.println("The queue is empty");
            return null;
        }else{
            Object target = this.array[this.front];
            this.front = (this.front + 1) % this.maxSize;
            return target;
        }
    }

    public int size(){
        if(this.front < this.rear){
            return this.rear - this.front;
        }else if(this.front > this.rear){
            return maxSize - this.front + this.rear;
        }else{
            if(this.array[this.front] == null){
                return 0;
            }else{
                return this.maxSize;
            }
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull(){
        return this.size() == this.maxSize;
    }

    public String toString(){
        String s = "";
        int pointer = this.front;
        if(!isEmpty()){
            for(int i = 0; i <= size(); i++){
                s += "[" + array[pointer].toString() + "]";
                pointer = (pointer + 1) % this.maxSize;
            }
            // new line and indent
            s += "\n\t";
            // add information about current queue size, front and rear
            s += "The current size of the queue is " + size() + ".";
            s += "The front is at index " + this.front + " and the rear is at index " + this.rear + ".";
        }else{
            s += "The queue is empty";
        }
        return s;
    }

}