package IOOC.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithTopVariable {

    private Queue<Integer> q;

    private int top;

    /** Initialize your data structure here. */
    public MyStackWithTopVariable() {
        q = new LinkedList<>();
    }

    // empty 的实现很简单，直接调用 q 的 isEmpty 就好了：）
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

    public void push(int x){
        q.add(x);
        top = x;
    }
    public int pop(){
        Queue<Integer> q2 = new LinkedList<>();

        while(q.size() > 1){
            q2.add(q.remove());
            top = q.peek();
        }

        int value = q.remove();
        q = q2;

        return value;
    }
    public int top(){
        return top;
    }

    public static void main(String[] args) {
        MyStackWithTopVariable stack = new MyStackWithTopVariable();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();

        int top = stack.top();
    }


}
