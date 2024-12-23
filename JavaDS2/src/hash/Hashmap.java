package hash;

public class Hashmap {
    // 哈希桶 - 数组链表
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 建立数组
    public Node[] arr;
    public int usedsize;

    public  static final   float  loadnum = 0.75f;

    public Hashmap() {
        this.arr = new Node[10];  // 初始化数组容量为 10
    }

    public void put(int key, int val) {
        int idx = key % arr.length;
        Node cur = arr[idx];

        // 如果链表已经存在，检查是否有相同 key
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;  // 更新值
                return;
            }
            cur = cur.next;
        }

        // 插入新节点（尾插法）
        Node newNode = new Node(key, val);

        // 如果当前桶为空，直接插入
        if (arr[idx] == null) {
            arr[idx] = newNode;
        } else {
            // 否则，找到链表的尾部插入新节点
            Node cur2 = arr[idx];
            while (cur2.next != null) {
                cur2 = cur2.next;
            }
            cur2.next = newNode;
        }
        usedsize++;
        if(loadnum()>loadnum)
        {
            resize();
        }
    }
    private  void resize()
    {
        Node [] newarr = new Node[arr.length*2];
        for(int i=0;i<arr.length;i++)
        {
            Node cur = arr[i];
            while(cur != null)
            {
                Node temp = cur.next;
                int idx = cur.key % newarr.length;// 新的地址
                cur.next = newarr[idx];
                newarr[idx] = cur;
                cur = temp;
            }
        }
        arr = newarr;
    }
    private  float  loadnum()
    {
        return usedsize*1.0f/arr.length;
    }

    public  int get(int key)
    {
        int idx = Math.abs(key % arr.length);
        Node cur = arr[idx];
        while(cur!=null)
        {
            if(cur.key == key)
            {
                return cur.val;
            }

                cur = cur.next;
        }
        return -1;
    }
}
