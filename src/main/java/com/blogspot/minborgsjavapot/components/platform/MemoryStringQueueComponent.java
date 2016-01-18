package com.blogspot.minborgsjavapot.components.platform;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MemoryStringQueueComponent implements StringQueueComponent {

    private final Queue<String> queue = new ConcurrentLinkedQueue<>();

    @Override
    public boolean offer(String msg) {
        return queue.offer(msg);
    }

    @Override
    public String poll() {
        return queue.poll();
    }

    @Override
    public void added() {
        System.out.println(getClass().getSimpleName() + " added");
    }

    @Override
    public void removed() {
        queue.clear();
        System.out.println(getClass().getSimpleName() + " removed");
    }

}
