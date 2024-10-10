package queue;

public interface Queue
{
     public boolean offer(int val);
     // 尾插

     public int poll();
     // 弹出

    public  int size();

    public  boolean isempty();

    public int peek();

    public void display();




}
