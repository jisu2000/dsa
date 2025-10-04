package binarysearch;

//https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
public class NthRoot {

    public static void main(String[] args) {
        int n = 2;
        int m = 100;

        NthRoot sol = new NthRoot();
        System.out.println(sol.nthRoot(n, m));
    }

    public int nthRoot(int n, int m) {

        int start = 1;
        int end = m;

        int ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            int res = calculatePower(mid, m, n);

            if (res == 0) {
                ans = mid;
                break;
            } else if (res > 0) {
                end = --mid;
            } else {
                start = ++mid;
            }
        }

        return ans;
    }

    private int calculatePower(int mid, int actual, int n) {

        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * (long) mid;
            if (ans > actual) {
                return 1;
            }
        }

        if (ans == actual) {
            return 0;
        } else {
            return -1;
        }

    }
}
