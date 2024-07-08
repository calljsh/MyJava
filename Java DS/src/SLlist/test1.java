package SLlist;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class test1
{
    public static int N=31000;
    public int [] num=new int[N];
    public static void main(String[] args) {
        MyIlist myIlist=new MyIlist();
     //   myIlist.createlistnode();
     //   myIlist.display();
         myIlist.addLast(1);
        myIlist.addLast(1);
        myIlist.addLast(2);
        myIlist.addLast(1);
        myIlist.display();
        myIlist.reverseList();
        myIlist.display();

    }
}
