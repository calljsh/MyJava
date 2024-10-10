package SLlist;

public interface IList
{
        //头插法
        public void addFirst(int data);
        //尾插法
        public void addLast(int data);
        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index,int data);
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key);
        //删除第一次出现关键字为key的节点
        public void remove(int key);
        //删除所有值为key的节点
        public void removeAllKey(int key);
        //得到单链表的长度
        public int size();
        public void clear();
     public void reverseList();
      // 反转链表
        public void display(MyIlist.Listnode head) ;
        MyIlist.Listnode getMidOfList();
    public MyIlist.Listnode mergeTwoLists( MyIlist.Listnode l1, MyIlist.Listnode L2);
}
