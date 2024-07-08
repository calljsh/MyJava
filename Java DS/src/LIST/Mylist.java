package LIST;
import java.util.Arrays;
public class Mylist implements list
{
    int [] myarray;
    public  static  final int number= 5;
  int  usedsize=0;
    public Mylist()
    {
        this.myarray = new int[number];
    }
private  void checkcap()
{
    if(isfull())
    // 检测一下
    {
        myarray = Arrays.copyOf(myarray,myarray.length*2);
        // 扩容(两倍)
    }
}
@Override
public boolean isfull()
// 检测顺序表是否以及满了
{
    if(usedsize==myarray.length)
        return true;
    else
        return  false;
}
    @Override
    public boolean isEmpty()
            // 检查是否为空的
    {
        return this.usedsize==0?true:false;
    }
    private  void checkPos (int pos)   throws POSIllegal
    {
        if(pos<0||pos>this.usedsize)
        {
            throw  new POSIllegal("pos不合法,你的pos是 :"+pos);
        }
    }
    private  void checkPosSet (int pos)   throws POSIllegal
    {
        if(pos<0||pos>=this.usedsize)
        {
            throw  new POSIllegal("pos不合法,你的pos是 :"+pos);
        }
    }
@Override
public void display()
{
        // 打印顺序表
        for(int i=0;i<this.usedsize;i++)
        {
            System.out.print(myarray[i]);
            System.out.print(" ");
        }
        System.out.println();
}
    @Override
    public void add(int data)
    {
        checkcap();
        this.myarray[this.usedsize]=data;
        usedsize++;
    }
//引用数据类型的变量存储的是对象在堆内存中的引用地址，而不是对象本身。
    @Override
    public void add(int pos, int data)
    {
        checkcap();
        try
        {
            checkPos(pos);
        }
        catch ( POSIllegal e)
        {
            e.printStackTrace();
            return ;
        }
                for(int i=this.usedsize-1;i>=pos;i--)
        {
             this.myarray[i+1]=this.myarray[i];
        }
        this.myarray[pos]=data;
        this.usedsize++;
    }
    @Override
    public boolean contains(int toFind)
    {
        // 负责找下标的
        if(isEmpty())
        {
            System.out.println("找不到,因为顺序表是空的");
            return false;
        }
        for(int i=0;i<usedsize;i++)
        {
            if(this.myarray[i]==toFind)
            {
                System.out.println("找到了,它的下标是 :"+i);
                return true;
            }
        }
        System.out.println("顺序表里没有这么元素");
        return  false;
    }
      @Override
    public int indexOf(int toFind)
    {
        if(isEmpty())
        {
            return -1;
        }
        else
        {
            for(int i=0;i<this.usedsize;i++)
            {
                if(this.myarray[i]==toFind)
                    return i;
            }
        }
            return -1;
    }
    @Override
    public int get(int pos)
    {
        try {
            return this.myarray[pos];
        } catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            System.out.println("越界了,数组只有"+myarray.length+"这么大");
            System.out.println("请你看看自己是不是选择了负数或者大于数组大小的数");
           return  pos;
        }
    }
    @Override
    public void set(int pos, int value)
    {
        try {
           checkPosSet(pos);
        }
        catch (POSIllegal e)
        {
            e.printStackTrace();
            return ;
        }
        this.myarray[pos]=value;
    }
    @Override
    public void remove(int toRemove)
    {
         int idx=indexOf(toRemove);
         if(idx==-1)
         {
             System.out.println("没有这个数字哦");
         }
         else
         {
             for(int i=idx;i<usedsize-1;i++)
             {
                 this.myarray[i]=this.myarray[i+1];
             }
             usedsize--;
         }
    }
    @Override
    public int size()
    {
        return this.usedsize;
    }
    @Override
    public void clear()
    {
        if(isEmpty())
        {
            System.out.println("没法清理,顺序表是空的");
            return ;
        }
        for(int i=0;i<this.usedsize;i++)
        {
            this.myarray[i]=0;
        }
        display();
        System.out.println("清空完成");
        this.usedsize=0;
    }
    @Override
    public void delete(int toDelete)
    {
        try {
            checkPos(toDelete);
        }
        catch (POSIllegal e)
        {
            e.printStackTrace();
            return;
        }
        for(int i=toDelete;i<this.usedsize-1;i++)
        {
            this.myarray[i]=this.myarray[i+1];
        }
        this.usedsize--;
    }
}
