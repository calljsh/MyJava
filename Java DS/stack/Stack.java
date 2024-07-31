package stack;

import java.util.Arrays;

public class Stack implements MyStack
    // 底层结构还是数组
{
    private int [] elem;
    private int usedsize;

    private  static  final  int DEFAULT_NUM =10;

    public Stack()
    {
        this.elem = new int[DEFAULT_NUM];
        this.usedsize = usedsize;
    }
 private  void  checkcap()
 {
     if(usedsize==elem.length)
     {
         elem= Arrays.copyOf(elem,elem.length*2);
     }
 }
    @Override
    public void push(int x)
    {
       checkcap();
       elem[usedsize]=x;
       usedsize++;
       //保证永远是放在数组的最后一个位置
    }

    @Override
    public int pop()
    {
        if(empty())
        {
            throw  new EmptyException("栈为空");
        }
        int oldnum=elem[usedsize-1];
        usedsize--;
          // elem[usedsize]=null;
        return oldnum;
    }
    @Override
    public int size()
    {
        return usedsize;
    }

    @Override
    public int peek()
    {
        if(empty())
        {
            throw  new EmptyException("栈为空");
        }
        int oldnum=elem[usedsize-1];
        // 不删
        return oldnum;

    }
    
    @Override
    public boolean empty()
    {
        if(usedsize==0)
        {
            return true;
        }
       return false;
    }
}
