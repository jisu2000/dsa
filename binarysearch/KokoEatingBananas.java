package binarysearch;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {


    public static void main(String[] args) {
        int arr[]={805306368,805306368,805306368};
        int h = 1000000000;
        KokoEatingBananas sol = new KokoEatingBananas();
        System.out.println(sol.minEatingSpeed(arr, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getmax(piles);
        while (start <= end) {
            int mid = start + (end - start) / 2; ;
            int totalHours = claculateHours(piles, mid);
            
            if (totalHours <= h ) {
                end = --mid;
            } else {
                start = ++mid;
            }
        }
        return start;
    }

    private int claculateHours(int arr[], int k) {
        int ans = 0;
        for (int banana : arr) {
            ans += (banana + k - 1) / k; 
        }
        return ans<1?Integer.MAX_VALUE:ans;
    }

    private int getmax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
