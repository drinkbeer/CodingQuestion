package Stack;

/*
A basic implementation of Stack
*/
public class Stack{
    // this array will store the data in the stack
    private Object[] array;
    private int top;
    private int maxSize;

    public Stack(){
        this.array = new Object[10];    //default max capacity is 10
        this.top = -1;
    }

    public Stack(int capacity){
        this.maxSize = capacity;
        this.array = new Object[this.maxSize];
        this.top = -1;
    }

    // Push a new item onto the top of the stack
    public void push(Object item){
        if(this.top >= this.maxSize - 1){
            System.out.println("Stack Overflow!");
        }else{
            this.top += 1;
            this.array[this.top] = item;
        }
    }

    // Pop an item from from the top of the stack
    public Object pop(){
        if(isEmpty() == true){
            System.out.println("Stack is Empty");
            return null;
        }else{
            this.top -= 1;
            return this.array[this.top + 1];
        }
    }

    // Peeks at the top item without popping it
    public Object peek(){
        if(isEmpty() == true){
            System.out.println("Stack is Empty");
            return null;
        }else{
            return this.array[this.top];
        }
    }

    public boolean isEmpty(){
        return this.top == -1;
    }
}