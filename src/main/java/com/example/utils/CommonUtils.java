package com.example.utils;

import org.springframework.transaction.support.TransactionSynchronizationManager;

public class CommonUtils {

    public static void printTransactionActive() {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }
}
