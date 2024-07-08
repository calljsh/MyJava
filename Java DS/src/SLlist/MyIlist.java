package SLlist;
import java.util.Scanner;
public class MyIlist implements IList
{
     static class  Listnode
     {
         public int value;
         public Listnode next;
         // 存地址的

         public Listnode(int value) {
             this.value = value;
         }
     }
     public int usedsize;
    public MyIlist() {
        this.usedsize = usedsize;
    }
    public  Listnode head;
     public  void createlistnode()
    {
        Listnode node1=new Listnode(12);
        Listnode node2=new Listnode(29);
        Listnode node3=new Listnode(42);
        Listnode node4=new Listnode(82);
        Listnode node5=new Listnode(97);
        node1.next=node2;
        // 表示node1的地质领存的是node2的地址
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        head=node1;
        //next 中存的就是地址
        //在这个代码中，node1, node2, node3, node4, 和 node5 都是引用变量，
        // 它们存储的是 Listnode 对象在堆内存中的引用地址（内存地址），而不是对象本身。通过这些引用地址，可以访问和操作链表中的各个节点。
    }
    @Override
    // 头插
    public void addFirst(int data)
    {
        Listnode node=new Listnode(data);
                if(head==null)
                {
                    this.head=node;
                }
                else
                {
                    node.next=this.head;
                    this.head=node;
                    // 先把旧的头的地址赋给地址域
                    //然后把新node当作新头
                    //不能搞反了,反了以后,就是node已经是头了,它的地址域存的还是自己的头,形成了一个闭环
                }
    }
    @Override
    // 尾插
    public void addLast(int data)
    {
        Listnode node=new Listnode(data);
        if(head==null)
        {
            this.head=node;
            return ;
        }
        Listnode cur=this.head;
        while(cur.next!=null)
        {
            cur=cur.next;
        }
            cur.next=node;
    }
private Listnode findindex(int idx)
        // 通过给的下标去找节点
{
    Listnode cur=this.head;
    int num=0;
    while(num!=idx-1)
    {
        cur=cur.next;
        num++;
    }
    return cur;
}
    @Override
    public void addIndex(int index, int data)
    {
        Listnode node=new Listnode(data);
        if(index<0||index>size())
        {
            return;
        }
        if(index==0)
        {
            addFirst(data);
            return;
        }
         if(index==size())
        {
            addLast(data);
            return;
        }
         Listnode cur=findindex(index);
         node.next=cur.next;
         cur.next=node;
    }
    @Override
    public boolean contains(int key)
    {
        Listnode cur=this.head;
        while(cur!=null)
        {
            if(cur.value==key)
            {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    private Listnode findindex2(int key)
// 通过给的下标去找节点
    {
        Listnode cur = this.head;
         while(cur.next!=null)
         {
             if(cur.next.value==key)
             {
                 return cur;
             }
             cur=cur.next;
         }
        return null;
    }
    @Override
    public void remove(int key)
    {
        Listnode cur=findindex2(key);
        if(this.head.value==key)
        {
            this.head=this.head.next;
            return ;
        }
        if(cur==null)
        {
            return ;
        }
        Listnode del=cur.next;
        cur.next=del.next;
    }
    @Override
    public void removeAllKey(int key)
    {
        // 创建哨兵节点来处理头节点可能被删除的情况
        Listnode dummy = new Listnode(0);
        dummy.next = this.head;
        Listnode cur = dummy;
        // 遍历链表，删除所有值为key的节点
        while(cur.next != null)
        {
            if(cur.next.value == key)
            {
                cur.next = cur.next.next; // 跳过要删除的节点
            }
            else
            {
                cur = cur.next; // 继续遍历
            }
        }
        // 更新链表的头节点
        this.head = dummy.next;
    }
    @Override
    public int size()
    {
        Listnode cur=this.head;
        while(cur!=null)
        {
            usedsize++;
            cur=cur.next;
        }
        return usedsize;
    }
    @Override
    public void clear()
    {
        Listnode cur=this.head;
        while(cur!=null)
        {
             Listnode curnext=cur.next;
             cur.value=0;
             cur.next=null;
             cur=curnext;
        }
        head=null;
        System.out.println("清空");
    }

    @Override
    public void display()
    {
        Listnode cur=this.head;
        if(head==null)
        {
            System.out.println("链表为空");
            return;
        }
             while(cur !=null)
             {
                 System.out.print(cur.value+" ");
                 cur=cur.next;
             }
        System.out.println();
    }
    public void reverseList()
    {
        Listnode pre=null;
        Listnode cur=head;
        while(cur!=null)
        {
            Listnode nextnode=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextnode;
        }
        this.head=pre;
    }
    // 反转链表


    @Override
    public Listnode getMidOfList()

    {
        Listnode fast=head;
        Listnode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


}









/*

package SLlist;

public class MyIlist implements IList {
    static class Listnode {
        public int value;
        public Listnode next;

        public Listnode(int value) {
            this.value = value;
        }
    }

    public int usedsize;
    public Listnode head;

    public MyIlist() {
        this.usedsize = 0;
    }

    public void createlistnode() {
        Listnode node1 = new Listnode(12);
        Listnode node2 = new Listnode(29);
        Listnode node3 = new Listnode(42);
        Listnode node4 = new Listnode(82);
        Listnode node5 = new Listnode(97);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        head = node1;
    }

    @Override
    public void addFirst(int data) {
        Listnode node = new Listnode(data);
        if (head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Listnode node = new Listnode(data);
        if (head == null) {
            this.head = node;
            return;
        }
        Listnode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    private Listnode findindex(int idx) {
        if (idx <= 0 || idx > size()) {
            return null;
        }
        Listnode cur = this.head;
        int num = 0;
        while (num != idx - 1) {
            cur = cur.next;
            num++;
        }
        return cur;
    }

    @Override
    public void addIndex(int index, int data) {
        Listnode node = new Listnode(data);
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Listnode cur = findindex(index);
        if (cur == null) {
            return;
        }
        node.next = cur.next;
        cur.next = node;
    }

    @Override
    public boolean contains(int key) {
        Listnode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Listnode findindex2(int key) {
        Listnode cur = this.head;
        while (cur != null && cur.next != null) {
            if (cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void remove(int key) {
        if (head == null) {
            return;
        }

        // 删除头节点的情况
        if (head.value == key) {
            head = head.next;
            return;
        }

        // 查找要删除节点的前一个节点
        Listnode cur = findindex2(key);
        if (cur == null) {
            return;
        }

        // 删除节点
        Listnode del = cur.next;
        if (del != null) {
            cur.next = del.next;
        }
    }

    @Override
    public void removeAllKey(int key) {
        // 还未实现删除所有指定值节点的方法
    }

    @Override
    public int size() {
        Listnode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {
        this.head = null;
        this.usedsize = 0;
    }

    @Override
    public void display() {
        Listnode cur = this.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

 */