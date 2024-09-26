package priorityqueue;
import java.util.*;
public class Test
{
    public static void main(String[] args)
    {
        int [] arr={27,15,19,18,28,34,65,49,25,37};
        Heap heap = new Heap();
        heap.intitElem(arr);
        heap.display(heap.elem);
        heap.createHeap();
        heap.display(heap.elem);
        heap.push(99);
        heap.display(heap.elem);
        heap.pop();
        heap.display(heap.elem);
    }
}
