class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int f0 = 0, f1 = 1;
        int fn = f0 + f1;

        for(int i = 2; i < n; i++) {
            f0 = f1;
            f1 = fn;
            fn = f0 + f1;
        }

        return fn;
        // if(n == 0) return 0;
        // if(n == 1) return 1;
        // return fib(n - 1) + fib(n - 2);
    }
}