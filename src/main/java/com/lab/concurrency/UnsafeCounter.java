package com.lab.concurrency;

public class UnsafeCounter{
    private int count = 0;

    public synchronized void increment(){
        count ++;
    }

    public synchronized int getCount(){
        return count;
    }
}