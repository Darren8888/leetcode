package com.example.sort.queue;

import java.util.PriorityQueue;

public class ShortLongerSelect {
    public static PriorityQueue<Long> check(long shorter, long longer, int k) {
        if (0>=k) return null;

        PriorityQueue<Long> queue = new PriorityQueue<>(k+1);
        if (shorter == longer) {
            queue.add(shorter*k);
        } else {
            long dis = longer-shorter;
            long kShorter = shorter*k;
            for (int i=0; i<=k; ++i) {
                queue.add(kShorter+dis*i);
            }
        }
        return queue;
    }
}
