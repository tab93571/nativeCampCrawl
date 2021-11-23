package IOOC.queue;

public class LoopQueueIOOC<E> implements QueueIOOC<E> {

    private E[] data;
    private int front,tail;
    private int size; //todo 如果不加size 要如何實現

    public LoopQueueIOOC(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueIOOC(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        if((tail + 1) % data.length == front){
            resize(getCapacity()*2);
        }

        data[tail] = e;
        tail = (tail + 1 ) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not deque from an empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        size -- ;

        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2 );
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not deque from an empty queue");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];

        for(int i = 0 ; i <size ; i ++){
            newData[i] = data[(front+i)%data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        //與resize 的遍歷方式比較 toString 的方式為到tail的前一個，也就是最後一個
        //resize的方式則是用size表示最後一個

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");

        for(int i = front ; i != tail ; i = (i+1) % data.length){
            res.append(data[i]);
            if((i+1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {

        QueueIOOC<Integer> queueIOOC = new LoopQueueIOOC<>();

        for(int i = 0 ; i < 10 ; i ++){
            queueIOOC.enqueue(i);
            System.out.println(queueIOOC);

            if(i % 3 == 2){
                queueIOOC.dequeue();
                System.out.println(queueIOOC);
            }

        }



    }


}
