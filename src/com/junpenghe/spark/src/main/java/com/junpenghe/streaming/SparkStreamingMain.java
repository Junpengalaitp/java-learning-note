package com.junpenghe.streaming;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

/**
 * @description: TODO
 * @author: Junpeng He
 * @date: 2021-04-26 4:48 PM
 */
public class SparkStreamingMain {

    public static void main(String[] args) throws InterruptedException {
        Logger.getLogger("org.apache").setLevel(Level.WARN);
        Logger.getLogger("org.apache.spark.storage").setLevel(Level.ERROR);

        SparkConf conf = new SparkConf()
                .setAppName("startingSpark")
                .setMaster("local[*]");

        JavaStreamingContext streamingContext = new JavaStreamingContext(conf, new Duration(3000));
        JavaReceiverInputDStream<String> inputDStream = streamingContext.socketTextStream("localhost", 8989);
        JavaDStream<String> stringJavaDStream = inputDStream.map(item -> item);
        JavaPairDStream<String, Integer> pairDStream = stringJavaDStream.mapToPair(rowLogMessage -> new Tuple2<>(rowLogMessage.split(",")[0], 1));
        pairDStream = pairDStream.reduceByKeyAndWindow(Integer::sum, Durations.minutes(2));

        pairDStream.print();

        streamingContext.start();
        streamingContext.awaitTermination();
    }
}
