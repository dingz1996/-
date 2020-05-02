package Algorithm.二叉树.非递归遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
前序遍历顺序为：根 -> 左 -> 右
后序遍历顺序为：左 -> 右 -> 根

如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
        那么结果链表就变为了：右 -> 左 -> 根

如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
        那么结果链表就变为了：左 -> 右 -> 根    这刚好是后序遍历的顺序

基于这两个思路，我们想一下如何处理：
修改前序遍历代码中，节点写入结果链表的代码，将插入队尾修改为插入队首
修改前序遍历代码中，每次先查看左节点再查看右节点的逻辑，变为先查看右节点再查看左节点
 */
public class 后序遍历巧方法 {
    Stack<TreeNode3> stack = new Stack<>();
    public List<Integer> postorderTraversal(TreeNode3 root) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        //不用考虑root是否为空的情况
        TreeNode3 t3 =root;
        while(true){
            add(t3,list);
            if(!stack.isEmpty()){
                t3 = stack.pop();
                //取左边的插入
                t3 = t3.left;
            }else{
                break;
            }
        }
        //这一步模拟了头插法 因为add是尾插法  所以直接倒置list为list1即可
        for(int i = list.size()-1;i>=0;i--){
            list1.add(list.get(i));
        }
        return list1;
    }
    private void add(TreeNode3 t3,List<Integer> list){
        while(t3!=null){
            list.add(t3.val);
            stack.push(t3);
            //先插右边的
            t3 = t3.right;
        }
    }
}

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3(int x) { val = x; }
}
