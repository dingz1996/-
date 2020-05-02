package Algorithm.二叉树.非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
巧妙之处在于 push两次
 */
public class 后序遍历笨方法 {
    Stack<TreeNode2> stack = new Stack<>();
    public List<Integer> postorderTraversal(TreeNode2 root) {
        List<Integer> list = new ArrayList<>();
        TreeNode2 t2 =root;
        while(true){
            add(t2);
            if(!stack.isEmpty()){
                TreeNode2 cur = stack.pop();
                //若pop出的和peek是同一个 则代表的是一直push左节点直至空的情况
                if(!stack.isEmpty()&&cur==stack.peek()){
                    t2 = cur.right;
                }else{
                    //若不是前面一种  则是右子树已经遍历完了 可以将该节点加入到list中了
                    list.add(cur.val);
                }
            }else{
                break;
            }
        }
        return list;
    }
    private void add(TreeNode2 t2){
        while(t2!=null){
            //两次push  第一次为了取其右子节点继续add
                       //第二次为了取值加入到list中
            stack.push(t2);
            stack.push(t2);
            t2 = t2.left;
        }
    }
}
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}