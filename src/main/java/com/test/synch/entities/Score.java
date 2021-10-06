package com.test.synch.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * The type Score.
 */
@Entity
@Table(name = "Score")
public class Score {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * The User.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    /**
     * The Category.
     */
    @Column(name = "category")
    private String category;

    /**
     * The Score.
     */
    @Column(name = "value")
    private Integer value;

    /**
     * Instantiates a new Score.
     */
    public Score() {
    }

    /**
     * Instantiates a new Score.
     *
     * @param category the category
     * @param value    the score
     */
    public Score(String category, Integer value) {
        this.category = category;
        this.value = value;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets score.
     *
     * @param value the score
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}
