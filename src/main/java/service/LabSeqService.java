package service;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabSeqService {
    private final ConcurrentHashMap<Integer, Integer> cache = new ConcurrentHashMap<>();

    public LabSeqService() {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 0);
        cache.put(3, 1);
    }

    public int calculateLabSeq(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result;
        if (n > 3) {
            result = calculateLabSeq(n - 4) + calculateLabSeq(n - 3);
        } else {
            result = cache.get(n);
        }

        cache.put(n, result);

        return result;
    }
}
