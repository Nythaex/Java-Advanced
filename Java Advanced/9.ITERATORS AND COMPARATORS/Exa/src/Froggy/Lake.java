package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] lake;
    private boolean finishedEvens=false;
    private StringBuilder builder;

    public Lake(int[] lake) {
        this.lake = lake;
    }

    public void setFinishedEvens(boolean finishedEvens) {
        this.finishedEvens = finishedEvens;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index=finishedEvens?1:0;
            @Override
            public boolean hasNext() {
                return index<lake.length ;
            }

            @Override
            public Integer next() {
                int p=lake[index];
                index+=2;
                return p;
            }

        };
    }
}
