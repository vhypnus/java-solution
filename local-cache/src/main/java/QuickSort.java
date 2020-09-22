import java.util.Arrays;

public class QuickSort {


    public void quicksort(int[] nums,int s,int e){
        if (s >= e) {
            return ;
        }

        int p = partition(nums,s,e) ;
        quicksort(nums,s,p-1);
        quicksort(nums,p+1,e);

    }

    private int partition(int[] nums,int s,int e) {

        int k = s ;
        for (;s < e;s++) {
            if(nums[s] < nums[e]){
                if (k < s) {
                    swap(nums,k,s) ;
                }
                k++ ;
            }
        }

        swap(nums,k,e) ;
        return k ;
    }

    private void swap(int[] nums,int i,int j) {
        int tmp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = tmp ;

    }

    public void println(int[] nums) {
        for(int i = 0 ,max = nums.length ;i < max ; i++){
            System.out.print(nums[i]+"->") ;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        QuickSort sort = new QuickSort() ;
//        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1} ;
//
//        sort.quicksort(nums,0,nums.length-1);
//        sort.println(nums);

        if((1 & 0x01 )== 0x1){
            System.out.println("yes") ;
        }


    }
}
