package com.tpg.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DifficultyLevel {
    @Column(name = "level")
    private int level;

    @Column(name = "count")
    private int count;

    public DifficultyLevel() {
        // Default constructor
    }

    public DifficultyLevel(int level, int count) {
        this.level = level;
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

