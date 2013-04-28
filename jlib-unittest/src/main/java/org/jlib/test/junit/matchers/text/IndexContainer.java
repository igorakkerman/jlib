package org.jlib.test.junit.matchers.text;

public abstract class IndexContainer {
    private final int index;
    
    protected IndexContainer(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
}