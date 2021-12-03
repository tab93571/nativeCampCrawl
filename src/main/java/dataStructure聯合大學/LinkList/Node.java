package dataStructure聯合大學.LinkList;

public class Node {

    int data;
    Node next;
    Node left;
    Node right;

    Node(){

    }

    Node(int data,Node node){
        this.data = data;
        this.next = node;
    }

    Node(int data){
        this.data = data;
    }
    Node(int data,Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() { return left; }

    public void setLeft(Node left) { this.left = left; }

    public Node getRight() { return right; }

    public void setRight(Node right) {
        this.right = right;
    }
}
