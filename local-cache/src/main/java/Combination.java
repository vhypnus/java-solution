import java.util.Stack;

public class Combination {
    private Stack<Integer> stack = new Stack<>() ;

    public void f (int[] nums) {
        if (stack.size() == 3) {
            int a = nums[stack.get(0)] ;
            int b = nums[stack.get(1)] ;
            int c = nums[stack.get(2)] ;
            if (a+b+c == 0){
                System.out.println(a+","+b+","+c) ;
            }

//            System.out.println(stack) ;
            return ;
        }

        for(int i = 0 ,max = nums.length ;i < max ; i++){
            if (stack.contains(i)){
                continue ;
            }
            stack.add(i) ;
            f(nums);
            stack.pop() ;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4} ;
        Combination c = new Combination() ;
        c.f(nums);
    }
}
