package com.junpenghe.java.basic.interfaces.adapting;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Junpeng He
 */
public class RandomStrings implements Readable {

    private static Random rand = new Random(47);

    private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();

    private int count;

    public RandomStrings(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);

        for (int i = 0; i < 4; i++) {
            cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
            cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }
        cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomStrings(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
