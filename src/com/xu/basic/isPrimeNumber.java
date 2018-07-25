package com.xu.basic;

public class isPrimeNumber {

    public boolean isPrime(int val) {
        if (val < 2) {
            return false;
        }
        for (int i = 2; i * i < val; i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

}
