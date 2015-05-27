package com.gmail.phtaran.consecutiveprimes;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] PRIMES = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    static final boolean[] TEST_PRIME = new boolean[36];
    static final int[] PRIME_USED = new int[19];
    static int N = 0;
    static boolean set[] = new boolean[19];

    static {
        Arrays.fill(TEST_PRIME, false);
        for (int i = 0; i < PRIMES.length; i++) {
            TEST_PRIME[PRIMES[i]] = true;
        }
    }

    public static void main(String[] args) throws IOException {

        long tt = System.currentTimeMillis();
//        File file = new File(args[0]);
        File file = new File("test_cases.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
//            System.out.println(calcPrimes(Integer.parseInt(line)));
            System.out.println(backtracking(Integer.parseInt(line)));
        }
        System.out.println(System.currentTimeMillis() - tt);
    }

    static int backtracking(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        N = n;
        Arrays.fill(set, 1, n + 1, true);
        Arrays.fill(PRIME_USED, 0, PRIME_USED.length, 0);
        set[1] = false;

        int res = 0;

        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(1);

        for (;;) {

            if (!selection(seq, n)) {
                if (seq.size() == 1) {
                    break;
                }
                backtrack(seq);
                continue;
            }
            if (seq.size() == n) {
                if (TEST_PRIME[last(seq) + first(seq)]) {
                    res++;
                }
                backtrack(seq);
            }
            if (PRIME_USED[seq.size()] == n) {
                backtrack(seq);
            }
        }
        return res;
    }

    static int last(ArrayList<Integer> seq) {
        return seq.get(seq.size() - 1);
    }
    static int first(ArrayList<Integer> seq) {
        return seq.get(0);
    }

    static boolean selection(ArrayList<Integer> seq, int max) {
        int last = last(seq);
        for (int i = PRIME_USED[seq.size()]; i < PRIMES.length; i++) {
            int candidate = PRIMES[i] - last;
            if (!seq.contains(candidate) && candidate > 0 && candidate <= max) {
                seq.add(candidate);
                PRIME_USED[seq.size() - 1] = i + 1;
                return true;
            }
        }
        return false;
    }

    static int backtrack(ArrayList<Integer> seq) {
        seq.remove(seq.size() - 1);
        Arrays.fill(PRIME_USED, seq.size() + 1, PRIME_USED.length - 1, 0);
        return PRIME_USED[seq.size() - 1];
    }

//    static int calcPrimes(int n) {
//
//        if (n % 2 == 1) {
//            return 0;
//        }
//
//        N = n;
//        Arrays.fill(set, 1, n + 1, true);
//        set[1] = false;
//        return doCalc(1, n - 1);
//    }
//
//    static int doCalc(int last, int counter) {
//
//        int res = 0;
//
//        for (int k = 0; k < PRIMES.length; k++) {
//
//            int i = PRIMES[k] - last;
//            if (i <= 0 || i > N || !set[i]) {
//                continue;
//            }
//
//            if (counter == 1) {
//                res = TEST_PRIME[1 + i] ? res + 1 : res;
//                break;
//            }
//
//            set[i] = false;
//            res += doCalc(i, counter - 1);
//        }
//        set[last] = true;
//        return res;
//    }
}
