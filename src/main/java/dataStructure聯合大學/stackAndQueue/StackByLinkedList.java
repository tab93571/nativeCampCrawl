package dataStructure聯合大學.stackAndQueue;

public class StackByLinkedList {
    Item top;

    public void create(){
        top = null;
    }

    public void push(Integer number){
        Item newItem = new Item(number);
        newItem.setNext(top);
        top = newItem;

    }

    public Integer pop(){
        if(top == null){
            System.out.println("stack is empty");
            return null;
        }
        Integer number = top.getData();
        top = top.getNext();
        return number;
    }

    public Integer top(){
        if(top == null){
            System.out.println("stack is empty");
            return null;
        }
        Integer number = top.getData();
        return number;
    }
    public boolean isEmpty(){
        return top == null;
    }
}
