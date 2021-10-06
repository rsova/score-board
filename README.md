# Spring Boot API with Angular UI

This app uses a Spring Boot API to generate users with scores for the score board demo, and display its data with an Angular UI.

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Node.js](https://nodejs.org/).

## Getting Started

To run the server, cd into the `score-board` folder and run:

```bash
./mvnw spring-boot:run
```

To run the client, cd into the `web` folder and run:

```bash
npm install && npm start
```
In your browser open [http://localhost:4200](http://localhost:4200) to see the top scores and available users.
User helped with autocomplete feature when searches for players.

## License

Apache 2.0, see [LICENSE](LICENSE).
