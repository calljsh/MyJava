package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Demo
{
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new ArrayDeque<>();
        // 分别为动态数组实现的与链表实现的

        Myqueue myqueue=new Myqueue();
        myqueue.offer(5);
        myqueue.offer(6);
        myqueue.offer(2);
        System.out.println(myqueue.size());
        myqueue.clear();
        System.out.println(myqueue.size());

    }
}

//class MyLinkedList {
//    public ListNode head;
//    public int usesize;
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public MyLinkedList() {
//        this.head = null;
//        this.usesize = 0;
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= usesize) {
//            return -1;
//        }
//        ListNode cur = head;
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
//        return cur.val;
//    }
//
//    public void addAtHead(int val) {
//        ListNode listNode = new ListNode(val);
//        listNode.next = head;
//        head = listNode;
//        usesize++;
//    }
//
//    public void addAtTail(int val) {
//        ListNode listNode = new ListNode(val);
//        if (head == null) {
//            head = listNode;
//        } else {
//            ListNode cur = head;
//            while (cur.next != null) {
//                cur = cur.next;
//            }
//            cur.next = listNode;
//        }
//        usesize++;
//    }
//
//    private ListNode findIndex(int idx) {
//        if (idx == 0) return null;  // 对于 idx == 0，返回 null 作为前一个节点不存在的标志
//        ListNode cur = head;
//        for (int i = 0; i < idx - 1; i++) {
//            cur = cur.next;
//        }
//        return cur;
//    }
//
//    public void addAtIndex(int index, int val) {
//        if (index < 0 || index > usesize) {
//            return;
//        }
//        if (index == 0) {
//            addAtHead(val);
//        } else if (index == usesize) {
//            addAtTail(val);
//        } else {
//            ListNode temp = findIndex(index);
//            ListNode listNode = new ListNode(val);
//            listNode.next = temp.next;
//            temp.next = listNode;
//            usesize++;
//        }
//    }
//
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index >= usesize) {
//            return;
//        }
//        if (index == 0) {
//            head = head.next;
//        } else {
//            ListNode temp = findIndex(index);
//            temp.next = temp.next.next;
//        }
//        usesize--;
//    }
//}
//
//class MyQueue
//{
//   private Stack<Integer> stack;
//   private Stack<Integer> stack1;
//
//
//    public MyQueue() {
//
//        stack=new Stack<>();
//        stack1=new Stack<>();
//    }
//
//    public void push(int x)
//    {
//           stack.push(x);
//    }
//
//    public int pop()
//    {
//        if(stack1.empty())
//        {
//            int size=stack.size();
//            for(int i=0;i<size;i++)
//            {
//                stack1.push(stack.pop());
//            }
//        }
//        return stack1.pop();
//
//    }
//
//    public int peek()
//    {
//        if(stack1.empty())
//        {
//            int size=stack.size();
//            for(int i=0;i<size;i++)
//            {
//                stack1.push(stack.pop());
//            }
//        }
//        return stack1.peek();
//
//    }
//
//    public boolean empty()
//    {
//        return stack1.empty()&&stack.empty();
//
//    }
//}
