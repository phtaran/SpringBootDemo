package com.gmail.phtaran.consecutiveprimes;

import java.io.*;
import java.util.*;

public class Main {

    static final int[] PRIMES = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    static final boolean[] TEST_PRIME = new boolean[36];
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
            System.out.println(calcPrimes(Integer.parseInt(line)));
        }
        System.out.println(System.currentTimeMillis() - tt);
    }

    static int calcPrimes(int n) {

        if (n % 2 == 1) {
            return 0;
        }

        N = n;
        Arrays.fill(set, 1, n + 1, true);
        set[1] = false;
        return doCalc(1, n - 1);
    }

    static int doCalc(int last, int counter) {

        int res = 0;

        for (int k = 0; k < PRIMES.length; k++) {

            int i = PRIMES[k] - last;
            if (i > N) {
                break;
            }
            if (i <= 0 || !set[i]) {
                continue;
            }

            if (counter == 1) {
                res = TEST_PRIME[1 + i] ? res + 1 : res;
                break;
            }

            set[i] = false;
            res += doCalc(i, counter - 1);
        }
        set[last] = true;
        return res;
    }
}
