package com.junpenghe.design.pattern.behavioral.strategy.simple;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Junpeng He
 */

class FindMiniMa {
    Function<List<Double>, List<Double>> algorithm;
}

class LeastSquares extends FindMiniMa {
    public LeastSquares() {
        algorithm = line -> Arrays.asList(1.1, 2.2);
    }
}

class Perturbation extends FindMiniMa {
    public Perturbation() {
        algorithm = line -> Arrays.asList(3.3, 4.4);
    }
}

class BiSection extends FindMiniMa {
    BiSection() {
        algorithm = line -> Arrays.asList(5.5, 6.6);
    }
}

class MinimaSolver {
    private FindMiniMa strategy;

    public MinimaSolver(FindMiniMa strategy) {
        this.strategy = strategy;
    }

    List<Double> minima(List<Double> line) {
        return strategy.algorithm.apply(line);
    }

    void changeAlgorithm(FindMiniMa newAlgo) {
        this.strategy = newAlgo;
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        MinimaSolver minimaSolver = new MinimaSolver(new LeastSquares());
        List<Double> line = Arrays.asList(1.0, 2.0, 1.0, 2.0, -1.0, 3.0, 4.0, 5.0, 4.0);
        System.out.println(minimaSolver.minima(line));
        minimaSolver.changeAlgorithm(new BiSection());
        System.out.println(minimaSolver.minima(line));
    }
}
