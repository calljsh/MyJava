package searchtree;

public class SearchTree
    // 二叉搜索树
{
    static  class TreeNode
    {
        public  int val;
        public  TreeNode left;
        public  TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public  TreeNode root;
    public  boolean search(int key)
    {
      TreeNode cur=root;
        while(cur!=null)
        {
            if(cur.val>key)
            {
                cur=cur.left;
            }
            else if(cur.val<key)
            {
                cur =cur.right;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
  public boolean insert(int val)
  {
      if(root==null)
      {
          root=new TreeNode(val);
          return true;
      }
      TreeNode parent=null;
      TreeNode cur=root;
      while(cur!=null)
      {
         if(cur.val>val)
         {
             parent=cur;
             cur=cur.left;
         } else if (cur.val<val) {
             parent=cur;
             cur=cur.right;
         }
         else {
             return false;
         }
      }
      if(parent.val>val)
      {
          parent.left=new TreeNode(val);
      }
      else
      {
          parent.right=new TreeNode(val);
      }
      return true;
  }
  public  boolean remove(int val)
  {
      TreeNode parent=null;
      TreeNode cur=root;
      while(cur!=null)
      {
          if(cur.val>val)
          {
              parent=cur;
              cur=cur.left;
          }
          else if(cur.val<val)
          {
              parent=cur;
              cur =cur.right;
          }
          else
          {
              // 找到了
              removeNode(cur,parent);
              return true;
          }
      }
      return false;
  }

    private void removeNode(TreeNode cur, TreeNode parent)
    {
        if(cur.left==null)
        // 左边为空
        {
            if(cur==root)
            {
                root=root.right;
                return;
            }
            else if(cur==parent.left)
            {
                parent.left=cur.right;
                return ;
            }
            else
            {
                parent.right=cur.right;
                return ;
            }

        }
        else if (cur.right==null)
        // 右边为空
        {
         if(cur==root)
         {
             root=root.left;
         }
         else if(cur==parent.left)
         {
             parent.left=cur.left;
         }
         else
         {
             parent.right=cur.left;
         }
        }
        else
        // 左右都不为空
        // 思路
        // 1.找到 cur
        // 2.找cur左子树最右边的或者cur右子树最左边的,替换
        {
            TreeNode ansparent = cur;
            TreeNode ans = cur.right;
            // 去找右子树最左边的
            while(ans.left!=null)
            {
                ansparent=ans;
                ans=ans.left;
            }
            // 找到以后,也要分情况
            cur.val=ans.val;
            if(ansparent.left == ans)
            {
                ansparent.left = ans.right;
            }
            else
            {
                ansparent.right=ans.right;
            }

        }
    }
}
