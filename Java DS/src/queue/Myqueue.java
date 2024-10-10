package queue;

public class Myqueue  implements Queue
{
    static  class  ListNode
    {
        public  int val;
        public ListNode  next;
        public ListNode  prev;
        //前驱
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode last;
   public  int size;
    @Override
    public boolean offer(int val)
    {
        ListNode listNode=new ListNode(val);
        // 尾插
        if(head==null)
        {
            head=listNode;
            last=listNode;
        }
        else {
            last.next=listNode;
            listNode.prev=last;
            last=last.next;
        }
        size++;
        return true;
    }

    @Override
    public int poll()
    {
        if(head==null)
        {
            return -1;
        }
        int num=head.val;
        if (head.next==null)
        {
            return num;
        }
        head=head.next;
        head.prev=null;
        return num;
    }
    @Override
    public int size()
    {
       return size;
    }
    @Override
    public boolean isempty()
    {
        if(size==0)
        {
            return  true;
        }
        return false;
    }
    @Override
    public int peek()
    {
        if(head==null)
        {
            return -1;
        }
        return head.val;
    }
    @Override
    public void display()
    {
        ListNode cur=head;
        while(cur!=null)
        {
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

}
