public class RainContainer {

    public int area(int[] nums) {
        int prev_i = 0 ;
        int area_i = 0 ;
        int area_j = 0 ;
        for(int i = 1 ,max = nums.length ;i < max ;i++){

            if (nums[i] >= nums[prev_i] || i == max-1) {
                System.out.println(i) ;
                int h = nums[prev_i] ;
                if(nums[i] < nums[prev_i]) {
                    h = nums[i] ;
                }
                area_i += (i - prev_i) * h ;
                for (int k = prev_i ;k < i ;k++){
                    if (nums[k] > h){
                        area_j += h ;
                    } else{
                        area_j += nums[k] ;
                    }
                }
                System.out.println("area"+(area_i-area_j)) ;

                prev_i = i ;
            }

        }

        return area_i - area_j ;
    }

    public static void main(String[] args) {
        RainContainer r = new RainContainer() ;
        int area = r.area(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) ;
        System.out.println(area) ;
    }
}
