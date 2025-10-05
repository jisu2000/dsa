package binarysearch;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

public class MinimumDaysNeedToMakeBouquets {

    public static void main(String[] args) {
        int b[] = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2;
        int k = 3;
        MinimumDaysNeedToMakeBouquets sol = new MinimumDaysNeedToMakeBouquets();
        System.out.println(sol.minDays(b, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int start = getMin(bloomDay);
        int end = getMax(bloomDay);

        while (start <= end) {
            int mid = (start + end) / 2;
            boolean possible = getNumberOfBouquets(bloomDay, k, mid) >= m;
            if (possible) {
                end = --mid;
            } else {
                start = ++mid;
            }
        }

        return start;

    }

    private int getMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int num : arr) {
            ans = Math.min(ans, num);
        }
        return ans;
    }

    private int getMax(int[] arr) {
        int ans = Integer.MIN_VALUE;
        for (int num : arr) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    private int getNumberOfBouquets(int[] bloomDay, int k, int day) {
        int ans = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                ans += count / k;
                count = 0;
            }
        }
        ans += count / k;
        return ans;
    }
}
