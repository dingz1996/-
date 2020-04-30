package Algorithm;

import java.util.ArrayList;
import java.util.List;
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
 */
public class 螺旋矩阵54 {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> list = new ArrayList<Integer>();
         if(matrix==null) return list;
         //设定上下左右边界
         int left = 0;
         int right = matrix[0].length-1;
         int up = 0;
         int down = matrix.length-1;
         while(true){
             for(int i = left;i<=right;i++)list.add(matrix[up][i]);
             // 一、向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
             if(++up>down) break;//二、判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
             //若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
             for(int j = up;j<=down;j++)list.add(matrix[j][right]);
             if(--right<left)break;
             for(int p = right;p>=left;p--)list.add(matrix[down][p]);
             if(--down<up)break;
             for(int q = down;q>=up;q--)list.add(matrix[q][left]);
             if(++left>right)break;//不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案
         }
         return list;
    }
}
