package Algorithm.二叉树.非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
非递归前序遍历   大致思路：1、当前节点加到栈之前  首先要放入list中（相当于打印值）
                        2、之后把当前节点的左节点设为当前节点  再执行1操作
                        3、若当前节点为空  取出栈顶元素  把栈顶元素的右节点设为当前节点 再执行1
 */
public class 前序遍历 {
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<Integer>();
         //不用考虑root是否为空的情况
        TreeNode t1 =root;
        while(true){
                add(t1,list);
                if(!stack.isEmpty()){
                    t1 = stack.pop();
                    t1 = t1.right;
                }else{
                    break;
                }
            }
        return list;
    }
    private void add(TreeNode t1,List<Integer> list){
        while(t1!=null){
            list.add(t1.val);
            stack.push(t1);
            t1 = t1.left;
        }
    }
}

class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
