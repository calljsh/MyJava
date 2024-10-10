package SLlist;

public class test1
{

    public static void main(String[] args) {

        MyIlist myIlist=new MyIlist();
        MyIlist.Listnode listnode= myIlist.createListNode();

       listnode = myIlist.partition(listnode,50);

       myIlist.display(listnode);








    }
}

