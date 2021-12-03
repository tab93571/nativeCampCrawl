package IOOC.linkedList;

import javafx.util.Pair;

public class LinkedListRecursion<E> {

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

    private Node head;
    private int size;

    public LinkedListRecursion(){
        head = null;
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

    }

    //在鏈表index位置添加元素
    //在鏈表中不是一個常用的操作，練習用
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal Index");
        }

        head = add(head,index,e);
        size++;

    }
    // 在以node为头结点的链表的index位置插入元素e，递归算法
    private Node add(Node node, int index, E e){

        if(index == 0){
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void  removeElements(E e){
        head = removeElements(head,e);

    }

    //在以head為頭節點的鏈表中刪除值為val的節點，並返回結果鏈表的頭節點
    private Node removeElements(Node node,E e){

        if(node == null){
            return null;
        }
        node.next = removeElements(node.next,e);

        if(node.e.equals(e)){
            size --;
            return node.next;
        }
        return node;
    }



    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index");

        }
        return get(head,index);
    }
    // 在以node为头结点的链表中，找到第index个元素，递归算法
    private E get(Node node, int index){
        if(index == 0){
            return node.e;
        }

        return get(node.next,index-1);
    }


    public E getFirst(){

        return get(0);
    }

    public E getLast(){

        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        set(head,index,e);
    }
    // 修改以node为头结点的链表中，第index(0-based)个位置的元素为e，递归算法
    private void set(Node node,int index, E e){
        if(index == 0){
            node.e = e;
            return;
        }

        set(node.next,index -- ,e);

    }


    public boolean contains(E e){
        return contains(head, e);
    }
    // 在以node为头结点的链表中，查找是否存在元素e，递归算法
    private boolean contains(Node node ,E e){

        if(node.equals(null)){
            return false;
        }

        if(node.e.equals(e)){
            return true;
        }
        return contains(node.next,e);
    }


    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal Index");
        }

        Pair<Node, E> res = remove(head, index);
        size --;
        head = res.getKey();
        return res.getValue();
    }
    // 从以node为头结点的链表中，删除第index位置的元素，递归算法
    // 返回值包含两个元素，删除后的链表头结点和删除的值：）
    private Pair<Node, E> remove(Node node, int index){
        if(index == 0)
            return new Pair<>(node.next, node.e);
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }



    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while(cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListRecursion<Integer> linkedList = new LinkedListRecursion<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
