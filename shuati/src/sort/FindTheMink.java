package sort;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 找到数组内最小的k个数
 * 1、小顶堆 getTheMinKPriorityQueue
 * 2、快速选择（基于快排算法） sortMinK
 * 3、实现快速排序 quickSort
 */
public class FindTheMink {

    public static ArrayList<Integer> getMink(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (k > nums.length) {
            return ret;
        }
        sortMinK(nums, k);
        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;

    }

    public static ArrayList<Integer> getTheMinKPriorityQueue(int[] nums, int k) {
        if (k == 0 || k > nums.length) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(priorityQueue);
        return ret;
    }

    public static void quickSort(int nums[], int l, int r) {
        if (l < r) {
            int numbers = nums[l];
            int k = l;
            int m = r;
            while (m > k) {
                while (m > k && nums[m] >= numbers) {
                    m--;
                }
                swap(nums, k, m);
                while (k < m && nums[k] <= numbers) {
                    k++;
                }
                swap(nums, k, m);
            }
            nums[k] = numbers;
            quickSort(nums, l, k - 1);
            quickSort(nums, k + 1, r);
        }
    }

    public static void sortMinK(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int par = partition(nums, l, r);
            if (par == k) {
                return;
            }
            if (par < k) {
                l = par + 1;
            }
            if (par > k) {
                r = par - 1;
            }
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int numbers = nums[l];
        int k = l;
        int m = r;
        while (m > k) {
            while (m > k && nums[m] >= numbers) {
                m--;
            }
            swap(nums, k, m);
            while (k < m && nums[k] <= numbers) {
                k++;
            }
            swap(nums, k, m);
        }
        nums[k] = numbers;
        return k;
    }


    public static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 2, 1, 5, 9, 6, 32131, 23, 543, 54, 7765, 3213, 53453};
        quickSort(nums, 0, 6);
        ArrayUtils.printArray(nums);
        System.out.println(getMink(nums, 10));
        System.out.println(getTheMinKPriorityQueue(nums,10));
    }
}
