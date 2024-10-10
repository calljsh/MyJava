package SLlist;

public  class MyIlist implements IList {
    public int usedsize;

    //    public Listnode head;
    static class Listnode {
        public int value;
        public Listnode next;
        public Listnode(int val) {
            this.value = val;
        }
    }
    public Listnode head;


    public MyIlist() {
        this.usedsize = 0;
        this.head = null;
    }

    public Listnode createListNode() {
        Listnode node1 = new Listnode(12756);
        Listnode node2 = new Listnode(29);
        Listnode node3 = new Listnode(24657);
        Listnode node4 = new Listnode(856);
        Listnode node5 = new Listnode(7);
        Listnode node6 = new Listnode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        head = node1;
        return head;
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

    private Listnode findIndex(int idx) {
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
        Listnode cur = findIndex(index);
        Listnode node = new Listnode(data);
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

    private Listnode findIndex2(int key) {
        Listnode cur = this.head;
        while (cur.next != null) {
            if (cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.value == key) {
            this.head = this.head.next;
            return;
        }
        Listnode cur = findIndex2(key);
        if (cur == null) {
            return;
        }
        Listnode del = cur.next;
        cur.next = del.next;
    }

    @Override
    public void removeAllKey(int key) {
        Listnode dummy = new Listnode(0);
        dummy.next = this.head;
        Listnode cur = dummy;
        while (cur.next != null) {
            if (cur.next.value == key) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        this.head = dummy.next;
    }

    @Override
    public int size() {
        Listnode cur = this.head;
        this.usedsize = 0;
        while (cur != null) {
            usedsize++;
            cur = cur.next;
        }
        return usedsize;
    }

    @Override
    public void clear() {
        Listnode cur = this.head;
        while (cur != null) {
            Listnode curNext = cur.next;
            cur.value = 0;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        System.out.println("清空");
    }

    @Override
    public void reverseList() {
        // 反转
        Listnode pre = null;
        Listnode cur = head;
        while (cur != null) {
            Listnode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        this.head = pre;
    }

    @Override
    public void display(Listnode listnode)
    {
        Listnode cur = listnode;
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    @Override
    public Listnode getMidOfList() {
        // 得到中间节点
        Listnode fast = head;
        Listnode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Override
    public Listnode mergeTwoLists(Listnode l1, Listnode L2) {
        return null;
    }


    //    public Listnode mergeTwoLists(Listnode l1, Listnode l2)
//    {
//        Listnode prehead = new   Listnode(-1);
//        Listnode prev = prehead;
//        while (l1 != null && l2 != null) {
//            if (l1.value <= l2.value) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        if(l1!=null)
//        {
//            prev.next=l1;
//        }
//        if(l2!=null)
//        {
//            prev.next=l2;
//        }
//        return prehead.next;
//        // 返回一个节点
//    }
    public Listnode partition(Listnode pHead, int x) {
        // write code here
        //分为两个链表,一个链表放小于x的节点，一个链表放大于等于x的节点
        Listnode bs = null;
        Listnode be = null;
        Listnode as = null;
        Listnode ae = null;
        if (pHead == null) {
            return null;
        }
        Listnode cur = pHead;
        while (cur != null) {
            if (cur.value < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs==null)
        {
            return as;
        }
        if(as==null)
        {
            return bs;
        }
        be.next=as;
        ae.next=null;
        return bs;
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