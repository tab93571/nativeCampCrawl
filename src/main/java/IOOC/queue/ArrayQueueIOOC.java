package IOOC.queue;

public class ArrayQueueIOOC<E> implements QueueIOOC<E> {
    private Array<E> array;

    public ArrayQueueIOOC(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueueIOOC(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }



    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }


    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueueIOOC<Integer> queue = new ArrayQueueIOOC<>();

        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }

}
