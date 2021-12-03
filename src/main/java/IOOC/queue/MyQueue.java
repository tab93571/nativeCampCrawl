package IOOC.queue;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack;

    public MyQueue(){
        stack = new Stack<>();
    }
    public boolean empty() {
        return stack.isEmpty();
    }

    //先定義隊首為stack頂
    public int pop(){
        return stack.pop();
    }
    public int peek (){
        return stack.peek();
    }


    public void push(int x){
        Stack<Integer> stack2 = new Stack();

        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        stack.push(x);
        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
