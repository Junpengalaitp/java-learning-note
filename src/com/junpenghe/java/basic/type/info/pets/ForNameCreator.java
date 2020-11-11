package com.junpenghe.java.basic.type.info.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junpeng He
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.junpenghe.java.basic.type.info.pets.Mutt",
            "com.junpenghe.java.basic.type.info.pets.Pug",
            "com.junpenghe.java.basic.type.info.pets.EgyptianMau",
            "com.junpenghe.java.basic.type.info.pets.Manx",
            "com.junpenghe.java.basic.type.info.pets.Cymric",
            "com.junpenghe.java.basic.type.info.pets.Rat",
            "com.junpenghe.java.basic.type.info.pets.Mouse",
            "com.junpenghe.java.basic.type.info.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        for (String name : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
