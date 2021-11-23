package IOOC.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithTopVariableReverse {

    private Queue<Integer> q;


    /** Initialize your data structure here. */
    public MyStackWithTopVariableReverse() {
        q = new LinkedList<>();
    }

    // empty 的实现很简单，直接调用 q 的 isEmpty 就好了：）
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

    public void push(int x){
        // with another queue
//        Queue<Integer> q2 = new LinkedList<>();
//        q2.add(x);
//        while(!q.isEmpty()){
//            q2.add(q.remove());
//        }
//        q = q2;

        //without another queue
        q.add(x);
        //執行 n-1次 出隊再入隊操作

        for(int i = 1; i < q.size(); i ++){
            q.add(q.remove());
        }


    }
    public int pop(){

        int value = q.remove();

        return value;
    }
    public int top(){
        return q.peek();
    }

    public static void main(String[] args) {

        MyStackWithTopVariableReverse stack = new MyStackWithTopVariableReverse();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();

        int top = stack.top();
    }


}
