package leetcode;

/**
 * 找出数组中重复出现的元素
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatedNumberInArray {

    public static int findRepeatNumber(int[] nums) {
        int temp;
        for(int i = 0;i<=nums.length;i++){
            while(nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,3,4,5,};
        System.out.println(findRepeatNumber(nums));
    }
}
