package niuke.sort;


import Utils.ArrayUtils;

import java.util.PriorityQueue;

/**
 * 求出数据流的中位数
 */
public class TheMediumOfStream {

    public static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static Integer N = 0;

    public static void insert(int nums) {
        N++;
        if (N % 2 == 0) {
            left.add(nums);
            right.add(left.poll());
        } else {
            right.add(nums);
            left.add(right.poll());
        }

    }

    public static int getMedium() {
        if (N == 0) {
            return 0;
        }
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) >> 1;
        } else {
            return left.peek();
        }
    }

    public static void main(String[] args) {
        for (int num: ArrayUtils.nums){
            insert(num);
            System.out.println(getMedium());
        }
    }
}
