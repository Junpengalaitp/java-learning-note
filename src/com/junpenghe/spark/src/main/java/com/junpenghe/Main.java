package com.junpenghe;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<String> inputData = Arrays.asList(
                "WARN: Tuesday 4 September 0405",
                "ERROR: Tuesday 4 September 0409",
                "FATAL: Wednesday 5 September 1632",
                "ERROR: Friday 5 September 1854",
                "WARN: Saturday 8 September 1942"
        );

        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf()
                .setAppName("startingSpark")
                .setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

//        sc.parallelize(inputData)
//                .mapToPair(rawValue -> new Tuple2<>(rawValue.split(":")[0], 1L))
//                .reduceByKey(Long::sum)
//                .foreach(tuple -> System.out.println(tuple._1 + " has " + tuple._2 + " instances"));

        sc.parallelize(inputData)
                .mapToPair(rawValue -> new Tuple2<>(rawValue.split(":")[0], 1L))
                .groupByKey()
                .foreach(tuple -> System.out.println(tuple._1 + " has " + tuple._2.spliterator().getExactSizeIfKnown() + " instances"));

        sc.close();

    }
}
