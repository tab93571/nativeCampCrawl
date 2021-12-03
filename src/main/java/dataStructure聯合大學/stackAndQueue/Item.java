package dataStructure聯合大學.stackAndQueue;

public class Item {

    public Item(){

    }
    public Item(Integer number){
        this.data = number;
    }

    private Integer data;
    private Item next;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
