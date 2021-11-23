package dataStructure.stackAndQueue;

public class TestLinkedListStack {

    public static void main(String[] args) {
        StackByLinkedList stackByLinkedList = new StackByLinkedList();
        stackByLinkedList.create();
        stackByLinkedList.push(1);
        stackByLinkedList.push(2);
        stackByLinkedList.push(3);

        System.out.println(stackByLinkedList.pop());
        System.out.println(stackByLinkedList.pop());
        System.out.println(stackByLinkedList.top());
        System.out.println(stackByLinkedList.pop());
        System.out.println(stackByLinkedList.isEmpty());

        int x,y;
        int z =10;
        x = y = z+2;

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }
}
