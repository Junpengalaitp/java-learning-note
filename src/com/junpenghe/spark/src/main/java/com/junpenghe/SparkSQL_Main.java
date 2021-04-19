package com.junpenghe;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class SparkSQL_Main {
    public static void main(String[] args) {
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkSession sparkSession = SparkSession.builder()
                .appName("testingSQL")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> dataset = sparkSession.read().option("header", true).csv("src/com/junpenghe/spark/src/main/resources/exams/students.csv");
        dataset.show();

        System.out.println("There are " + dataset.count() + " records");

        Row firstRow = dataset.first();
        int year = Integer.parseInt(firstRow.getAs("year"));
        System.out.println(year);

        Dataset<Row> modernArtResults = dataset.filter("subject = 'Modern Art' AND year >= 2007");
        modernArtResults.show();

        modernArtResults = dataset.filter((FilterFunction<Row>) row -> row.getAs("subject").equals("Modern Art") &&
                row.getAs("year").toString().compareTo("2007") >= 0);
        modernArtResults.show();

        modernArtResults = dataset.filter(col("subject").equalTo("Modern Art").and(col("year").geq(2007)));
        modernArtResults.show();


        sparkSession.close();
    }
}
