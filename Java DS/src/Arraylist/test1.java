package Arraylist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class test1
{
    public static void main(String[] args)
    {
        // 操作一
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        Iterator<Integer> it= list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

}
}