package Algorithm.快排_堆排;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6,5,7,1,4,9,15,3};
        quicksort(a,0,a.length-1);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    private static void quicksort(int[] a,int x,int y){
        if(x>=y) {
            return;
        }

            int k = a[x];
        int left = x;
        int right = y;
        while(left<right){
            while(left<right&&a[right]>=k){
                right--;
            }
            while(left<right&&a[left]<=k){
                left++;
            }
            if(left<right){
                int swap = a[left];
                a[left] = a[right];
                a[right] = swap;
            }

        }
        a[x] = a[left];
        a[left] = k;
        quicksort(a,x,left-1);
        quicksort(a,left+1,y);
    }
}
