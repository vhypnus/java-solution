import java.util.Arrays;

public class Closest {


   public int threeSumClosest(int[] nums, int target) {
        f(stack,nums,target) ;
        return closest ;
    }

    public Integer closest = null ;

    public Stack<Integer> stack = new Stack() ;

    public void f(Stack<Integer> stack,int[] nums,int num){
        if (stack.size() == 3 ){
            int a = nums[stack.get(0)] ;
            int b = nums[stack.get(1)] ;
            int c = nums[stack.get(2)] ;

            int sum = a+b+c ;
            if (closest == null){
                closest = sum ;
            } else {
                closest = Math.abs(num-closest) > Math.abs(sum-num) ? sum:closest ;
            }

            return ;
        }

        for(int i = 0,max = nums.length ;i < max ; i++){
            if(stack.contains(i)){
                continue ;
            }
            stack.add(i) ;
            f(stack,nums,num) ;

            stack.pop() ;
        }
    }

    public static void main(String[] args) {
        Closest c = new Closest() ;
        System.out.println(c.threeSumClosest(new int[]{0,2,1-3},1)) ;
    }
}
