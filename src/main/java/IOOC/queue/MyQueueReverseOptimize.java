package IOOC.queue;

import java.util.Stack;

public class MyQueueReverseOptimize {

    //todo

    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    int front;

    public MyQueueReverseOptimize(){
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    public boolean empty() {
        return stack.isEmpty();
    }

    //定義棧頂為隊尾
    public int pop(){


        if(!stack2.isEmpty()){
            return stack2.pop();
        }

        while(stack.size()>1){
            stack2.push(stack.pop());
        }
        return  stack.pop();



    }
    public int peek (){

        if(!stack2.isEmpty()){
            return stack2.peek();
        }

        return front;
    }
    public void push(int x){

        if(stack.isEmpty()){
            front = x;
        }

       stack.push(x);
    }

    public static void main(String[] args) {
        MyQueueReverseOptimize queue = new MyQueueReverseOptimize();
        queue.push(1);
        queue.push(2);
        queue.push(3);

    }
}

