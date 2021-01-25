package leetcode;

public class TheKthNumberInTwoArray {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int k = length1 + length2;
        if (k % 2 == 1) {
            return findKthNumberInTwoSortedArray(nums1, nums2, k / 2 + 1);
        } else {
            return (findKthNumberInTwoSortedArray(nums1, nums2, k / 2) + findKthNumberInTwoSortedArray(nums1, nums2, k / 2 + 1)) / 2.0;
        }

    }

    public static double findKthNumberInTwoSortedArray(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int paviot = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            paviot = k / 2;
            int newIndex1 = Math.min(index1 + paviot, length1) - 1;
            int newIndex2 = Math.min(index2 + paviot, length2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3};
        int b[] = {2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
