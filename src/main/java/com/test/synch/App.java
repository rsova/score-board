package com.test.synch;

import com.test.synch.entities.Score;
import com.test.synch.entities.User;
import com.test.synch.repositories.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The type App.
 */
@SpringBootApplication
public class App {

    /**
     * The constant CATEGORIES.
     */
    public static final List<String> CATEGORIES = Arrays.asList("Attack", "Defense", "Magic", "Cooking", "Crafting");
    /**
     * The constant OVERALL.
     */
    public static final String OVERALL = "Overall";
    /**
     * The constant CATEGORIES_LIST.
     */
    private static final List<String> CATEGORIES_LIST = new LinkedList<>(CATEGORIES);
    /**
     * The  log.
     */
    private static final Log log = LogFactory.getLog(App.class);
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * App init.
     *
     * @param event the event
     */
    @EventListener
    public void init(ApplicationReadyEvent event) throws IOException {
        log.info("Initializing users");
        File file = ResourceUtils.getFile("classpath:users");
        String[] names = new String(Files.readAllBytes(file.toPath())).split(",");
        Arrays.asList(names).forEach(name -> userRepository.save(new User(name, createScores())));
    }

    /**
     * Create scores list.
     *
     * @return the list
     */
    private List<Score> createScores() {
        Collections.shuffle(CATEGORIES_LIST);
        return new HashSet<>(CATEGORIES_LIST.subList(1, 5))
                .stream()
                .map(category -> new Score(category, new Random().nextInt(200)))
                .collect(Collectors.toList());
    }


}
