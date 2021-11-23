package IOOC.linkedList;

public class DummyHeadLinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e ){
            this(e, null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){

        add(0,e);

        size ++;
    }

    //在鏈表index位置添加元素
    //在鏈表中不是一個常用的操作，練習用
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal Index");
        }

        Node prev = dummyHead; // dummyHead為0前面的節點

        //所以遍歷index次 會到 index前面的那個節點
        for(int i=0 ; i<index ; i ++){
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size ++;

    }

    public void addLast(E e){
        add(size, e);
    }
}
