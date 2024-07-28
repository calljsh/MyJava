package Linkedlist;

public class Test {
    public static void main(String[] args) {
        Linkedlist linkedlist=new Linkedlist();
        linkedlist.addFirst(10);
        linkedlist.addFirst(25);
        linkedlist.addFirst(356);
        linkedlist.addLast(563);
        linkedlist.addLast(123);
        linkedlist.addLast(563);
        linkedlist.addLast(563);
        linkedlist.addLast(563);
        linkedlist.addLast(563);
        linkedlist.addLast(563);
        linkedlist.addLast(563);

        linkedlist.display();
        System.out.println();
        linkedlist.removeAllKey(563);
        linkedlist.display();






    }
}
