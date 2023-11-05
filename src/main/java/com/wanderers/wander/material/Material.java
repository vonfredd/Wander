package com.wanderers.wander.material;

public abstract class Material {
    protected int level;
    protected int count;

    public Material(int level) {
        this.level = level;
        this.count = 0;
    }

    public void produce() {
        count += level;
    }

    public int getCount() {
        return count;
    }
}