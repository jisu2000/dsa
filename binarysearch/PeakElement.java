package binarysearch;

//https://leetcode.com/problems/find-peak-element/

public class PeakElement {
    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        PeakElement sol = new PeakElement();
        int ans = sol.findPeakElement(nums);
        System.out.println(ans);
    }

    public int findPeakElement(int[] nums) {

        /*
         * Handling the edge cases such as if
         * the peak element in start
         * or the end of the array
         * or its the only element in the array
         */

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int start = 1;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // It is the Peak element
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }

            /*
             * Suppose if the element is in increasing curve 
             * then for sure we will get a peak element in the right search space
             */
            else if (nums[mid] > nums[mid - 1]) {
                start = ++mid;
            } else {
                end = --mid;
            }
        }

        return -1;
    }

}