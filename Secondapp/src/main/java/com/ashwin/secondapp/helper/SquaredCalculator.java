package com.ashwin.secondapp.helper;

public class SquaredCalculator {

    private CacheHelper cache;

    public int getSquareValueOfNumber(int input) {
        if (cache.getSquareNumberCache().containsKey(input)) {
            System.out.println("returning from cache");
            return cache.getSquareNumberCache().get(input);
        }

        System.out.println("Calculating square value of " + input +
                " and caching result.");

        int squaredValue = (int) Math.pow(input, 2);
        cache.getSquareNumberCache().put(input, squaredValue);

        return squaredValue;
    }

    public CacheHelper getCache() {
        return cache;
    }

    public void setCache(CacheHelper cache) {
        this.cache = cache;
    }
}
