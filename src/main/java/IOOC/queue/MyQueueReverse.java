package IOOC.queue;

import java.util.Stack;

public class MyQueueReverse {
    private Stack<Integer> stack;
    int front;

    public MyQueueReverse(){
        stack = new Stack<>();
    }
    public boolean empty() {
        return stack.isEmpty();
    }

    //定義棧頂為隊尾
    public int pop(){
        Stack<Integer> stack2 = new Stack<>();
        while(stack.size()>1){
            front = stack.peek();
            stack2.push(stack.pop());
        }
        int ret = stack.pop();

        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }

        return ret;

    }
    public int peek (){
        return front;
    }
    public void push(int x){
        if(empty()){
            front = x;
        }
       stack.push(x);
    }

    public static void main(String[] args) {
        MyQueueReverse queue = new MyQueueReverse();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());

        queue.pop();
        System.out.println(queue.peek());



    }
}

