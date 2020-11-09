package com.junpenghe.design.pattern.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Junpeng He
 */
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        return treeTypes.computeIfAbsent(name, k -> new TreeType(name, color, otherTreeData));
    }
}
