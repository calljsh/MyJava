package tree;

import java.util.*;

public class BinaryTree {
    public static class BTNode {
        BTNode left;
        BTNode right;
        int value;

        BTNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "存在,它的地址是" + super.toString();
        }
    }

    private BTNode root;

    public BTNode createBinaryTree() {
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);
        BTNode node6 = new BTNode(6);
        BTNode node7 = new BTNode(7);
        BTNode node8 = new BTNode(8);
        root = node1;
       node1.right=node2;
       node1.left=node3;
       node2.left=node4;
       node2.right=node8;
       node3.right=node5;

        return node1;
    }

    public void preorder(BTNode root)
    // 前序遍历
    {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(BTNode root)
    // 中序遍历
    {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public void lastorder(BTNode root)
    // 后序遍历
    {
        if (root == null) {
            return;
        }
        lastorder(root.left);
        lastorder(root.right);
        System.out.print(root.value + " ");
    }

    public int size1;

    public int treesize(BTNode root)
    // 节点个数
    {
        size1 = 0;
        dfs2(root);
        return size1;
    }

    private void dfs2(BTNode root) {
        if (root != null) {
            size1++;
            dfs2(root.left);
            dfs2(root.right);
        } else {
            return;
        }
    }

    public int size2;

    //    public int leafsize(BTNode root)
//    // 叶子节点
//    {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        return leafsize(root.left) + leafsize(root.right);
//    }
    private int sum;  // 用来存储叶子节点的数量

    public int leafsize(BTNode root) {
        sum = 0;  // 初始化sum
        dfs(root);  // 启动DFS
        return sum;  // 返回叶子节点的总数
    }

    private void dfs(BTNode node) {
        // 进入节点 node
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // 如果是叶子节点，更新sum
            sum++;
        }
        // 递归处理左子树和右子树
        dfs(node.left);
        dfs(node.right);
        // 离开节点 node
    }

    // 获取第K层节点的个数
    public int getKLevelNodeCount(BTNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1 && root != null) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    // 获取二叉树的高度
//    int getHeight(BTNode root)
//    {
//       if(root==null)
//       {
//           return 0;
//       }
//       return Math.max(getHeight(root.left),getHeight(root.right))+1;
//    }
    public int max;

    public int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }
        max = 1;
        DFS(root, 1);
        return max;
    }

    private void DFS(BTNode root, int num) {
        if (root.left == null && root.right == null) {
            max = Math.max(num, max);
            return;
        }
        if (root.left != null) {
            int num1 = num + 1;
            DFS(root.left, num1);

        }
        if (root.right != null) {
            DFS(root.right, num + 1);
        }
    }

    // 检测值为value的元素是否存在
//    BTNode find(BTNode root, int val)
//    {
//        if(root==null)
//        {
//            return null;
//        }
//        if(root.value==val)
//        {
//            return root;
//        }
//        BTNode btNode=find(root.left,val);
//        // 能一直找
//        if(btNode!=null)
//        {
//            return btNode;
//        }
//        BTNode btNode1=find(root.right,val);
//        if(btNode1!=null)
//        {
//            return btNode1;
//        }
//        return null;
//    }
    BTNode btNode;
    int pd = 0;
    BTNode find(BTNode root, int val) {
        Dfs(root, val);
        if (pd == 1)
            return btNode;
        else
            return null;
    }
    private void Dfs(BTNode root, int val) {
        if (pd == 1 || root == null) {
            return;
        }
        if (root.value == val) {
            btNode = root;
            pd = 1;
        }
        Dfs(root.right, val);
        Dfs(root.left, val);
    }

    //层序遍历
    public void levelOrder(BTNode root)
    {
        if (root == null)
        {
            return;  // 如果根节点为空，直接返回
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);  // 将根节点加入队列
        while(!queue.isEmpty())
        {
            BTNode temp=queue.poll();
            System.out.print(temp.value+" ");
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
    }
    // 判断一棵树是不是完全二叉树
  public   boolean isCompleteTree(BTNode root)
    {
        if(root==null)
        {
            return true;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);  // 将根节点加入队列
        while(!queue.isEmpty())
        {
            BTNode temp=queue.poll();
            if(temp!=null)
            {
                queue.offer(temp.right);
                queue.offer(temp.left);
            }
            else
            {
                break;
            }
        }
        while(!queue.isEmpty())
        {
            BTNode temp=queue.poll();
            if(temp!=null)
            {
                return false;
            }
        }
        return true;
    }

    public String tree2str(BTNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root, str);
        return str.toString(); // 修复拼写错误
    }

    public void dfs(BTNode root, StringBuilder str) {
        if (root == null) {
            return;
        }
        str.append(root.value);
        // 左子树处理
        if (root.left != null) {
            str.append("(");
            dfs(root.left, str);
            str.append(")");
        }
        else if (root.right != null) {
            // 如果左子树为空且右子树不为空，需要补充 "()"
            str.append("()");
        }

        // 右子树处理
        if (root.right != null) {
            str.append("(");
            dfs(root.right, str);
            str.append(")");
        }
    }


    // 判断两棵树是否相同
    public int PD = 0; // 标志位，表示是否发现不相同
    public boolean ans = true; // 存储结果，默认是相同

    public boolean isSameTree(BTNode  p, BTNode  q) {
        dfs(p, q);
        return ans;
    }

    private void dfs(BTNode  p, BTNode  q) {
        if (PD == 1) {
            return; // 如果已经发现不同，直接返回
        }
        if (p == null && q == null) {
            return; // 如果两个节点都为空，继续递归
        }
        if (p == null || q == null || p.value != q.value) {
            PD = 1; // 如果只有一个节点为空或者值不同，标记为不同
            ans = false;
            return;
        }
        // 递归检查左右子树
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }
}
