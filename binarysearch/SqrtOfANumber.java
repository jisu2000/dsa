package binarysearch;

public class SqrtOfANumber {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            long SQRT = (long)mid*mid;
            if (SQRT <= x) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        SqrtOfANumber sol = new SqrtOfANumber();
        System.out.println(sol.mySqrt(0));
    }
}
