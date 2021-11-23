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

    //先定義對手為stack頂
    public int pop(){
        return stack.pop();
    }
    public int peek (){
        return stack.peek();
    }
}
