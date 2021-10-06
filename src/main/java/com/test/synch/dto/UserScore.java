package com.test.synch.dto;

import java.util.Objects;

/**
 * The type Score board item.
 */
public class UserScore {

    /**
     * The Name.
     */
    public String name;
    /**
     * The Level.
     */
    public Integer level;
    /**
     * The Score.
     */
    public Integer value;
    /**
     * Instantiates a new Score board item.
     *
     * @param name  the name
     * @param level the level
     * @param value the score
     */
    public UserScore(String name, Integer level, Integer value) {
        this.name = name;
        this.level = level;
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserScore userScore = (UserScore) o;
        return Objects.equals(name, userScore.name)
                && Objects.equals(level, userScore.level)
                && Objects.equals(value, userScore.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, value);
    }
}
