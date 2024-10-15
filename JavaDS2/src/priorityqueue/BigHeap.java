package priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Imp implements Comparator<Integer>
{
    public Imp() {
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

public class BigHeap
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Imp());

        for(int i :priorityQueue)
        {
            System.out.print(i+" ");
        }
    }
}

