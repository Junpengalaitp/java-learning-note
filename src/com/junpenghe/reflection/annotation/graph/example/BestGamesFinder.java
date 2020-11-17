package com.junpenghe.reflection.annotation.graph.example;

import com.junpenghe.reflection.annotation.annotation.Annotations;

import java.util.*;

/**
 * @author Junpeng He
 */
public class BestGamesFinder {
    private Database database = new DataBase();

    @Annotations.Operation("All-Games")
    public Set<String> getAllGames() {
        return database.readAllGames();
    }

    @Annotations.Operation("Game-to-Price")
    public Set<String> readGameToPrice(@Annotations.DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToPrice();
    }

    @Annotations.Operation("Game-to-Rating")
    public Set<String> readGameToRating(@Annotations.DependsOn("All-Games") Set<String> allGames) {
        return database.readGameToRating();
    }

    @Annotations.Operation("Score-to-Game")
    public SortedMap<Double, String> scoreGames(@Annotations.DependsOn("Game-to-Price")Map<String, Float> gameToPrice,
                                                @Annotations.DependsOn("Game-to-Rating") Map<String, Float> gameToRating) {
        SortedMap<Double, String> gameToScore = new TreeMap<>(Collections.reverseOrder());
        for (String gameName : gameToPrice.keySet()) {
            double score = (double) gameToRating.get(gameName) / gameToPrice.get(gameName);
            gameToScore.put(score, gameName);
        }
        return gameToScore;
    }

    @Annotations.FinalResult
    public List<String> getTopGames(SortedMap<Double, String> gameToScore) {
        return new ArrayList<>(gameToScore.values());
    }

}
