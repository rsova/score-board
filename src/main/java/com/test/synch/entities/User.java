package com.test.synch.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The type User.
 */
//@Data
//@NoArgsConstructor
//@Builder()
@Entity
@Table(name = "User")
//@Document(indexName = "user", type = "user",shards = 1)
public class User implements Serializable {

    /**
     * The  log.
     */
    private static final Log log = LogFactory.getLog(User.class);

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    /**
     * The Name.
     */
    @Column(name = "name")
    private String name;
    /**
     * The Total.
     */
    @Column(name = "overallScore")
    private Integer overallScore;
    /**
     * The Scores.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
    @JsonManagedReference
    @OrderBy("value")
    private List<Score> scores;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param name   the name
     * @param scores the scores
     */
    public User(String name, List<Score> scores) {
        this.name = name;
        this.scores = scores;
    }

    /**
     * Gets scores.
     *
     * @return the scores
     */
    public List<Score> getScores() {
        return scores;
    }

    /**
     * Sets scores.
     *
     * @param scores the scores
     */
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Integer getOverallScore() {
        return overallScore;
    }

    /**
     * Sets total.
     *
     * @param overallScore the total
     */
    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }

    /**
     * Log new user added.
     */
    @PrePersist
    @PreUpdate
    public void postProcessUser() {
        log.info("Persisting user scores and overall score ");
        scores.stream().forEach(s -> s.setUser(this));
        overallScore = scores.stream().map(s -> s.getValue()).reduce(0, Integer::sum);
    }

}