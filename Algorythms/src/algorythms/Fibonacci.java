package algorythms;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        long after = System.currentTimeMillis();
        int n = 100;
        long memoization[] = new long[n + 1];
        Arrays.fill(memoization,-1);

        System.out.println(fibEffective(n));
        System.out.println(((double) (System.currentTimeMillis() - after)) / 1000);

        System.out.println(fibNaive(n, memoization));
        System.out.println(((double) (System.currentTimeMillis() - after)) / 1000);
    }

    // Медленный и очевидный
    // Вычисление 100-ого элемента примерно 50_000 лет
    //
    //Применяем мемоизацию
    //После ее применения нахождение сотого элемента выполняется моментально
    private static long fibNaive(int n, long[] memoization) {
        if (n < 0) {
            System.out.println("Wrong Number");
        }

        if (memoization[n] != -1) {
            return memoization[n];
        }


        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long result = fibNaive(n - 1, memoization) + fibNaive(n - 2, memoization);
        memoization[n] = result;

        return result;
    }

    //Вычисление 1000-ого элемента моментально
    private static long fibEffective(int n) {

        if (n < 0) {
            return -1;
        }

        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
