package binarysearch;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

public class SmallestDivisorLessThanThresHold {

    public static void main(String[] args) {
        int arr[] = {1,2,5,9};
        int t = 6;
        SmallestDivisorLessThanThresHold sol = new SmallestDivisorLessThanThresHold();
        System.out.println(sol.getCeilSum(arr, t));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = getMax(nums);

        while(start<=end){
            int mid = (start+end)/2;
            long sum = getCeilSum(nums, mid);
            if(sum<=threshold){
                end=--mid;
            }else{
                start=++mid;
            }
        }

        return start;

    }

    private int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            max = Math.max(max, num);
        }
        return max;
    }

    private long getCeilSum(int[] arr, int n) {
        long ans = 0;

        for (int num : arr) {
            ans += num % n == 0 ? num / n : num / n + 1;
        }

        return ans;

    }
}