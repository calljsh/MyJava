package priorityqueue;

import java.util.Arrays;

public class MinHeap
{
    // 创建一个小根堆
    public int[] elem;
    public int usedSize;

    public MinHeap()
    {
        this.elem = new int[10];
    }

    public void initElem(int[] arr) {
        int num = arr.length;
        usedSize = num;
        elem = Arrays.copyOf(arr, num);
    }

    public void createHeap() {
        for (int parent = (usedSize - 2) / 2; parent >= 0; parent--) {
            // 从最后一个双亲节点向下调整构造小根堆
            siftDown(parent, usedSize);
        }
    }

    private void siftDown(int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            // 如果有右孩子且右孩子比左孩子小，选右孩子
            if (child + 1 < len && elem[child] > elem[child + 1]) {
                child = child + 1;
            }
            // 若父节点大于最小的子节点，则交换
            if (elem[parent] > elem[child]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;

                // 继续向下检查
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private void checkUp(int size) {
        if (elem.length == size) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
    }

    public void push(int val) {
        // 插入元素到堆中
        checkUp(usedSize);
        elem[usedSize] = val;
        siftUp(usedSize);
        usedSize++;
    }

    private void siftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            // 若子节点小于父节点，则交换
            if (elem[child] < elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;

                // 继续向上检查
                child = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int pop() {
        // 弹出堆顶元素
        if (empty()) {
            return -1;
        } else {
            int temp = elem[0];
            elem[0] = elem[usedSize - 1];
            elem[usedSize - 1] = temp;
            usedSize--;
            siftDown(0, usedSize);
            return temp;
        }
    }

    private boolean empty() {
        return usedSize == 0;
    }

    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}
