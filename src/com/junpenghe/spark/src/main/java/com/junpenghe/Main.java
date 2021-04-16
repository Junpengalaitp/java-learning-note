package com.junpenghe;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("startingSpark")
                .setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> initRDD = sc.textFile("src/com/junpenghe/spark/src/main/resources/subtitles/input.txt");
        JavaRDD<String> lettersOnlyRDD = initRDD.map(sentence -> sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase(Locale.ROOT));
        JavaRDD<String> noBlankRDD = lettersOnlyRDD.filter(sentence -> !sentence.trim().isEmpty());
        JavaRDD<String> words = noBlankRDD.flatMap(sentence -> Arrays.stream(sentence.split(" ")).iterator());
        JavaRDD<String> validWords = words.filter(StringUtils::isNoneEmpty);
        JavaRDD<String> justInterestWords = validWords.filter(Util::isNotBoring);
        JavaPairRDD<String, Integer> stringIntegerJavaPairRDD = justInterestWords.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> totals = stringIntegerJavaPairRDD.reduceByKey(Integer::sum);
        JavaPairRDD<Integer, String> switched = totals.mapToPair(tuple -> new Tuple2<>(tuple._2, tuple._1));
        JavaPairRDD<Integer, String> sorted = switched.sortByKey(false);
        List<Tuple2<Integer, String>> result = sorted.take(10000);
        result.forEach(System.out::println);


        sc.close();

    }
}
