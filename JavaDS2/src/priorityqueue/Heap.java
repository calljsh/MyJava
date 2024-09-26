package priorityqueue;

import java.util.Arrays;

public class Heap
    //创建一个大根堆
{
    public  int [] elem;
    public  int usedsize;

    public Heap() {
        this.elem =new int[10];
    }

    public  void intitElem (int [] arr)
    {
        int num=arr.length;
        usedsize=num;
        elem= Arrays.copyOf(arr,num);
        // 因为是完全二叉树能完全利用数组空间,所以数组存储的顺序就是层序遍历的顺序
    }

//   1. 如果i为0，则i表示的节点为根节点，否则i节点的双亲节点为 (i - 1)/2
//   2. 如果2 * i + 1 小于节点个数，则节点i的左孩子下标为2 * i + 1，否则没有左孩子
//   3. 如果2 * i + 2 小于节点个数，则节点i的右孩子下标为2 * i + 2，否则没有右孩子
 public  void createHeap()
 // 这是创建一个大根堆
 {
     for(int parent = (usedsize-1-1)/2;parent>=0;parent--)
     // usedsizd 是大小, -1以后是下标 ,再减1除2,获得双亲结点
     //  换句话说,这个for 循环就是遍历双亲结点,不遍历孩子结点
     // 从 树的最底下开始循环,判断位置是否需要交换
     {
          siftdown(parent,usedsize);
          // 向下调整
          // 这是一次双亲结点进行交换的方法
     }
 }
 private  void  siftdown(int parent,int len)
 {
     int child = 2*parent+1;
     while(child<len)
     {
         if( child+1<len &&elem[child]<elem[child+1])
         //   有 右孩子,而且右孩子更大
         {
             child=child+1;
             // 标识给到右孩子,为下一步的交换做铺垫
             // 如果不进入这么循环,说明左子树的值更大
         }
         if(elem[parent]<elem[child])
         {
             int temp=elem[child];
             elem[child]=elem[parent];
             elem[parent]=temp;
             // 交换值
             parent = child;
             child=2*parent+1;
             // 继续检查能不能交换
         }
         else
         {
             break;
             // 无法交换了,没必要继续了,直接break;
         }
     }
 }
 private  void checkup (int size)
 {
     if(elem.length==size)
     {
         elem=Arrays.copyOf(elem,elem.length*2);
     }
     else
     {
         return ;
     }
 }
    public  void push(int val)
            // 堆的插入
    {
        checkup(usedsize);
        elem[usedsize]=val;
        siftup(usedsize);
        usedsize++;
    }
    private  void siftup(int num)
    {
        int num2=(num-1)/2;
        // 双亲结点
        while(num>0)
        {

            if(elem[num]>elem[num2])
            {
                int temp=elem[num];
                elem[num]=elem[num2];
                elem[num2]=temp;
                num=num2;
                num2=(num2-1)/2;
                // 交换
            }
            else
            {
                break;
            }
        }
    }
    public int pop()
   // 弹出堆顶元素
    {
        if(empty())
        {
            return -1;
        }
        else
        {
            int temp=elem[0];
            elem[0]= elem[usedsize-1];
            elem[usedsize-1]=temp;
            usedsize--;
            siftdown(0,usedsize);
            int val=elem[0];
            return val;
        }
    }
    private  boolean empty()
    {
        return usedsize==0;
    }

    public  void display(int [] elem)
 {
     for(int i=0;i<usedsize;i++)
     {
         System.out.print(elem[i]+" ");
     }
     System.out.println();
 }
}
