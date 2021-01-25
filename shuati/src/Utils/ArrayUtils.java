package Utils;

public class ArrayUtils {

    public static final int[] nums = {3, 4, 2, 1, 5, 9, 6, 32131, 23, 543, 54, 7765, 3213, 53453};

    public static void printArray(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
