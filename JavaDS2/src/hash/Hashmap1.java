package hash;

public class Hashmap1<K, V> {
    // 哈希桶 - 数组链表
    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    // 建立数组
    public Node<K, V>[] arr;
    public int usedsize;
    public static final float LOAD_FACTOR = 0.75f;
    // 构造函数，初始化数组容量
    public Hashmap1() {
        this.arr = new Node[10]; // 初始化容量为 10
    }
    // 插入或更新键值对
    public void put(K key, V val) {
        int idx = Math.abs(key.hashCode() % arr.length);  // 使用键的 hashCode() 来计算索引
        Node<K, V> cur = arr[idx];
        // 如果链表中存在相同的 key，更新对应的值
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;  // 更新值
                return;
            }
            cur = cur.next;
        }

        // 插入新节点（尾插法）
        Node<K, V> newNode = new Node<>(key, val);

        // 如果当前桶为空，直接插入
        if (arr[idx] == null) {
            arr[idx] = newNode;
        } else {
            // 否则，找到链表的尾部插入新节点
            Node<K, V> cur2 = arr[idx];
            while (cur2.next != null) {
                cur2 = cur2.next;
            }
            cur2.next = newNode;
        }
        usedsize++;

        // 判断是否需要扩容
        if (loadFactor() > LOAD_FACTOR) {
            resize();
        }
    }
    // 重新调整哈希表的大小
    private void resize() {
        Node<K, V>[] newarr = new Node[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            Node<K, V> cur = arr[i];
            while (cur != null) {
                Node<K, V> temp = cur.next;
                int idx = Math.abs(cur.key.hashCode() % newarr.length); // 计算新索引
                cur.next = newarr[idx];
                newarr[idx] = cur;
                cur = temp;
            }
        }
        arr = newarr;
    }
    // 计算负载因子
    private float loadFactor() {
        return usedsize * 1.0f / arr.length;
    }

    // 根据键获取值
    public V get(K key) {
        int idx = Math.abs(key.hashCode() % arr.length);
        Node<K, V> cur = arr[idx];
        while (cur != null) {
            if (cur.key.equals(key))
            {
                System.out.println(key.hashCode());
                return cur.val;
            }
            cur = cur.next;
        }
        return null; // 如果没找到，返回 null
    }
}
