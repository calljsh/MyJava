package Linkedlist;

public class Linkedlist  implements Mylinkedlist
{
    static  class ListNode
    {
        // 内部类;
        public  int val;
        public  ListNode next;
        public  ListNode prev;
        //前驱
        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;
    @Override
    public void addFirst(int data)
    {
        ListNode temp=new ListNode(data);
        if(this.head==null)
        {
            this.head=temp;
            this.last=temp;
        }
        else {
            temp.next=this.head;
            this.head.prev=temp;
            this.head=temp;
        }
    }

    @Override
    public void addLast(int data)
    {
        ListNode temp=new ListNode(data);
       if(head==null)
       {
           head=temp;
           last=temp;
       }
       else
       {
           last.next=temp;
           temp.prev=last;
           last=temp;
       }
    }

    private ListNode Findidx(int idx)
    {
        ListNode cur=this.head;
        while(idx-1!=0)
        {
            cur=cur.next;
            idx--;
        }
        return cur;
    }
    @Override
    public void addIndex(int index, int data)
    {
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
        ListNode cur=Findidx(index);
        // 找到前一个坐标
        ListNode temp=new ListNode(data);
        // 需要插入的
        temp.next=cur.next;
        cur.next.prev=temp;
        temp.prev=cur;
        cur.next=temp;
    }

    @Override
    public boolean contains(int key)
    {
        ListNode cur=head;

        while(cur!=null)
        {
           if(cur.val==key)
           {
               return true;
           }
            cur=cur.next;
        }
        return false;
    }

    private  ListNode Findidx2(int num)
    {
        ListNode cur=this.head;
        while (cur != null) {
            if (cur.val==num) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void remove(int key)
    {
        if (this.head == null)
        {
            return;
        }
        if (this.head.val == key)
        {
            this.head = this.head.next;
            if(head!=null)
            {
                this.head.prev=null;
                return;
                // 只有一个元素的链表
            }
            last=null;
            return ;
            // 删头节点
        }
        ListNode cur=Findidx2(key);
        if (cur == null) {
            return;
        }
        if(cur.next==null)
        {
            cur.prev.next=null;
            cur.prev=last;
            return;
            // 删尾节点
        }
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
    }

    @Override
    public void removeAllKey(int key)
    {
        ListNode cur=head;
        while(cur!=null)
        {
            if(cur.val==key)
            {
                if(cur==head)
                {
                    head=head.next;
                    if(head==null)
                    {
                        last=null;
                    }
                    else
                    {
                        head.prev=null;
                    }
                }
                else
                {
                    cur.prev.next=cur.next;
                    if(cur.next==null)
                    {
                        last=last.prev;
                    }
                    else
                    {
                        cur.next.prev=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }


    @Override
    public int size()
    {
        int count=0;
        ListNode cur=head;
        while(cur!=null)
        {
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display()
    {
        ListNode cur=head;
        if(cur==null)
        {
            return;
        }
        while(cur!=null)
        {
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    @Override
    public void clear()
    {
       ListNode cur=head;
       while(cur!=null)
       {
           ListNode temp=cur.next;
           cur.val=0;
           cur.prev=null;
           cur.next=null;
           cur=temp;
       }
       head=null;
        System.out.println("清理完成");
    }
}
