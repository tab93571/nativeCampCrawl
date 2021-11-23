package dataStructure.LinkList;

public class SingleLinkedListMain {
    public static void main(String[] args) {

        //插入資料20在節點x 之前，也就是說資料要變成1-2-20-3-4 但不能用for迴圈



        Node a = new Node(1);
        Node b = new Node(2);
        Node x = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = x;
        x.next = d;
        d.next = null;

        Node list = a;

        printData(list);
        count(list);

        Node c = new Node();
        c.next = x.next;
        c.data = x.data;
        x.next = c;
        x.data = 20;
        x = c;  //這時候b.next 應該是沒有對到reference了
       x.data = 7;




        printData(list);
        count(list);

        //delete a

        list = a.next;
        a = null;
        printData(list);
        count(list);

        //delete x  a-b-x-c-d

//        Node pre = b;
        b.next = x.next;
//        x = null;
        printData(list);
        count(list);

//--------------------------------Concatenate

        Node a1 = new Node(1);
        Node b1 = new Node(2);
        Node c1 = new Node(3);
        a1.next =b1;
        b1.next = c1;


        Node a2 = new Node(11);
        Node b2 = new Node(22);
        Node c2 = new Node(33);
        a2.next = b2;
        b2.next = c2;


        Node temp = a1;
        while(temp.next != null){
            temp = temp.next;
        }


        //temp會指到a1最後一個節點
        temp.next = a2;

        Node concatenate = a1;

        printData(concatenate);


        //--------------invert

        Node a3 = new Node(111);
        Node b3 = new Node(222);
        Node c3 = new Node(333);
        a3.next = b3;
        b3.next = c3;

        Node p = a3;
        Node q = null;
        Node r;
        while(p!= null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;

        }
        Node reverse = q;
        System.out.println("------invert-------");
        printData(reverse);












    }
    private static void printData(Node node){

        while(true){
            System.out.println(node.data);
            node = node.next;
            if(null == node){
                break;
            }
        }
        System.out.println("------------------------------------------");
    }

    private static void count(Node node){
        int count = 1;

        while(node !=null && node.next != null){
            count++;
            node = node.next;
        }


        System.out.println("count = "+ count+"\n");
    }
}
