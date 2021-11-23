package dataStructure.LinkList;

public class CircularLinkedListMain {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.next = b;
        b.next = c;
        c.next = a;
        count(a);

        //concatenate

        Node a1 = new Node(11);
        Node b1 = new Node(22);
        Node c1= new Node(33);
        a1.next = b1;
        b1.next = c1;
        c1.next = a1;

        Node concatenate = a.next;
        a.next = a1.next;
        a1.next = concatenate;
        count(concatenate);
        print(concatenate);

        //--------------invert



        Node a3 = new Node(111);
        Node b3 = new Node(222);
        Node c3 = new Node(333);
        a3.next = b3;
        b3.next = c3;
        c3.next = a3;

        System.out.println("before reverse");
        print(a3);

        Node reverse = a3;

        Node p = reverse.next;
        Node q = reverse;
        Node r;
        do{
            r = q;
            q = p;
            p = p.next;
            q.next = r;

        }
        while(p!= reverse);

        reverse.next = q;
         reverse = q;
        System.out.println("------invert-------");
        print(reverse);



    }

    public static void count(Node node){
        int count = 0;
        if(null == node){

        }else{
            Node temp = node;
            do{
                count++;
                temp = temp.next;

            }while(node != temp);

        }

        System.out.println("count = "+count);
    }


    public static void print(Node node){
        Node temp = node;
        do{
            System.out.println(temp.data);
            temp = temp.next;


        }while(node != temp);




    }
}


