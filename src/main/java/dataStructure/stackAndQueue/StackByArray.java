package dataStructure.stackAndQueue;

import java.util.concurrent.atomic.AtomicInteger;

public class StackByArray {
    AtomicInteger top = new AtomicInteger(-1);
    Integer[] stack;

    public void create(){
        stack = new Integer[5];

    }
    public void push(int number){
        if(top.equals(stack.length-1)){
            System.out.println("stack is full");
        }else{
            stack[top.incrementAndGet()] = number;
        }
    }
    public Integer pop(){
        if(top .equals(-1)){
            System.out.println("stack is empty");
            return null;
        }else{
            return stack[top.getAndDecrement()];
        }
    }

    public Integer top(){
        if(top.equals(-1)){
            System.out.println("stack is empty");
            return null;
        }else{
            return stack[top.get()];
        }
    }
    public boolean isEmpty(){
        if(top.equals(-1) ){
            return true;
        }else return false;
    }

    public boolean isFull(){
        if(top.equals(stack.length-1)){
            return true;
        }else{
           return false;
        }
    }


}
