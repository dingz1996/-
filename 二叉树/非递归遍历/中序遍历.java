package Algorithm.二叉树.非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
非递归中序遍历：大致思路：1、当前节点入栈
                        2、之后把当前节点的左节点设为当前节点  再执行1操作
                        3、若当前节点为空  取出栈顶元素
                                                   1放入list中（相当于打印值）
                                                   2把栈顶元素的右节点设为当前节点 再执行1
 */
public class 中序遍历 {
    Stack<TreeNode1> stack = new Stack<>();
    public List<Integer> inorderTraversal(TreeNode1 root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode1 t1 =root;
        while(true){
            add(t1);
            if(!stack.isEmpty()){
                t1 = stack.pop();
                list.add(t1.val);
                t1 = t1.right;
            }else{
                break;
            }
        }
        return list;
    }
    private void add(TreeNode1 t1){
        while(t1!=null){
            stack.push(t1);
            t1 = t1.left;
        }
    }
}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
}