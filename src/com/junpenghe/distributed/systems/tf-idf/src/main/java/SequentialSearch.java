import model.DocumentData;
import search.TFIDF;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SequentialSearch {
    public static final String BOOKS_DIR = "./resources/books";
    public static final String SEARCH_QUERY_1 = "The best detective that catches many criminals using his deductive methods";
    public static final String SEARCH_QUERY_2 = "The girl that falls through a rabbit hole into a fantasy wonderland";
    public static final String SEARCH_QUERY_3 = "A war between Russian and France in the cold winter";

    public static void main(String[] args) throws Exception {
        File documentDirectory = new File(BOOKS_DIR);
        List<String> documents = Arrays.stream(Objects.requireNonNull(documentDirectory.list()))
                .map(docName -> BOOKS_DIR + "/" + docName)
                .collect(Collectors.toList());
        List<String> terms = TFIDF.getWordsFromLine(SEARCH_QUERY_1);
        findMostRelevantDocuments(documents, terms);
    }

    private static void findMostRelevantDocuments(List<String> documents, List<String> terms) throws FileNotFoundException {
        Map<String, DocumentData> documentsResult = new HashMap<>();

        for (String document : documents) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(document));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            List<String> words = TFIDF.getWordsFromLines(lines);
            DocumentData documentData = TFIDF.createDocumentData(words, terms);
            documentsResult.put(document, documentData);
        }

        Map<Double, List<String>> documentByScore = TFIDF.getDocumentsSortedByScore(terms, documentsResult);
        printResults(documentByScore);
    }

    private static void printResults(Map<Double, List<String>> documentsByScore) {
        for (Map.Entry<Double, List<String>> docScorePair : documentsByScore.entrySet()) {
            double score = docScorePair.getKey();
            for (String document : docScorePair.getValue()) {
                System.out.println(String.format("Book : %s - score : %f", document.split("/")[3], score));
            }
        }
    }
}
